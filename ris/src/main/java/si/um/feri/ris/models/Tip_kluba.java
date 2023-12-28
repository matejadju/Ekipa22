package si.um.feri.ris.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Tip_kluba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idtip_kluba;

    private String naziv;
    private String opis;

    @OneToMany(mappedBy = "tip_kluba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Klub> klubi;

    public Long getIdtip_kluba() {
        return idtip_kluba;
    }

    public void setIdtip_kluba(Long idtip_kluba) {
        this.idtip_kluba = idtip_kluba;
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

    public Collection<Klub> getKlubi() {
        return klubi;
    }

    public void setKlubi(Collection<Klub> klubi) {
        this.klubi = klubi;
    }
}
