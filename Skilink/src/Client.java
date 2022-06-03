
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.*;

import Conn.ConexioBD;

public class Client {

    private String email;
    private String dni;
    private String nom;
    private String cognom;
    private LocalDate data_naix;
    private String sexe;
    private String telefon;
    private String ccc;
    private String nivell;
    private String num_familia;

    // Contructors
    // #############################################

    public Client(String email, String dni, String nom, String cognom, LocalDate data_naix, String sexe, String telefon,
            String ccc, String nivell, String num_familia, ArrayList<Client> clients) {
        this.email = email;
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.data_naix = data_naix;
        this.sexe = sexe;
        this.telefon = telefon;
        this.ccc = ccc;
        this.nivell = nivell;
        this.num_familia = num_familia;

    }

    public Client() {

    }

    // Getters Setters
    // #############################################

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public LocalDate getData_naix() {
        return data_naix;
    }

    public void setData_naix(LocalDate data_naix) {
        this.data_naix = data_naix;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }

    public String getNum_familia() {
        return num_familia;
    }

    public void setNum_familia(String num_familia) {
        this.num_familia = num_familia;
    }

    @Override
    public String toString() {
        return "Client [ccc=" + ccc + ", cognom=" + cognom + ", data_naix=" + data_naix
                + ", dni=" + dni + ", email=" + email + ", nivell=" + nivell + ", nom=" + nom + ", num_familia="
                + num_familia + ", sexe=" + sexe + ", telefon=" + telefon + "]";
    }

    public ArrayList<Client> consultaBDClients() throws SQLException {

        Connection conn = ConexioBD.getConnection();

        ArrayList<Client> clients = new ArrayList<>();

        String consulta = "SELECT cli.DNI, cli.nom, cli.cognom, cli.sexe, cli.data_naix ,cli.telefon ,cli.email, cli.compte_bancari,fed.nivell, fam.num_familia FROM clients cli left join familia_nombrosa fam on cli.DNI=dni_client left join federat fed on cli.DNI=dni_federat";

        PreparedStatement sql = conn.prepareStatement(consulta);

        ResultSet rs = sql.executeQuery();

        while (rs.next()) {

            Client c1 = new Client();

            c1.setDni(rs.getString("DNI"));
            c1.setNom(rs.getString("nom"));
            c1.setCognom(rs.getString("cognom"));
            c1.setSexe(rs.getString("sexe"));
            c1.setData_naix(LocalDate.parse(rs.getString("data_naix")));
            c1.setTelefon(rs.getString("telefon"));
            c1.setEmail(rs.getString("email"));
            c1.setCcc(rs.getString("compte_bancari"));

            try {
                c1.setNivell(rs.getString("nivell"));
            } catch (Exception e) {

            }

            try {
                c1.setNum_familia(rs.getString("num_familia"));
            } catch (Exception e) {

            }

            clients.add(c1);
        }

        return clients;
    }

}