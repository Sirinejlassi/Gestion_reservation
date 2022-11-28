package tn.esen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservationTab")
public class reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idres;
	@Column(name="date_reservation")
	private String dateRes;
	@Column(name="nb_personne")
	private int nbPersonne;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Endroit endroit;
	

	public reservation(String dateRes, int nbPersonne, Client client , Endroit endroit) {
		super();
		this.dateRes = dateRes;
		this.nbPersonne = nbPersonne;
		this.client = client;
		this.endroit= endroit;
		
	}
	public reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdRes() {
		return idres;
	}
	public void setIdRes(Long idRes) {
		this.idres = idRes;
	}
	public String getDateRes() {
		return dateRes;
	}
	public void setDateRes(String dateRes) {
		this.dateRes = dateRes;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public Long getIdres() {
		return idres;
	}
	public void setIdres(Long idres) {
		this.idres = idres;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Endroit getEndroit() {
		return endroit;
	}
	public void setEndroit(Endroit endroit) {
		this.endroit = endroit;
	}

	
	
	

}
