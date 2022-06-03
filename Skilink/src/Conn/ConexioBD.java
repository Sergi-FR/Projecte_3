package Conn;

import java.sql.*;

public class ConexioBD {

    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    ConexioBD() {

        String url = "jdbc:mysql://localhost:3306/esqui";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "1234";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        if (conn == null) {
            new ConexioBD();
        }

        return conn;
    }
}