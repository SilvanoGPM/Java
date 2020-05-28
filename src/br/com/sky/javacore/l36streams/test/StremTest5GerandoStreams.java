package br.com.sky.javacore.l36streams.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StremTest5GerandoStreams {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(x -> System.out.print(x+" "));
        System.out.println();
        IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(x -> System.out.print(x+" "));

        System.out.println();

        Stream<String> strings =Stream.of("Silvano", "Gabriel", "Pimentel", "Marques");
        strings.map(String::toUpperCase).forEach(System.out::println);
        System.out.println();

        Stream<String> emptyStrings = Stream.empty();

        int[] nums = {1,2,3,4,5};
        OptionalDouble avg = Arrays.stream(nums).average();
        System.out.println(avg.getAsDouble());

        try (Stream<String> lines  = Files.lines(Paths.get("Teste.txt"), Charset.defaultCharset())) {

            lines.filter(x -> x.contains("File")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        Stream.iterate(new int[]{0,1}, a -> new int[]{a[1], a[0]+a[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(n -> System.out.print(n+".. "));

        ThreadLocalRandom r = ThreadLocalRandom.current();
        Stream.generate(() -> r.nextInt(1, 100)).limit(10).forEach(System.out::println);

    }
}
