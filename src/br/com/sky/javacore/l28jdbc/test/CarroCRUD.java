package br.com.sky.javacore.l28jdbc.test;

import br.com.sky.javacore.l28jdbc.classes.Carro;
import br.com.sky.javacore.l28jdbc.classes.Comprador;
import br.com.sky.javacore.l28jdbc.db.CarroDAOImpl;
import br.com.sky.javacore.l28jdbc.interfaces.CarroDAO;

import java.util.List;
import java.util.Scanner;

public class CarroCRUD {

    private static Scanner teclado = new Scanner(System.in);
    private static CarroDAO dao = new CarroDAOImpl();

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
        Carro c = new Carro();
        System.out.print("No me: ");
        c.setNome(teclado.nextLine());
        System.out.print("Placa: ");
        c.setPlaca(teclado.nextLine());
        System.out.println("Selecione um comprador: ");
        List<Comprador> compradorList = CompradorCRUD.listar();
        c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));

        System.out.println();
        dao.save(c);
    }

    private static void atualizar() {

        System.out.println("Selecione um carro: ");
        List<Carro> carroList = listar();

        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("<!> APERTE SOMENTE \"ENTER\" SE NÃO QUISER MODIFICAR O CAMPO <!>");
        System.out.print("Novo nome: ");
        String nome = teclado.nextLine();
        System.out.print("Nova placa: ");
        String placa = teclado.nextLine();

        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!placa.isEmpty()) {
            c.setPlaca(placa);
        }
        dao.update(c);


    }

    private static List<Carro> listar() {

        List<Carro> carroList = dao.selectAll();

        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("<" + i + "> " + c.getNome() + " | " + c.getPlaca() + " | " + c.getComprador().getNome());
        }

        return carroList;
    }

    private static void buscarPorNome(String nome) {

        List<Carro> carroList = dao.searchByName(nome);

        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("<" + i + "> " + c.getNome() + " | " + c.getPlaca() + " | " + c.getComprador().getNome());

        }

    }

    private static void deletar() {

        System.out.println("Selecione um carro: ");
        List<Carro> carroList = listar();
        int index = Integer.parseInt(teclado.nextLine());
        System.out.println("Tem certeza? [S/N]");
        String op = teclado.nextLine().toUpperCase();

        if (op.startsWith("S")) {
            dao.delete(carroList.get(index));
        }

    }

}
