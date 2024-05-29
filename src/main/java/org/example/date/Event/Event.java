package org.example.date.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Event {
    // Properties of the Event class
    private String name;
    private Date startTimeUTC;
    private Date endTimeUTC;
    private String timeZone;

    // Constructor to initialize the Event object
    public Event(String name, String startTimeLocal, String endTimeLocal, String timeZone) throws ParseException {
        // Set the name and time zone of the event
        this.name = name;
        this.timeZone = timeZone;

        // Convert local start and end times to UTC
        this.startTimeUTC = convertLocalToUTC(startTimeLocal, timeZone);
        this.endTimeUTC = convertLocalToUTC(endTimeLocal, timeZone);
    }

    // Getter and setter methods for the name property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for the startTimeUTC property
    public Date getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(Date startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    // Getter and setter methods for the endTimeUTC property
    public Date getEndTimeUTC() {
        return endTimeUTC;
    }

    public void setEndTimeUTC(Date endTimeUTC) {
        this.endTimeUTC = endTimeUTC;
    }

    // Getter and setter methods for the timeZone property
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    // Method to convert local time to UTC
    private Date convertLocalToUTC(String localTime, String timeZone) throws ParseException {
        // Create a SimpleDateFormat object for parsing local time
        SimpleDateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        // Parse the local time string to a Date object
        Date localDate = localFormat.parse(localTime);

        // Create a SimpleDateFormat object for formatting UTC time
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        // Format the local date to UTC time string
        String utcTimeString = utcFormat.format(localDate);

        // Parse the formatted UTC time string to a Date object and return
        return utcFormat.parse(utcTimeString);
    }

    // Method to convert UTC time to local time in a specified time zone
    public String getLocalStartTime(String userTimeZone) {
        return convertUTCToLocal(startTimeUTC, userTimeZone);
    }

    public String getLocalEndTime(String userTimeZone) {
        return convertUTCToLocal(endTimeUTC, userTimeZone);
    }

    private String convertUTCToLocal(Date utcDate, String timeZone) {
        // Create a SimpleDateFormat object for formatting local time
        SimpleDateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        // Format the UTC date to local time in the specified time zone
        return localFormat.format(utcDate);
    }
}
