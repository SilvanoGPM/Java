package br.com.sky.javacore.l31padroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingleton {
    // EAGER INITIALIZATION
    // private static final AviaoSingleton INSTANCE = new AviaoSingleton();
    private static AviaoSingleton INSTANCE;
    private Set<String> assentosDisponiveis;

//    public static AviaoSingleton getINSTANCE() {
//        return INSTANCE;
//    }

    public synchronized static AviaoSingleton getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Aviao.class) {
                if (INSTANCE == null) INSTANCE = new AviaoSingleton();
            }
        }
        return INSTANCE;
    }

    private AviaoSingleton() {
        this.assentosDisponiveis = new HashSet<>();
        this.assentosDisponiveis.add("1A");
        this.assentosDisponiveis.add("1B");
    }

    public boolean bookAssento(String assento) {
        return this.assentosDisponiveis.remove(assento);
    }

}
