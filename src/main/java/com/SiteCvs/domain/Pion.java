package com.SiteCvs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPion;

	private int numero_ligne_dernier_coup;
	private int numero_colonne_dernier_coup;
	private int numéro_joueur;

	public Pion(){
		
	}
	
	public Pion(int idPion, int numero_ligne_dernier_coup, int numero_colonne_dernier_coup, int numéro_joueur) {
		super();
		this.idPion = idPion;
		this.numero_ligne_dernier_coup = numero_ligne_dernier_coup;
		this.numero_colonne_dernier_coup = numero_colonne_dernier_coup;
		this.numéro_joueur = numéro_joueur;
	}

	public int getIdPion() {
		return idPion;
	}

	public void setIdPion(int idPion) {
		this.idPion = idPion;
	}

	public int getNumero_ligne_dernier_coup() {
		return numero_ligne_dernier_coup;
	}

	public void setNumero_ligne_dernier_coup(int numero_ligne_dernier_coup) {
		this.numero_ligne_dernier_coup = numero_ligne_dernier_coup;
	}

	public int getNumero_colonne_dernier_coup() {
		return numero_colonne_dernier_coup;
	}

	public void setNumero_colonne_dernier_coup(int numero_colonne_dernier_coup) {
		this.numero_colonne_dernier_coup = numero_colonne_dernier_coup;
	}

	public int getNuméro_joueur() {
		return numéro_joueur;
	}

	public void setNuméro_joueur(int numéro_joueur) {
		this.numéro_joueur = numéro_joueur;
	}

	@Override
	public String toString() {
		return "Pion [getIdPion()=" + getIdPion() + ", getNumero_ligne_dernier_coup()=" + getNumero_ligne_dernier_coup()
				+ ", getNumero_colonne_dernier_coup()=" + getNumero_colonne_dernier_coup() + ", getNuméro_joueur()="
				+ getNuméro_joueur() + "]";
	}

}
