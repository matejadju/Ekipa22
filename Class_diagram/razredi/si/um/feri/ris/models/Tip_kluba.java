package si.um.feri.ris.models;

import java.util.*;

@Entity
public class Tip_kluba {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idtip_kluba;
	private String naziv;
	private String opis;
	@OneToMany(mappedBy="tip_kluba", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Klub> klubi;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="idtip_kluba")
	public Long getIdtip_kluba() {
		return this.idtip_kluba;
	}

	public void setIdtip_kluba(Long idtip_kluba) {
		this.idtip_kluba = idtip_kluba;
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

	@javax.persistence.Transient
	public Collection<Klub> getKlubi() {
		return this.klubi;
	}

	public void setKlubi(Collection<Klub> klubi) {
		this.klubi = klubi;
	}

}