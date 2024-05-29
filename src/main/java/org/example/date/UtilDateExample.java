package org.example.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class UtilDateExample {

    public static void main(String[] args) {
        // 1. Display the current date and time.
        displayCurrentDateTime();

        // 2. Create a date object from milliseconds and display it.
        displayDateFromMilliseconds();

        // 3. Calculate the number of days between two given dates.
        calculateDaysBetweenDates();

        // 4. Parse a date string into a java.util.Date object and then format it into a different string representation.
        parseAndFormatDate();

        // 5. Schedule a task to run at a specific date and time in the future.
        scheduleTaskInFuture();

        // 6. Given a date of birth, calculate the current age.
        calculateAgeFromDateOfBirth();
    }

    // 1. Display the current date and time.
    private static void displayCurrentDateTime() {
        Date currentDate = new Date();
        System.out.println("Current-Date-Time: " + currentDate);
        System.out.println("........................");
    }

    // 2. Create a date object from milliseconds and display it.
    private static void displayDateFromMilliseconds() {
        Date dateInMilliseconds = new Date(25000000L);
        System.out.println("Milliseconds Date: " + dateInMilliseconds);
        System.out.println("........................");
    }

    // 3. Calculate the number of days between two given dates.
    private static void calculateDaysBetweenDates() {
        Date date1 = new Date();
        long tenDaysInMilliseconds = 10L * 24 * 60 * 60 * 1000;
        Date date2 = new Date(date1.getTime() + tenDaysInMilliseconds);

        long diffInMillis = date2.getTime() - date1.getTime();
        long differenceBetweenTwoDates = TimeUnit.MILLISECONDS.toDays(diffInMillis);
        System.out.println("Difference in days: " + differenceBetweenTwoDates);
        System.out.println("........................");
    }

    // 4. Parse a date string into a java.util.Date object and then format it into a different string representation.
    private static void parseAndFormatDate() {
        String dateStr = "2000-04-09";
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

        try {
            Date date = parser.parse(dateStr);
            String formattedDate = formatter.format(date);
            System.out.println("Formatted Date: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("........................");
    }

    // 5. Schedule a task to run at a specific date and time in the future.
    private static void scheduleTaskInFuture() {
        Timer timer = new Timer();
        Date runDate = new Date(new Date().getTime() + 10000); // Schedule to run 10 seconds from now

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task executed at: " + new Date());
                timer.cancel();
            }
        }, runDate);

        System.out.println("Task scheduled for: " + runDate);
        System.out.println("........................");
    }

    // 6. Given a date of birth, calculate the current age.
    private static void calculateAgeFromDateOfBirth() {
        Calendar dob = Calendar.getInstance();
        dob.set(2000, Calendar.APRIL, 9);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        // If birth date is greater than today's date (after comparing month and day), subtract one year
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        System.out.println("Age: " + age);
    }
}
