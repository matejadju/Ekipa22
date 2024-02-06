package si.um.feri.ris.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Rezervacija {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private java.util.Date datum;
	private int steviloOseb;
	private String poruka;
	Uporabnik uporabnik_rezervacija;
	@OneToMany(mappedBy="rezervacija_miza", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Miza> mize;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name="datum")
	public java.util.Date getDatum() {
		return this.datum;
	}

	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}

	@javax.persistence.Column(name="steviloOseb")
	public int getSteviloOseb() {
		return this.steviloOseb;
	}

	public void setSteviloOseb(int steviloOseb) {
		this.steviloOseb = steviloOseb;
	}

	@javax.persistence.Column(name="poruka")
	public String getPoruka() {
		return this.poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Rezervacijaid", referencedColumnName="id")
	public Uporabnik getUporabnik_rezervacija() {
		return this.uporabnik_rezervacija;
	}

	public void setUporabnik_rezervacija(Uporabnik uporabnik_rezervacija) {
		this.uporabnik_rezervacija = uporabnik_rezervacija;
	}

	@javax.persistence.Transient
	public Collection<Miza> getMize() {
		return this.mize;
	}

	public void setMize(Collection<Miza> mize) {
		this.mize = mize;
	}

}