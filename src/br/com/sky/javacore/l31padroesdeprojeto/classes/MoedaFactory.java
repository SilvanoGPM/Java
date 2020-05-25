package br.com.sky.javacore.l31padroesdeprojeto.classes;

public class MoedaFactory {
    public static Moeda criarMoeda(Pais pais) {

        if (pais == Pais.BRASIL) return new Real();

        else if (pais == Pais.EUA) return new USDolar();

        else throw new IllegalArgumentException("Country Not Found!");

    }
}
