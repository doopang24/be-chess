package chess;

import java.util.List;

import static utils.StringUtils.appendNewLine;

public class ChessView {    // 출력 담당

    private final int RANK_SIZE = 8;

    LocationConverter converter = new LocationConverter();

    // 출력할 체스판 구성
    public String showBoard(List<Rank> board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < RANK_SIZE; i++) {
            builder.append(board.get(i).getRankView()).append(" ").append(appendNewLine(converter.indexToRank(i)));
        }
        builder.append(appendNewLine("")).append(converter.getFILE());
        return builder.toString();
    }

    public void printBoard(List<Rank> board) {
        System.out.println(showBoard(board));
    }
}
