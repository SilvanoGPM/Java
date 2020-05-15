package br.com.sky.javacore.l6modificadorestatico.classes;

public class Carro {
    private String nome;
    private double velocidadeMaxima;
    public static double velocidadeLimite = 240;

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Carro() {
    }

    public static void setVelocidadeLimite(double velocidadeLimite) {
        Carro.velocidadeLimite = velocidadeLimite;
    }
    public static double getVelocidadeLimite() {
        return Carro.velocidadeLimite;
    }

    public void imprime() {
        System.out.println("----------------------------------------");
        System.out.println("Nome: "+this.nome);
        System.out.println("Velocidade MAX: "+this.velocidadeMaxima);
        System.out.println("Velocidade Limite: "+velocidadeLimite);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

}

