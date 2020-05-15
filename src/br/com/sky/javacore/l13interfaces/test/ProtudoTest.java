package br.com.sky.javacore.l13interfaces.test;

import br.com.sky.javacore.l13interfaces.classes.Produto;

public class ProtudoTest {
    public static void main(String[] args) {
        Produto p = new Produto("Notebook",4.0,3000);
        p.calculaFrete();
        p.calcularImposto();
        System.out.println(p);
    }
}
