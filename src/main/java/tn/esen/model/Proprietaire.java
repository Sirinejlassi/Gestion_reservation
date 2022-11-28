package tn.esen.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="proprietaire")
public class Proprietaire extends Personne {
	@JoinColumn(name="idend")
	@OneToOne(cascade = CascadeType.ALL)
	private Endroit endroit;

	public Proprietaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proprietaire(String nom, String prenom, int numTel, Endroit endroit) {
		super(nom, prenom, numTel);
		this.endroit = endroit;
		// TODO Auto-generated constructor stub
	}

	public Endroit getEndroit() {
		return endroit;
	}

	public void setEndroit(Endroit endroit) {
		this.endroit = endroit;
	}

	
	

}
