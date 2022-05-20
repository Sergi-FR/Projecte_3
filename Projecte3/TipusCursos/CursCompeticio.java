package Projecte3.TipusCursos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Projecte3.ConnexioBD;
import Projecte3.Curs;

public class CursCompeticio extends Curs {

    private String nivell_curs;
    private LocalTime hora_inici;
    private LocalTime hora_final;
    private LocalDate data_fi;
    private double preu;

    public CursCompeticio(int id, LocalDate data, String nomMonitor, String nivell_curs, LocalTime hora_inici,
            LocalTime hora_final, LocalDate data_fi, double preu) {
        super(id, data, nomMonitor);
        this.nivell_curs = nivell_curs;
        this.hora_inici = hora_inici;
        this.hora_final = hora_final;
        this.data_fi = data_fi;
        this.preu = preu;
    }

    public CursCompeticio() {

    }

    public String getNivell_curs() {
        return nivell_curs;
    }

    public void setNivell_curs(String nivell_curs) {
        this.nivell_curs = nivell_curs;
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

    public LocalDate getData_fi() {
        return data_fi;
    }

    public void setData_fi(LocalDate data_fi) {
        this.data_fi = data_fi;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public ArrayList<CursCompeticio> consultaClientBD() throws SQLException {

        // Fem connexió a la BD
        ConnexioBD con = new ConnexioBD();
        con.conectarBD();

        // Com necessito l'array en sol aquest metode, el creare aqui
        ArrayList<CursCompeticio> cursColectiu = new ArrayList<>();

        // Demanem el DNI
        String consultaColectius = "SELECT C.DNI, C.nom, C.cognom, C.sexe, C.email, B.num_familia, B.data_caducitat AS data_final , F.data_caducitat AS data_fed, F.nivell FROM clients C LEFT JOIN familia_nombrosa B ON C.DNI = B.dni_client LEFT JOIN federat F ON C.DNI = F.dni_federat";
        PreparedStatement dades = con.connexioBD.prepareStatement(consultaColectius);

        ResultSet rs = dades.executeQuery();

        while (rs.next()) {

            CursCompeticio colectiu = new CursCompeticio();
            colectiu.setId(rs.getInt("ID"));
            colectiu.setNomMonitor(rs.getString("nomMonitor"));
            colectiu.setData(Date.valueOf(rs.getString("data_curs")).toLocalDate());
            colectiu.setData_fi(Date.valueOf(rs.getString("data_curs")).toLocalDate());
            colectiu.setNivell_curs(rs.getString("nivell_curs"));
            colectiu.setHora_inici(Time.valueOf(rs.getString("hora_inici")).toLocalTime());
            colectiu.setHora_final(Time.valueOf(rs.getString("hora_final")).toLocalTime());
            colectiu.setPreu(rs.getDouble("preu"));
            cursColectiu.add(colectiu);

        }

        con.desconectarBD();

        return cursColectiu;
    }
}
