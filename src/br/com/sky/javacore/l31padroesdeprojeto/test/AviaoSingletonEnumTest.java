package br.com.sky.javacore.l31padroesdeprojeto.test;

import br.com.sky.javacore.l31padroesdeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {
    public static void main(String[] args) {
        AviaoSingletonEnum.agendarAssento("1A");
        AviaoSingletonEnum.agendarAssento("1A");
    }
}
