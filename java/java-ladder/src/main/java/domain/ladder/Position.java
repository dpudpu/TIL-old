package domain.ladder;

import java.util.Objects;

public class Position implements Comparable<Position>{
    static final int MIN_RANGE = 0;

    private final int position;

    private Position(final int position) {
        validate(position);
        this.position = position;
    }

    private void validate(final int position) {
        if (position < MIN_RANGE) {
            throw new IllegalArgumentException("포지션은 "+ MIN_RANGE +" 이상");
        }
    }

    public static Position from(final int position) {
        return new Position(position);
    }

    public int value() {
        return position;
    }

    public Position move(final int direction) {
        return new Position(this.position + direction);
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
