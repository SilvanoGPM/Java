package br.com.sky.javacore.l7assosiacaoclasses.classes;

public class Seminario {
    private String titulo;
    private Aluno[] alunos;
    private Professor professor;
    private Local local;

    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    public Seminario() {
    }

    public void print() {
        System.out.println("---------------- Relatorio Seminario ----------------");
        System.out.println();
        if (this.getTitulo() != null) {
            System.out.println("Seminario: ");
            System.out.println("      *" + this.getTitulo());
        } else {
            System.out.println("Seminario: ");
            System.out.println("      *Sem informação");
        }
        if (this.getProfessor().getNome() != null) {
            System.out.println("Professor: ");
            System.out.println("      *"+this.getProfessor().getNome());
        } else {
            System.out.println("Professor: ");
            System.out.println("      *Sem professor");
        }
        if (this.getLocal().getRua() != null && this.getLocal().getBairro() != null) {
            System.out.println("Local: ");
            System.out.println("      *Rua: " + this.getLocal().getRua());
            System.out.println("      *Bairro: " + this.getLocal().getBairro());
        } else {
            System.out.println("Local: ");
            System.out.println("      *Sem informação!");
        }
        if (this.alunos != null && this.alunos.length != 0) {
            System.out.println("Alunos: ");
            for (Aluno aluno : this.alunos) {
                System.out.println("      *" + aluno.getNome());
            }
        } else {
            System.out.println("Alunos: ");
            System.out.println("      *Sem informações");
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
