package br.com.sky.javacore.Eblocodeinicializacao.test;

import br.com.sky.javacore.Eblocodeinicializacao.classes.Cliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        System.out.println("\nExibindo quantidade de parcelas possiveis: ");
        for (int par : c.getParcelas()) {
            System.out.print(par);
            if (par != 100) {
                System.out.print(", ");
            } else {
                continue;
            }
        }
    }
}
