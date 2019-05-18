package cal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorEnumTest {
    @Test
    void name() {
        System.out.println(CalculatorEnum.valueOf("MINUS"));
    }

    @Test
    void calculateTest() {
        assertEquals(3, CalculatorEnum.calculate("+", 1, 2));
    }
}