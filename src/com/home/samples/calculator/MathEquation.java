package com.home.samples.calculator;

public class MathEquation {
    static int limit;
    private static int numberOfCalculations;
    private static double sumOfResults;

    // initialization block
    static {
        CalculationLimit cl = new CalculationLimit();
        limit = cl.getCalculationLimit();
    }

    private double leftValue;
    private double rightValue;
    private double result;
    private char opCode;

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

    MathEquation() {
    }

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

    public double getRightValue() {
        return rightValue;
    }

    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public double getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    void execute(double leftValue, double rightValue) {
        this.setLeftValue(leftValue);
        this.setRightValue(rightValue);
        this.execute();
    }

    void execute(int leftInt, int rightInt) {
        this.leftValue = leftInt;
        this.rightValue = rightInt;
        execute();
        result = (int) result;
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

    double getResult() {
        return this.result;
    }
}
