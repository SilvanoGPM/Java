package br.com.sky.javacore.l12classesabstratas.classes;

public class Vendedor extends Funcionario{
    private double totVendas;

    public Vendedor() {
    }

    public Vendedor(String nome, String clt, double salario, double totVendas) {
        super(nome, clt, salario);
        this.totVendas = totVendas;
    }

    @Override
    public void calculaSalario() {
        this.salario = this.salario + (this.totVendas * 0.05);
    }

    public double getTotVendas() {
        return totVendas;
    }

    public void setTotVendas(double totVendas) {
        this.totVendas = totVendas;
    }
}
