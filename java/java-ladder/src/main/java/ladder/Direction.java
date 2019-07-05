package ladder;

public enum Direction {
    RIGHT(1), LEFT(-1), STRAIGHT(0);

    private final int direction;

    private Direction(final int direction) {
        this.direction = direction;
    }

    public static Direction first(final boolean right) {
        if (right) {
            return RIGHT;
        }
        return STRAIGHT;
    }


    public int move() {
        return this.direction;
    }

    public Direction next(final boolean right) {
        if (this == RIGHT) {
            return LEFT;
        }
        return right ? RIGHT : STRAIGHT;
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }
}
