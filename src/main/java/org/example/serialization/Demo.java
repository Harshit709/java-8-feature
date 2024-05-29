package org.example.serialization;

import java.io.*;

// Demo class implements Serializable interface for object serialization
public class Demo implements Serializable {
    // Class fields to be serialized
    public int a;
    public String b;

    // Constructor to initialize the Demo object
    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

class Test {
    public static void main(String[] args) throws IOException {
        // Creating an instance of the Demo class
        Demo object = new Demo(1, "Hey Java");
        String filename = "file.ser";

        // Serialization process
        try {
            // Saving the object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of the object
            out.writeObject(object);

            // Closing the ObjectOutputStream and FileOutputStream
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        // Setting the object to null to demonstrate deserialization
        Demo object1 = null;

        // Deserialization process
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of the object
            object1 = (Demo) in.readObject();

            // Closing the ObjectInputStream and FileInputStream
            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            // Printing the data of the deserialized object
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
