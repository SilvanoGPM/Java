package br.com.sky.javacore.l33lambdas.test;

import br.com.sky.javacore.l33lambdas.classes.Carro;
import br.com.sky.javacore.l33lambdas.classes.ComparadorCarro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest3 {
    public static void main(String[] args) {
        List<String> names = asList("Silvano", "Gabriel", "Pimentel", "Marques");
        List<Carro> cars = asList(new Carro("Verde", 1943), new Carro("Preto", 2000), new Carro("Vermelho", 2000), new Carro("Preto", 2010), new Carro("Azul", 2002));

        ComparadorCarro comparadorCarro = new ComparadorCarro();
        Collections.sort(cars, comparadorCarro::compareByYear);

        System.out.println(cars);
        forEach(names, System.out::println);

        List<Integer> lengths = map(names, i -> i.length());
        System.out.println(lengths);

        Function<String, Integer> stringToInteger = Integer::parseInt;
//        System.out.println(stringToInteger.apply(";23"));

        BiPredicate<List<String>, String>  contais = List::contains;
        System.out.println(contais.test(names, "Silvano"));

        Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new;
        System.out.println(comparadorCarroSupplier.get());

    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T e : list) {
            c.accept(e);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> lengths = new ArrayList<>();

        for (T e : list) {
            lengths.add(f.apply(e));
        }

        return lengths;
    }

}
