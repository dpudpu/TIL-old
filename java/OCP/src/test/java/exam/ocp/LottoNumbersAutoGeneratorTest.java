package exam.ocp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumbersAutoGeneratorTest {
    @Test
    void 제대로_리턴하는지_확인() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> expected = new LottoNumbersAutoGenerator((numbers) -> actual).generate();

        assertThat(actual).isEqualTo(expected);
    }
}



