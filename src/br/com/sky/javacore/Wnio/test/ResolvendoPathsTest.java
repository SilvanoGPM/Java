package br.com.sky.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvendoPathsTest {
    public static void main(String[] args) {
        Path dir = Paths.get("home\\silvano");
        Path arquivo = Paths.get("dev\\arquivo.txt");
        Path result = dir.resolve(arquivo);
        System.out.println(result);

        Path absoluto = Paths.get("Java\\home\\silvano");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("test.txt");

        System.out.println("Resultado: "+absoluto.resolve(relativo.resolve(file)));
    }
}
