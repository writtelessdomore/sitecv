package com.SiteCV.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Expertise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idExpertise;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="CurriculumVitae", referencedColumnName="idCurriculumVitae")
	private CurriculumVitae cv;

	private String title;

	private String corps;

	public Expertise() {

	}

	public Expertise(int idExpertise, CurriculumVitae cv, String title, String corps) {
		super();
		this.idExpertise = idExpertise;
		this.cv = cv;
		this.title = title;
		this.corps = corps;
	}

	public int getIdExpertise() {
		return idExpertise;
	}

	public void setIdExpertise(int idExpertise) {
		this.idExpertise = idExpertise;
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

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	@Override
	public String toString() {
		return "Expertise [getIdExpertise()=" + getIdExpertise() + ", getCv()=" + getCv() + ", getTitle()=" + getTitle()
				+ ", getCorps()=" + getCorps() + "]";
	}

}
