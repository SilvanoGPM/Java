package br.com.sky.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultado Cachorro!");
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultado Gato!");
    }
}

public class WildCardTest {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};

        consultarAnimais(cachorros);
//        consultarAnimais(gatos);

        System.out.println("------------------------------------------");

        List<Cachorro> cachorrosList = new ArrayList<>();
        cachorrosList.add(new Cachorro());
        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());

        List<Animal> animalsList = new ArrayList<>();
        consultarAnimaisList(animalsList);
//        consultarAnimaisList(cachorrosList);
//        consultarAnimaisList(gatoList);
    }

    public static void consultarAnimais(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    // ? = Caractere Curinga

    public static void consultarAnimaisList(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    public static void consultarCachorrosList(List<? super Cachorro> cachorroList){
        Cachorro cachorro = new Cachorro();
        Animal animal = new Cachorro();
        Object object = new Cachorro();

        cachorroList.add(new Cachorro());
//        cachorroList.add(new Animal());

    }
}
