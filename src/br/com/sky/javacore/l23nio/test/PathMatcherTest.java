package br.com.sky.javacore.l23nio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTest extends SimpleFileVisitor<Path> {
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)) {
            System.out.println("\t"+file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PathMatcherTest {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pasta/subpasta/subsubpasta/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("silvano");
        Path path4 = Paths.get("./");
        // * : Procura tudo menos separadores de diretório.
        // ** ou **/* : Procura tudo incluindo separadores de diretório.
        // ? : Usado quando se quer achar arquivos com determinados números de caracteres.
        // {} : Usado para procurar palavras chaves.

        matcher(path1, "glob:**");
        matcher(path2, "glob:**.bkp");
        matcher(path3, "glob:{silvano, gabriel}");
        matcher(path4, "glob:*{Test}*{.class, .java}*");

        System.out.println("\nTodos os .java e .class: \n\t");
        Files.walkFileTree(path4, new FindAllTest());
    }

    private static void matcher(Path path, String glob) {
        PathMatcher matches = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println("\n"+glob+"\n\tresultado: "+matches.matches(path));
    }
}
