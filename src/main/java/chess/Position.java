package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private final int x;
    private final int y;
    private static final Map<String, Position> CACHE = new HashMap<>();

    public Position(String notation) {
        isValidNotation(notation);
        this.x = notation.charAt(0) - 'a';      // a-h -> 0-7
        this.y = notation.charAt(1) - '1';      // 1-8 -> 0-7
    }

    // 팩토리 메소드
    public static Position createWithNotation(String notation) {
        if (!CACHE.containsKey(notation)) {
            (CACHE).put(notation, new Position(notation));
        }
        return CACHE.get(notation);
    }

    public static Position createWithXY(int x, int y) {
        StringBuilder builder = new StringBuilder();
        String file = "abcdefgh";
        builder.append(file.charAt(x)).append(String.valueOf(y + 1));
        return createWithNotation(builder.toString());
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int yValueToIndex() {
        return 7 - y;
    }

    public String getNotation() {
        char file = (char) ( x + 'a');
        char rank = (char) ( y + '1');
        return String.valueOf(file) + rank;
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
