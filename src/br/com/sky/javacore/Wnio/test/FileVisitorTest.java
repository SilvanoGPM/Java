package br.com.sky.javacore.Wnio.test;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class AcharTodosOsBkp extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.getFileName().toString().endsWith(".bkp")) {
            System.out.println("\t"+file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

class PrintDirs extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("VisitFile: "+file.getFileName());
        if (file.getFileName().toString().endsWith("arquivo copiado.txt")) {
//            return FileVisitResult.TERMINATE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("PreVisit: "+dir);
        if(dir.getFileName().toString().endsWith("pasta")) {
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("PostVisit: "+dir);
        return FileVisitResult.CONTINUE;
    }
}

public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
//        Path dir = Paths.get("pasta");
//        System.out.println("Procurar todos os arquivos .bkp no diretório: '"+dir+"'\n");
//        Files.walkFileTree(dir, new AcharTodosOsBkp());
        Files.walkFileTree(Paths.get("pasta"), new PrintDirs());

    }
}

