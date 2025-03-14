package pieces;

import chess.ChessGame;
import chess.Direction;
import chess.Position;

import java.util.List;

public class King extends Piece {

    public King(Piece.Color color, Piece.Type type, char representation, Position position) {
        super(color, type, representation, position);
    }

    public static Piece createWhiteKing(Position position) {
        return new King(Color.WHITE, Type.KING, Type.KING.getWhiteRepresentation(), position);
    }

    public static Piece createBlackKing(Position position) {
        return new King(Color.BLACK, Type.KING, Type.KING.getBlackRepresentation(), position);
    }

    // 해당 기물이 목표 지점에 갈 수 있는가?
    public boolean isMoveable(Position sourcePosition, Position targetPosition, ChessGame game) {
        List<Direction> moveList = Direction.everyDirection();
        for (Direction direction : moveList) {
            int targetX = POSITION.getX() + direction.getXDegree();
            int targetY = POSITION.getY() + direction.getYDegree();
            if (Position.createWithXY(targetX, targetY).equals(targetPosition)) {
                return true;
            }
        }
        return false;
    }



}
