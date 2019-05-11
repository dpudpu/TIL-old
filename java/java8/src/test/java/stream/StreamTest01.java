package stream;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;



public class StreamTest01 {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void streamTest01() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> expectedNums = Arrays.asList(2,3,4,5);
        List<Integer> results = nums.stream().map(x -> cal.plus(x, 1)).collect(Collectors.toList());
        results.stream().forEach(x->assertTrue(expectedNums.contains(x)));
        assertThat(cal.plus(2,3)).isEqualTo(5);
    }

    @Test
    void name() {
    }
}
