package org.example.lambda;

public class RunnableExample {

    public static void main(String[] args) {
        // Requirement: Create a new thread using a lambda expression

        // Create a new Thread object and pass a lambda expression as the Runnable task
        Thread thread = new Thread(() -> {
            // This code will be executed by the new thread
            System.out.println("Hello new thread");
        });

        // Start the thread
        thread.start();  // The 'start' method is used to begin execution of the new thread

        // 'thread.run()' will execute the Runnable's run method on the main thread,
        // which is not what we want if we intend to use threading correctly
    }
}
