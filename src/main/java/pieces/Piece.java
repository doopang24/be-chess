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

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN, Type.PAWN.getWhiteRepresentation());
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN, Type.PAWN.getBlackRepresentation());
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT, Type.KNIGHT.getWhiteRepresentation());
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT, Type.KNIGHT.getBlackRepresentation());
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK, Type.ROOK.getWhiteRepresentation());
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK, Type.ROOK.getBlackRepresentation());
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP, Type.BISHOP.getWhiteRepresentation());
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP, Type.BISHOP.getBlackRepresentation());
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN, Type.QUEEN.getWhiteRepresentation());
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN, Type.QUEEN.getBlackRepresentation());
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING, Type.KING.getWhiteRepresentation());
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING, Type.KING.getBlackRepresentation());
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
