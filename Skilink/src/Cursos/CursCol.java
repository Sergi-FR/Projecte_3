package Cursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Conn.ConexioBD;

public class CursCol extends Curs {

    private LocalTime hora_inici;
    private LocalTime hora_final;
    private int aforament;

    // Contructors
    // #############################################

    public CursCol() {
    }

    public CursCol(int preu, LocalDate data_curs, int id, String nom_monitor, LocalTime hora_inici,
            LocalTime hora_final, int aforament) {
        super(preu, data_curs, id, nom_monitor);
        this.hora_inici = hora_inici;
        this.hora_final = hora_final;
        this.aforament = aforament;
    }

    // Getters Setters
    // #############################################

    public LocalTime getHora_inici() {
        return hora_inici;
    }

    public void setHora_inici(LocalTime hora_inici) {
        this.hora_inici = hora_inici;
    }

    public LocalTime getHora_final() {
        return hora_final;
    }

    public void setHora_final(LocalTime hora_final) {
        this.hora_final = hora_final;
    }

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public ArrayList<CursCol> consultaBDCursosCol() throws SQLException {

        Connection conn = ConexioBD.getConnection();

        ArrayList<CursCol> cursosCol = new ArrayList<>();

        String consulta = "SELECT IDC,data_curs, aforament,nom,hora_inici, hora_final,preu FROM cursos c, colectius cc, monitors m where m.DNI = c.nomMonitor and cc.IDC= c.ID";

        PreparedStatement sql;

        sql = conn.prepareStatement(consulta);

        ResultSet rs = sql.executeQuery();

        while (rs.next()) {

            CursCol ccol = new CursCol();

            ccol.setId(rs.getInt("IDC"));
            ccol.setData_curs(LocalDate.parse(rs.getString("data_curs")));
            ccol.setAforament(rs.getInt("aforament"));
            ccol.setNom_monitor(rs.getString("nom"));
            ccol.setHora_inici(LocalTime.parse(rs.getString("hora_inici")));
            ccol.setHora_final(LocalTime.parse(rs.getString("hora_final")));
            ccol.setPreu(rs.getInt("preu"));

            cursosCol.add(ccol);
        }

        return cursosCol;

    }

}
