package br.com.sky.javacore.l31padroesdeprojeto.test;

import br.com.sky.javacore.l31padroesdeprojeto.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa.PessoaBuilder("Silvano")
                .nomeMeio("Pimentel")
                .ultimoNome("Marques")
                .apelido("Sky")
                .nomeDoPai("Silvino")
                .build();
        System.out.println(p);
    }
}
