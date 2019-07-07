package domain.ladder;

import java.util.List;

@FunctionalInterface
public interface DirectionsGenerator {
    List<Direction> generate(int size);
}
