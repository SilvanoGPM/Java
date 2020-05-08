package br.com.sky.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest {
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\Users\\campeão\\IdeaProjects\\Java\\Arquivo.txt");
        Path p2 = Paths.get("C:\\Users\\campeão\\IdeaProjects\\Java", "Arquivo.txt");
        Path p3 = Paths.get("C:", "Users\\campeão\\IdeaProjects\\Java", "Arquivo.txt");
        Path p4 = Paths.get("C:", "Users", "campeão", "IdeaProjects", "Java", "Arquivo.txt");

        File file = p4.toFile();

        Path path1 = Paths.get("pasta");
        Path path2 = Paths.get("pasta", "subpasta", "subsubpasta", "text.txt");
        Path arquivo = Paths.get("pasta", "subpasta", "subsubpasta", "test.txt");
        try {
//            if(Files.notExists(path1))
//                Files.createDirectory(path1);
            if (Files.notExists(path2.getParent())) {
                Files.createDirectories(path2.getParent());
            }
            if (Files.notExists(arquivo))
                Files.createFile(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("folder\\arquivo renomeado.txt");
        Path target = Paths.get("pasta\\arquivo copiado.txt");
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
