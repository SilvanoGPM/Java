package br.com.sky.javacore.l33lambdas.classes;

public class ComparadorCarro {
    public static int compareByColor(Carro c1, Carro c2) {
        return c1.getCor().compareTo(c2.getCor());
    }

    public int compareByYear(Carro c1, Carro c2) {
        return ((Integer) c2.getAno()).compareTo(c1.getAno());
    }

}
