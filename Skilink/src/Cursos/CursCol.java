package Cursos;

import java.time.LocalDate;
import java.time.LocalTime;

public class CursCol extends Curs {

    private LocalTime hora_inici;
    private LocalTime hora_final;
    private String nivell_curs;

    // Contructors
    // #############################################

    public CursCol(int preu, LocalDate data_curs, int id, String nom_monitor, LocalTime hora_inici,
            LocalTime hora_final, String nivell_curs) {
        super(preu, data_curs, id, nom_monitor);
        this.hora_inici = hora_inici;
        this.hora_final = hora_final;
        this.nivell_curs = nivell_curs;
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

    public String getNivell_curs() {
        return nivell_curs;
    }

    public void setNivell_curs(String nivell_curs) {
        this.nivell_curs = nivell_curs;
    }

}
