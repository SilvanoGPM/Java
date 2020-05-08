package br.com.sky.javacore.Hheranca.classes;

public class Pessoa extends Object{
    private String nome;
    private String cpf;
    private Endereco end;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void print() {
        System.out.println("Nome: "+this.nome);
        System.out.println("CPF: "+this.cpf);
        System.out.println("Rua: "+this.end.getRua()+" Bairro: "+this.end.getBairro());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }
}
