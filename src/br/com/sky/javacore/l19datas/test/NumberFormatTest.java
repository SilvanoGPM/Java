package br.com.sky.javacore.l19datas.test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float valor = 125353.45678f;
        Locale pais = new Locale("","BR");
        Locale locale = new Locale("jp");
        Locale locale2 = new Locale("fr");
        Locale locale3 = new Locale("it");
        NumberFormat[] nb = new NumberFormat[4];
        nb[0] = NumberFormat.getInstance();
        nb[2] = NumberFormat.getInstance(pais);
        nb[1] = NumberFormat.getCurrencyInstance();
        nb[3] = NumberFormat.getCurrencyInstance(pais);
//        for (NumberFormat nf : nb) {
//            System.out.println(nf.format(valor));
//        }

        NumberFormat number = NumberFormat.getInstance();
        number.setMaximumFractionDigits(1);
        number.setParseIntegerOnly(true);

        System.out.println();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println(currency.format(valor));
    }
}
