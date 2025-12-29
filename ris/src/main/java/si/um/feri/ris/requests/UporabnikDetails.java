package si.um.feri.ris.requests;

import si.um.feri.ris.models.Vrsta;

public class UporabnikDetails {

    private String ime;
    private String priimek;
    private String email;
    private String geslo;
    private Vrsta vrsta;

    public UporabnikDetails() {
    }

    public UporabnikDetails(String ime,
                            String priimek,
                            String email,
                            String geslo,
                            Vrsta vrsta) {
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.geslo = geslo;
        this.vrsta = vrsta;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public String getEmail() {
        return email;
    }

    public String getGeslo() {
        return geslo;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }
}
