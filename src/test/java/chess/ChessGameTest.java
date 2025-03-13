package chess;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

import org.assertj.core.api.GenericComparableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

public class ChessGameTest {

    @Test
    @DisplayName("")
    public void move() throws Exception {
        Board board = new Board();
        board.initialize();

        ChessGame game = new ChessGame(board);

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.move(sourcePosition, targetPosition);
        assertThat(Piece.createBlank(Position.createPos(sourcePosition))).isEqualTo(game.findPiece(sourcePosition));
        assertThat(Piece.createWhitePawn(Position.createPos(targetPosition))).isEqualTo(game.findPiece(targetPosition));
    }
}
