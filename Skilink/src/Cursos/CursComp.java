package Cursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Conn.ConexioBD;

public class CursComp extends Curs {

    private LocalTime hora_inici;
    private LocalTime hora_final;
    private LocalDate data_final;
    private String nivell_curs;

    // Contructors
    // #############################################

    public CursComp() {
    }

    public CursComp(int preu, LocalDate data_curs, int id, String nom_monitor, LocalTime hora_inici,
            LocalTime hora_final, LocalDate data_final, String nivell_curs) {
        super(preu, data_curs, id, nom_monitor);
        this.hora_inici = hora_inici;
        this.hora_final = hora_final;
        this.data_final = data_final;
        this.nivell_curs = nivell_curs;
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

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }

    public String getNivell_curs() {
        return nivell_curs;
    }

    public void setNivell_curs(String nivell_curs) {
        this.nivell_curs = nivell_curs;
    }

    public ArrayList<CursComp> consultaBDCursosComp() throws SQLException {

        Connection conn = ConexioBD.getConnection();

        ArrayList<CursComp> cursosComp = new ArrayList<>();

        String consulta = "SELECT ID_comp, nivell_curs, nom, data_curs, data_final, hora_inici, hora_final,preu FROM cursos c, competicio cc, monitors m where m.DNI = c.nomMonitor and cc.ID_comp= c.ID";

        PreparedStatement sql;

        sql = conn.prepareStatement(consulta);

        ResultSet rs = sql.executeQuery();

        while (rs.next()) {

            CursComp ccomp = new CursComp();

            ccomp.setId(rs.getInt("ID_comp"));
            ccomp.setNivell_curs(rs.getString("nivell_curs"));
            ccomp.setNom_monitor(rs.getString("nom"));
            ccomp.setData_curs(LocalDate.parse(rs.getString("data_curs")));
            ccomp.setData_final(LocalDate.parse(rs.getString("data_final")));
            ccomp.setHora_inici(LocalTime.parse(rs.getString("hora_inici")));
            ccomp.setHora_final(LocalTime.parse(rs.getString("hora_final")));
            ccomp.setPreu(rs.getInt("preu"));

            cursosComp.add(ccomp);

        }

        return cursosComp;

    }

}
