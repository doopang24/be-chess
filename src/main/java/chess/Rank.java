package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private final List<Piece> RANK = new ArrayList<>();
    private final int RANK_SIZE = 8;

    public void addRank(Piece piece) {
        RANK.add(piece);
    }

    public String getRankView() {
        StringBuilder builder = new StringBuilder();
        for (Piece piece : RANK) {
            builder.append(piece.getRepresentation());
        }
        return builder.toString();
    }

    public int countPieceType(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Piece piece : RANK) {
            if (piece.getColor() == color && piece.getType() == type) {
                count++;
            }
        }
        return count;
    }
}
