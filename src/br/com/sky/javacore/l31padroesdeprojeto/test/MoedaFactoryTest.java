package br.com.sky.javacore.l31padroesdeprojeto.test;

import br.com.sky.javacore.l31padroesdeprojeto.classes.Moeda;
import br.com.sky.javacore.l31padroesdeprojeto.classes.MoedaFactory;
import br.com.sky.javacore.l31padroesdeprojeto.classes.Pais;

public class MoedaFactoryTest {

    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.criarMoeda(Pais.EUA);
        System.out.println(moeda.getSimbolo());
    }

}
