package br.com.sky.javacore.l36streams.test;

import br.com.sky.javacore.l36streams.classes.Pessoa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Pessoa> listPessoas = Pessoa.bancoDePessoa();
        listPessoas.sort(Comparator.comparing(Pessoa::getNome));

        List<String> listNomes = new ArrayList<>();
        for (Pessoa pessoa : listPessoas) {
            if (pessoa.getIdade() < 25) {
                listNomes.add(pessoa.getNome());
                if (listNomes.size() == 3) break;
            }
        }
        System.out.println(listNomes);

        List<String> listNomes2 = listPessoas
                .stream()
                .filter( p -> p.getIdade() < 25)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .limit(5)
                .skip(1)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());
        System.out.println(listNomes2);

        System.out.println(listPessoas
                .stream()
                .filter(p -> p.getIdade() < 25)
                .map(Pessoa::getNome)
                .distinct()
                .count()
        );

        listPessoas.stream().distinct().forEach(System.out::println);

        // Intermediate(retorna outro stream) and Terminal(retorna um valor que não é uma stream).

    }
}
