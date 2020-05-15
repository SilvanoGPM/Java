package br.com.sky.javacore.l30concorrencia.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {
    private Map<String, String> map = new LinkedHashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public Object[] allKeys() {
        return map.keySet().toArray();
    }

}

public class MapReadWriteLockTest {

    private final static MapReadWrite MRW = new MapReadWrite();
    private final static ReentrantReadWriteLock RRWL = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        new Thread(new Write()).start();
        new Thread(new ReadA()).start();
        new Thread(new ReadB()).start();
    }

    static class Write implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    RRWL.writeLock().lock();
                    MRW.put(String.valueOf(i), String.valueOf(i));
                } finally {
                    RRWL.writeLock().unlock();
                }
            }
        }
    }

    static class ReadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    RRWL.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(MRW.allKeys()));
                } finally {
                    RRWL.readLock().unlock();
                }

            }
        }
    }

    static class ReadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    RRWL.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(MRW.allKeys()));
                } finally {
                    RRWL.readLock().unlock();
                }

            }
        }
    }

}
