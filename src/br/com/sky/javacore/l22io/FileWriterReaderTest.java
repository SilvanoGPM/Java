package br.com.sky.javacore.l22io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt ");
        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file)) {
            fw.write("Escrevendo 3");
            fw.flush();
            char[] in = new char[500];
            int size = fr.read(in);
            System.out.println();
            System.out.println(size);
            for (char s : in) {
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FileWriter fw = new FileWriter(file);
//            fw.write("Escrevendo");
//            fw.flush();
//            fw.close();
//            FileReader fr = new FileReader(file);
//            char[] in = new char[500];
//            int size = fr.read(in);
//            System.out.println(size);
//            for (char s : in) {
//               System.out.print(s);
//            }
//             fr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
