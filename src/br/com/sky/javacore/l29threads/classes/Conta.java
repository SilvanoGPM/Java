package br.com.sky.javacore.l29threads.classes;

public class Conta {

    private int saldo = 50;

    public int getSaldo() {
        return saldo;
    }

    public void saque(int valor) {
        saldo -= valor;
    }
}
