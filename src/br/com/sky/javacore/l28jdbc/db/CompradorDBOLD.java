package br.com.sky.javacore.l28jdbc.db;

import br.com.sky.javacore.l28jdbc.classes.Comprador;
import br.com.sky.javacore.l28jdbc.classes.MyRowSetListener;
import br.com.sky.javacore.l28jdbc.coon.ConexaoFactory;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDBOLD {

    public static void save(Comprador comprador) {
        Connection conn = ConexaoFactory.getConexao();
        try {

            String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "');";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("REGISTRO SALVO COM SUCESSO");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveTransaction() {
        Connection conn = ConexaoFactory.getConexao();
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE1', 'TESTE1');";
        String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE2', 'TESTE2');";
        String sql3 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE3', 'TESTE3');";
        Savepoint savepoint = null;
        try {

            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            savepoint = conn.setSavepoint("One");
            stmt.executeUpdate(sql2);
            savepoint = conn.setSavepoint("Two");
            if (true)
                throw new SQLException();

            stmt.executeUpdate(sql3);
            conn.commit();
            ConexaoFactory.close(conn, stmt);
            System.out.println("REGISTRO SALVO COM SUCESSO");

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback(savepoint);
                conn.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível deletar o registro!");
            return;
        }

        Connection conn = ConexaoFactory.getConexao();
        try {

            String sql = "DELETE FROM `agencia`.`comprador` WHERE (`id` = '" + comprador.getId() + "');";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("REGISTRO EXCLUIDO COM SUCESSO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro!");
            return;
        }

        Connection conn = ConexaoFactory.getConexao();
        try {

            String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '" + comprador.getCpf() + "', `nome` = '" + comprador.getNome() + "' WHERE (`id` = '" + comprador.getId() + "');";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("REGISTRO ATUALIZADO COM SUCESSO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            ConexaoFactory.close(conn, stmt, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String search) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE '%" + search + "%'";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            ConexaoFactory.close(conn, stmt, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectMetaData() {
        String sql = "SELECT * FROM agencia.comprador";

        Connection conn = ConexaoFactory.getConexao();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            int qtdColunas = rsmd.getColumnCount();
            System.out.println("Quantidades de colunas: " + qtdColunas);

            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("Tabela: " + rsmd.getTableName(i));
                System.out.println("Nome da coluna: " + rsmd.getColumnName(i));
                System.out.println("Tamanho da coluna: " + rsmd.getColumnDisplaySize(i));
            }

            ConexaoFactory.close(conn, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void checkDriverStatus() {

        Connection conn = ConexaoFactory.getConexao();

        try {
            DatabaseMetaData ddmd = conn.getMetaData();

            if (ddmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Suporta o TYPE_FORWARD_ONLY");
                if (ddmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE))
                    System.out.println(" e tbm suporta o CONCUR_UPDATABLE");
            }

            if (ddmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta o TYPE_SCROLL_INSENSITIVE");
                if (ddmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE))
                    System.out.println(" e tbm suporta o CONCUR_UPDATABLE");
            }

            if (ddmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta o TYPE_SCROLL_SENSITIVE");
                if (ddmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE))
                    System.out.println(" e tbm suporta o CONCUR_UPDATABLE");
            }

            ConexaoFactory.close(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void testTypeScroll() {

        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();

        try {

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.last()) {
                System.out.println("Última linha: " + (new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"))));
                System.out.println("Número da última linha: " + rs.getRow());
            }

            System.out.println("Retornou para a primeira linha: " + rs.first());
            System.out.println("Número da linha: " + rs.getRow());
            System.out.println("Retornou para a linha: " + rs.absolute(4));
            System.out.println("Número da linha: " + rs.getRow());

            System.out.println("Linha 4: " + (new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"))));

            rs.relative(-1);

            System.out.println("Linha 3: " + (new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"))));

            System.out.println(rs.isLast());
            System.out.println(rs.isFirst());
            rs.afterLast();
            while (rs.previous()) {
                System.out.println("Comprador: " + (new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"))));
                System.out.println("Número da última linha: " + rs.getRow());
            }


            ConexaoFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNomesToLowerCase() {

        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        try {
            DatabaseMetaData dbmd = conn.getMetaData();

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println(dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//            System.out.println(dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//            System.out.println(dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            if (rs.next()) {
                rs.updateString("nome", rs.getString("nome").toUpperCase());
                rs.updateRow();
                rs.cancelRowUpdates();
//                if (rs.rowUpdated()) System.out.println("Linha atualizada!");
            }

            rs.absolute(2);
            String nome = rs.getString("nome");
            rs.moveToInsertRow();
            rs.updateString("nome", nome.toUpperCase());
            rs.updateString("cpf", "999.234.134-43");
            rs.insertRow();
            rs.moveToCurrentRow();
            System.out.println(rs.getString("nome"));

            rs.absolute(8);
            rs.deleteRow();


            ConexaoFactory.close(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> searchByNamePreparedStatement(String search) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            ConexaoFactory.close(conn, ps, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updatePreparedStatement(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro!");
            return;
        }

        Connection conn = ConexaoFactory.getConexao();
        try {

            String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE (`id` = ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();
            ConexaoFactory.close(conn, ps);
            System.out.println("REGISTRO ATUALIZADO COM SUCESSO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> searchByNameCallableStatement(String search) {
        String sql = "CALL `agencia`.`SP_GetCompradoresPorNome`(?);";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, "%" + search + "%");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            ConexaoFactory.close(conn, cs, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByNameRollSet(String search) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnetion();
        jrs.addRowSetListener(new MyRowSetListener());
        List<Comprador> compradorList = new ArrayList<>();
        try {

            jrs.setCommand(sql);

//            PreparedStatement ps = jrs.prepareStatement(sql);
            jrs.setString(1, "%" + search + "%");
            jrs.execute();


            while (jrs.next()) {
                compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("nome"), jrs.getString("cpf")));
            }

            ConexaoFactory.close(jrs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateRowSet(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro!");
            return;
        }

        JdbcRowSet jrs = ConexaoFactory.getRowSetConnetion();
        jrs.addRowSetListener(new MyRowSetListener());

        try {

            String sql = "SELECT * FROM comprador WHERE id = ?";

            jrs.setCommand(sql);
            jrs.setInt(1, comprador.getId());
            jrs.execute();

            jrs.next();
            jrs.updateString("nome", "Maria");
            jrs.updateRow();

            ConexaoFactory.close(jrs);
            System.out.println("REGISTRO ATUALIZADO COM SUCESSO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRowSetCached(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro!");
            return;
        }

        CachedRowSet crs = ConexaoFactory.getRowSetConnetionCached();

        try {

            String sql = "SELECT * FROM comprador WHERE id = ?";

            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();
            crs.next();
            crs.updateString("nome", "MARIA");
            crs.updateRow();
            Thread.sleep(1000);
            crs.acceptChanges();

            System.out.println("REGISTRO ATUALIZADO COM SUCESSO");
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}


