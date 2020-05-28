package br.com.sky.javacore.l36streams.test;

import br.com.sky.javacore.l36streams.classes.Pessoa;

import java.util.Comparator;
import java.util.List;

public class StreamTest3 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.bancoDePessoa();
        System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 2000));
        System.out.println(pessoas.stream().allMatch(p -> p.getIdade() > 10));
        System.out.println(pessoas.stream().noneMatch(p -> p.getIdade() < 10));
        pessoas.stream()
                .filter(p -> p.getIdade() < 25)
                .findAny()
                .ifPresent(System.out::println);

        pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .findFirst()
                .ifPresent(System.out::println);

    }


}
