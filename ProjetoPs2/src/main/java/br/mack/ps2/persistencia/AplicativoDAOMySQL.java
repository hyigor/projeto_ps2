package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Aplicativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AplicativoDAOMySQL implements AplicativoDAO{
    private String createSQL = "INSERT INTO aplicativo (nome,desenvolvedor,numero_de_downloads) VALUES (?,?,?)";
    private String readSQL = "SELECT * FROM aplicativo";
    private String updateSQL = "UPDATE aplicativo SET nome = ?, desenvolvedor = ?, numero_de_downloads = ? WHERE id = ?";
    private String deleteSQL = "DELETE FROM aplicativo WHERE id = ?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1, aplicativo.getNome());
            stm.setString(2, aplicativo.getDesenvolvedor());
            stm.setLong(3, aplicativo.getNumero_de_downloads());
            int registro = stm.executeUpdate();
            return registro > 0;

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Aplicativo> read() {
        Connection conexao = mysql.getConnection();
        List<Aplicativo> aplicativos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet registro = stm.executeQuery();

            while (registro.next()){
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.setId(registro.getLong("id"));
                aplicativo.setNome(registro.getString("nome"));
                aplicativo.setDesenvolvedor(registro.getString("desenvolvedor"));
                aplicativo.setNumero_de_downloads(registro.getLong("numero_de_downloads"));
                aplicativos.add(aplicativo);
            }
                return aplicativos;

        } catch (final SQLException e){
            e.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final Exception e){
                e.printStackTrace();
            }
        }

        return aplicativos;
    }

    @Override
    public boolean update(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        int registros = -1;
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1,aplicativo.getNome());
            stm.setString(2,aplicativo.getDesenvolvedor());
            stm.setLong(3, aplicativo.getNumero_de_downloads());
            stm.setLong(4, aplicativo.getId());

            registros = stm.executeUpdate();



        } catch (final SQLException e){
            System.out.println("Falha de conexão com a base de dados!");
            e.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final Exception e){
                e.printStackTrace();
            }
        }
        return registros > 0;
    }

    @Override
    public boolean delete(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1,aplicativo.getId());
            int registros = stm.executeUpdate();
            return registros > 0;

        } catch (SQLException e){
            System.out.println("Falha de conexão com a base de dados!");
            e.printStackTrace();
        } catch(final Exception e){
            e.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final Exception e){
                e.printStackTrace();
            }
        }

        return false;
    }
}
