package br.com.sky.javacore.l28jdbc.db;

import br.com.sky.javacore.l28jdbc.classes.Comprador;
import br.com.sky.javacore.l28jdbc.coon.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO {

    public static void save(Comprador comprador) {

        String sql = "INSERT INTO agencia.comprador (cpf, nome) VALUES (?, ?);";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.executeUpdate();

            System.out.println("Comprador Adicionado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void delete(Comprador comprador) {

        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel deletar o comprador!");
            return;
        }

        String sql = "DELETE FROM agencia.comprador WHERE (id = ?);";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, comprador.getId());
            ps.executeUpdate();
            System.out.println("Comprador deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void update(Comprador comprador) {

        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o comprador!");
            return;
        }

        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE (`id` = ?);";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());

            ps.executeUpdate();
            System.out.println("Atulição concluida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static List<Comprador> selectAll() {

        List<Comprador> compradores = new ArrayList<>();
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                compradores.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

            }

            return compradores;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String nome) {

        List<Comprador> compradores = new ArrayList<>();
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE (?)";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                compradores.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

            }

            ConexaoFactory.close(conn, ps, rs);
            return compradores;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static Comprador searchById(Integer id) {

        Comprador comprador = null;
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE id = ?";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                comprador = new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"));

            }

            ConexaoFactory.close(conn, ps, rs);
            return comprador;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

}
