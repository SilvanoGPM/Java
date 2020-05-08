package br.com.sky.javacore.Ycolecoes.test;

import br.com.sky.javacore.Ycolecoes.classes.Celular;

public class EqualsTest {
    public static void main(String[] args) {
        String nome1 = "Silvano Gabriel";
        String nome2 = "Silvano Gabriel";

        System.out.println(nome1 == nome2);

        Celular c1 = new Celular("IPhone" ,"1234");
        Celular c2 = new Celular("IPhone", "1234");

        System.out.println(c2.equals(c1));
        System.out.println(c1.getImei().hashCode());
        System.out.println(c2.hashCode());
    }
}
