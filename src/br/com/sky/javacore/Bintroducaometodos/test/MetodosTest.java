package br.com.sky.javacore.Bintroducaometodos.test;

import br.com.sky.javacore.Bintroducaometodos.classes.Metodos;

public class MetodosTest {
    public static void main(String[] args) {
        Metodos testes = new Metodos();
        testes.mensagem("Bom"," Dia");
        testes.vddOuFalso(false,true);
        testes.questionario('A','B','B','D');
        boolean gay = testes.gayOuNao("Silvano");
        if (gay == true) {
            System.out.println("É gay sim!");
        } else {
            System.out.println("Nem perto de ser gay!");
        }
    }
}
