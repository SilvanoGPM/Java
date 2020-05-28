package br.com.sky.javacore.l35optional.classes;

import java.util.Optional;

public class Carro {

    private Seguradora seguradora;
    private String nome;

    public Carro(Seguradora carro, String nome) {
        this.seguradora = carro;
        this.nome = nome;
    }

    public Carro(String nome) {
        this.nome = nome;
    }

    public Optional<Seguradora> getSeguradora() {
        return Optional.ofNullable(this.seguradora);
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
