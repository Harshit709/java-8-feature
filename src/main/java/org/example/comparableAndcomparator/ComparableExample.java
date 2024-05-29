package org.example.comparableAndcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        // Create a list of PersonWithComparable objects
        List<PersonWithComparable> people = new ArrayList<>();
        people.add(new PersonWithComparable("Alice", 30));
        people.add(new PersonWithComparable("Bob", 25));
        people.add(new PersonWithComparable("Charlie", 35));

        // Sort the list using the natural ordering defined by the compareTo method in PersonWithComparable class
        people.sort(PersonWithComparable::compareTo);

        // Print the sorted list
        people.forEach(System.out::println);

        System.out.println("............................");

        // Write a program to sort the list of Person objects in descending order by age
        // Use Collections.reverseOrder() with Collections.sort() method
        Collections.sort(people, Collections.reverseOrder());
        people.forEach(System.out::println);

        System.out.println("............................");

        // Modify the Person class so that it sorts primarily by age and secondarily by name if ages are the same
        // Use the natural ordering defined by the compareTo method in PersonWithComparable class
        Collections.sort(people);
        people.forEach(System.out::println);
    }
}
