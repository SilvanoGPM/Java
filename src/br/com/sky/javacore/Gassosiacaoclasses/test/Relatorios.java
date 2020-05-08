package br.com.sky.javacore.Gassosiacaoclasses.test;

import br.com.sky.javacore.Gassosiacaoclasses.classes.Aluno;
import br.com.sky.javacore.Gassosiacaoclasses.classes.Local;
import br.com.sky.javacore.Gassosiacaoclasses.classes.Professor;
import br.com.sky.javacore.Gassosiacaoclasses.classes.Seminario;

public class Relatorios {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Silvano",15);
        Aluno aluno1 = new Aluno("Gustavo",16);
        Professor prof = new Professor("Gabriel","GAMES");
        Local local = new Local("Los angeles","Sem informação");
        Seminario semi = new Seminario("Como ficar melhor no csgo? ");
        Seminario semi1 = new Seminario("Comer cu? MELHOR COISA!");
        Seminario semi2 = new Seminario("Comer cu? MELHOR COISA!");
        Seminario semi3 = new Seminario("Comer cu? MELHOR COISA!");
        Seminario semi4 = new Seminario("Comer cu? MELHOR COISA!");
        aluno.setSeminario(semi);
        Seminario array[] = new Seminario[]{semi,semi1,semi2,semi3,semi4};
        prof.setSeminarios(array);
        Aluno alunoArray[] = new Aluno[]{aluno1,aluno};
        semi.setAlunos(alunoArray);
        semi.setProfessor(prof);
        semi.setLocal(local);
//        semi.print();
        prof.print();
    }
}
