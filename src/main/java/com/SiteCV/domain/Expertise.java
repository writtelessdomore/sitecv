package com.SiteCV.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expertise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idExpertise;

	private int idCv;

	private String title;

	private String corps;

	public Expertise() {

	}

	public int getIdExpertise() {
		return idExpertise;
	}

	public void setIdExpertise(int idExpertise) {
		this.idExpertise = idExpertise;
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

	public int getIdCv() {
		return idCv;
	}

	public void setIdCv(int idCv) {
		this.idCv = idCv;
	}

}
