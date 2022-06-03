package Cursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Conn.ConexioBD;

public class CursInd extends Curs {

    LocalTime hora_inici;
    int duracio;

    public CursInd() {
    }

    public CursInd(int preu, LocalDate data_curs, int id, String nom_monitor) {
        super(preu, data_curs, id, nom_monitor);
    }

    public ArrayList<CursInd> consultaBDCursosInd() throws SQLException {

        Connection conn = ConexioBD.getConnection();

        ArrayList<CursInd> cursosInd = new ArrayList<>();

        String consulta = "SELECT IDI, nom, data_curs, preu FROM cursos c, individuals ci, monitors m where m.DNI = c.nomMonitor and ci.IDI= c.ID";

        PreparedStatement sql;

        sql = conn.prepareStatement(consulta);

        ResultSet rs = sql.executeQuery();

        while (rs.next()) {

            CursInd cind = new CursInd();

            cind.setId(rs.getInt("IDI"));
            cind.setNom_monitor(rs.getString("nom"));
            cind.setData_curs(LocalDate.parse(rs.getString("data_curs")));
            cind.setPreu(rs.getInt("preu"));

            cursosInd.add(cind);

            System.out.println(cind);

        }

        return cursosInd;

    }

}
