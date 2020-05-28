package br.com.sky.javacore.l36streams.classes;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Pessoa {

    private String nome;
    private int idade;
    private double salario;
    private Genero genero;

    public Pessoa(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public Pessoa(String nome, int idade, double salario, Genero genero) {
        this(nome, idade, salario);
        this.genero = genero;
    }

    public static List<Pessoa> bancoDePessoa() {

        return asList(
                new Pessoa("Silvano", 15, 1653, Genero.MASCULINO),
                new Pessoa("Lenny", 16, 1931, Genero.FEMININO),
                new Pessoa("Silvano", 11, 203, Genero.MASCULINO),
                new Pessoa("Helbnny", 15, 2331, Genero.MASCULINO),
                new Pessoa("Gui", 16, 1443, Genero.MASCULINO),
                new Pessoa("Milayne", 15, 2030, Genero.FEMININO),
                new Pessoa("Mikael", 17, 1812, Genero.MASCULINO),
                new Pessoa("Vitinho", 15, 1234, Genero.MASCULINO),
                new Pessoa("Marlos", 15, 1031, Genero.MASCULINO),
                new Pessoa("Vitoria", 19, 2230, Genero.FEMININO),
                new Pessoa("Vinicius", 15, 860.4, Genero.MASCULINO),
                new Pessoa("Christian", 15, 2000, Genero.MASCULINO),
                new Pessoa("Matheus", 19, 1100, Genero.MASCULINO),
                new Pessoa("Everton", 21, 1600, Genero.MASCULINO),
                new Pessoa("Amanda", 15, 3231, Genero.FEMININO),
                new Pessoa("Shaylane", 15, 2022, Genero.FEMININO)
        );

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Genero getGenero() {
        return this.genero;
    }

}
