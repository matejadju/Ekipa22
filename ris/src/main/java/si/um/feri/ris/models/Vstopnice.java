package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vstopnice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idvstopnice;

    private Date datum;
    private int cena;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dogodek_iddogodek")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("vstopnice")
    Dogodek dogodek_vstopnica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("vstopnice")
    Uporabnik uporabnik_vstopnice;
    public Long getIdvstopnice() {
        return idvstopnice;
    }

    public void setIdvstopnice(Long idvstopnice) {
        this.idvstopnice = idvstopnice;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Dogodek getDogodek_vstopnica() {
        return dogodek_vstopnica;
    }

    public void setDogodek_vstopnica(Dogodek dogodek_vstopnica) {
        this.dogodek_vstopnica = dogodek_vstopnica;
    }

    public Uporabnik getUporabnik_vstopnice() {
        return uporabnik_vstopnice;
    }

    public void setUporabnik_vstopnice(Uporabnik uporabnik_vstopnice) {
        this.uporabnik_vstopnice = uporabnik_vstopnice;
    }
}
