package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private final int x;
    private final int y;
    private static final Map<String, Position> CACHE = new HashMap<>();

    private Position(String notation) {
        isValidNotation(notation);
        this.x = notation.charAt(0) - 'a' + 1;  // a-h -> 1-8
        this.y = notation.charAt(1) - '0';      // 1-8 -> 1-8
    }

    // 팩토리 메소드
    public static Position createPos(String notation) {
        if (!CACHE.containsKey(notation)) {
            (CACHE).put(notation, new Position(notation));
        }
        return CACHE.get(notation);
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
