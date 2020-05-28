package br.com.sky.javacore.l35optional.test;

import java.util.Optional;

public class OptionalTest1 {

    private String nome;

    public static void main(String[] args) {
        OptionalTest1 ot1 = new OptionalTest1();
        Optional<String> optional1 = Optional.of("SkyG0D");
        Optional<String> optional2 = Optional.empty();
        Optional<String> optional3 = Optional.ofNullable(ot1.nome);

        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);

        System.out.println(optional3.orElse("VAZIO"));

    }

}
