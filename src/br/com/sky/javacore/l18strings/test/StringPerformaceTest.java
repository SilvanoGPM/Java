package br.com.sky.javacore.l18strings.test;

public class StringPerformaceTest {
    public static void main(String[] args) {
        long inicio = 0;
        long fim = 0;

        inicio = System.currentTimeMillis();
        concactString(30000);
        fim = System.currentTimeMillis();
        System.out.printf("Tempo(String): %1d",(fim-inicio));

        System.out.println("\n-----------------------------------");

        inicio = System.currentTimeMillis();
        concactStringBuilder(1000000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo(StringBuilder): "+(fim-inicio));

        System.out.println("\n-----------------------------------");

        inicio = System.currentTimeMillis();
        concactStringBuffer(1000000);
        fim = System.currentTimeMillis();
        System.out.printf("Tempo(StringBuffer): %d",(fim-inicio));
    }

    private static void concactString(int tamanho) {
        String string = "0";
        for (int i = 0; i < tamanho; i++) {
            string += i;
        }
    }

    private static void concactStringBuilder(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }

    private static void concactStringBuffer(int tamanho) {
        StringBuffer sb = new StringBuffer(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
}
