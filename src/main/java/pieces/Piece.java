package pieces;

import chess.Position;

import java.util.Objects;

public class Piece {

    public enum Color {
        WHITE,
        BLACK,
        NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
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
    private final Position position;

    private Piece(Color color, Type type, char representation, Position position) {
        this.COLOR = color;
        this.TYPE = type;
        this.REPRESENTATION = representation;
        this.position = position;
    }

    private static Piece createWhite(Type type, Position position) {
        return new Piece(Color.WHITE, type, type.getWhiteRepresentation(), position);
    }

    private static Piece createBlack(Type type, Position position) {
        return new Piece(Color.BLACK, type, type.getBlackRepresentation(), position);
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(Type.PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(Type.PAWN, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(Type.KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(Type.KNIGHT, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(Type.ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(Type.ROOK, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return createWhite(Type.BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return createBlack(Type.BISHOP, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return createWhite(Type.QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return createBlack(Type.QUEEN, position);
    }

    public static Piece createWhiteKing(Position position) {
        return createWhite(Type.KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return createBlack(Type.KING, position);
    }

    public static Piece createBlank(Position position) {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE, Type.NO_PIECE.getBlankRepresentation(), position);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return COLOR == piece.COLOR && this.TYPE == piece.TYPE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(COLOR, TYPE);
    }
}
