package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Klub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKlub;

    private String naziv;
    private String adresa;
    private int telefon;
    private int pib;
    private boolean status;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tip_kluba_idtip_kluba")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("klubi")
   @JsonIgnore
    TipKluba tipKluba;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik;

    @OneToMany(mappedBy = "idDogodek", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Dogodek> dogodki;

    @OneToMany(mappedBy = "idRecenzija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Recenzija> recenzije;

    public Long getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Long idklub) {
        this.idKlub = idklub;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TipKluba getTipKluba() {
        return tipKluba;
    }

    public void setTipKluba(TipKluba tipKluba) {
        this.tipKluba = tipKluba;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    @Override
    public String toString() {
        return "Klub{" +
                "idKlub=" + idKlub +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon=" + telefon +
                ", pib=" + pib +
                ", status=" + status +
                '}';
    }
}
