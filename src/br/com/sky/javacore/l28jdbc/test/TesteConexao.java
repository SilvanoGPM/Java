package br.com.sky.javacore.l28jdbc.test;

import br.com.sky.javacore.l28jdbc.classes.Comprador;
import br.com.sky.javacore.l28jdbc.db.CompradorDAO;
import br.com.sky.javacore.l28jdbc.db.CompradorDBOLD;

import java.util.List;

public class TesteConexao {
    public static void main(String[] args) {

       CompradorDAO.update(new Comprador(1, "MARIA", "123.451.414-23"));


    }

    public static void inserir() {
        Comprador alex = new Comprador("Silva", "433.134.135.43");
        CompradorDBOLD.save(alex);
    }

    public static void deletar() {
        Comprador alex = new Comprador();
        alex.setId(8);
        CompradorDBOLD.delete(alex);
    }

    public static void atualizar() {
        Comprador alex = new Comprador(7, "Silvano", "433.134.135.43");
        CompradorDBOLD.update(alex);
    }

    public static List<Comprador> selecionarTudo() {
        return CompradorDBOLD.selectAll();
    }

    public static List<Comprador> buscarPeloNome(String nome) {
        return CompradorDBOLD.searchByName(nome);
    }

}

