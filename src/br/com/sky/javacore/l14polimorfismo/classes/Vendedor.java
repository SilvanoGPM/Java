package br.com.sky.javacore.l14polimorfismo.classes;

public class Vendedor extends Funcionario {
    private double totalVendas;

    public Vendedor(double salario, String nome, double totalVendas) {
        super(salario, nome);
        this.totalVendas = totalVendas;
    }

    @Override
    public void calcularPagamento() {
        this.salario = this.salario + (this.totalVendas * 0.05);
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
