package chess;

import pieces.Piece;

import java.util.List;

public class ChessGame {    // 게임 진행

    private final List<Rank> BOARD;

    public ChessGame(List<Rank> board) {
        this.BOARD = board;
    }

    // 지정한 위치에 기물 배치
    public void move(String sourcePosition, String targetPosition) {
        Piece piece = findPiece(sourcePosition);
        if (isAvailable(targetPosition)) {
            putPieceIntoBoard(targetPosition, piece);
            putBlankIntoBoard(sourcePosition);
        }
    }

    public void getSourceAndTarget(String notation) {
        String[] moveCommand = notation.split(" ");
        String sourcePosition = moveCommand[0];
        String targetPosition = moveCommand[1];
        move(sourcePosition, targetPosition);
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
    public Piece findPiece(String notation) {
        Position position = Position.createPos(notation);
        int xIndex = position.getX();
        int yIndex = position.yValueToIndex();
        return BOARD.get(yIndex).findPieceFromRank(xIndex);
    }

    // 해당 위치가 빈 칸이면 true
    public boolean isAvailable(String notation) {
        Position position = Position.createPos(notation);
        int xIndex = position.getX();
        int yIndex = position.yValueToIndex();
        Piece piece = BOARD.get(yIndex).findPieceFromRank(xIndex);
        if (piece.getType() == Piece.Type.NO_PIECE) {
            return true;
        }
        return false;
    }

    private void putPieceIntoBoard(String notation, Piece piece) {
        Position position = Position.createPos(notation);
        BOARD.get(position.yValueToIndex()).putPiece(position.getX(), piece);
    }

    private void putBlankIntoBoard(String notation) {
        Position position = Position.createPos(notation);
        Piece emptyPiece = Piece.createBlank(Position.createPos(notation));
        BOARD.get(position.yValueToIndex()).putBlack(position.getX(), emptyPiece);
    }
}
