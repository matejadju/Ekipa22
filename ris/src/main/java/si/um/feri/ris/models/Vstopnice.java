package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Dogodek dogodek_vstopnica;

    @ManyToMany
    @JoinTable(
            name = "vstopnice_uporabnik",
            joinColumns = @JoinColumn(name = "idvstopnice"),
            inverseJoinColumns = @JoinColumn(name = "iduporabnik")
    )
    private Set<Uporabnik> uporabnikSet = new HashSet<>();

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
}
