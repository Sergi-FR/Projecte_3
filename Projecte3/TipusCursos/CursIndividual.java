package Projecte3.TipusCursos;

import java.sql.Connection;
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

public class CursIndividual extends Curs {

    private double preu;
    private LocalTime hora_inici;
    private int duracio;

    public CursIndividual(int id, LocalDate data, String nomMonitor, double preu, LocalTime hora_inici, int duracio) {
        super(id, data, nomMonitor);
        this.preu = preu;
        this.hora_inici = hora_inici;
        this.duracio = duracio;
    }

    public CursIndividual() {

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

    public int getDuracio() {
        return duracio;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public ArrayList<CursIndividual> consultaCursIndividualBD() throws SQLException {

        // Fem connexió a la BD
        Connection con = ConnexioBD.getConnection();

        // Com necessito l'array en sol aquest metode, el creare aqui
        ArrayList<CursIndividual> cursIndividual = new ArrayList<>();

        // Demanem el DNI
        String consultaIndividual = "SELECT C.ID, C.nomMonitor, C.data_curs, I.preu FROM cursos C, individuals I WHERE C.ID= I.IDI";
        PreparedStatement dades = con.prepareStatement(consultaIndividual);

        ResultSet rs = dades.executeQuery();

        while (rs.next()) {

            CursIndividual individual = new CursIndividual();
            individual.setId(rs.getInt("ID"));
            individual.setNomMonitor(rs.getString("nomMonitor"));
            individual.setData(Date.valueOf(rs.getString("data_curs")).toLocalDate());
            individual.setPreu(rs.getDouble("preu"));
            cursIndividual.add(individual);

        }

        return cursIndividual;
    }

}
