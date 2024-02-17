package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Tip_mize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int steiloOseb;
    private String naziv;
    private String opis;

    @OneToMany(mappedBy = "tip_mize_miza", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
            @JsonIgnore
    Collection<Miza> tip_miza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSteiloOseb() {
        return steiloOseb;
    }

    public void setSteiloOseb(int steiloOseb) {
        this.steiloOseb = steiloOseb;
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
}
