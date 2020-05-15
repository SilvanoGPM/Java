package br.com.sky.javacore.l25colecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversaoDeListasArraysTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        Integer[] listToArray = new Integer[numeros.size()];
        numeros.toArray(listToArray);
        System.out.println(numeros);
        System.out.println(Arrays.toString(listToArray));

        Integer[] numerosArray2 = new Integer[4];
        numerosArray2[0] = 10;
        numerosArray2[1] = 9;
        numerosArray2[2] = 8;
        numerosArray2[3] = 7;

        List<Integer> arraysToListt = new ArrayList<>();
        List<Integer> arraysToList = Arrays.asList(numerosArray2);
        arraysToListt.addAll(Arrays.asList(numerosArray2));
        System.out.println(Arrays.toString(numerosArray2));
        System.out.println(arraysToList);
        arraysToListt.add(10);
        arraysToListt.add(10);
        arraysToListt.add(10);
        arraysToListt.add(10);
        System.out.println(arraysToListt);
    }
}
