package chess;

import pieces.Piece;

import java.util.List;

import static utils.StringUtils.appendNewLine;

public class ChessView {    // 출력 담당

    private final int RANK_SIZE = 8;

    public void showTurn(String turn) {
        System.out.println(turn + "의 차례입니다.");
    }

    // 출력할 체스판 구성
    private String showBoard(List<Rank> chessBoard) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < RANK_SIZE; i++) {
            builder.append(chessBoard.get(i).getRankView()).append("    ").append(appendNewLine(String.valueOf(RANK_SIZE - i)));
        }
        builder.append(appendNewLine("")).append(Board.FILE).append(appendNewLine(""));
        return builder.toString();
    }

    public void printBoard(List<Rank> board) {
        System.out.println(showBoard(board));
    }

    public void printMoveSuccess(Piece currentPiece, Position sourcePosition, Position targetPosition) {
        String source = sourcePosition.getNotation();
        String target = targetPosition.getNotation();
        System.out.println(currentPiece.getType() + "을 " + source + "에서 " + target + "으로 이동하는데 성공했습니다.");
    }

    public void printMoveFailure(Piece currentPiece, Position sourcePosition, Position targetPosition) {
        String source = sourcePosition.getNotation();
        String target = targetPosition.getNotation();
        System.out.println(currentPiece.getType() + "을 " + source + "에서 " + target + "으로 이동하는데 실패했습니다.");
    }
}
