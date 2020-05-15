package br.com.sky.javacore.l20expressoesregulares;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 true 100 oi");
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        System.out.println("--------------------------------------");
        Scanner scanner2 = new Scanner("1 true 100 oi");
        while(scanner2.hasNext()) {
            if(scanner2.hasNextInt()) {
                int um = scanner2.nextInt();
                System.out.println(um);
            } else if(scanner2.hasNextBoolean()) {
                boolean b = scanner2.nextBoolean();
                System.out.println(b);
            } else {
                System.out.println(scanner2.next());
            }
        }
        System.out.println("--------------------------------------------");
        Scanner s = new Scanner("2,2");
        while(s.hasNext()) {
            if(s.hasNextDouble()) {
                System.out.println("A");
                double d = s.nextDouble();
                System.out.println(d);
            }
        }
    }
}
