package br.com.sky.javacore.l33lambdas.test;

import br.com.sky.javacore.l33lambdas.classes.Carro;

import static java.util.Arrays.asList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest2 {
    public static void main(String[] args) {
        List<String> nomes = asList("Silvano", "Helbnny", "Mikael", "Victor", "Vitor", "Marlos", "Christian", "Vinicius");

        List<Carro> cars = asList(new Carro("Verde", 1943), new Carro("Preto", 2000), new Carro("Vermelho", 2000), new Carro("Preto", 2010), new Carro("Azul", 2002));

        forEach(nomes, (String s) -> System.out.println(s));

        List<Integer> lengths = map(nomes, (String s) -> s.length());
        System.out.println(lengths);

        Set<Integer> colors = new HashSet<>();
        colors.addAll(map(cars, (Carro c) -> c.getAno()));
        System.out.println(colors);

        Supplier<String> suplier1 = () -> "Helo, World!";
        Supplier<Carro> suplier2 = () -> new Carro("Azul", 2000);

        System.out.println(suplier1.get());
        System.out.println(suplier2.get());

    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();

        for (T e : list) {
            result.add(f.apply(e));
        }

        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {

        for (T e : list) {
            c.accept(e);
        }

    }

}
