import static utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    // 각 테스트 전에 실행
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blackRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blackRank + blackRank + blackRank + blackRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }
}
