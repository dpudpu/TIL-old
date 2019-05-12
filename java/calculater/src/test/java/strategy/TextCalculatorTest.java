package strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextCalculatorTest {
    @Test
    void test() {
        assertEquals(2, TextCalculator.calculate("3 + 2 * 4 / 10"));
    }
}