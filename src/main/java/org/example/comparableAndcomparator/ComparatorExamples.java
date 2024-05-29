package org.example.comparableAndcomparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExamples {
    public static void main(String[] args) {
        // Create a list of PersonWithComparator objects
        List<PersonWithComparator> people = new ArrayList<>();
        people.add(new PersonWithComparator("Alice", 30));
        people.add(new PersonWithComparator("Bob", 25));
        people.add(new PersonWithComparator("Charlie", 35));
        people.add(new PersonWithComparator("David", 40));
        people.add(new PersonWithComparator("Edward", 20));
        people.add(new PersonWithComparator("Frank", 32));
        people.add(new PersonWithComparator("George", 35));
        people.add(new PersonWithComparator("Henry", 28));
        people.add(new PersonWithComparator("Isabel", 30));
        people.add(new PersonWithComparator("Jessica", 27));

        // Sort the list by the length of the names in ascending order
        people.sort(Comparator.comparingInt((PersonWithComparator p) -> p.getName().length()));
        people.forEach(System.out::println);

        System.out.println(".............................................");

        // If two names have the same length, then sort by age in descending order
        people.sort(Comparator.comparingInt((PersonWithComparator p) -> p.getName().length())
                .thenComparing(PersonWithComparator::getAge).reversed());
        people.forEach(System.out::println);

        System.out.println(".............................................");

        // If both name length and age are the same, then sort by name in alphabetical order
        people.sort(Comparator.comparingInt((PersonWithComparator p) -> p.getName().length())
                .thenComparing(PersonWithComparator::getAge).reversed()
                .thenComparing(PersonWithComparator::getName));
        people.forEach(System.out::println);

        System.out.println(".............................................");

        // Primary Sorting Criteria: Sort by the number of vowels in the name, in descending order
        // Secondary Sort Criteria: If two names have the same number of vowels, sort by age in ascending order
        // Tertiary Sort Criteria: If both the number of vowels and age are the same, sort by the length of the name in descending order
        // Quaternary Sort Criteria: If all previous criteria are the same, sort by the reverse alphabetical order of the name
        people.sort(Comparator.comparingInt(ComparatorExamples::countVowels).reversed()
                .thenComparing(PersonWithComparator::getAge)
                .thenComparing((PersonWithComparator p) -> p.getName().length()).reversed()
                .thenComparing(PersonWithComparator::getName));
        people.forEach(System.out::println);
    }

    // Method to count the number of vowels in a person's name
    private static int countVowels(PersonWithComparator person) {
        String name = person.getName().toLowerCase();
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
