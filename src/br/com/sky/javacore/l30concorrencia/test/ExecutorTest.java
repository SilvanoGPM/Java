package br.com.sky.javacore.l30concorrencia.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadTrabalhadorExecutor implements Runnable {

    private String num;

    public ThreadTrabalhadorExecutor(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " iniciou: "+num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" finalizou!");
    }
}


public class ExecutorTest  {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        es.execute(new ThreadTrabalhadorExecutor("1"));
        es.execute(new ThreadTrabalhadorExecutor("2"));
        es.execute(new ThreadTrabalhadorExecutor("3"));
        es.execute(new ThreadTrabalhadorExecutor("4"));
        es.shutdown();
        while (!es.isTerminated()){}
        System.out.println(es.isTerminated());
        System.out.println("Finalizado");
    }
}
