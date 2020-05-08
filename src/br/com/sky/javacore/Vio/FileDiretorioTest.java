package br.com.sky.javacore.Vio;

import java.io.File;
import java.io.IOException;

public class FileDiretorioTest {
    public static void main(String[] args) throws IOException{
        File diretorio = new File("folder");
        boolean mkdir = diretorio.mkdir();
        System.out.println("Diretorio criado? "+mkdir);
        File arquivo = new File(diretorio,"arquivo.txt");
        boolean newFile = arquivo.createNewFile();
        System.out.println("Arquivo criado? "+newFile);

        File novoNome = new File(diretorio,"arquivo renomeado.txt");
        arquivo.renameTo(novoNome);

    }

    public static void buscarArquivos() {
        File file = new File("C:\\");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
