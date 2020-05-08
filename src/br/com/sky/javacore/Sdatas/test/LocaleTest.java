package br.com.sky.javacore.Sdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        Locale[] locale = new Locale[3];
        locale[0] = new Locale("it");
        locale[1] = new Locale("en");
        locale[2] = new Locale("pt");
        Calendar c = Calendar.getInstance();
        c.set(2019, Calendar.DECEMBER, 23);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale[0]);
        System.out.println(df.format(c.getTime()));
    }
}
