package br.com.sky.javacore.l19datas.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String padrao = "H:m 'Brasil:' d 'de' MMMM',' y";
        SimpleDateFormat sdf = new SimpleDateFormat(padrao);
        System.out.println(sdf.format(c.getTime()));
    }
}
