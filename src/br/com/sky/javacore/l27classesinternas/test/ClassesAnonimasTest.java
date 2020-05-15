package br.com.sky.javacore.l27classesinternas.test;


import br.com.sky.javacore.l26generics.classes.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Animal {
    public void andar() {
        System.out.println("Andando...");
    }
}


public class ClassesAnonimasTest {
    public static void main(String[] args) {
        Animal a = new Animal() {
            public void andar() {
                System.out.println("Andando anonimamente...");
            }
        };
        a.andar();

        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("BMW"));
        carros.add(new Carro("AUDI"));
        Collections.sort(carros, new Comparator<Carro>() {

            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println(carros);
    }

}

class CarroComparator implements Comparator<Carro> {

    @Override
    public int compare(Carro o1, Carro o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
