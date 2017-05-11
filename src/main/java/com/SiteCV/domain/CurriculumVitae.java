package com.SiteCV.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCurriculumVitae;

	private String divers;

	private int idFormation;
	
	private int  idExpertise;

	private int idLangue;

	private int idUser;

	public CurriculumVitae() {
	}

	public int getIdCurriculumVitae() {
		return idCurriculumVitae;
	}

	public void setIdCurriculumVitae(int idCurriculumVitae) {
		this.idCurriculumVitae = idCurriculumVitae;
	}

	public String getDivers() {
		return divers;
	}

	public void setDivers(String divers) {
		this.divers = divers;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public int getIdExpertise() {
		return idExpertise;
	}

	public void setIdExpertise(int idExpertise) {
		this.idExpertise = idExpertise;
	}

	public int getIdLangue() {
		return idLangue;
	}

	public void setIdLangue(int idLangue) {
		this.idLangue = idLangue;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
}
