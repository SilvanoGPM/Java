package br.com.sky.javacore.l15exception.checkedexception.test;

import br.com.sky.javacore.l15exception.checkedexception.classes.Funcionario;
import br.com.sky.javacore.l15exception.checkedexception.classes.Pessoa;

public class SobrescritaComException {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        Pessoa p = new Pessoa();

        f.salvar();
    }
}
