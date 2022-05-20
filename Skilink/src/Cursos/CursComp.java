package Cursos;

import java.time.LocalDate;
import java.time.LocalTime;

public class CursComp extends Curs {

    private LocalTime hora_inici;
    private LocalTime hora_final;
    private int aforament;
    private LocalDate data_final;

    // Contructors
    // #############################################

    public CursComp(int preu, LocalDate data_curs, int id, String nom_monitor, LocalTime hora_inici,
            LocalTime hora_final, int aforament, LocalDate data_final) {
        super(preu, data_curs, id, nom_monitor);
        this.hora_inici = hora_inici;
        this.hora_final = hora_final;
        this.aforament = aforament;
        this.data_final = data_final;
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

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }

}
