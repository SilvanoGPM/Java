package br.com.sky.javacore.Aintroducaoclasses.test;

import br.com.sky.javacore.Aintroducaoclasses.classes.Estudantes;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudantes goku = new Estudantes();
        goku.nome = "Goku";
        goku.matricula = "1212";
        goku.idade = 15;

        System.out.println(goku.nome);
        System.out.println(goku.matricula);
        System.out.println(goku.idade);

    }
}
