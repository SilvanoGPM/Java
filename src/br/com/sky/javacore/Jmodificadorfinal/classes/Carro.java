package br.com.sky.javacore.Jmodificadorfinal.classes;

public class Carro {
    public static final double VELOCIDADE_FINAL = 250;
    private String nome;
    private String marca;
    private final Comprador COMPRADOR = new Comprador();


    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public final void print() {

    }

    public static double getVelocidadeFinal() {
        return VELOCIDADE_FINAL;
    }

    public Comprador getComprador() {
        return COMPRADOR;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
