package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;
import java.util.Date;

@Entity
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRezervacija;
    private Date datum;
    private int steviloOseb;
    private String poruka;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik_rezervacija;

    @ManyToOne(mappedBy = "rezervacija_miza", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Miza mize;

    public Long getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(Long idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getSteviloOseb() {
        return steviloOseb;
    }

    public void setSteviloOseb(int steviloOseb) {
        this.steviloOseb = steviloOseb;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Uporabnik getUporabnik_rezervacija() {
        return uporabnik_rezervacija;
    }

    public void setUporabnik_rezervacija(Uporabnik uporabnik_rezervacija) {
        this.uporabnik_rezervacija = uporabnik_rezervacija;
    }


    public Collection<Miza> getMize() {
        return mize;
    }

    public void setMize(Collection<Miza> mize) {
        this.mize = mize;
    }
}
