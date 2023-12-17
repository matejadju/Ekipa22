package si.um.feri.ris.controllers;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Uporabnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iduporabnik;

    private String ime;
    private String priimek;
    private String email;
    private String geslo;

    @Enumerated(EnumType.STRING)
    private Vrsta vrsta;
    private int telefon;

    private int emso;

    private int davcnaStevilka;

    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Klub> klubi;

    @OneToMany(mappedBy = "uporabnik_rezervacija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Rezervacija> rezervacije;

    public Collection<Klub> getKlubi() {
        return klubi;
    }

    public void setKlubi(Collection<Klub> klubi) {
        this.klubi = klubi;
    }

    public Long getIduporabnik() {
        return iduporabnik;
    }

    public void setIduporabnik(Long iduporabnik) {
        this.iduporabnik = iduporabnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getEmso() {
        return emso;
    }

    public void setEmso(int emso) {
        this.emso = emso;
    }

    public int getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public void setDavcnaStevilka(int davcnaStevilka) {
        this.davcnaStevilka = davcnaStevilka;
    }

    public Collection<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Collection<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
}
