package robottracker;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

import static robottracker.RobotTracker.ROTATION.*;

public class RobotTracker {

    public enum ROTATION {LEFT, RIGHT}

    private enum DIRECTION {UP, RIGHT, DOWN, LEFT}

    private DIRECTION currentDirection = DIRECTION.UP;

    private enum VISIT_STATUS {VISITED, CANNOT_VISIT}

    private DIRECTION getDirectionFromRotation(ROTATION rotation) {
        DIRECTION newDirection = null;
        switch (rotation) {
            case LEFT:
                newDirection = DIRECTION.values()[3 - currentDirection.ordinal()];
                break;
            case RIGHT:
                newDirection = DIRECTION.values()[(currentDirection.ordinal() + 1) % 4];
                break;
            default:
                throw new IllegalArgumentException("Invalid Direction");
        }
        return newDirection;
    }

    private DIRECTION getCounterDirectionFromRotation(ROTATION rotation){
        DIRECTION counterDirection = null;
        if (rotation == LEFT) {
            counterDirection = DIRECTION.values()[(currentDirection.ordinal() + 1) % 4];
        }else if (rotation == RIGHT) {
            counterDirection = DIRECTION.values()[3 - currentDirection.ordinal()];
        }else if (rotation == null) {
            counterDirection = DIRECTION.values()[(currentDirection.ordinal() + 2) % 4];
        }
        return counterDirection;
    }

    private Position currentPosition = position(0, 0);

    private Stack<ROTATION> historicRotation = new Stack<>();

    private Position getNewPosition(DIRECTION direction) {
        Position newPosition = null;
        switch (direction) {
            case LEFT:
                newPosition = position(currentPosition.x, currentPosition.y - 1);
                break;
            case DOWN:
                newPosition = position(currentPosition.x + 1, currentPosition.y);
                break;
            case RIGHT:
                newPosition = position(currentPosition.x, currentPosition.y + 1);
                break;
            case UP:
                newPosition = position(currentPosition.x - 1, currentPosition.y);
                break;
            default:
                throw new IllegalArgumentException("Invalid Position");
        }
        return newPosition;
    }

//    public boolean isVisited(ROTATION rotation) {
//        DIRECTION direction = getDirectionFromRotation(rotation);
//        Position newPosition = getNewPosition(direction);
//        return ;
//    }

    public boolean canVisit(ROTATION rotation) {
        DIRECTION direction = currentDirection;
        if (rotation != null) {
            direction = getDirectionFromRotation(rotation);
        }
        Position newPosition = getNewPosition(direction);
        return !traversed.containsKey(newPosition);
    }

    private static class Position {

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    private Position position(int x, int y) {
        return new Position(x, y);
    }

    private Map<Position, VISIT_STATUS> traversed = new HashMap<>();

    public void cleanInPosition() {
        this.traversed.put(currentPosition, VISIT_STATUS.VISITED);
    }

    public void moveAndClean(ROTATION rotation) {
        DIRECTION direction = currentDirection;
        if (rotation != null) {
            direction = getDirectionFromRotation(rotation);
            this.currentDirection = direction;
            this.historicRotation.push(rotation == LEFT ? RIGHT : LEFT);
        }
        this.currentPosition = getNewPosition(direction);
        cleanInPosition();
    }

    public void cannotClean(ROTATION fromRotation) {
        this.traversed.put(currentPosition, VISIT_STATUS.CANNOT_VISIT);
        DIRECTION counterDirection = getCounterDirectionFromRotation(fromRotation);
        this.currentDirection = counterDirection;
        this.currentPosition = getNewPosition(counterDirection);
    }

    public void retreat() {
        ROTATION pop = this.historicRotation.pop();
        DIRECTION direction = getDirectionFromRotation(pop);
        this.currentDirection = direction;
        this.currentPosition = getNewPosition(direction);
    }
}
