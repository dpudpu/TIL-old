package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DirectionsRandomGenerator implements DirectionsGenerator {
    private DirectionsRandomGenerator() {
    }

    public static DirectionsRandomGenerator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public List<Direction> generate(final int size) {
        List<Direction> directions = new ArrayList<>();

        //TODO 리팩토링
        Direction current = Direction.first(nextBoolean());
        directions.add(current);
        for (int i = 0; i < size-2; i++) {
            current = current.next(nextBoolean());
            directions.add(current);
        }
        directions.add(current.last());
        return directions;
    }

    private boolean nextBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    private static class LazyHolder {
        private static final DirectionsRandomGenerator INSTANCE = new DirectionsRandomGenerator();
    }
}
