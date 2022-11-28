package tn.esen.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcat;
	private String type;
	@OneToMany(mappedBy = "cat")
	private Collection<Endroit> endroit;
	public Categorie(String type) {
		super();
		this.type = type;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdcat() {
		return idcat;
	}
	public void setIdcat(Long idcat) {
		this.idcat = idcat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
