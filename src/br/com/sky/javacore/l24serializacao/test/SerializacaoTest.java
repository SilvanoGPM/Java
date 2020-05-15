package br.com.sky.javacore.l24serializacao.test;

import br.com.sky.javacore.l24serializacao.classes.Aluno;
import br.com.sky.javacore.l24serializacao.classes.Turma;

import java.io.*;

public class SerializacaoTest {
    public static void main(String[] args) {
        gravador();
        leitor();
    }


    public static void gravador() {
        Turma t = new Turma("1° A");
        Aluno aluno = new Aluno(1L, "Silvano Gabriel", "12345678");
        aluno.setTurma(t);
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("aluno.ser"))) {
            obj.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leitor() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("aluno.ser"))) {
            Aluno aluno = (Aluno) obj.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
