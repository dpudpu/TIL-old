package strategy;

public class TextCalculator {
    public static double calculate(String inputText) {
        String tokens[] = inputText.trim().split(" ");
        double result = toDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double number = toDouble(tokens[i + 1]);
            result = calculate(operator, result, number);
        }
        return result;
    }

    private static double calculate(String operator, double result, double number) {
        return CalculatorMapping.getCalculator(operator).calculate(result, number);
    }

    private static double toDouble(String value) {
        return Double.parseDouble(value);
    }
}



