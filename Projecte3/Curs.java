package Projecte3;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Curs {

    private int id;
    private LocalDate data;
    private String nomMonitor;

    public Curs(int id, LocalDate data, String nomMonitor) {
        this.id = id;
        this.data = data;
        this.nomMonitor = nomMonitor;
    }

    public Curs() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomMonitor() {
        return nomMonitor;
    }

    public void setNomMonitor(String nomMonitor) {
        this.nomMonitor = nomMonitor;
    }
}
