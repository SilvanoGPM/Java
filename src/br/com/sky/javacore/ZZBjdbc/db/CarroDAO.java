package br.com.sky.javacore.ZZBjdbc.db;

import br.com.sky.javacore.ZZBjdbc.classes.Carro;
import br.com.sky.javacore.ZZBjdbc.classes.Comprador;
import br.com.sky.javacore.ZZBjdbc.coon.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    public static void save(Carro carro) {

        String sql = "INSERT INTO agencia.carro (nome, placa, compradorid) VALUES (?, ?, ?);";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, carro.getNome());
            ps.setString(2, carro.getPlaca());
            ps.setInt(3, carro.getComprador().getId());
            ps.executeUpdate();

            System.out.println("Carro Adicionado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void delete(Carro carro) {

        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possivel deletar o carro!");
            return;
        }

        String sql = "DELETE FROM agencia.carro WHERE (id = ?);";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, carro.getId());
            ps.executeUpdate();
            System.out.println("Carro deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void update(Carro carro) {

        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível atualizar o carro!");
            return;
        }

        String sql = "UPDATE `agencia`.`carro` SET `placa` = ?, `nome` = ? WHERE (`id` = ?);";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, carro.getId());

            ps.executeUpdate();
            System.out.println("Atulição concluida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static List<Carro> selectAll() {

        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT id, nome, placa, compradorid FROM agencia.carro";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Comprador c = CompradorDAO.searchById(rs.getInt("compradorid"));
                carros.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));

            }

            return carros;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Carro> searchByName(String nome) {

        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT id, nome, placa, compradorid FROM agencia.carro WHERE nome LIKE (?)";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comprador c = CompradorDAO.searchById(rs.getInt("compradorid"));
                carros.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));

            }

            ConexaoFactory.close(conn, ps, rs);
            return carros;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


}
