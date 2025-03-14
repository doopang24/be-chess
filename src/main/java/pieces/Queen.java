package pieces;

import chess.ChessGame;
import chess.Direction;
import chess.Position;
import chess.Rank;

import javax.swing.*;
import java.util.List;

public class Queen extends Piece {

    public Queen(Piece.Color color, Piece.Type type, char representation, Position position) {
        super(color, type, representation, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return new Queen(Color.WHITE, Type.QUEEN, Type.QUEEN.getWhiteRepresentation(), position);
    }

    public static Piece createBlackQueen(Position position) {
        return new Queen(Color.BLACK, Type.QUEEN, Type.QUEEN.getBlackRepresentation(), position);
    }


    public boolean isMoveable(Position sourcePosition, Position targetPosition, ChessGame game) {
        List<Direction> moveList = Direction.everyDirection();
        boolean directionCheck = isValidDirection(sourcePosition, targetPosition);
        boolean pathCheck = isValidPath(sourcePosition, targetPosition, game);
        if (directionCheck && pathCheck) return true;
        return false;
    }

    private boolean isValidDirection(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = targetPosition.getY() - sourcePosition.getY();
        if ((dx == 0 || dy == 0) || (dy / dx == 1 || dy / dx == -1)) {
            return true;
        }
        return false;
    }

    private boolean isValidPath(Position sourcePosition, Position targetPosition, ChessGame game) {
        List<Direction> moveList = Direction.everyDirection();
        int xFrom = sourcePosition.getX();
        int yFrom = sourcePosition.getY();
        int xTo = targetPosition.getX();
        int yTo = targetPosition.getY();
        try {
            for (Direction direction : moveList) {
                checkPathClear(direction, xFrom, yFrom, xTo, yTo, game);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    // 재귀
    private void checkPathClear(Direction direction, int xFrom, int yFrom, int xTo, int yTo, ChessGame game) {
        if (xFrom == xTo && yFrom == yTo) return;
        if (xFrom > 7 || yFrom > 7) return;

        int nx = xFrom + direction.getXDegree();
        int ny = yFrom + direction.getYDegree();
        if(game.checkSquareClear(nx, ny)) {
            checkPathClear(direction, nx, ny, xTo, yTo, game);
        } else {
            throw new IllegalArgumentException("가능한 경로가 아닙니다.");
        }
    }
}
