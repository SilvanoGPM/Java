package br.com.sky.javacore.Isobreiscrita.test;

import br.com.sky.javacore.Isobreiscrita.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Joaquina na esquina");
        p.setIdade(300);
        System.out.println(p);
    }
}
