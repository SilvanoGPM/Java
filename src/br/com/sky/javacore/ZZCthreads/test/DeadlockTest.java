package br.com.sky.javacore.ZZCthreads.test;

public class DeadlockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new ThreadExemplo1().start();
        new ThreadExemplo2().start();
    }

    private static class ThreadExemplo1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("A Thread 1: Segurando lock1");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("A Thread 1: Esperando pelo lock2");
                synchronized (lock2) {
                    System.out.println("A Thread 1: Segurando lock1 e o lock2");
                }
            }
        }
    }

    private static class ThreadExemplo2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("A Thread 2: Segurando lock1");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("A Thread 2: Esperando pelo lock2");
                synchronized (lock2) {
                    System.out.println("A Thread 1: Segurando lock2 e o lock1");
                }
            }
        }
    }

}
