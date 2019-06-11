package exam.ocp;

import java.util.List;

@FunctionalInterface
public interface ShuffleStrategy {
    List<Integer> shuffle(final List<Integer> numbers);
}
