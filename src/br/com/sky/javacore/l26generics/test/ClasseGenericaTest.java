package br.com.sky.javacore.l26generics.test;

import br.com.sky.javacore.l26generics.classes.Carro;
import br.com.sky.javacore.l26generics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Gol"));
        carros.add(new Carro("BMW"));
        ObjetosAlugaveis<Carro> carroAlugavel = new ObjetosAlugaveis<>(carros);
        Carro c = carroAlugavel.getObjetoDisponivel();
        System.out.println("Usando Carro por um Mês!");
        carroAlugavel.devolverObjeto(c);

        System.out.println("------------------------------------------");

        List<Computador> computadores = new ArrayList<>();
        computadores.add(new Computador("AlienWare"));
        computadores.add(new Computador("HP"));
        ObjetosAlugaveis<Computador> computadoresAlugaveis = new ObjetosAlugaveis<>(computadores);
        Computador computador = computadoresAlugaveis.getObjetoDisponivel();
        System.out.println("Usando computador por um Mês!");
        computadoresAlugaveis.devolverObjeto(computador);
    }
}

// T = Type

class ObjetosAlugaveis<T> {
    private List<T> objetosDisponiveis = new ArrayList<>();

    public ObjetosAlugaveis(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    // Alugar
    public T getObjetoDisponivel() {
        T c = this.objetosDisponiveis.remove(0);
        System.out.println("Objetos disponives: "+this.objetosDisponiveis);
        System.out.println("Alugando objeto: "+c);
        return c;
    }

    public void devolverObjeto(T c) {
        System.out.println("Devolvendo objeto: "+c);
        this.objetosDisponiveis.add(c);
        System.out.println("Objetos disponives: "+this.objetosDisponiveis);
    }
}

class DoisAtributos<T, F> {
   T um;
   F dois;

    public DoisAtributos(T um, F dois) {
        this.um = um;
        this.dois = dois;
    }
}
