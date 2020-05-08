package br.com.sky.introducao;

import java.util.Scanner;
public class Arrays1 {
    public static void main(String[] args) {
        //byte, short, int, long, float, double = 0
        //char = '\u0000' or ' '
        //boolean = false
        //refenrence = null
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Qual o tamanho do array? ");
        int n1 = keyboard.nextInt();
        String[] nome = new String[n1];
        nome[0] = "Goku";
        nome[1] = "Naruto";
        nome[2] = "Luffy";
        nome[3] = "Kaneki";
        for (int controle = 0; controle < nome.length; controle++) {
            System.out.println("Meu nome é "+nome[controle]);
        }
        System.out.println("o novo array tem o tamanho de? ");
        n1 = keyboard.nextInt();
        for(int controle = 0; controle < nome.length; controle++) {
            System.out.println(nome[controle]);
        }
    }
}
