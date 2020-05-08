package br.com.sky.javacore.Rstrings.test;

public class StringTest {
    public static void main(String[] args) {
        String nome1 = "Silvano";
        String nome2 = "Silvano";
        String nome3 = new String("Silvano");

        if (nome1 == nome2) {
            System.out.println("Tudo é igual!");
        } else {
            System.out.println("Tudo não é igual!");
        }

        String test = "  Silvano";

        System.out.println(test.substring(0,test.length()));

        System.out.println(test.trim());
    }
}
