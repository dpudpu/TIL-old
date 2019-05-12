package strategy;

public interface Calculator {
    double calculate(double num1, double num2);
}

class DivideCalculator implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }
}

class MinusCalculator implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

class MultiplyCalculator implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

class PlusCalculator implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}
