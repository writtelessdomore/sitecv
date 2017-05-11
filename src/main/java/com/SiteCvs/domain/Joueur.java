package com.SiteCvs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idJoueur;

	private String nomJoueur;
	private int numJoueur;
	
	public Joueur(){	
	}
	
	public Joueur(int idJoueur, String nomJoueur, int numJoueur) {
		super();
		this.idJoueur = idJoueur;
		this.nomJoueur = nomJoueur;
		this.numJoueur = numJoueur;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public int getNumJoueur() {
		return numJoueur;
	}
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}	

}
