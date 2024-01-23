package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Recenzija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idrecenzija;

    private int ocena;
    private String tekst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klub_idklub")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Klub klub_recenzija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik_recenzije;



    public Long getIdrecenzija() {
        return idrecenzija;
    }

    public void setIdrecenzija(Long idrecenzija) {
        this.idrecenzija = idrecenzija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Klub getKlub_recenzija() {
        return klub_recenzija;
    }

    public void setKlub_recenzija(Klub klub_recenzija) {
        this.klub_recenzija = klub_recenzija;
    }
}
