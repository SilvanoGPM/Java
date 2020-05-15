package br.com.sky.javacore.l25colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Silvano");
        nomes.add("Gabriel");
        nomes.add("Pimentel");
        nomes.add("Afonso");
        nomes.add("Marques");



        Collections.sort(nomes);
        for (String nome : nomes) {

            System.out.println(nome);
        }

    }
}
