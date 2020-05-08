package br.com.sky.introducao;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Até que número você quer que vá? ");
        int ate = entrada.nextInt();
        System.out.print("A tabuada de que número você que ver? ");
        int tabuada = entrada.nextInt();
        for (int i = 1; i <= ate; i++) {
            int resultado = i*tabuada;
        System.out.print(tabuada+" x "+i+" = "+resultado+"\n");
        }
        boolean vdd = true;

    }
}
