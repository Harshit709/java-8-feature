package org.example.lambda;

// Functional interface to find the maximum of two numbers
@FunctionalInterface
interface CheckMax {
    Integer Max(int a, int b);
}

// Functional interface to calculate the area of a rectangle
@FunctionalInterface
interface CalculateArea {
    Integer Calculate(int length, int width);
}

// Functional interface with a method to print a hello message
@FunctionalInterface
interface FunctionType {
    void hello();
}

public class Main {
    public static void main(String[] args) {
        // Requirement: Implement a lambda expression to find the maximum of two numbers
        CheckMax max = (a, b) -> {
            if (a >= b)
                return a;
            else
                return b;
        };

        // Requirement: Implement a lambda expression to calculate the area of a rectangle
        CalculateArea area = (a, b) -> {
            return a * b;
        };

        // Requirement: Use the max lambda to find the maximum of 4 and 6
        Integer result = max.Max(4, 6);
        System.out.println("Max Number is: " + result);

        // Requirement: Use the area lambda to calculate the area of a rectangle with length 8 and width 4
        Integer areaResult = area.Calculate(8, 4);
        System.out.println("Area of rectangle: " + areaResult);

        // Requirement: Implement a lambda expression to print a hello message
        FunctionType functionCalled = () -> System.out.println("Hello Harshit");
        functionCalled.hello();

        // Requirement: Implement another lambda expression to print a different hello message
        FunctionType newFunction = () -> System.out.println("Hello World");
        newFunction.hello();
    }
}
