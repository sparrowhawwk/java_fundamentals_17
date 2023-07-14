package com.home.samples.calculator;

public class MathEquation {
    double leftValue;
    double rightValue;
    double result;
    char opCode;
    private static int numberOfCalculations;
    private static double sumOfResults;
    static int limit;

    // initialization block
    // this rus before constructor call and after field initialization
    {
        this.leftValue = 0.0d;
        this.rightValue = 0.0d;
        this.result = 0.0d;
        this.opCode = 'm';
        // numberOfCalculations = 0;
        // sumOfResults = 0.0d;
    }

    static {
        CalculationLimit cl = new CalculationLimit();
        limit = cl.getCalculationLimit();
    }

    MathEquation() {}

    MathEquation(char opCode) {
        this.opCode = opCode;
    }

    MathEquation(char opCode, double leftValue, double rightValue) {
        this(opCode);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    void execute() {
        switch (opCode) {
            case 'a':
                result = leftValue + rightValue;
                break;
            case 's':
                result = leftValue - rightValue;
                break;
            case 'm':
                result = leftValue * rightValue;
                break;
            case 'd':
                result = rightValue != 0 ? leftValue / rightValue : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode " + opCode);
                result += 0.0d;
                break;
        }
        numberOfCalculations++;
        sumOfResults += result;
    }
}
