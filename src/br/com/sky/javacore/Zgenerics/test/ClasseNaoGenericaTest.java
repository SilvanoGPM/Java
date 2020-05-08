package br.com.sky.javacore.Zgenerics.test;

import br.com.sky.javacore.Zgenerics.classes.Carro;
import br.com.sky.javacore.Zgenerics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClasseNaoGenericaTest {
    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.getCarroDisponivel();
        System.out.println("Carro usado por um Mês!");
        carroAlugavel.devolverCarro(carroAlugado);

        System.out.println("------------------------------------");

        ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
        Computador computador = computadorAlugavel.getComputadorDisponivel();
        System.out.println("Computador usado por um Mês!");
        computadorAlugavel.devolverComputador(computador);
    }
}

class CarroAlugavel {
    private List<Carro> carrosDisponiveis = new ArrayList<>();

    {
        this.carrosDisponiveis.add(new Carro("Gol"));
        this.carrosDisponiveis.add(new Carro("BMW"));
    }

    // Alugar
    public Carro getCarroDisponivel() {
        Carro c = this.carrosDisponiveis.remove(0);
        System.out.println("Carros disponives: "+this.carrosDisponiveis);
        System.out.println("Alugando carro: "+c.getNome());
        return c;
    }

    public void devolverCarro(Carro c) {
        System.out.println("Devolvendo carro: "+c.getNome());
        this.carrosDisponiveis.add(c);
        System.out.println("Carros disponives: "+this.carrosDisponiveis);
    }
}

class ComputadorAlugavel {
    private List<Computador> computadorDisponiveis = new ArrayList<>();

    {
        this.computadorDisponiveis.add(new Computador("AlienWare"));
        this.computadorDisponiveis.add(new Computador("HP"));
    }

    // Alugar
    public Computador getComputadorDisponivel() {
        Computador c = this.computadorDisponiveis.remove(0);
        System.out.println("PCs disponives: "+this.computadorDisponiveis);
        System.out.println("Alugando PC: "+c.getNome());
        return c;
    }

    public void devolverComputador(Computador c) {
        System.out.println("Devolvendo PC: "+c.getNome());
        this.computadorDisponiveis.add(c);
        System.out.println("PCs disponives: "+this.computadorDisponiveis);
    }
}

