package tn.esen.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="endroit")
public class Endroit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idend;
	@Column(name="nom_endroit")
	private String nomEnd;
	private String adresse;
	@Column(name="telephone_end")
	private int telEnd;
	@OneToOne(mappedBy = "endroit")
	private Proprietaire proprietaire;
	@OneToMany(mappedBy = "endroit")
	private Collection<reservation> res;
	@ManyToOne
	private Categorie cat;
	
	
	public Endroit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endroit(String nomEnd, String adresse, int telEnd, Categorie cat) {
		super();
		this.nomEnd = nomEnd;
		this.adresse = adresse;
		this.telEnd = telEnd;
		this.cat = cat;
	}
	public Long getIdend() {
		return idend;
	}
	public void setIdend(Long idend) {
		this.idend = idend;
	}
	public String getNomEnd() {
		return nomEnd;
	}
	public void setNomEnd(String nomEnd) {
		this.nomEnd = nomEnd;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelEnd() {
		return telEnd;
	}
	public void setTelEnd(int telEnd) {
		this.telEnd = telEnd;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	

}
