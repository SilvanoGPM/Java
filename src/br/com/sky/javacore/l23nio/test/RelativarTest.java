package br.com.sky.javacore.l23nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativarTest {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/silvano");
        Path classe = Paths.get("/home/silvano/java/Pessoa.java");
        Path classeDir = dir.relativize(classe);
        System.out.println(classeDir);
    }
}
