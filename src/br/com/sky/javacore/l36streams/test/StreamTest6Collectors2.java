package br.com.sky.javacore.l36streams.test;

import br.com.sky.javacore.l36streams.classes.Genero;
import br.com.sky.javacore.l36streams.classes.Maioridade;
import br.com.sky.javacore.l36streams.classes.Pessoa;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamTest6Collectors2 {
    // Agrupamento

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoa();

        // Agrupamento por Genero
        Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();
        List<Pessoa> masculinos = new ArrayList<>();
        List<Pessoa> femininos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getGenero() == Genero.FEMININO) {
                femininos.add(pessoa);
            } else {
                masculinos.add(pessoa);
            }
        }
        generoListMap.put(Genero.MASCULINO, masculinos);
        generoListMap.put(Genero.FEMININO, femininos);
        System.out.println(generoListMap.get(Genero.MASCULINO));

        System.out.println("------------------------------------------------");

        // Agrupamento por Idade
        Map<Maioridade, List<Pessoa>> mapMaioridade1 = new HashMap<>();
        ArrayList<Pessoa> menor = new ArrayList<>();
        ArrayList<Pessoa> maior = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p.getIdade() < 18) menor.add(p);
            else maior.add(p);
        }
        mapMaioridade1.put(Maioridade.MENOR, menor);
        mapMaioridade1.put(Maioridade.MAIOR, maior);
        System.out.println(mapMaioridade1);

        System.out.println("------------------------------------------------");

        // Agrupamento por Genero (Collectors)
        Map<Genero, List<Pessoa>> mapGenero = pessoas.stream().collect(groupingBy(Pessoa::getGenero));
        System.out.println(mapGenero.get(Genero.MASCULINO));

        System.out.println("------------------------------------------------");

        // Agrupamento por Maioridade (Collectors)
        Map<Maioridade, List<Pessoa>> mapMaioridade2 = pessoas.stream()
                .collect(groupingBy(p -> {
                    if (p.getIdade() < 18) return Maioridade.MENOR;
                    else return Maioridade.MAIOR;
                }));
        System.out.println(mapMaioridade2);

        System.out.println("------------------------------------------------");

        // Agrupamento por Genero e Maioridade (Collectors)
        Map<Genero, Map<Maioridade, List<Pessoa>>> mapGeneroMaioridade = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, groupingBy(p -> {
                    if (p.getIdade() < 18) return Maioridade.MENOR;
                    else return Maioridade.MAIOR;
                })));
        System.out.println(mapGeneroMaioridade);

        System.out.println("------------------------------------------------");

        // Agrupando por genero e quantidade
        Map<Genero, Long> mapGeneroQuantidade = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, counting()));
        System.out.println(mapGeneroQuantidade);

        System.out.println("------------------------------------------------");

        // Agrupando por Genero e Maior Salario com Optional
        Map<Genero, Optional<Pessoa>> mapGeneroMaiorSalario = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, maxBy(comparing(Pessoa::getSalario))));
        System.out.println(mapGeneroMaiorSalario);

        System.out.println("------------------------------------------------");

        // Agrupando por Genero e Maior Salario sem Optional
        Map<Genero, Pessoa> mapGeneroMaiorSalarioOptional = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero,
                        collectingAndThen(maxBy(comparing(Pessoa::getSalario)), Optional::get)));
        System.out.println(mapGeneroMaiorSalarioOptional);

        System.out.println("------------------------------------------------");

        // Agrupando por Genero e Estatisticas
        Map<Genero, DoubleSummaryStatistics> mapGeneroEstatisticas = pessoas
                .stream()
                .collect(groupingBy(Pessoa::getGenero, summarizingDouble(Pessoa::getSalario)));
        System.out.println(mapGeneroEstatisticas);

        System.out.println("------------------------------------------------");

        // Agrupando por Genero e Maioridade (Set)
        Map<Genero, Set<Maioridade>> pessoaSet = pessoas
                .stream()
                .collect(groupingBy(Pessoa::getGenero, mapping(p -> {
                    if (p.getIdade() < 18) return Maioridade.MENOR;
                    else return Maioridade.MAIOR;
                }, toSet())));
        System.out.println(pessoaSet);

        System.out.println("------------------------------------------------");

        // Agrupando por Genero e Maioridade (Collection)
        Map<Genero, Set<Maioridade>> pessoaLinkedSet = pessoas
                .stream()
                .collect(groupingBy(Pessoa::getGenero, mapping(p -> {
                    if (p.getIdade() < 18) return Maioridade.MENOR;
                    else return Maioridade.MAIOR;
                }, toCollection(LinkedHashSet::new))));
        System.out.println(pessoaLinkedSet);

    }
}
