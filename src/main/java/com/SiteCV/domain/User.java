package com.SiteCV.domain;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CurriculumVitae", referencedColumnName="idCurriculumVitae")
	private CurriculumVitae cv;

	private String nom;

	private String prenom;

	private String typeUser;

	private Blob photo;

	public User() {

	}

	public User(int idUser, String nom, String prenom, String typeUser, Blob photo) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.typeUser = typeUser;
		this.photo = photo;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public CurriculumVitae getCv() {
		return cv;
	}

	public void setCv(CurriculumVitae cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "User [getIdUser()=" + getIdUser() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getTypeUser()=" + getTypeUser() + ", getPhoto()=" + getPhoto() + "]";
	}

}
