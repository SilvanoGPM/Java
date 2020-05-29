package br.com.sky.javacore.l39datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTimeAPITest1 {
    public static void main(String[] args) {

        System.out.println("=-=-=-=-=-= LocalDate =-=-=-=-=-=\n");

        LocalDate date = LocalDate.of(2019, Month.AUGUST, 30);
        System.out.println("Ano: " + date.getYear());
        System.out.println("Mês: " + date.getMonth());
        System.out.println("Número do mês: " + date.getMonthValue());
        System.out.println("Dia do mês: " + date.getDayOfMonth());
        System.out.println("Dia da semana: " + date.getDayOfWeek());
        System.out.println("Dias que o mês contém: " + date.lengthOfMonth());
        System.out.println("Dias que o ano contém: " + date.lengthOfYear());
        System.out.println("Ano bissexto? " + date.isLeapYear());
        System.out.println("Dia do mês(Chronofield): " + date.get(ChronoField.DAY_OF_MONTH));

        LocalDate now = LocalDate.now();
        System.out.println("Data completa: " + date);
        System.out.println("Data completa(agora): " + now);
        System.out.println("Data maxima: " + LocalDate.MAX);
        System.out.println("Data minima: " + LocalDate.MIN);

        System.out.println("\n=-=-=-=-=-= LocalTime =-=-=-=-=-=\n");

        LocalTime time = LocalTime.of(23, 10, 42);
        System.out.println("Hora: " + time.getHour());
        System.out.println("Minuto: " + time.getMinute());
        System.out.println("Segundo: " + time.getSecond());
        System.out.println("Hora Formatada: " + time);
        System.out.println("Hora maxima: " + LocalTime.MAX);
        System.out.println("Hora minima: " + LocalTime.MIN);

        System.out.println("\n=-=-=-=-=-= Parsing =-=-=-=-=-=\n");

        LocalDate parseDate = LocalDate.parse("0202-05-29");
        LocalTime parseTime = LocalTime.parse("20:32:32");
        System.out.println("Data convertida de String: " + parseDate);
        System.out.println("Hora convertida de String: " + parseTime);

        System.out.println("\n=-=-=-=-=-= LocalDateTime =-=-=-=-=-=\n");

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(2019, Month.SEPTEMBER , 10, 20, 10, 15);
        LocalDateTime dateTimeAdd = date.atTime(12, 5,20);
        LocalDateTime dateTimeAdd2 = date.atTime(LocalTime.now());
        LocalDateTime dateTimeAdd3 = time.atDate(LocalDate.of(2010, Month.JANUARY, 4));
        LocalDateTime dateTimeAdd4 = time.atDate(LocalDate.now());

        System.out.println(dateTimeNow);
        System.out.println(dateTime);
        System.out.println(dateTimeAdd);
        System.out.println(dateTimeAdd2);
        System.out.println(dateTimeAdd3);
        System.out.println(dateTimeAdd4);

    }
}
