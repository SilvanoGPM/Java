package br.com.sky.javacore.Ycolecoes.test;

import br.com.sky.javacore.Ycolecoes.classes.Celular;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Celular> celulares = new ArrayList<>();
        celulares.add(new Celular("Silvano","1921"));
        celulares.add(new Celular("Gabriel","3481"));
        celulares.add(new Celular("Nicole","3912"));
        celulares.clear();
        for (Celular cell : celulares) {
            System.out.println(cell);
            System.out.println("###########################");
        }

    }
}