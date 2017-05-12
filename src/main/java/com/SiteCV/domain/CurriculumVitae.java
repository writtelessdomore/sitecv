package com.SiteCV.domain;

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
@Table(name = "curriculum_vitae")
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_curriculum_vitae")
	private int idCurriculumVitae;

	@Column(name = "various", nullable = false)
	private String various;

	@ManyToMany
	@JoinTable(name = "formation", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_formation", nullable = true))
	@Null
	private Collection<Formation> idFormation;

	@ManyToMany
	@JoinTable(name = "expertise", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_expertise", nullable = true))
	@Null
	private Collection<Expertise> idExpertise;

	@ManyToMany
	@JoinTable(name = "language", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_language", nullable = true))
	@Null
	private Collection<Langue> idLangue;

	@ManyToMany
	@JoinTable(name = "user", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_user", nullable = true))
	@Null
	private Collection<User> idUser;
	
	@ManyToMany
	@JoinTable(name = "experiments", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_experiments", nullable = true))
	@Null
	private Collection<User> idExperiments;

	public CurriculumVitae() {
	}

	public int getIdCurriculumVitae() {
		return idCurriculumVitae;
	}

	public void setIdCurriculumVitae(int idCurriculumVitae) {
		this.idCurriculumVitae = idCurriculumVitae;
	}

	public String getVarious() {
		return various;
	}

	public void setVarious(String divers) {
		this.various = divers;
	}

	public Collection<Formation> getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Collection<Formation> idFormation) {
		this.idFormation = idFormation;
	}

	public Collection<Expertise> getIdExpertise() {
		return idExpertise;
	}

	public void setIdExpertise(Collection<Expertise> idExpertise) {
		this.idExpertise = idExpertise;
	}

	public Collection<Langue> getIdLangue() {
		return idLangue;
	}

	public void setIdLangue(Collection<Langue> idLangue) {
		this.idLangue = idLangue;
	}

	public Collection<User> getIdUser() {
		return idUser;
	}

	public void setIdUser(Collection<User> idUser) {
		this.idUser = idUser;
	}

	public Collection<User> getIdExperiments() {
		return idExperiments;
	}

	public void setIdExperiments(Collection<User> idExperiments) {
		this.idExperiments = idExperiments;
	}
	
}
