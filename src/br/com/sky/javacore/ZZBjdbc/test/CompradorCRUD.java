package br.com.sky.javacore.ZZBjdbc.test;

import br.com.sky.javacore.ZZBjdbc.classes.Comprador;
import br.com.sky.javacore.ZZBjdbc.db.CompradorDAO;

import java.util.List;
import java.util.Scanner;

public class CompradorCRUD {

    private static Scanner teclado = new Scanner(System.in);

    public static void executar(int op) {
        switch (op) {
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                System.out.println("Digite o nome: ");
                buscarPorNome(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;
            case 6:
                break;
        }
    }

    private static void inserir() {
        Comprador c = new Comprador();
        System.out.print("Nome: ");
        c.setNome(teclado.nextLine());
        System.out.print("CPF: ");
        c.setCpf(teclado.nextLine());
        System.out.println();
        CompradorDAO.save(c);
    }

    private static void atualizar() {

        System.out.println("Selecione um comprador: ");
        List<Comprador> compradorList = listar();

        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("<!> NÃO DIGITE SE NÃO QUISER MODIFICAR O CAMPO <!>");
        System.out.print("Novo nome: ");
        String nome = teclado.nextLine();
        System.out.print("Novo CPF: ");
        String cpf = teclado.nextLine();

        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!cpf.isEmpty()) {
            c.setCpf(cpf);
        }
        CompradorDAO.update(c);


    }

    public static List<Comprador> listar() {

        List<Comprador> compradorList = CompradorDAO.selectAll();

        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("<" + i + "> " + c.getNome() + " | " + c.getCpf());
        }

        return compradorList;
    }

    private static void buscarPorNome(String nome) {

        List<Comprador> compradorList = CompradorDAO.searchByName(nome);

        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("<" + i + "> " + c.getNome() + " | " + c.getCpf());
        }

    }

    private static void deletar() {

        System.out.println("Selecione um comprador: ");
        List<Comprador> compradorList = listar();
        int index = Integer.parseInt(teclado.nextLine());
        System.out.println("Tem certeza? [S/N]");
        String op = teclado.nextLine().toUpperCase();

        if (op.startsWith("S")) {
            CompradorDAO.delete(compradorList.get(index));
        }

    }

}
