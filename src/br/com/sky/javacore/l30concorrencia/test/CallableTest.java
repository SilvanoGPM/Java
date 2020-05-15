package br.com.sky.javacore.l30concorrencia.test;

import java.util.concurrent.*;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName()+ "executando...");
        }
        return "Trabalho finalizado o número aleatorio eh: "+count;
    }

    public static void main(String[] args) {
        CallableTest ct = new CallableTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(ct);
        try {
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
