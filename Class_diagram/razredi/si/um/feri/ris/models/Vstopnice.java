package si.um.feri.ris.models;

import java.util.*;
import javax.persistence.*;

@Entity
public class Vstopnice {

	Collection<Uporabnik> uporabnik;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idvstopnice;
	private java.util.Date datum;
	private int cena;
	Dogodek dogodek_vstopnica;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="idvstopnice")
	public Long getIdvstopnice() {
		return this.idvstopnice;
	}

	public void setIdvstopnice(Long idvstopnice) {
		this.idvstopnice = idvstopnice;
	}

	@javax.persistence.Column(name="datum")
	public java.util.Date getDatum() {
		return this.datum;
	}

	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}

	@javax.persistence.Column(name="cena")
	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Dogodekiddogodek", referencedColumnName="iddogodek")
	public Dogodek getDogodek_vstopnica() {
		return this.dogodek_vstopnica;
	}

	public void setDogodek_vstopnica(Dogodek dogodek_vstopnica) {
		this.dogodek_vstopnica = dogodek_vstopnica;
	}

}