package strategy;

import java.util.HashMap;
import java.util.Map;

public class CalculatorMapping {
    private static Map<String, Calculator> calculatorMap = new HashMap<>();

    static{
        calculatorMap.put("+",new PlusCalculator());
        calculatorMap.put("-",new MinusCalculator());
        calculatorMap.put("*",new MultiplyCalculator());
        calculatorMap.put("/",new DivideCalculator());
    }

    public static Calculator getCalculator(String operator){
        return calculatorMap.get(operator);
    }
}
