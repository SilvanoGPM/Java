package br.com.sky.javacore.Hheranca.classes;

public class Funcionario extends Pessoa{
    private double salario;

    public Funcionario(String nome) {
        super(nome);

    }

    public void print() {
        super.print();
        System.out.println(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
