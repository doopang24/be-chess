package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

public class BoardTest {

    @Test
    @DisplayName("체스판이 잘 초기화 되었는지 확인")
    public void findPiece() throws Exception {
        Board board = new Board();
        board.initialize();

        ChessGame game = new ChessGame(board);

        assertThat(Piece.createBlackRook(Position.createPos("a8"))).isEqualTo(game.findPiece("a8"));
        assertThat(Piece.createBlackRook(Position.createPos("h8"))).isEqualTo(game.findPiece("h8"));
        assertThat(Piece.createWhiteRook(Position.createPos("a1"))).isEqualTo(game.findPiece("a1"));
        assertThat(Piece.createWhiteRook(Position.createPos("h1"))).isEqualTo(game.findPiece("h1"));
    }

    @Test
    @DisplayName("체스판이 모두 빈 칸으로 초기화 되었는지 확인")
    public void calculatePoint() throws Exception {
        Board board = new Board();
        board.initializeEmpty();

        ChessGame game = new ChessGame(board);

        assertThat(Piece.createBlank(Position.createPos("a8"))).isEqualTo(game.findPiece("a8"));
        assertThat(Piece.createBlank(Position.createPos("f7"))).isEqualTo(game.findPiece("f7"));
        assertThat(Piece.createBlank(Position.createPos("b5"))).isEqualTo(game.findPiece("b5"));
        assertThat(Piece.createBlank(Position.createPos("d2"))).isEqualTo(game.findPiece("d2"));
        assertThat(Piece.createBlank(Position.createPos("h1"))).isEqualTo(game.findPiece("h1"));
    }


}
