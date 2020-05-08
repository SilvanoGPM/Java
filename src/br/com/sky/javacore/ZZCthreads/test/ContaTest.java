package br.com.sky.javacore.ZZCthreads.test;

import br.com.sky.javacore.ZZCthreads.classes.Conta;

public class ContaTest implements Runnable {

    private final Conta conta = new Conta();


    public static void main(String[] args) {
        ContaTest contaTest = new ContaTest();
        Thread silvano = new Thread(contaTest, "Silvano");
        Thread ana = new Thread(contaTest, "Ana");
        silvano.start();
        ana.start();

    }


    private void saque(int valor) {
        synchronized (conta) {
            if (conta.getSaldo() >= valor) {
                System.out.println(Thread.currentThread().getName() + " Esta indo sacar");
                conta.saque(valor);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Completou o saque, saldo: " + conta.getSaldo());
            } else {
                System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque, saldo: " + conta.getSaldo());
            }
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            saque(10);
            if (conta.getSaldo() < 0) {
                System.out.println("OH MEU DEUS!");
            }
        }
    }


}
