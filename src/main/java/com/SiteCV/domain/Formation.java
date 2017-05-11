package com.SiteCV.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFormation;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="CurriculumVitae", referencedColumnName="idCurriculumVitae")
	private CurriculumVitae cv;

	private Date dateDebut;

	private Date dateFin;

	private String titre;

	private String description;

	public Formation() {

	}

	public Formation(int idFormation, CurriculumVitae cv, Date dateDebut, Date dateFin, String titre,
			String description) {
		super();
		this.idFormation = idFormation;
		this.cv = cv;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.titre = titre;
		this.description = description;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public CurriculumVitae getCv() {
		return cv;
	}

	public void setCv(CurriculumVitae cv) {
		this.cv = cv;
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

	@Override
	public String toString() {
		return "Formation [getIdFormation()=" + getIdFormation() + ", getCv()=" + getCv() + ", getDateDebut()="
				+ getDateDebut() + ", getDateFin()=" + getDateFin() + ", getTitre()=" + getTitre()
				+ ", getDescription()=" + getDescription() + "]";
	}

}
