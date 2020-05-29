package br.com.sky.javacore.l37streamsparalelos;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsPararelos1 {

    public static void main(String[] args) {
        long num = 10_000_000_000L;
        somaFor(num);
//        System.out.println("---------------------------------------");
//        somaStreamIterate(num);
//        System.out.println("---------------------------------------");
//        somaParallelStreamIterate(num);
//        System.out.println("---------------------------------------");
        somaRangeClosedStream(num);
        System.out.println("---------------------------------------");
        somaRangeClosedParallelStream(num);
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

    }

    public static void somaFor(long num) {
        System.out.println("Dentro do somaFor!");
        long init = System.currentTimeMillis();

        long result = 0L;
        for (long i = 1L; i <= num; i++) {
            result += i;
        }

        long end = System.currentTimeMillis();
        System.out.println("Resultado: " + result);
        System.out.println("Tempo: " + (end - init) + "ms");

    }

    public static void somaStreamIterate(long num) {
        System.out.println("Dentro do somaStreamIterate (Sequencial)");
        long init = System.currentTimeMillis();

        long result = 0;
        result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("Resultado: " + result);
        System.out.println("Tempo: " + (end - init) + "ms");
    }

    public static void somaParallelStreamIterate(long num) {
        System.out.println("Dentro do somaParallelStreamIterate! (Parelelo)");
        long init = System.currentTimeMillis();

        long result = 0;
        result = Stream.iterate(1L , i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("Resultado: "+result);
        System.out.println("Tempo: "+(end-init)+"ms");

    }

    public static void somaRangeClosedStream(long num) {
        System.out.println("Dentro do somaRangeClosedStream");
        long init = System.currentTimeMillis();

        long result = 0;
        result = LongStream.rangeClosed(1L, num).sum();

        long end = System.currentTimeMillis();
        System.out.println("Resultado: "+result);
        System.out.println("Tempo: "+(end-init)+"ms");
    }

    public static void somaRangeClosedParallelStream(long num) {
        System.out.println("Dentro do somaRangeClosedParallelStream!");
        long init = System.currentTimeMillis();

        long result = 0;
        result = LongStream.rangeClosed(1L , num).parallel().sum();

        long end = System.currentTimeMillis();
        System.out.println("Resultado: "+result);
        System.out.println("Tempo: "+(end-init)+"ms");

    }

}
