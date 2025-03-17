package pieces;

import chess.ChessGame;
import chess.Direction;
import chess.Position;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(Piece.Color color, Piece.Type type, char representation, Position position) {
        super(color, type, representation, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return new Bishop(Color.WHITE, Type.BISHOP, Type.BISHOP.getWhiteRepresentation(), position);
    }

    public static Piece createBlackBishop(Position position) {
        return new Bishop(Color.BLACK, Type.BISHOP, Type.BISHOP.getBlackRepresentation(), position);
    }

    public boolean isMoveable(Position sourcePosition, Position targetPosition, ChessGame game) {
        List<Direction> moveList = Direction.diagonalDirection();
        boolean directionCheck = isValidDirection(sourcePosition, targetPosition)
        return false;
    }

    private boolean isValidDirection(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = targetPosition.getY() - sourcePosition.getY();
        if (dy / dx == 1 || dy / dx == -1) {
            return true;
        }
        return false;
    }
}
