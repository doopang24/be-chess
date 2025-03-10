package pieces;

public class Piece {

    public enum Color {
        WHITE,
        BLACK,
        NOCOLOR;
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private char representation;

        // private 생성자로 이미 초기화해놓은 문자('p'등)를 private char representation 필드에 할당
        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }

        public char getBlankRepresentation() {
            return representation;
        }
    }

    private final Color COLOR;
    private final Type TYPE;
    private final char REPRESENTATION;

    private Piece(Color color, Type type, char representation) {
        this.COLOR = color;
        this.TYPE = type;
        this.REPRESENTATION = representation;
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type, type.getWhiteRepresentation());
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type, type.getBlackRepresentation());
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE, Type.NO_PIECE.getBlankRepresentation());
    }

    public Color getColor() {
        return COLOR;
    }

    public Type getType() {
        return TYPE;
    }

    public char getRepresentation() {
        return REPRESENTATION;
    }

    public boolean isBlack() {
        return COLOR == Color.BLACK;
    }

    public boolean isWhite() {
        return COLOR == Color.WHITE;
    }
}
