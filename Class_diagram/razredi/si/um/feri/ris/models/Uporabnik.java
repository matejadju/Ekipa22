package si.um.feri.ris.models;

import java.util.*;

@Entity
public class Uporabnik {

	Collection<Vstopnice> vstopnice;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long iduporabnik;
	private String ime;
	private String priimek;
	private String email;
	private String geslo;
	private int telefon;
	@Column(nullable=true)
	private int emso;
	@Column(nullable=true)
	private int davcnaStevilka;
	@Enumerated(EnumType.STRING)
	private Vrsta vrsta;
	@OneToMany(mappedBy="uporabnik", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	Collection<Klub> klubi;
	@OneToMany(mappedBy="uporabnik_rezervacija", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Rezervacija> rezervacije;
	@OneToMany(mappedBy="uporabnik_dogodek", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Dogodek> dogodki;
	@OneToMany(mappedBy="uporabnik_recenzije")
	Collection<Recenzija> rezervacija;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="iduporabnik")
	public Long getIduporabnik() {
		return this.iduporabnik;
	}

	public void setIduporabnik(Long iduporabnik) {
		this.iduporabnik = iduporabnik;
	}

	@javax.persistence.Column(name="ime")
	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	@javax.persistence.Column(name="priimek")
	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	@javax.persistence.Column(name="email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@javax.persistence.Column(name="geslo")
	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	@javax.persistence.Column(name="telefon")
	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@javax.persistence.Column(name="emso")
	public int getEmso() {
		return this.emso;
	}

	public void setEmso(int emso) {
		this.emso = emso;
	}

	@javax.persistence.Column(name="davcnaStevilka")
	public int getDavcnaStevilka() {
		return this.davcnaStevilka;
	}

	public void setDavcnaStevilka(int davcnaStevilka) {
		this.davcnaStevilka = davcnaStevilka;
	}

	@javax.persistence.Transient
	public Vrsta getVrsta() {
		return this.vrsta;
	}

	public void setVrsta(Vrsta vrsta) {
		this.vrsta = vrsta;
	}

	@javax.persistence.Transient
	public Collection<Klub> getKlubi() {
		return this.klubi;
	}

	public void setKlubi(Collection<Klub> klubi) {
		this.klubi = klubi;
	}

	@javax.persistence.Transient
	public Collection<Rezervacija> getRezervacije() {
		return this.rezervacije;
	}

	public void setRezervacije(Collection<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	@javax.persistence.Transient
	public Collection<Dogodek> getDogodki() {
		return this.dogodki;
	}

	public void setDogodki(Collection<Dogodek> dogodki) {
		this.dogodki = dogodki;
	}

	@javax.persistence.Transient
	public Collection<Recenzija> getRezervacija() {
		return this.rezervacija;
	}

	public void setRezervacija(Collection<Recenzija> rezervacija) {
		this.rezervacija = rezervacija;
	}

}