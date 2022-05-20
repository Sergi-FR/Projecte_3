package Clients;

import java.time.LocalDate;

public class Federat extends Client {

    private String nivell;

    public Federat(String email, String dni, String nom, String cognom, LocalDate data_naix, String sexe,
            String telefon, String ccc, LocalDate data_caducitat, String nivell) {
        super(email, dni, nom, cognom, data_naix, sexe, telefon, ccc, data_caducitat);
        this.nivell = nivell;
    }

}
