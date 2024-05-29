package org.example.comparableAndcomparator;
public class PersonWithComparable implements Comparable<PersonWithComparable> {
    private String name;
    private int age;

    public PersonWithComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(PersonWithComparable otherPerson) {
        int ageComparison = Integer.compare(this.age, otherPerson.age);
        if (ageComparison != 0) {
            return ageComparison;
        } else {
            return this.name.compareTo(otherPerson.name);
        }

    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
