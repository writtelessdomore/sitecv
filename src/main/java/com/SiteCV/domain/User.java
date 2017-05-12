package com.SiteCV.domain;

import java.sql.Blob;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user", nullable = false, unique = true)
	private int idUser;

	@ManyToMany
	@JoinTable(name = "curriculum_vitae", joinColumns = @JoinColumn(name = "id_user", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true))
	@Null
	private Collection<CurriculumVitae> idCv;

	@Column(name = "nom", nullable = false)
	private String nom;

	@Column(name = "prenom", nullable = false)
	private String prenom;

	@Column(name = "type_user", nullable = false)
	private String typeUser;

	@Column(name = "photo", nullable = false)
	private Blob photo;

	public User() {

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

	public Collection<CurriculumVitae> getIdCv() {
		return idCv;
	}

	public void setIdCv(Collection<CurriculumVitae> idCv) {
		this.idCv = idCv;
	}

}
