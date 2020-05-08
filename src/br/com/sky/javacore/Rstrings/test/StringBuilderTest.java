package br.com.sky.javacore.Rstrings.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "\numa frase comum";
        StringBuilder sb = new StringBuilder(16);
        sb.append("Silvano");
        sb.append(" Gabriel");
        System.out.println(sb.insert(1, "Dono da conta: "));
        System.out.println(s.substring(0,1));
    }
}
