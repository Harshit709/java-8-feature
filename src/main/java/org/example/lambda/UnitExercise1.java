package org.example.lambda;



import java.util.Arrays;
import java.util.List;

public class UnitExercise1 {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> list = Arrays.asList(
                new Person("harshit", "chouhan", 23),
                new Person("kunal", "rock", 24),
                new Person("tossif", "bhatti", 23),
                new Person("yogesh", "sharma", 20),
                new Person("rahul", "pardeshi", 20)
        );

        // Step 1 -> Sort the list by last name
        sortList sortedList = (list1) -> {
            list1.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
            return list1;
        };
        List<Person> sortedPersons = sortedList.outputList(list);
        System.out.println("Sorted List by Last Name:");
        sortedPersons.forEach(System.out::println);

        // Step 2 -> Create a method to print all elements of the list
        PrintAllEle printAllEle = (list1) -> list1;
        System.out.println("\nAll Elements in the List:");
        printAllEle.printEle(list).forEach(System.out::println);

        // Step 3 -> Create a method that prints all people with last names beginning with 'C'
        PrintLastNameWithC printLastNameWithC = (list1) -> {
            for (Person p : list1) {
                if (p.getLastName().startsWith("c")) {
                    System.out.println(p);
                }
            }
        };
        System.out.println("\nPeople with Last Name Starting with 'C':");
        printLastNameWithC.printWithC(list);
    }
}

// Functional interface for sorting the list
@FunctionalInterface
interface sortList {
    List<Person> outputList(List<Person> inputList);
}

// Functional interface for printing all elements in the list
@FunctionalInterface
interface PrintAllEle {
    List<Person> printEle(List<Person> inputList);
}

// Functional interface for printing people with last names starting with 'C'
@FunctionalInterface
interface PrintLastNameWithC {
    void printWithC(List<Person> inputList);
}