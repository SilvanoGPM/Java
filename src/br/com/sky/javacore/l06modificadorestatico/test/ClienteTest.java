package br.com.sky.javacore.l06modificadorestatico.test;


import br.com.sky.javacore.l06modificadorestatico.classes.Cliente;

public class ClienteTest {
    public static void main(String[] args) {
        System.out.println(Cliente.getParcelas());
        System.out.println("\nExibindo quantidade de parcelas possiveis: ");
        for (int par : Cliente.getParcelas()) {
            if (par == 34)  {
                System.out.print("\n");
            } else if (par == 66) {
                System.out.print("\n");
            }
            System.out.print(par + ", ");
        }
        System.out.println("Tamanho: " + Cliente.getParcelas().length);
    }
}
