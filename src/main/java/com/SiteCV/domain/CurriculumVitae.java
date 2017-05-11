package com.SiteCV.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCurriculumVitae;
	
	private String divers;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="Formation", referencedColumnName="idFormation")
	private Formation formation;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="Expertise", referencedColumnName="idExpertise")
	private Expertise expertise;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="Langue", referencedColumnName="idLangue")
	private Langue langue;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="User", referencedColumnName="idUser")
	private User user;
	
	public CurriculumVitae(){	
	}
	
	public CurriculumVitae(int idCurriculumVitae, String divers, Formation formation, Expertise expertise,
			Langue langue) {
		super();
		this.idCurriculumVitae = idCurriculumVitae;
		this.divers = divers;
		this.formation = formation;
		this.expertise = expertise;
		this.langue = langue;
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Expertise getExpertise() {
		return expertise;
	}

	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}

	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

}
