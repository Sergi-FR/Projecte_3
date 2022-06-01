package Projecte3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioBD {

   private static Connection connexioBD = null;

   public static Connection getConnection() {
      try {
         if (connexioBD == null) {
            String driver = "com.mysql.cj.jdbc.Driver";
            String bbdd = "jdbc:mysql://localhost/esqui?autoReconnect=true";
            String usuari = "root";
            String contrasenya = "mysql";
            Class.forName(driver);
            connexioBD = DriverManager.getConnection(bbdd, usuari, contrasenya);
         }
      } catch (ClassNotFoundException | SQLException ex) {
         ex.printStackTrace();
      }
      return connexioBD;
   }

}
