package br.com.sky.javacore.l31padroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public enum AviaoSingletonEnum {
    INSTANCE;
    private Set<String> assentosDisponiveis;

    AviaoSingletonEnum() {
        this.assentosDisponiveis = new HashSet<>();
        this.assentosDisponiveis.add("1A");
        this.assentosDisponiveis.add("1B");
    }

    public boolean bookAssento(String assento) {
        return this.assentosDisponiveis.remove(assento);
    }

    public static void agendarAssento(String assento) {
        AviaoSingletonEnum a = AviaoSingletonEnum.INSTANCE;
        System.out.println(a.bookAssento(assento));
    }
}
