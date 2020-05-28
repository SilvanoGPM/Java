package br.com.sky.javacore.l35optional.test;

import br.com.sky.javacore.l35optional.classes.Carro;
import br.com.sky.javacore.l35optional.classes.Pessoa;
import br.com.sky.javacore.l35optional.classes.Seguradora;

import java.util.Optional;

public class OptionalTest2 {

    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora(/**/"Sky Seguros");
        Carro carro = new Carro(seguradora, "Audi");
        Pessoa pessoa = new Pessoa(carro, "Silvano");
        pessoa.setIdade(16);

        checarNomeSeguradora(seguradora);
        checarNomeSeguradoraOptional(seguradora);

        System.out.println("---------------------------------------------");

        System.out.println(obterNomeSeguradoraComIdade(pessoa, 17));

        System.out.println("---------------------------------------------");

        System.out.println(stringToInteger("A"));
    }

    private static String obterNomeSeguradoraComIdade(Pessoa p, int idadeMinima) {
        return Optional.ofNullable(p)
                .filter(pessoa -> pessoa.getIdade() >= idadeMinima)
                .flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome)
                .orElse("Não encontrado!");
    }

    private static Optional<Integer> stringToInteger (String numero) {
        try {
            return Optional.of(Integer.parseInt(numero));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private static void checarNomeSeguradoraOptional(Seguradora seguradora) {
        Optional.ofNullable(seguradora)
                .filter(s -> s.getNome().equals("Sky Seguros"))
                .ifPresent(x -> {
                    System.out.println("É o Sky Seguros");
                });
    }

    private static void checarNomeSeguradora(Seguradora seguradora) {
        if (seguradora != null && seguradora.getNome().equals("Sky Seguros"))
            System.out.println("É a sky seguros");
    }


    private static String obterNomeSeguradora(Optional<Pessoa> p) {
        return p.flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome)
                .orElse("Seguradora não existente!");
    }


}
