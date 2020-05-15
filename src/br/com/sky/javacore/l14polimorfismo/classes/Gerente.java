package br.com.sky.javacore.l14polimorfismo.classes;

public class Gerente extends Funcionario {
    private double pnl;
    public Gerente(double salario, String nome, double pnl) {
        super(salario, nome);
        this.pnl = pnl;
    }

    @Override
    public void calcularPagamento() {
        this.salario = this.salario + this.pnl;
    }

    public double getPnl() {
        return pnl;
    }

    public void setPnl(double pnl) {
        this.pnl = pnl;
    }
}
