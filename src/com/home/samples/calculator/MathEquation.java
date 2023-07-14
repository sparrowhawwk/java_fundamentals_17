package com.home.samples.calculator;

public class MathEquation {
    double leftValue = 0.0d;
    double rightValue = 0.0d;
    double result = 0.0d;
    char opCode = 'm';

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
    }
}
