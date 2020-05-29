package br.com.sky.javacore.l38completablefuture.test;

import br.com.sky.javacore.l38completablefuture.classes.Desconto;
import br.com.sky.javacore.l38completablefuture.classes.NovaLoja;
import br.com.sky.javacore.l38completablefuture.classes.Orcamento;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class NovaLojaTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<NovaLoja> lojas = NovaLoja.lojas();
//        lojas.stream().forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
//        acharPrecos(lojas);

        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), tf -> {
            Thread t = new Thread(tf);
            t.setDaemon(true);
            return t;
        });
        acharPrecosAsync(lojas, executor);
    }

    private static List<String> acharPrecos(List<NovaLoja> lojas) {
        System.out.println("Stream Sequencial");
        long start = System.currentTimeMillis();

        List<String> lojasPrecos = lojas.stream()
                .map(NovaLoja::getPreco)
                .map(Orcamento::parse)
                .map(Desconto::calcularDesconto)
                .collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }

    private static List<String> acharPrecosAsync(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completable Future Async");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> futures = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                .map(future -> future.thenApply(Orcamento::parse))
                .map(future -> future.thenCompose(orcamento ->
                        CompletableFuture.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)))
                .collect(toList());

        List<String> lojasPrecos = futures.stream().map(CompletableFuture::join).collect(toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: "+(end-start)+"ms");

        System.out.println(lojasPrecos);
        return lojasPrecos;
    }

}
