package br.com.sky.javacore.ZZAclassesinternas.test;

public class ClassesLocaisTest {

    private String nome = "Silvano";

    public void fazAlgumaCoisa() {
        class Interna {
            public void imprimeNomeExterno() {
                System.out.println(nome);
            }
        }

        Interna interna = new Interna();
        interna.imprimeNomeExterno();
    }

    public static void main(String[] args) {
        ClassesLocaisTest externa = new ClassesLocaisTest();
        externa.fazAlgumaCoisa();
    }
}
