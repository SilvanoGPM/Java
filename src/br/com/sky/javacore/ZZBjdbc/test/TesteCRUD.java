package br.com.sky.javacore.ZZBjdbc.test;

import java.util.Scanner;

public class TesteCRUD {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int op;

        while (true) {
            menu();
            op = Integer.parseInt(teclado.nextLine());

            if (op == 1) {
                menuComprador();
                op = Integer.parseInt(teclado.nextLine());
                CompradorCRUD.executar(op);
            }
            if (op == 2) {
                menuCarro();
                op = Integer.parseInt(teclado.nextLine());
                CarroCRUD.executar(op);
            }

            if (op == 0) {
                System.out.println("Encerrando sistema!");
                break;
            }

        }

    }

    private static void menu() {
        System.out.println("Selecione um menu: ");
        System.out.println("[1] Comprador");
        System.out.println("[2] Carro");
        System.out.println("[0] Sair");
    }

    private static void menuComprador() {
        System.out.println("Digite a opção: ");
        System.out.println("[1] Inserir Comprador");
        System.out.println("[2] Atualizar Comprador");
        System.out.println("[3] Listar todos os compradores");
        System.out.println("[4] Buscar um comprador por nome");
        System.out.println("[5] Deletar um comprador");
        System.out.println("[6] Voltar");


    }

    private static void menuCarro() {
        System.out.println("Digite a opção: ");
        System.out.println("[1] Inserir carro");
        System.out.println("[2] Atualizar carro");
        System.out.println("[3] Listar todos os carros");
        System.out.println("[4] Buscar um carro por nome");
        System.out.println("[5] Deletar um carro");
        System.out.println("[6] Voltar");


    }

}
