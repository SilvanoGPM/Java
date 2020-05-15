package br.com.sky.javacore.l22io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try {
            System.out.println(file.createNewFile());
            boolean exists = file.exists();
            System.out.println("last modified: "+ new Date(file.lastModified()));
            if(exists) {
                System.out.println("Deletado? "+file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
