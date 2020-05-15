package br.com.sky.javacore.l30concorrencia.test;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    private static final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
    private static void beep() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis())+" beep");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
//        scheduledExecutor.scheduleAtFixedRate(beeper, 0, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = scheduledExecutor.scheduleWithFixedDelay(beeper, 0, 5, TimeUnit.SECONDS);
        scheduledExecutor.schedule(new Runnable()  {
            @Override
            public void run() {
                scheduledFuture.cancel(false);
//                scheduledExecutor.shutdown();
            }
        }, 2, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        beep();
    }


}
