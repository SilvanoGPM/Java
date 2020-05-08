package br.com.sky.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {
    public static void main(String[] args) {
        String diretorioProjeto = "Java\\home\\silvano\\dev";
        String arquivoText = "..\\..\\arquivo.txt";
        Path p1 = Paths.get(diretorioProjeto,arquivoText);
        System.out.println(p1);
        System.out.println(p1.normalize());
        Path p2 = Paths.get("home/./silvano/./dev");
        System.out.println(p2);
        System.out.println(p2.normalize());
    }
}
