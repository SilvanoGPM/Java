package br.com.sky.javacore.l36streams.test;

import br.com.sky.javacore.l36streams.classes.Pessoa;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamTest6Collectors1 {

    // Redução e Sumarização de streams em um valor único
    // Agrupamento e elementos
    // Particionamento de elementos
    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.bancoDePessoa();
        System.out.println("Total de pessoas: " + pessoas.stream().count());
        System.out.println("Total de pessoas(Collectors): " + pessoas.stream().collect(counting()));

        System.out.println("----------------------------------");

        Optional<Pessoa> max1 = pessoas.stream().max(comparing(Pessoa::getSalario));
        System.out.println("Maior salário: R$" + max1.get().getSalario());
        Optional<Pessoa> max2 = pessoas.stream().collect(maxBy(comparing(Pessoa::getSalario)));
        System.out.println("Maior salário(Collectors): R$" + max2.get().getSalario());
        Optional<Pessoa> min1 = pessoas.stream().min(comparing(Pessoa::getSalario));
        System.out.println("Menor salário: R$" + min1.get().getSalario());
        Optional<Pessoa> min2 = pessoas.stream().collect(minBy(comparing(Pessoa::getSalario)));
        System.out.println("Menor salário(Collectors): R$" + min2.get().getSalario());

        System.out.println("----------------------------------");

        Double soma1 = pessoas.stream().mapToDouble(Pessoa::getSalario).sum();
        System.out.println("Soma de todos os salários: R$" + soma1);
        Double soma2 = pessoas.stream().collect(summingDouble(Pessoa::getSalario));
        System.out.println("Soma de todos os salários(Collectors): R$" + soma2);
        Double media1 = pessoas.stream().mapToDouble(Pessoa::getSalario).average().getAsDouble();
        System.out.printf("Média dos salários: R$%.2f%n", media1);
        Double media2 = pessoas.stream().collect(averagingDouble(Pessoa::getSalario));
        System.out.printf("Média dos salários(Collectors): R$%.2f%n", media2);

        DoubleSummaryStatistics summary = pessoas.stream().collect(summarizingDouble(Pessoa::getSalario));
        System.out.println(summary);

        System.out.println(pessoas.stream().map(Pessoa::getNome).collect(joining(", ")));

    }

}
