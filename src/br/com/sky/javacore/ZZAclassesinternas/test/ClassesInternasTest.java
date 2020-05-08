package br.com.sky.javacore.ZZAclassesinternas.test;

public class ClassesInternasTest {
    private String nome = "Silvano - SkyG0D";

    class Interna {
        String nome = "Seu cu";
        public void verClasseExterna() {
            System.out.println(this.nome);
            System.out.println(ClassesInternasTest.this.nome);
        }
    }

    public static void main(String[] args) {
        ClassesInternasTest externo = new ClassesInternasTest();
        ClassesInternasTest.Interna interna = externo.new Interna();
        ClassesInternasTest.Interna interna2 = new ClassesInternasTest().new Interna();
        interna2.verClasseExterna();
    }
}

//class Externa {
//    private String nome = "Silvano - SkyG0D";
//
//    class Interna {
//        public void verClasseExterna() {
//            System.out.println(nome);
//        }
//    }
//}