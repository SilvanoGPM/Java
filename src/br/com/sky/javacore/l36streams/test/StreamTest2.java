package br.com.sky.javacore.l36streams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamTest2 {

    public static void main(String[] args) {
        List<List<String>> nomes = new ArrayList<>();
        nomes.add(asList("SkyG0D", "Silvano"));
        nomes.add(asList("GustavoRocha908", "Gustavo"));
        List<String> nomes2 = nomes.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(nomes);
        System.out.println(nomes2);

        List<String> palavras = asList("Ola", " Goku");
        String[] split = palavras.get(1).split("");
        System.out.println(Arrays.toString(split));
        Arrays.stream( (String[]) palavras.toArray()).forEach(System.out::println);

        List<String> splitStream  = palavras.stream() // Stream<String>
                .map( p -> p.split(""))         // Stream<String[]>
                .flatMap(Arrays::stream)             // Stream<String>
                .collect(Collectors.toList());

        splitStream.forEach(System.out::println);
    }

}
