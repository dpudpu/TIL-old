package enums.old;

import java.util.HashMap;
import java.util.Map;

public class CalculatorMapping {
    private static Map<String, Calculator> calculatorMap = new HashMap<>();

    static {
        calculatorMap.put("+", Calculator.PLUS);
        calculatorMap.put("-", Calculator.MINUS);
        calculatorMap.put("*", Calculator.MULTIPLY);
        calculatorMap.put("/", Calculator.DIVIDE);
    }

    public static Calculator getCalculator(String operator) {
        return calculatorMap.get(operator);
    }
}
