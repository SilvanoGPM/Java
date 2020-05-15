package br.com.sky.javacore.l1introducaoclasses.test;

import br.com.sky.javacore.l1introducaoclasses.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.modelo = "Fusca";
        carro.placa = "ABCD431";
        carro.velocidadeMaxima = 243.20f;
        System.out.println(carro.modelo);
        System.out.println(carro.placa);
        System.out.println(carro.velocidadeMaxima);
    }
}
