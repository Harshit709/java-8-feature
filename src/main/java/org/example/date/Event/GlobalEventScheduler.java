package org.example.date.Event;

import java.text.ParseException;

public class GlobalEventScheduler {

    public static void main(String[] args) {
        try {
            // Create an event in New York local time
            Event event = new Event("Conference", "2024-06-21 09:00:00",
                    "2024-06-21 18:00:00",
                    "America/New_York");

            // Display the event details in UTC
            System.out.println("Event: " + event.getName());
            System.out.println("Start Time (UTC): " + event.getStartTimeUTC());
            System.out.println("End Time (UTC): " + event.getEndTimeUTC());


            // Display the event details in another user's local time (e.g., London)
            System.out.println("Start Time (London): " + event.getLocalStartTime("Europe/London"));
            System.out.println("End Time (London): " + event.getLocalEndTime("Europe/London"));

            // Display the event details in another user's local time (e.g., Tokyo)
            System.out.println("Start Time (Tokyo): " + event.getLocalStartTime("Asia/Tokyo"));
            System.out.println("End Time (Tokyo): " + event.getLocalEndTime("Asia/Tokyo"));

            // Display the event details in another user's local time (e.g., India)
            System.out.println("Start Time (India): " + event.getLocalStartTime("Asia/Kolkata"));
            System.out.println("End Time (India): " + event.getLocalEndTime("Asia/Kolkata"));

        } catch (ParseException e) {
            // If parsing exception occurs (e.g., invalid date format), print the stack trace
            e.printStackTrace();
        }
    }
}
