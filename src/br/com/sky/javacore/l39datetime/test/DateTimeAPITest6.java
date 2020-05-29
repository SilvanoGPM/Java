package br.com.sky.javacore.l39datetime.test;

import com.sun.scenario.effect.Offset;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class DateTimeAPITest6 {
    public static void main(String[] args) {
        for (Map.Entry<String, String> entry : ZoneId.SHORT_IDS.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("-------------------------------------------------");
        System.out.println(ZoneId.systemDefault());
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyo);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        dateTime.atZone(tokyo);
        System.out.println(dateTime);

        ZonedDateTime tokyoZoned = Instant.now().atZone(tokyo);
        System.out.println(tokyoZoned);

        System.out.println(ZoneOffset.MIN);
        System.out.println(ZoneOffset.MAX);
        ZoneOffset manausZone = ZoneOffset.of("-04:00");
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), manausZone));

        System.out.println((Instant.now().atOffset(manausZone)));

        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);
        LocalDate antigamente = LocalDate.of(1900, 2, 1);
        System.out.println(JapaneseDate.from(antigamente));

    }
}
