package cal;

public enum CalculatorEnum {
    PLUS("+", new PlusCalculator()),
    MINUS("-", new MinusCalculator()),
    MULTIPLY("*", new MultiplyCalculator()),
    DIVIDE("/", new DivideCalculator());

    private String operator;
    private Calculator calculator;

    CalculatorEnum(String operator, Calculator calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static int calculate(String operator, int num1, int num2) {
        Calculator cal = valueOf(operator).calculator;
        return cal.calculate(num1, num2);
    }
}
