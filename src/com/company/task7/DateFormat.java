package com.company.task7;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormat {

    // 4*. Задана строка с датой вида "22.01.2019 19:15:00".
    // Написать метод, который преобразовывает ее в формат "22 Jan, 7:15 PM".
    // Предусмотреть обработку ситуации, если входящая дата в недопустимом формате.

    public static void main(String[] args) {

        String dateString = "22.01.2019 19:15:00";
        formatDateTime(dateString);

    }

    private static void formatDateTime(String s) {
        try {
            LocalDateTime newStr = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
            System.out.println(newStr.format(DateTimeFormatter.ofPattern("dd MMMM, hh:mm a", Locale.forLanguageTag("us"))));
        } catch (Exception e) {
            System.out.println("Wrong date/time format: " + s);
        }
    }

}