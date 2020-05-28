package br.com.sky.javacore.l35optional.classes;

import java.util.Optional;

public class Seguradora {

    private String nome;

    public Seguradora(String nome) {
        this.nome = nome;
    }

    public Seguradora() {

    }

    @Override
    public String toString() {
        return "Seguradora{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
