package domain.player;

import java.util.Objects;

public class Position implements Comparable<Position>{
    static final int MIN_LENGTH = 1;

    private final int position;

    private Position(final int position) {
        validateLength(position);
        this.position = position;
    }

    public static Position from(final int position) {
        return new Position(position);
    }

    public Position move(final int direction) {
        return new Position(this.position + direction);
    }

    private void validateLength(final int position) {
        if (position < MIN_LENGTH) {
            throw new IllegalArgumentException("포지션은 1 이상");
        }
    }

    @Override
    public int compareTo(final Position o) {
        return this.position-o.position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
