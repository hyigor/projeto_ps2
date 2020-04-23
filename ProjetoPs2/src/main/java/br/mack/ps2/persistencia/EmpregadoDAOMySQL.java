package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Empregado;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDAOMySQL implements EmpregadoDAO {
    private String creatSQL = "INSERT INTO empregado (nome, cargo, salario ) VALUES(?,?,?)";
    private String readSQL = "SELECT * FROM empregado";
    private String updateSQL = " UPDATE empregado SET nome=?, cargo=?, salario=? where id = ?";
    private String deleteSQL = "DELETE FROM empregado where id = ?";

    private MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean creat(Empregado empregado) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(creatSQL);
            stm.setString(1, empregado.getNome());
            stm.setString(2,empregado.getCargo());
            stm.setLong(3,empregado.getSalario());
            int registro = stm.executeUpdate();
            return (registro>0);
                  }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Empregado> read() {
        Connection conexao = mysql.getConnection();
        List<Empregado> empregados = new ArrayList();
        try{
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while ( rs.next()){
                Empregado empregado = new Empregado();
                empregado.setId(rs.getLong("id"));
                empregado.setNome(rs.getString("nome"));
                empregado.setCargo(rs.getString("cargo"));
                empregado.setSalario(rs.getLong("salario"));
                empregados.add(empregado);
            }
            return empregados;
        } catch (final SQLException ex){
            System.out.println("Falha de conexao com a base de dados!");
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
            }return empregados;
        }


    @Override
    public boolean update(Empregado empregado) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            stm.setString(1,empregado.getNome());
            stm.setString(2,empregado.getCargo());
            stm.setLong(3,empregado.getSalario());

            int registros = stm.executeUpdate();
            return registros >0 ? true : false;
        }catch (final SQLException ex){
            System.out.println("Falha na conexao com a base de dados!");
            ex.printStackTrace();
        }catch (final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean delete(Empregado empregado) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setLong(1,empregado.getId());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false ;

        }catch (final SQLException ex){
            System.out.println("Falha na conexao com a base de dados!");
            ex.printStackTrace();
        }catch (final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
