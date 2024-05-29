package org.example.comparableAndcomparator;

public class PersonWithComparator  {
    private String name;
    private int age;

    public PersonWithComparator(String name, int age) {
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
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }


}
