package Projecte3.TipusCursos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import Projecte3.ConnexioBD;
import Projecte3.Curs;

public class CursIndividual extends Curs {

    private double preu;

    public CursIndividual(int id, LocalDate data, String nomMonitor, double preu) {
        super(id, data, nomMonitor);
        this.preu = preu;
    }

    public CursIndividual() {

    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public ArrayList<CursIndividual> consultaCursIndividualBD() throws SQLException {

        // Fem connexió a la BD
        ConnexioBD con = new ConnexioBD();
        con.conectarBD();

        // Com necessito l'array en sol aquest metode, el creare aqui
        ArrayList<CursIndividual> cursIndividual = new ArrayList<>();

        // Demanem el DNI
        String consultaIndividual = "SELECT C.ID, C.nomMonitor, C.data_curs, I.preu FROM cursos C, individuals I WHERE C.ID= I.IDI";
        PreparedStatement dades = con.connexioBD.prepareStatement(consultaIndividual);

        ResultSet rs = dades.executeQuery();

        while (rs.next()) {

            CursIndividual individual = new CursIndividual();
            individual.setId(rs.getInt("ID"));
            individual.setNomMonitor(rs.getString("nomMonitor"));
            individual.setData(Date.valueOf(rs.getString("data_curs")).toLocalDate());
            individual.setPreu(rs.getDouble("preu"));
            cursIndividual.add(individual);

        }

        con.desconectarBD();

        return cursIndividual;
    }

}
