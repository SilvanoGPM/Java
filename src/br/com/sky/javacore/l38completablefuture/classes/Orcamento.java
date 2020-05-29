package br.com.sky.javacore.l38completablefuture.classes;

public class Orcamento {

    private final String nomeLoja;
    private final double preco;
    private final Desconto.Code desconto;

    private Orcamento(String nomeLoja, double preco, Desconto.Code desconto) {
        this.nomeLoja = nomeLoja;
        this.preco = preco;
        this.desconto = desconto;
    }

    public static Orcamento parse(String s) {
        String[] split = s.split(":");
        String nomeLoja = split[0];
        double preco = Double.parseDouble(split[1]);
        Desconto.Code desconto = Desconto.Code.valueOf(split[2]);
        return new Orcamento(nomeLoja, preco, desconto);
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public double getPreco() {
        return preco;
    }

    public Desconto.Code getDesconto() {
        return desconto;
    }
}
