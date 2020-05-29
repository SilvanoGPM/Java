package br.com.sky.javacore.l39datetime.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest2 {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(LocalDateTime.now());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
        System.out.println(Instant.ofEpochSecond(1590758522));

        System.out.println("\n-------------- DURATION --------------\n");

        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.of(2017, Month.JANUARY, 1, 23, 0, 0);
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(5, 0, 0);

        // Não se pode usar o LocalDate.
        // Não se pode usar o LocalDateTime junto com LocalTime.

        Duration d1 = Duration.between(dt1, dt2);
        Duration d2 = Duration.between(time1, time2);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
//        Duration d4 = Duration.between(LocalDate.now(), LocalDate.now().plusDays(2));
//        Duration d5 = Duration.between(dt1, time2);
        Duration d6 = Duration.between(dt2, time2.atDate(dt2.toLocalDate()));
        Duration d7 = Duration.ofMinutes(3);
        Duration d8 = Duration.of(3, ChronoUnit.DAYS);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
//        System.out.println(d4);
//        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);

        System.out.println("\n-------------- PERIOD --------------\n");

        Period p1 = Period.between(dt1.toLocalDate(), dt2.toLocalDate());
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(76);
        Period p4 = Period.ofYears(5);
        System.out.println(p1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

//        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())).getMonths());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));

        System.out.println("\n-------------- CHRONOUNIT --------------\n");
        LocalDateTime aniversario = LocalDateTime.of(2004, 5, 23, 12,0,0);
        System.out.println(ChronoUnit.DAYS.between(aniversario, now));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now));
        System.out.println(ChronoUnit.YEARS.between(aniversario, now));

    }
}
