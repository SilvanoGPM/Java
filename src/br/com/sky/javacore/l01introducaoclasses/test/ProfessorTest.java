package br.com.sky.javacore.l01introducaoclasses.test;

import br.com.sky.javacore.l01introducaoclasses.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor prof = new Professor();
        prof.nome = "Alucard";
        prof.cpf = 6666666;
        prof.rg = "666-666";
        prof.matricula = "666";
        System.out.println("O professor "+ prof.nome + " tem a matricula de número "+ prof.matricula);
    }

}
