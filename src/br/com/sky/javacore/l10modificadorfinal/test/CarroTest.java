package br.com.sky.javacore.l10modificadorfinal.test;

import br.com.sky.javacore.l10modificadorfinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c = new Carro();

        c.getComprador().setNome("Sky");
        System.out.println(c.getComprador());
    }
}
