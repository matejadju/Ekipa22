package si.um.feri.ris.models;

import java.util.*;

@Entity
public class Tip_mize {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int steiloOseb;
	private String naziv;
	private String opis;
	@OneToMany(mappedBy="tip_mize_miza", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Collection<Miza> tip_miza;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name="steiloOseb")
	public int getSteiloOseb() {
		return this.steiloOseb;
	}

	public void setSteiloOseb(int steiloOseb) {
		this.steiloOseb = steiloOseb;
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
	public Collection<Miza> getTip_miza() {
		return this.tip_miza;
	}

	public void setTip_miza(Collection<Miza> tip_miza) {
		this.tip_miza = tip_miza;
	}

}