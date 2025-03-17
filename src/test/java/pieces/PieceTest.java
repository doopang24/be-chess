package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

//    @Test
//    public void getRepresentationPerPiece() throws Exception {
//        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
//        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
//    }
//
//    @Test
//    public void create_piece() {
//        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN);
//        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Piece.Type.ROOK);
//        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT);
//        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP);
//        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Piece.Type.QUEEN);
//        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Piece.Type.KING);
//
//        Piece blank = Piece.createBlank();
//        assertFalse(blank.isWhite());
//        assertFalse(blank.isBlack());
//        assertEquals(Piece.Type.NO_PIECE, blank.getType());
//    }
//
//    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
//        assertTrue(whitePiece.isWhite());
//        assertEquals(type, whitePiece.getType());
//
//        assertTrue(blackPiece.isBlack());
//        assertEquals(type, blackPiece.getType());
//    }
}
