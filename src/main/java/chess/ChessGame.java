package chess;

import pieces.Piece;

import java.util.List;

public class ChessGame {    // 게임 진행

    private final List<Rank> BOARD;
    private String turn = "white";

    private ChessView view = new ChessView();

    public ChessGame(Board board) {
        this.BOARD = board.getBOARD();
    }

    public void startGame(String userCommand) {
        view.showTurn(turn);
        getSourceAndTargetPosition(userCommand);
        view.printBoard(BOARD);
        turn = turn.equals("white") ? "black" : "white";
    }

    private void getSourceAndTargetPosition(String userCommand) {
        String[] moveCommand = userCommand.split(" ");
        String source = moveCommand[0];
        Position sourcePosition = Position.createWithNotation(source);
        String target = moveCommand[1];
        Position targetPosition = Position.createWithNotation(target);
        move(sourcePosition, targetPosition);
    }

    // 지정한 위치에 기물 배치
    private void move(Position sourcePosition, Position targetPosition) {
        Piece currentPiece = findPiece(sourcePosition);
        if (isAvailable(currentPiece, targetPosition) && currentPiece.isMoveable(sourcePosition, targetPosition)) {
            putPieceIntoBoard(targetPosition, currentPiece);
            putBlankIntoBoard(sourcePosition);
            view.printMoveSuccess(currentPiece, sourcePosition, targetPosition);
            return;
        }
        view.printMoveFailure(currentPiece, sourcePosition, targetPosition);
    }

    // 체스판에 해당 기물이 몇 개 있는지 반환
    public int countPieceFromBoard(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : BOARD) {
            count += rank.countPieceFromRank(color, type);
        }
        return count;
    }

    // 입력받은 위치에 있는 기물 반환
    public Piece findPiece(Position position) {
        int xIndex = position.getX();
        int yIndex = position.yValueToIndex();
        return BOARD.get(yIndex).findPieceFromRank(xIndex);
    }

    // 같은 색깔이면 false
    private boolean isAvailable(Piece piece, Position position) {
        int xIndex = position.getX();
        int yIndex = position.yValueToIndex();
        if (BOARD.get(yIndex).findPieceFromRank(xIndex).getColor().equals(piece.getColor())) {
            return false;
        }
        return true;
    }

    private void putPieceIntoBoard(Position position, Piece piece) {
        BOARD.get(position.yValueToIndex()).putPiece(position.getX(), piece);
    }

    private void putBlankIntoBoard(Position position) {
        Piece emptyPiece = Piece.createBlank(position);
        BOARD.get(position.yValueToIndex()).putBlack(position.getX(), emptyPiece);
    }

    public boolean checkSquareClear(int x, int y) {
        int rankIndex = 7 - y;
        if (BOARD.get(rankIndex).findPieceFromRank(x).getType().equals(Piece.Type.NO_PIECE)) return true;
        return false;
    }
}
