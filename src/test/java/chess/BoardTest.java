package chess;

import static utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Piece;

public class BoardTest {
    private Board board;

    // 각 테스트 전에 실행
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPiece(position));
        System.out.println(board.showBoard());
    }
}
