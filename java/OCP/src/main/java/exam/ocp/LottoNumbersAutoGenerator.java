package exam.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersAutoGenerator {
    private ShuffleStrategy shuffleStrategy;

    public LottoNumbersAutoGenerator(final ShuffleStrategy shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            numbers.add(i);
        }

        numbers = shuffleStrategy.shuffle(numbers);

        return numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE);
    }
}


