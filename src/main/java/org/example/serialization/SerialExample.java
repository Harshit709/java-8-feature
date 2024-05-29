package org.example.serialization;

import java.io.*;

// Emp class implements Serializable interface for object serialization
class Emp implements Serializable {
    // Unique identifier for serialization
    private static final long serialVersionUID = 129348938L;
    // Transient fields are not serialized
    transient int a;
    // Static fields are not serialized since they are class-level fields
    static int b;
    String name;
    int age;

    // Constructor to initialize the Emp object
    public Emp(String name, int age, int a, int b) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }
}

public class SerialExample {
    // Method to print the data of Emp object
    public static void printdata(Emp object1) {
        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }

    public static void main(String[] args) {
        // Creating an instance of Emp class
        Emp object = new Emp("ab", 20, 2, 1000);
        String filename = "shubham.txt";

        // Serialization process
        try {
            // Saving the object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            // Closing the ObjectOutputStream and FileOutputStream
            out.close();
            file.close();

            System.out.println("Object has been serialized\n" + "Data before Deserialization:");
            // Printing the data before deserialization
            printdata(object);

            // Changing the value of the static variable b
            object.b = 2000;

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        // Setting the object to null to demonstrate deserialization
        object = null;

        // Deserialization process
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object = (Emp) in.readObject();

            // Closing the ObjectInputStream and FileInputStream
            in.close();
            file.close();

            System.out.println("Object has been deserialized\n" + "Data after Deserialization:");
            // Printing the data after deserialization
            printdata(object);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}

/*
Description for Output: You have seen while deserializing the object the values of a and b has changed. The reason being a was marked as transient and b was static.
 */
