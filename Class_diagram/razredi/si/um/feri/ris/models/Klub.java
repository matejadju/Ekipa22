package si.um.feri.ris.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Klub {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idklub;
	private String naziv;
	private String adresa;
	private int telefon;
	private int PIB;
	private boolean status;
	Tip_kluba tip_kluba;
	Uporabnik uporabnik;
	@OneToMany(mappedBy="klub_dogodek", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	Collection<Dogodek> dogodki;
	@OneToMany(mappedBy="klub_recenzija", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Recenzija> recenzije;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="idklub")
	public Long getIdklub() {
		return this.idklub;
	}

	public void setIdklub(Long idklub) {
		this.idklub = idklub;
	}

	@javax.persistence.Column(name="naziv")
	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@javax.persistence.Column(name="adresa")
	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@javax.persistence.Column(name="telefon")
	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@javax.persistence.Column(name="PIB")
	public int getPIB() {
		return this.PIB;
	}

	public void setPIB(int PIB) {
		this.PIB = PIB;
	}

	@javax.persistence.Column(name="status")
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Klubidklub", referencedColumnName="idklub")
	public Tip_kluba getTip_kluba() {
		return this.tip_kluba;
	}

	public void setTip_kluba(Tip_kluba tip_kluba) {
		this.tip_kluba = tip_kluba;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Klubidklub2", referencedColumnName="idklub")
	public Uporabnik getUporabnik() {
		return this.uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	@javax.persistence.Transient
	public Collection<Dogodek> getDogodki() {
		return this.dogodki;
	}

	public void setDogodki(Collection<Dogodek> dogodki) {
		this.dogodki = dogodki;
	}

	@javax.persistence.Transient
	public Collection<Recenzija> getRecenzije() {
		return this.recenzije;
	}

	public void setRecenzije(Collection<Recenzija> recenzije) {
		this.recenzije = recenzije;
	}

}