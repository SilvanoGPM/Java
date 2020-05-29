package br.com.sky.javacore.l38completablefuture.test;

import br.com.sky.javacore.l38completablefuture.classes.Loja;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class LojaTest2 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Loja> lojas = asList(
                new Loja("Americanas"),
                new Loja("Casas Bahia"),
                new Loja("Casas Bahia"),
                new Loja("Casas Bahia"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("BestBuy"),
                new Loja("Wallmart")
        );
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(lojas.size());
//        acharPrecos(lojas);
        acharPrecos2(lojas);
//        acharPrecos3(lojas);
        acharPrecos4(lojas);
        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), tf -> {
                Thread t = new Thread(tf);
                t.setDaemon(true);
                return t;
        });
        acharPrecos4(lojas, executor);


    }

    private static List<String> acharPrecos(List<Loja> lojas) {
        System.out.println("Stream Sequencial");
        long start = System.currentTimeMillis();


        List<String> lojasPrecos = lojas.stream()
                .map(loja -> String.format("%s o preco é: $%.2f", loja.getNome(), loja.getPreco()))
                .collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }

    private static List<String> acharPrecos2(List<Loja> lojas) {
        System.out.println("Stream Paralelo");
        long start = System.currentTimeMillis();


        List<String> lojasPrecos = lojas.parallelStream()
                .map(loja -> String.format("%s o preco é: $%.2f", loja.getNome(), loja.getPreco()))
                .collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }

    private static List<String> acharPrecos3(List<Loja> lojas) {
        System.out.println("Completable Future Sequencial");
        long start = System.currentTimeMillis();

        List<String> lojasPrecos = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é: $%.2f", loja.getNome(), loja.getPreco())
                ))
                .map(CompletableFuture::join)
                .collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }

    private static List<String> acharPrecos4(List<Loja> lojas) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é: $%.2f", loja.getNome(), loja.getPreco())
                ))
                .collect(toList());

        List<String> lojasPrecos = precoFuturo.stream().map(CompletableFuture::join).collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }

    private static List<String> acharPrecos4(List<Loja> lojas, Executor executor) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é: $%.2f", loja.getNome(), loja.getPreco(), executor)
                ))
                .collect(toList());

        List<String> lojasPrecos = precoFuturo.stream().map(CompletableFuture::join).collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }
}

