package br.com.sky.javacore.l30concorrencia.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {
    private final ReentrantLock lock = new ReentrantLock();
    private final Queue<String> emails = new LinkedList<>();
    private boolean aberta = true;
    private final Condition condition = lock.newCondition();

    public String obterEmailMembro() {
        String email = null;
        try {
            lock.lock();
            while (this.emails.size() == 0) {
                if (!aberta) return null;
                System.out.println("Lista vazia, colocando a thread: " + Thread.currentThread().getName() + " em modo wait!");
                this.condition.await();
            }
            email = this.emails.poll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return email;
    }

    public void adicionarEmailMembro(String email) {
        try {
            lock.lock();
            this.emails.add(email);
            System.out.println("Email adicionado!");
            System.out.println("Notificando as Threads que estão em espera");
            this.condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void fecharLista() {
        System.out.println("Notificando todas as threads e fechando a lista");
        this.aberta = false;
        try {
            lock.lock();
            this.emails.notifyAll();
        } finally {
            lock.unlock();
        }
    }

    public int getEmailsPedentes() {
        try {
            lock.lock();
            return this.emails.size();
        } finally {
            lock.unlock();
        }

    }

    public boolean isAberta() {
        return aberta;
    }

}
