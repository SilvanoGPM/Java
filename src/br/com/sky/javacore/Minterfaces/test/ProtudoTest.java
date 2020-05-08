package br.com.sky.javacore.Minterfaces.test;

import br.com.sky.javacore.Minterfaces.classes.Produto;

public class ProtudoTest {
    public static void main(String[] args) {
        Produto p = new Produto("Notebook",4.0,3000);
        p.calculaFrete();
        p.calcularImposto();
        System.out.println(p);
    }
}
