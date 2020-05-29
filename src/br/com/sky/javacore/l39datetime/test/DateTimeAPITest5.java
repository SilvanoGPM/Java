package br.com.sky.javacore.l39datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeAPITest5 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        String s4 = "2020-05-29+5:00";
        String s5 = "20200529";

        LocalDate parse = LocalDate.parse(s5, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);

        LocalDateTime dateTime = LocalDateTime.now();
        String s6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println(s6);

        String s7 = "2020-05-29T13:23:42.225";
        LocalDateTime dateTimeParse = LocalDateTime.parse(s7);
        System.out.println(dateTimeParse);

        DateTimeFormatter formatterBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDate.now().format(formatterBr));

        String br = "01/12/2020";
        LocalDate dateBr = LocalDate.parse(br, formatterBr);
        System.out.println(dateBr);

        DateTimeFormatter formatterFr = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.CHINA);
        String formatFr = LocalDate.now().format(formatterFr);
        System.out.println(formatFr);

        String fr = "29.五月.2020";
        LocalDate dateFr = LocalDate.parse(fr, formatterFr);
        System.out.println(dateFr);

    }
}
