package br.com.sky.javacore.l04sobrecargaconstrutores.classes;

public class Estudante {
    private String matricula;
    private String nome;
    private double[] notas;
    private String dataMat;

    public Estudante(String matricula, String nome, double[] notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
    }

    public Estudante(String matricula, String nome, double[] notas, String dataMat) {
        this(matricula, nome, notas);
        this.dataMat = dataMat;
    }

    public Estudante() {
    }

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.matricula);
        for (double nota : this.notas) {
            System.out.println(nota);
        }
        System.out.println(this.dataMat);
        System.out.println(this.notas[0]);
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public double[] getNotas() {
        return this.notas;
    }
}
