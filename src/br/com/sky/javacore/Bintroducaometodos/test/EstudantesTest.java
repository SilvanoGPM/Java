package br.com.sky.javacore.Bintroducaometodos.test;

import br.com.sky.javacore.Bintroducaometodos.classes.Estudantes;

public class EstudantesTest {
    public static void main(String[] args) {
        Estudantes estudantes = new Estudantes();
        estudantes.setNome("Gabriel");
        estudantes.setIdade(-1);
        estudantes.setNota(new float[] {6,7,1});
        System.out.println("=============================================================");
        estudantes.print();
        System.out.println("=============================================================");
        estudantes.mostrarMediaDoAluno();
        System.out.println("=============================================================");
        System.out.println(estudantes.isAprovado());
    }
}
