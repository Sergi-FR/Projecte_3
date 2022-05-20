package Projecte3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioBD {

    public static Connection connexioBD = null;

    private String servidor;
    private String bbdd;
    private String user;
    private String password;

    public void conectarBD() {

        String servidor = "jdbc:mysql://localhost:3306/";
        String bbdd = "esqui";
        String user = "root";
        String password = "mysql";

        try {
            connexioBD = DriverManager.getConnection(servidor + bbdd, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void desconectarBD() throws SQLException {
        connexioBD.close();
    }

}
