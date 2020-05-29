package br.com.sky.javacore.l39datetime.test;

import br.com.sky.javacore.l39datetime.util.ObeterProximoDiaUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAPITest4 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
        System.out.println(date);

        date = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date);
        date =  LocalDate.now().plusDays(7);
        System.out.println(date.getDayOfWeek());
        date = date.with(new ObeterProximoDiaUtil());
        System.out.println(date.getDayOfWeek());
    }
}
