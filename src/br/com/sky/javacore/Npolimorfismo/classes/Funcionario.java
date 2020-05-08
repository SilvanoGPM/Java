package br.com.sky.javacore.Npolimorfismo.classes;

public abstract class Funcionario {
    protected double salario;
    protected String nome;

    public Funcionario(double salario, String nome) {
        this.salario = salario;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", nome='" + nome + '\'' +
                '}';
    }

    public abstract void calcularPagamento();

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
