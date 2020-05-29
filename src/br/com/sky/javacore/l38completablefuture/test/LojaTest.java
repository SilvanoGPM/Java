package br.com.sky.javacore.l38completablefuture.test;

import br.com.sky.javacore.l38completablefuture.classes.Loja;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LojaTest {
    public static void main(String[] args) {

        Loja americanas = new Loja();
        Loja casasBahia = new Loja();
        Loja bestBuy = new Loja();
        Loja wallmart = new Loja();

        long start = System.currentTimeMillis();

//        System.out.printf("americanas: $%.2f%n", americanas.getPreco());
//        System.out.printf("casas bahia: $%.2f%n", casasBahia.getPreco());
//        System.out.printf("bestbuy: $%.2f%n", bestBuy.getPreco());
//        System.out.printf("wallmart: $%.2f%n", wallmart.getPreco());

        Future<Double> americanasPreco = americanas.getPrecoAsyncTunado();
        Future<Double> casasBahiaPreco = casasBahia.getPrecoAsyncTunado();
        Future<Double> bestBuyPreco = bestBuy.getPrecoAsyncTunado();
        Future<Double> wallmartPreco = wallmart.getPrecoAsyncTunado();

        long end = System.currentTimeMillis();
        System.out.println("Tempo de invocação: " + (end - start) + "ms");
        enrolando();
        try {
            System.out.printf("Americanas: $%.2f%n", americanasPreco.get(3, TimeUnit.SECONDS));
            System.out.printf("Casas Bahia: $%.2f%n", casasBahiaPreco.get(3, TimeUnit.SECONDS));
            System.out.printf("Bestbuy: $%.2f%n", bestBuyPreco.get(3, TimeUnit.SECONDS));
            System.out.printf("Wallmart: $%.2f%n", wallmartPreco.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo para pegar os resultados: " + (end - start) + "ms");
    }

    private static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        System.out.println(soma);
    }

}
