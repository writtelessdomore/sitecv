package com.SiteCV.domain;

import java.util.Collection;
import java.util.Date;

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
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_formation", nullable = false, unique = true)
	private int idFormation;

	@ManyToMany
	@JoinTable(name = "curriculum_vitae", joinColumns = @JoinColumn(name = "id_formation", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = false))
	@Null
	private Collection<CurriculumVitae> idCv;

	@Column(name = "date_debut", nullable = false)
	private Date dateDebut;

	@Column(name = "date_fin", nullable = false)
	private Date dateFin;

	@Column(name = "titre", nullable = false)
	private String titre;

	@Column(name = "description", nullable = false)
	private String description;

	public Formation() {

	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Collection<CurriculumVitae> getIdCv() {
		return idCv;
	}

	public void setIdCv(Collection<CurriculumVitae> idCv) {
		this.idCv = idCv;
	}
}
