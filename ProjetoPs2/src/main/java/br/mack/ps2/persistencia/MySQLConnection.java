package br.mack.ps2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class MySQLConnection {
    String url = "jdbc:mysql://localhost:3306/projeto_ps2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String usuario = "root";
    String psw = "root";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, psw);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}