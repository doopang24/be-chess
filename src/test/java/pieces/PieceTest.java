package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceTest {

    @Test
    public void create_piece() {
        verifyBlackPiece(Piece.createBlackPawn(), Piece.COLOR_BLACK, Piece.PAWN_BLACK);
        verifyBlackPiece(Piece.createBlackKnight(), Piece.COLOR_BLACK, Piece.KNIGHT_BLACK);
        verifyBlackPiece(Piece.createBlackRook(), Piece.COLOR_BLACK, Piece.ROOK_BLACK);
        verifyBlackPiece(Piece.createBlackBishop(), Piece.COLOR_BLACK, Piece.BISHOP_BLACK);
        verifyBlackPiece(Piece.createBlackQueen(), Piece.COLOR_BLACK, Piece.QUEEN_BLACK);
        verifyBlackPiece(Piece.createBlackKing(), Piece.COLOR_BLACK, Piece.KING_BLACK);

        verifyWhitePiece(Piece.createWhitePawn(), Piece.COLOR_WHITE, Piece.PAWN_WHITE);
        verifyWhitePiece(Piece.createWhiteKnight(), Piece.COLOR_WHITE, Piece.KNIGHT_WHITE);
        verifyWhitePiece(Piece.createWhiteRook(), Piece.COLOR_WHITE, Piece.ROOK_WHITE);
        verifyWhitePiece(Piece.createWhiteBishop(), Piece.COLOR_WHITE, Piece.BISHOP_WHITE);
        verifyWhitePiece(Piece.createWhiteQueen(), Piece.COLOR_WHITE, Piece.QUEEN_WHITE);
        verifyWhitePiece(Piece.createWhiteKing(), Piece.COLOR_WHITE, Piece.KING_WHITE);
    }

    void verifyBlackPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
        assertTrue(piece.isBlack());
    }

    void verifyWhitePiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
        assertTrue(piece.isWhite());
    }
}
