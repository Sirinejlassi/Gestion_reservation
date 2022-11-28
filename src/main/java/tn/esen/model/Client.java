package tn.esen.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client extends Personne {
	@OneToMany(mappedBy = "client")
	private Collection<reservation> res;


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, int numTel) {
		super(nom, prenom, numTel);
		// TODO Auto-generated constructor stub
	}



}
