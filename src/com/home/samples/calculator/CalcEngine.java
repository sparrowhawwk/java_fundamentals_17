package com.home.samples.calculator;

import java.util.Scanner;

public class CalcEngine {
    public static void main(String[] args) {
        if (args.length == 3) {
            handleCommandLine(args);
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if (args.length == 0) {
            defaultOperation();
        } else {
            printGuideLines();
        }
    }

    private static void printGuideLines() {
        System.out.println("please a valid format for the operation");
        System.out.println("Operation code followed by two number !");
    }

    private static void defaultOperation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('m', 10.0d, 50.0d);
        equations[1] = new MathEquation('d', 50.0d, 2.0d);
        equations[2] = new MathEquation('a', 25.0d, 15.0d);
        equations[3] = new MathEquation('s', 75.0d, 15.0d);
        for (var equation : equations) {
            if (equations.length <= MathEquation.limit) {
                equation.execute();
                System.out.println(equation.getResult());
            }
        }
        System.out.println("Average calculation result is = " + MathEquation.getAverageResult());
        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();
        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println(equationOverload.getResult());

        // test the above overload with integers
        int leftInt = 5;
        int rightInt = 2;
        equationOverload.execute(leftInt, rightInt);
        System.out.println(equationOverload.getResult());
    }

    private static void handleCommandLine(String[] args) {
        char opCode = getOpCodeFromString(args[0]);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(leftVal, rightVal, opCode);
        System.out.println(result);
    }

    private static void executeInteractively() {
        System.out.println("Enter an operation name followed by two numbers!");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] inputParts = userInput.split(" ");
        performOperation(inputParts);
    }

    private static void performOperation(String[] inputParts) {
        char opCode = getOpCodeFromString(inputParts[0]);
        double leftVal = getDoubleFromString(inputParts[1]);
        double rightVal = getDoubleFromString(inputParts[2]);
        double result = execute(leftVal, rightVal, opCode);
        displayResult(opCode, leftVal, rightVal, result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = getSymbolFromOpCode(opCode);
        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(" ");
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);
        String output = sb.toString();
        System.out.println(output);
    }

    private static double execute(double leftVal, double rightVal, char opCode) {
        double result = 0.0d;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode " + opCode);
                result += 0.0d;
                break;
        }
        return result;
    }

    private static char getOpCodeFromString(String operation) {
        return operation.charAt(0);
    }

    private static double getDoubleFromString(String numberName) {
        String[] numberNames = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        double d = 0.0d;
        for (int i = 0; i < numberNames.length; i++) {
            if (numberName.equals(numberNames[i])) {
                d += i;
                break;
            }
        }
        return d;
    }

    private static char getSymbolFromOpCode(char opCode) {
        char[] opCodes = {'m', 'd', 'a', 's'};
        char[] symbols = {'*', '/', '+', '-'};
        char symbol = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if (opCode == opCodes[i]) {
                symbol = symbols[i];
                break;
            }
        }
        return symbol;
    }
}
