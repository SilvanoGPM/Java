package br.com.sky.javacore.l25colecoes.classes;

import java.util.Objects;

public class Produto implements Comparable<Produto> {

    // ATTRIBUTES

    private String serialNumber;
    private String nome;
    private Double preco;
    private int quantidades;

    // CONSTRUCTORS

    public Produto(String serialNumber, String nome,  double preco) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String serialNumber, String nome, Double preco, int quantidades) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preco = preco;
        this.quantidades = quantidades;
    }

    // OVERRIDES


    @Override
    public String toString() {
        return "Produto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidades=" + quantidades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(serialNumber, produto.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public int compareTo(Produto otherObject) {
        // Se retornar valor positivo: thisObject > otherObject
        // Se retornar valor negativo: thisObject < otherObject
        // Se retornar valor nulo: thisObject == otherObject
        return serialNumber.compareTo(otherObject.getSerialNumber());
    }

    // GETTERS AND SETTERS

    public int getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(int quantidades) {
        this.quantidades = quantidades;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
