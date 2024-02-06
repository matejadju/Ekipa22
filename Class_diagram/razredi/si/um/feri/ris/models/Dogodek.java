package si.um.feri.ris.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Dogodek {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long iddogodek;
	private java.time.LocalDateTime datum;
	private String naziv;
	private String opis;
	private Float cenaVstopnice;
	private int steviloVstopnica;
	private int steviloMiz;
	Klub klub_dogodek;
	Uporabnik uporabnik_dogodek;
	@OneToMany(mappedBy="dogodek_miza", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Miza> mize;
	@OneToMany(mappedBy="dogodek_vstopnica", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Vstopnice> vstopnice;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="iddogodek")
	public Long getIddogodek() {
		return this.iddogodek;
	}

	public void setIddogodek(Long iddogodek) {
		this.iddogodek = iddogodek;
	}

	@javax.persistence.Column(name="datum")
	public java.time.LocalDateTime getDatum() {
		return this.datum;
	}

	public void setDatum(java.time.LocalDateTime datum) {
		this.datum = datum;
	}

	@javax.persistence.Column(name="naziv")
	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@javax.persistence.Column(name="opis")
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@javax.persistence.Column(name="cenaVstopnice")
	public Float getCenaVstopnice() {
		return this.cenaVstopnice;
	}

	public void setCenaVstopnice(Float cenaVstopnice) {
		this.cenaVstopnice = cenaVstopnice;
	}

	@javax.persistence.Column(name="steviloVstopnica")
	public int getSteviloVstopnica() {
		return this.steviloVstopnica;
	}

	public void setSteviloVstopnica(int steviloVstopnica) {
		this.steviloVstopnica = steviloVstopnica;
	}

	@javax.persistence.Column(name="steviloMiz")
	public int getSteviloMiz() {
		return this.steviloMiz;
	}

	public void setSteviloMiz(int steviloMiz) {
		this.steviloMiz = steviloMiz;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Dogodekiddogodek", referencedColumnName="iddogodek")
	public Klub getKlub_dogodek() {
		return this.klub_dogodek;
	}

	public void setKlub_dogodek(Klub klub_dogodek) {
		this.klub_dogodek = klub_dogodek;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Dogodekiddogodek2", referencedColumnName="iddogodek")
	public Uporabnik getUporabnik_dogodek() {
		return this.uporabnik_dogodek;
	}

	public void setUporabnik_dogodek(Uporabnik uporabnik_dogodek) {
		this.uporabnik_dogodek = uporabnik_dogodek;
	}

	@javax.persistence.Transient
	public Collection<Miza> getMize() {
		return this.mize;
	}

	public void setMize(Collection<Miza> mize) {
		this.mize = mize;
	}

	@javax.persistence.Transient
	public Collection<Vstopnice> getVstopnice() {
		return this.vstopnice;
	}

	public void setVstopnice(Collection<Vstopnice> vstopnice) {
		this.vstopnice = vstopnice;
	}

}