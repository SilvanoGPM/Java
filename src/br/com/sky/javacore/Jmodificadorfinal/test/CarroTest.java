package br.com.sky.javacore.Jmodificadorfinal.test;

import br.com.sky.javacore.Jmodificadorfinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c = new Carro();

        c.getComprador().setNome("Sky");
        System.out.println(c.getComprador());
    }
}
