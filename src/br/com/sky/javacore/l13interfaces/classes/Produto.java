package br.com.sky.javacore.l13interfaces.classes;

public class Produto implements Tributavel, Transportavel{
    private String nome;
    private double peso;
    private double preco;
    private double precoFinal;
    private double valorFrete;

    public Produto(String nome, double peso, double preco) {
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome: "+this.nome+
                "\nPreço: "+this.preco+
                "\nPreço Final(imposto e frete): "+(this.precoFinal+this.valorFrete);
    }

    public  void calcularImposto() {
        precoFinal = this.preco + (this.preco * IMPOSTO);
    }

    public void calculaFrete() {
        this.valorFrete = this.preco / peso *  0.1;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
