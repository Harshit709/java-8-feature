package org.example.lambda;

// Functional interface to define a method that returns the length of a string
@FunctionalInterface
interface StringLength {
    int stringLengthMethod(String inputString);
}

public class TypeInferenceExample {

    public static void main(String[] args) {
        // Requirement: Implement a lambda expression to find the length of a given string

        // Lambda expression that implements the stringLengthMethod of the StringLength interface
        StringLength length = (input) -> input.length();

        // Test the lambda expression with the input "harshit" and print the result
        System.out.println("Length of the string 'harshit': " + length.stringLengthMethod("harshit"));
    }
}
