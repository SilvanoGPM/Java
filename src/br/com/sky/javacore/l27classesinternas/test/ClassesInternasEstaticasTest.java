package br.com.sky.javacore.l27classesinternas.test;

class Externa {
    static class Interna {
        public void imprimir() {
            System.out.println("Interna 1");
        }
    }
}

public class ClassesInternasEstaticasTest {
    public static void main(String[] args) {
        Externa.Interna in = new Externa.Interna();
        Interna2 in2 = new Interna2();
        in.imprimir();
        in2.imprimir();
    }

    static class Interna2 {
        public void imprimir() {
            System.out.println("Interna 2");
        }
    }
}
