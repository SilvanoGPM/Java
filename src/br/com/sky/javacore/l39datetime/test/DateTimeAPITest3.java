package br.com.sky.javacore.l39datetime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest3 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020, Month.FEBRUARY, 25);
        System.out.println(localDate);
        localDate = localDate.withYear(2017);
        localDate = localDate.withMonth(Month.JANUARY.getValue());
        localDate = localDate.withDayOfMonth(20);
        System.out.println(localDate);
        localDate = localDate.with(ChronoField.DAY_OF_MONTH, 1);
        System.out.println(localDate);
        localDate = localDate.plusMonths(2);
        localDate = localDate.plus(10, ChronoUnit.DAYS);
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        localTime = localTime.withHour(2).plus(30, ChronoUnit.HOURS);
        System.out.println(localTime);
    }
}
