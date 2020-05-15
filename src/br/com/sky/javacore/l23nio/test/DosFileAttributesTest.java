package br.com.sky.javacore.l23nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest {
    public static void main(String[] args) {
        Path path = Paths.get("folder\\teste.txt");
        try {
            Files.createFile(path);
            Files.setAttribute(path, "dos:hidden",true);
            Files.setAttribute(path, "dos:readonly",true);
            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println("Arquivo: "+path.toAbsolutePath());
            System.out.println("IsHidden? "+dos.isHidden());
            System.out.println("IsReadOnly? "+dos.isReadOnly());

            System.out.println("---------------------------------------------");

            DosFileAttributeView dosView = Files.getFileAttributeView(path,DosFileAttributeView.class);
            dosView.setHidden(false);
            dosView.setReadOnly(false);
            dos =  Files.readAttributes(path, DosFileAttributes.class);
            System.out.println("MODIFICADO!");
            System.out.println("IsHidden? "+dos.isHidden());
            System.out.println("IsReadOnly? "+dos.isReadOnly());

            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
