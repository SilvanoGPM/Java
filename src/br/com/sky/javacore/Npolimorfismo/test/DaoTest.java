package br.com.sky.javacore.Npolimorfismo.test;

import br.com.sky.javacore.Npolimorfismo.classes.DatabaseDAOImpl;
import br.com.sky.javacore.Npolimorfismo.classes.GenericDAO;

import java.util.LinkedList;
import java.util.List;

public class DaoTest {
    public static void main(String[] args) {
        GenericDAO arquivoDAO = new DatabaseDAOImpl();
        arquivoDAO.save();
        List<String> lista = new LinkedList<>();
        lista.add("Nome 1");
        lista.add("Nome 2");
        lista.add("Nome 3");
        lista.add("Nome 4");
        lista.add("Nome 5");
        lista.add("Nome 6");
        for(String nome : lista) {
            System.out.println(nome);
        }
    }
}
