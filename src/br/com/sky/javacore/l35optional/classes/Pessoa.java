package br.com.sky.javacore.l35optional.classes;

import java.util.Optional;

public class Pessoa {

    private Carro carro;
    private String nome;
    private int idade;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(Carro carro, String nome) {
        this(nome);
        this.carro = carro;
    }

    public Optional<Carro> getCarro() {
        return Optional.ofNullable(this.carro);
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
