package com.SiteCV.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Langue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLangue;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="CurriculumVitae", referencedColumnName="idCurriculumVitae")
	private CurriculumVitae cv;

	private String title;

	private String details;

	public Langue() {
	}

	public Langue(int idLangue, CurriculumVitae cv, String title, String details) {
		super();
		this.idLangue = idLangue;
		this.cv = cv;
		this.title = title;
		this.details = details;
	}

	public int getIdLangue() {
		return idLangue;
	}

	public void setIdLangue(int idLangue) {
		this.idLangue = idLangue;
	}

	public CurriculumVitae getCv() {
		return cv;
	}

	public void setCv(CurriculumVitae cv) {
		this.cv = cv;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Langue [getIdLangue()=" + getIdLangue() + ", getCv()=" + getCv() + ", getTitle()=" + getTitle()
				+ ", getDetails()=" + getDetails() + "]";
	}

}
