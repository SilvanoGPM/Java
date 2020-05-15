package br.com.sky.javacore.l19datas.test;

import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDadosTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println("---------------------------------");
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        String s = "CU";
        System.out.println(c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR));
    }
}
