package stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    Calculator calculator;
    @BeforeAll
    static void initBeforeAll(){
        System.out.println("----initBeforeAll...");
    }

    @BeforeEach
    void setup(){
        System.out.println("----BeforeEach");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        System.out.println("----addsTwoNumbers");
        assertEquals(2, calculator.plus(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        System.out.println("---add");
        assertEquals(expectedResult, calculator.plus(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @Disabled
    @DisplayName("스킵하는 테스트")
    void disabledTest(){
        assertEquals(1,2);
    }
}
