package br.com.sky.javacore.l25colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        List<String> numeros = new ArrayList<>();
        numeros.add("Silvano");
        numeros.add("Gabriel");
        numeros.add("Pimentel");
        numeros.add("Marques");

        // -(ponto de inserção) -1

        Collections.sort(numeros);
        int search = Collections.binarySearch(numeros, "silvano");
        if (search > -1) System.out.println(numeros.get(search));
        else System.out.println("O valor a ser procurado não existe! {"+search+"}");
    }
}
