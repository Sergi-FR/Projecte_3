package Clients;

import java.time.LocalDate;

public class Nombros extends Client {

    private String num_familia;

    public Nombros(String email, String dni, String nom, String cognom, LocalDate data_naix, String sexe,
            String telefon, String ccc, LocalDate data_caducitat, String num_familia) {
        super(email, dni, nom, cognom, data_naix, sexe, telefon, ccc, data_caducitat);
        this.num_familia = num_familia;
    }

}
