package br.com.sky.javacore.l20expressoesregulares;

public class TokenTest {
    public static void main(String[] args) {
        String str = "Silvano, Vitor, Victor, Helbnny, Mikael, Marlos, Christian";
        String[] tokens = str.split(",");
        for (String array : tokens ) {
            System.out.println(array.trim());
        }
    }
}
