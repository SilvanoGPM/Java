package br.com.sky.javacore.Bintroducaometodos.test;

import br.com.sky.javacore.Bintroducaometodos.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor prof = new Professor();
        prof.matricula = "1000-1";
        prof.rg = "4024-1";
        prof.nome = "Goku";
        prof.cpf = "122.222.333-45";
        prof.imprime();
        prof.matricula = "1001-1";
        prof.rg = "4314-1";
        prof.nome = "Naruto";
        prof.cpf = "122.212.234-45";
        prof.imprime();
    }
}
