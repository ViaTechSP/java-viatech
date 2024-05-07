package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConexao {

    private static final String url = "jdbc:mysql://localhost:3306/projeto";

    private static final String user = "root";
    private static final String password = "Renan12.";

    private static Connection conn;

    public static Connection getbancoConexao() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}