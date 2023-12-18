package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Uporabnik_has_recenzija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iduporabnik_has_recenzija;


    @ManyToOne
    @JoinColumn(name = "uporabnik_iduporabnik", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik;


    @ManyToOne
    @JoinColumn(name = "recenzija_idrecenzija", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Recenzija recenzija;

    public Long getIduporabnik_has_recenzija() {
        return iduporabnik_has_recenzija;
    }

    public void setIduporabnik_has_recenzija(Long iduporabnik_has_recenzija) {
        this.iduporabnik_has_recenzija = iduporabnik_has_recenzija;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }
}
