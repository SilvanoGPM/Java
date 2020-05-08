package br.com.sky.javacore.Oexception.checkedexception.test;

import br.com.sky.javacore.Oexception.checkedexception.classes.Leitor01;
import br.com.sky.javacore.Oexception.checkedexception.classes.Leitor02;

import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        lerArquivo();
    }

    public static void lerArquivo() {
        try(Leitor01 leitor01 = new Leitor01();
            Leitor02 leitor02 = new Leitor02()) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void lerArquivoOld() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\testejava\\text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
