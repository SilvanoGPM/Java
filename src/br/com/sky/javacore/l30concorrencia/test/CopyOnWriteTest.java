package br.com.sky.javacore.l30concorrencia.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

// Um Objeto Imutável!
final class Pessoa {
    private final String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class CopyOnWriteTest implements Runnable {
    private List<Integer> list = new CopyOnWriteArrayList<>();
    private Set<Integer> set = new CopyOnWriteArraySet<>();

    public CopyOnWriteTest() {
        for (int i = 0; i < 9000; i++) {
            list.add(i);
        }
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public void run() {
        Iterator<Integer> iterator = list.iterator();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (iterator.hasNext()) {
            System.out.println(Thread.currentThread().getName() + " "+iterator.next());
        }
    }

    public static void main(String[] args) {
        CopyOnWriteTest cowt = new CopyOnWriteTest();
        new Thread(cowt).start();
        new Thread(cowt).start();
        new Thread(new RemoverMembros(cowt.getList())).start();
    }

    private static class RemoverMembros implements Runnable {

        private List<Integer> list;

        public RemoverMembros(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName()+" removeu: "+list.remove(i));
            }
        }
    }

}
