package si.um.feri.ris.models;

import javax.persistence.*;

@Entity
public class Miza {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idmiza;
	private boolean status;
	Tip_mize tip_mize_miza;
	Rezervacija rezervacija_miza;
	Dogodek dogodek_miza;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="idmiza")
	public Long getIdmiza() {
		return this.idmiza;
	}

	public void setIdmiza(Long idmiza) {
		this.idmiza = idmiza;
	}

	@javax.persistence.Column(name="status")
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Mizaidmiza", referencedColumnName="idmiza")
	public Tip_mize getTip_mize_miza() {
		return this.tip_mize_miza;
	}

	public void setTip_mize_miza(Tip_mize tip_mize_miza) {
		this.tip_mize_miza = tip_mize_miza;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Mizaidmiza2", referencedColumnName="idmiza")
	public Rezervacija getRezervacija_miza() {
		return this.rezervacija_miza;
	}

	public void setRezervacija_miza(Rezervacija rezervacija_miza) {
		this.rezervacija_miza = rezervacija_miza;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Dogodekiddogodek", referencedColumnName="iddogodek")
	public Dogodek getDogodek_miza() {
		return this.dogodek_miza;
	}

	public void setDogodek_miza(Dogodek dogodek_miza) {
		this.dogodek_miza = dogodek_miza;
	}

}