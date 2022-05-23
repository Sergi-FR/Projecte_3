package Projecte3.TipusCursos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.mysql.cj.result.LocalTimeValueFactory;

import Projecte3.ConnexioBD;
import Projecte3.Curs;

public class CursColectiu extends Curs {

    private int aforament;
    private double preu;
    private LocalTime hora_inici;
    private LocalTime hora_final;

    

    public CursColectiu(int id, LocalDate data, String nomMonitor, int aforament, double preu, LocalTime hora_inici,
            LocalTime hora_final) {
        super(id, data, nomMonitor);
        this.aforament = aforament;
        this.preu = preu;
        this.hora_inici = hora_inici;
        this.hora_final = hora_final;
    }

    public CursColectiu() {

    }

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

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

    public ArrayList<CursColectiu> consultaCursColectiuBD() throws SQLException {

        // Fem connexió a la BD
        ConnexioBD con = new ConnexioBD();
        con.conectarBD();

        // Com necessito l'array en sol aquest metode, el creare aqui
        ArrayList<CursColectiu> cursColectiu = new ArrayList<>();

        // Demanem el DNI
        String consultaColectius = "SELECT C.ID, C.nomMonitor, C.data_curs, CO.aforament, CO.hora_inici, CO.hora_final, CO.preu FROM cursos C, colectius CO WHERE C.ID= CO.IDC";
        PreparedStatement dades = con.connexioBD.prepareStatement(consultaColectius);

        ResultSet rs = dades.executeQuery();

        while (rs.next()) {

            CursColectiu colectiu = new CursColectiu();
            colectiu.setId(rs.getInt("ID"));
            colectiu.setNomMonitor(rs.getString("nomMonitor"));
            colectiu.setData(Date.valueOf(rs.getString("data_curs")).toLocalDate());
            colectiu.setAforament(rs.getInt("aforament"));
            colectiu.setHora_inici(Time.valueOf(rs.getString("hora_inici")).toLocalTime());
            colectiu.setHora_final(Time.valueOf(rs.getString("hora_final")).toLocalTime());
            colectiu.setPreu(rs.getDouble("preu"));
            cursColectiu.add(colectiu);

        }

        con.desconectarBD();

        return cursColectiu;
    }

}
