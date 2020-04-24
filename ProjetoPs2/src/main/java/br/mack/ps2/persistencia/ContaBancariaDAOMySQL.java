package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.ContaBancaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaBancariaDAOMySQL implements ContaBancariaDAO {
    private String createSQL = "INSERT INTO conta_bancaria(nome_do_titular,saldo,numero_da_agencia) VALUES(?,?,?)";
    private String readSQL = "SELECT * FROM conta_bancaria";
    private String updateSQL = "UPDATE conta_bancaria SET nome_do_titular=?, saldo=?, numero_da_agencia=? WHERE id=?";
    private String deleteSQL = "DELETE FROM conta_bancaria WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(ContaBancaria contabancaria) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1,contabancaria.getNome_do_titular());
            stm.setLong(2, contabancaria.getSaldo());
            stm.setInt(3, contabancaria.getNum_da_agencia());
            int registro = stm.executeUpdate();
            return (registro>0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<ContaBancaria> read() {
        Connection conexao = mysql.getConnection();
        List<ContaBancaria> contas= new ArrayList();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet registro = stm.executeQuery();
            while (registro.next()) {
                ContaBancaria conta = new ContaBancaria();
                conta.setId(registro.getLong("id"));
                conta.setNome_do_titular(registro.getString("nome_do_titular"));
                conta.setSaldo(registro.getLong("saldo"));
                conta.setNum_da_agencia(registro.getInt("numero_da_agencia"));
                contas.add(conta);
            }
            return contas;

        } catch (final SQLException throwables) {
            throwables.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (final SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return contas;
    }

    @Override
    public boolean updade(ContaBancaria contabancaria) {
        Connection conexao =mysql.getConnection();
        int registro = -1;
        try{
            PreparedStatement stm= conexao.prepareStatement(updateSQL);
            stm.setString(1,contabancaria.getNome_do_titular());
            stm.setLong(2, contabancaria.getSaldo());
            stm.setInt(3, contabancaria.getNum_da_agencia());
            stm.setLong(4, contabancaria.getId());

            registro = stm.executeUpdate();


        } catch (final SQLException throwables) {
            System.out.println("Falha de conexão com a base de dados!");
            throwables.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (final SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return registro > 0;
    }

    @Override
    public boolean delete(ContaBancaria contabancaria) {
        Connection conexao= mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1, contabancaria.getId());
            int registro = stm.executeUpdate();
            return registro>0 ? true:false;
        } catch (final SQLException throwables) {
            System.out.println("Falha de conexão com a base de dados!");
            throwables.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (final SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
    }
}
