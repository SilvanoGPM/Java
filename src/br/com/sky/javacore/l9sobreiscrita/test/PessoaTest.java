package br.com.sky.javacore.l9sobreiscrita.test;

import br.com.sky.javacore.l9sobreiscrita.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Joaquina na esquina");
        p.setIdade(300);
        System.out.println(p);
    }
}
