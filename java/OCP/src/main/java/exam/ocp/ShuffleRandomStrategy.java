package exam.ocp;

import java.util.Collections;
import java.util.List;

public class ShuffleRandomStrategy implements ShuffleStrategy {
    private static ShuffleRandomStrategy instance = new ShuffleRandomStrategy();

    private ShuffleRandomStrategy() {
    }

    public static ShuffleRandomStrategy getInstance() {
        return instance;
    }

    public List<Integer> shuffle(final List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }
}
