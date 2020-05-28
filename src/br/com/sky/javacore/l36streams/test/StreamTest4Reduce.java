package br.com.sky.javacore.l36streams.test;

import br.com.sky.javacore.l36streams.classes.Pessoa;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest4Reduce {

    public static void main(String[] args) {
        Optional<Integer> sum1 = getStream().reduce((x, y) -> x + y);
        System.out.println(sum1.get());

        Integer sum2 = getStream().reduce(0, (x, y) -> x + y);
        System.out.println(sum2);

        Optional<Integer> sum3 = getStream().reduce(Integer::sum);
        System.out.println(sum3.get());

        Optional<Integer> mult1 = getStream().reduce((x, y) -> x * y);
        System.out.println(mult1.get());

        Integer mult2 = getStream().reduce(1, (x, y) -> x * y);
        System.out.println(mult2);

        Optional<Integer> max1 = getStream().reduce((x, y) -> x > y ? x : y);
        System.out.println(max1.get());

        Optional<Integer> max2 = getStream().reduce(Integer::max);
        System.out.println(max2.get());

        Stream<Pessoa> streamPessoa = Pessoa.bancoDePessoa().stream();
        System.out.println(streamPessoa
                .filter(p -> p.getSalario() >= 1000)
                .map(Pessoa::getSalario)
                .reduce(Double::sum)
                .get()
        );


        streamPessoa = Pessoa.bancoDePessoa().stream();
        System.out.println(streamPessoa
                .filter(p -> p.getSalario() >= 1000)
                .mapToDouble(Pessoa::getSalario)
                .sum()
        );

        streamPessoa = Pessoa.bancoDePessoa().stream();
        DoubleStream doubleStream = streamPessoa
                .filter(p -> p.getSalario() >= 1000)
                .mapToDouble(Pessoa::getSalario);
        Stream<Double> streamDouble = doubleStream.boxed();
        System.out.println(streamDouble.reduce(Double::sum).get());

    }

    private static Stream<Integer> getStream() {
        return asList(1, 2, 3, 4, 5, 6).stream();
    }

}
