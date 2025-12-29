package si.um.feri.ris.requests;

import java.time.LocalDateTime;

public class DogodekDetails {

    private String naziv;
    private LocalDateTime datum;
    private String opis;
    private int cenaVstopnice;
    private int steviloVstopnica;
    private boolean odobren;

    public DogodekDetails() {
    }

    public DogodekDetails(String naziv, LocalDateTime datum, String opis,
                          int cenaVstopnice, int steviloVstopnica, boolean odobren) {
        this.naziv = naziv;
        this.datum = datum;
        this.opis = opis;
        this.cenaVstopnice = cenaVstopnice;
        this.steviloVstopnica = steviloVstopnica;
        this.odobren = odobren;
    }

    public String getNaziv() {
        return naziv;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public String getOpis() {
        return opis;
    }

    public int getCenaVstopnice() {
        return cenaVstopnice;
    }

    public int getSteviloVstopnica() {
        return steviloVstopnica;
    }

    public boolean isOdobren() {
        return odobren;
    }
}
