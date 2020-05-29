package br.com.sky.javacore.l38completablefuture.classes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;
import static java.util.concurrent.ThreadLocalRandom.current;

public class NovaLoja {

    private String nome;

    public NovaLoja() {
    }

    public NovaLoja(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        double preco = calcularPreco();
        Desconto.Code desconto = Desconto.Code.values()[current().nextInt(Desconto.Code.values().length)];
        return String.format("%s:%.2f:%s", nome, preco, desconto);
    }

    private double calcularPreco() {
        delay();
//        System.out.println(1 / 0);
        return current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<NovaLoja> lojas() {
        return asList(
                new NovaLoja("Americanas"),
                new NovaLoja("Casas Bahia"),
                new NovaLoja("BestBuy"),
                new NovaLoja("Wallmart")
        );
    }

    public String getNome() {
        return this.nome;
    }

}
