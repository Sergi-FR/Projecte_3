package Clients;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.*;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

public abstract class Client {

    private String email;
    private String dni;
    private String nom;
    private String cognom;
    private LocalDate data_naix;
    private String sexe;
    private String telefon;
    private String ccc;

    ArrayList<Client> clients;

    private LocalDate data_caducitat;
    // private String num_familia;
    // private String nivell;

    // Contructors
    // #############################################

    public Client() {
    }

    public Client(String email, String dni, String nom, String cognom, LocalDate data_naix, String sexe, String telefon,
            String ccc, LocalDate data_caducitat) {
        this.email = email;
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.data_naix = data_naix;
        this.sexe = sexe;
        this.telefon = telefon;
        this.ccc = ccc;
        this.data_caducitat = data_caducitat;
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

    public LocalDate getData_caducitat() {
        return data_caducitat;
    }

    public void setData_caducitat(LocalDate data_caducitat) {
        this.data_caducitat = data_caducitat;
    }

    public ArrayList<Client> consultaBDClients() {

        ConexioBD conBD = new ConexioBD();

        ArrayList<Client> clients = new ArrayList<>();

        String consulta = "select * from clients";

        PreparableStatement sql = conBD.prepareStatement(consulta);

        ResultSet rs = sql.executeQuery();

        while (rs.next()) {

            Client c1 = new Client();

            cargarDadesDeSentenciaEnClients(rs);

            clients.add(c1);
        }

        return clients;

    }

    private void cargarDadesDeSentenciaEnClients(ResultSet rs) throws SQLException {

        // this.DNI = new Dni(rs.getString("DNI"));
        this.nom = rs.getString("nom");
        this.cognom = rs.getString("cognom");
        this.sexe = rs.getString("sexe");
        // this.setDataNaixament(rs.getDate("data_naix").toLocalDate());
        this.telefon = new Telefon(rs.getString("telefon"));
        this.correu = new Correu(rs.getString("email"));

        this.condicioFisica = rs.getString("Condicio_Fisica");
        this.comunicacio = rs.getBoolean("Comunicació_comercial");

    }
}
