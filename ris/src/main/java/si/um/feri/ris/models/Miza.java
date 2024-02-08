package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.jsf.FacesContextUtils;

@Entity
public class Miza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idmiza;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_mize_idtip_mize")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Tip_mize tip_mize_miza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rezervacija_idrezervacija")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Rezervacija rezervacija_miza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dogodek_iddogodek")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Dogodek dogodek_miza;

    public Long getIdmiza() {
        return idmiza;
    }

    public void setIdmiza(Long idmiza) {
        this.idmiza = idmiza;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Tip_mize getTip_mize_miza() {
        return tip_mize_miza;
    }

    public void setTip_mize_miza(Tip_mize tip_mize_miza) {
        this.tip_mize_miza = tip_mize_miza;
    }

    public Rezervacija getRezervacija_miza() {
        return rezervacija_miza;
    }

    public void setRezervacija_miza(Rezervacija rezervacija_miza) {
        this.rezervacija_miza = rezervacija_miza;
    }

    public Dogodek getDogodek_miza() {
        return dogodek_miza;
    }

    public void setDogodek_miza(Dogodek dogodek_miza) {
        this.dogodek_miza = dogodek_miza;
    }
}
