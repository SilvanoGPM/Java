package br.com.sky.javacore.l22io;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            bw.write("Escrevendo");
            bw.newLine();
            bw.write("Pulou linha");
            bw.flush();

            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ///////////////////////////////////////////////////////////////////////////////////

//        try {
//            FileWriter fw = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            bw.write("Escrevendo");
//            bw.newLine();
//            bw.write("Pulou linha");
//            bw.flush();
//            bw.close();
//
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//            String s;
//            while((s = br.readLine()) != null) {
//                System.out.println(s);
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
