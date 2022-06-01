package Projecte3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.exceptions.DeadlockTimeoutRollbackMarker;

public class Client {

    private String dni;
    private String nom;
    private String cognom;
    private String sexe;
    private LocalDate data_naix;
    private int telefon;
    private String email;
    private String usuari;
    private String contrasenya;
    private String compte_bancari;
    private int num_familia;
    private LocalDate dataFa_caducitat;
    private LocalDate dataFe_caducitat;
    private String nivell;

    public Client(String dni, String nom, String cognom, String sexe, LocalDate data_naix, int telefon, String email,
            String usuari, String contrasenya, String compte_bancari, int num_familia, LocalDate dataFa_caducitat,
            LocalDate dataFe_caducitat, String nivell) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.sexe = sexe;
        this.data_naix = data_naix;
        this.telefon = telefon;
        this.email = email;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
        this.compte_bancari = compte_bancari;
        this.num_familia = num_familia;
        this.dataFa_caducitat = dataFa_caducitat;
        this.dataFe_caducitat = dataFe_caducitat;
        this.nivell = nivell;
    }

    public Client() {

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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getData_naix() {
        return data_naix;
    }

    public void setData_naix(LocalDate data_naix) {
        this.data_naix = data_naix;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCompte_bancari() {
        return compte_bancari;
    }

    public void setCompte_bancari(String compte_bancari) {
        this.compte_bancari = compte_bancari;
    }

    public int getNum_familia() {
        return num_familia;
    }

    public void setNum_familia(int num_familia) {
        this.num_familia = num_familia;
    }

    public LocalDate getDataFa_caducitat() {
        return dataFa_caducitat;
    }

    public void setDataFa_caducitat(LocalDate dataFa_caducitat) {
        this.dataFa_caducitat = dataFa_caducitat;
    }

    public LocalDate getDataFe_caducitat() {
        return dataFe_caducitat;
    }

    public void setDataFe_caducitat(LocalDate dataFe_caducitat) {
        this.dataFe_caducitat = dataFe_caducitat;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }

    public ArrayList<Client> consultaClientBD() throws SQLException {

        // Fem connexió a la BD
        Connection con = ConnexioBD.getConnection();

        // Com necessito l'array en sol aquest metode, el creare aqui
        ArrayList<Client> clients = new ArrayList<>();

        // Demanem el DNI
        String consultaClients = "SELECT C.DNI, C.nom, C.cognom, C.sexe, B.num_familia, B.dataFa_caducitat , F.dataFe_caducitat, F.nivell FROM clients C LEFT JOIN familia_nombrosa B ON C.DNI = B.dni_client LEFT JOIN federat F ON C.DNI = F.dni_federat";
        PreparedStatement dades = con.prepareStatement(consultaClients);

        ResultSet rs = dades.executeQuery();

        while (rs.next()) {

            Client client = new Client();
            client.setDni(rs.getString("DNI"));
            client.setNom(rs.getString("nom"));
            client.setCognom(rs.getString("cognom"));
            client.setSexe(rs.getString("sexe"));
            client.setNum_familia(rs.getInt("num_familia"));
            // fem un try catch ja que tambe volem visualitzar si la data es null
            try {
                client.setDataFa_caducitat(LocalDate.parse(rs.getString("dataFa_caducitat")));
            } catch (Exception e) {
            }
            try {
                client.setDataFe_caducitat(LocalDate.parse(rs.getString("dataFe_caducitat")));
            } catch (Exception e) {
            }
            client.setNivell(rs.getString("nivell"));
            clients.add(client);
        }

        return clients;
    }

}