package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private final List<Piece> RANK = new ArrayList<>();

    public void addRank(Piece piece) {
        RANK.add(piece);
    }

    // rank 의 representation 덩어리 반환
    public String getRankView() {
        StringBuilder builder = new StringBuilder();
        for (Piece piece : RANK) {
            builder.append(piece.getRepresentation());
        }
        return builder.toString();
    }

    // 랭크에 몇 개 있는지 반환
    public int countPieceFromRank(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Piece piece : RANK) {
            if (piece.getColor() == color && piece.getType() == type) {
                count++;
            }
        }
        return count;
    }

    // 해당 index 의 Piece 반환
    public Piece findPieceFromRank(int index) {
        return RANK.get(index);
    }
}
