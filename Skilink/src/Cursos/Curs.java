package Cursos;

import java.time.LocalDate;

public abstract class Curs {

    private int preu;
    private LocalDate data_curs;
    private int id;
    private String nom_monitor;

    // Contructors
    // #############################################

    public Curs() {
    }

    public Curs(int preu, LocalDate data_curs, int id, String nom_monitor) {
        this.preu = preu;
        this.data_curs = data_curs;
        this.id = id;
        this.nom_monitor = nom_monitor;
    }

    // Getters Setters
    // #############################################

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public LocalDate getData_curs() {
        return data_curs;
    }

    public void setData_curs(LocalDate data_curs) {
        this.data_curs = data_curs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_monitor() {
        return nom_monitor;
    }

    public void setNom_monitor(String nom_monitor) {
        this.nom_monitor = nom_monitor;
    }

}
