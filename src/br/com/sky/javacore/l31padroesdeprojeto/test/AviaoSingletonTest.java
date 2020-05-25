package br.com.sky.javacore.l31padroesdeprojeto.test;

import br.com.sky.javacore.l31padroesdeprojeto.classes.Aviao;
import br.com.sky.javacore.l31padroesdeprojeto.classes.AviaoSingleton;

public class AviaoSingletonTest {
    public static void main(String[] args) {
        agendarAssento("1A");
        agendarAssento("1A");
    }

    private static void agendarAssento(String assento) {
        AviaoSingleton a = AviaoSingleton.getINSTANCE();
        System.out.println(a.bookAssento(assento));
    }
}
