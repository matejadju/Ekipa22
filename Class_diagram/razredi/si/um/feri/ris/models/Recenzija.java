package si.um.feri.ris.models;

import javax.persistence.*;

@Entity
public class Recenzija {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idrecenzija;
	private int ocena;
	private String tekst;
	Klub klub_recenzija;
	Uporabnik uporabnik_recenzije;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="idrecenzija")
	public Long getIdrecenzija() {
		return this.idrecenzija;
	}

	public void setIdrecenzija(Long idrecenzija) {
		this.idrecenzija = idrecenzija;
	}

	@javax.persistence.Column(name="ocena")
	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	@javax.persistence.Column(name="tekst")
	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Klubidklub", referencedColumnName="idklub")
	public Klub getKlub_recenzija() {
		return this.klub_recenzija;
	}

	public void setKlub_recenzija(Klub klub_recenzija) {
		this.klub_recenzija = klub_recenzija;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Recenzijaidrecenzija", referencedColumnName="idrecenzija")
	public Uporabnik getUporabnik_recenzije() {
		return this.uporabnik_recenzije;
	}

	public void setUporabnik_recenzije(Uporabnik uporabnik_recenzije) {
		this.uporabnik_recenzije = uporabnik_recenzije;
	}

}