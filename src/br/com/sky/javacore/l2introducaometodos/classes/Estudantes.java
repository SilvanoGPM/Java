package br.com.sky.javacore.l2introducaometodos.classes;

public class Estudantes {
    private String nome;
    private int idade;
    private float[] nota;
    private boolean aprovado;

    public void print() {
        System.out.println("Dados do aluno: ");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.print("Notas: / ");
        if (this.nota == null) {
            System.out.println("Aluno não possui notas");
            return;
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(this.nota[i] + " / ");
        }
        System.out.println();

    }


    public void mostrarMediaDoAluno() {
        if (this.nota == null) {
            System.out.println("Aluno não possui notas");
            return;
        }
        float soma = 0;
        String status;
        for (float n : this.nota) {
            soma += n;
        }
        float notaFinal = soma / this.nota.length;
        if (notaFinal >= 6) {
            this.aprovado = true;
            status = "Aprovado";
        } else {
            this.aprovado = false;
            status = "Reprovado";
        }

        System.out.println("Media do aluno: ");
        System.out.println("Media de " + this.nome + " é de " + notaFinal);
        System.out.println("Status: " + status);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            System.out.println("ERROR Idade menor que zero");
            return;
        }
        this.idade = idade;
    }

    public void setNota(float[] nota) {
        this.nota = nota;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public float[] getNota() {
        return this.nota;
    }

    public boolean isAprovado() {
        return this.aprovado;
    }
}
