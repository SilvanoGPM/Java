package br.com.sky.javacore.l31padroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class Aviao {

    private Set<String> assentosDisponiveis;
    private static Aviao instance;

    private Aviao() {
        this.assentosDisponiveis = new HashSet<>();
        this.assentosDisponiveis.add("1A");
        this.assentosDisponiveis.add("1B");
    }

    public static Aviao createAviao() {
        if (instance == null) {
            System.out.println("Criou");
            instance = new Aviao();
        }
        return instance;
    }

    public boolean bookAssento(String assento) {
        return this.assentosDisponiveis.remove(assento);
    }

}
