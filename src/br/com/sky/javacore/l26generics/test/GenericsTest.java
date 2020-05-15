package br.com.sky.javacore.l26generics.test;

import br.com.sky.javacore.l25colecoes.classes.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        // Type Erasure
        List list = new ArrayList();
        list.add(new Consumidor("Silvano", "123"));

        System.out.println(list);
    }
}
