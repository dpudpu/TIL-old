package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        this.directions = new ArrayList<>(directions);
    }

    public Position move(Position position) {
        final Direction direction = directions.get(position.value());
        return position.move(direction.move());
    }
}
