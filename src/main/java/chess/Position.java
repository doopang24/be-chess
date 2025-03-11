package chess;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public Position(String notation) {
        isValidNotation(notation);
        this.x = notation.charAt(0) - 'a';  // a-h -> 0-7
        this.y = notation.charAt(1) - '0';  // 1-8 -> 0-7
    }

    private void isValidNotation(String notation) {
        if (notation.length() != 2) throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        char file = notation.charAt(0);
        char rank = notation.charAt(1);
        if (file < 'a' || file > 'h') {
            throw new IllegalArgumentException("올바른 파일값이 아닙니다.");
        }
        if (rank < '1' || rank > '8') {
            throw new IllegalArgumentException("올바른 랭크값이 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return this.x == position.x && this.y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
