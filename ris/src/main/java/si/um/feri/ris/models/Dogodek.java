package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Dogodek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddogodek;

    private LocalDateTime datum;
    private String naziv;
    private String opis;
    private Float cenaVstopnice;
    private int steviloVstopnica;
    private int steviloMiz;

    private boolean odobren;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klub_idklub")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Klub klub_dogodek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik_dogodek;

    @OneToMany(mappedBy = "dogodek_miza", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Miza> mize;

    @OneToMany(mappedBy = "dogodek_vstopnica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Vstopnice> vstopnice;

    public Long getIddogodek() {
        return iddogodek;
    }

    public void setIddogodek(Long iddogodek) {
        this.iddogodek = iddogodek;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Float getCenaVstopnice() {
        return cenaVstopnice;
    }

    public void setCenaVstopnice(Float cenaVstopnice) {
        this.cenaVstopnice = cenaVstopnice;
    }

    public int getSteviloVstopnica() {
        return steviloVstopnica;
    }

    public void setSteviloVstopnica(int steviloVstopnica) {
        this.steviloVstopnica = steviloVstopnica;
    }

    public int getSteviloMiz() {
        return steviloMiz;
    }

    public void setSteviloMiz(int steviloMiz) {
        this.steviloMiz = steviloMiz;
    }

    public Klub getKlub_dogodek() {
        return klub_dogodek;
    }

    public void setKlub_dogodek(Klub klub_dogodek) {
        this.klub_dogodek = klub_dogodek;
    }

    public Uporabnik getUporabnik_dogodek() {
        return uporabnik_dogodek;
    }

    public void setUporabnik_dogodek(Uporabnik uporabnik_dogodek) {
        this.uporabnik_dogodek = uporabnik_dogodek;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }
}