package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperator {
    private static final int TIME_LENGTH = 4;
    public static LocalDateTime parseDateTime(String date, String time) {
        String processedTime = time.length() == TIME_LENGTH ? "0" + time : time;
        String dateTime = date + " " + processedTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static String normilizeDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
