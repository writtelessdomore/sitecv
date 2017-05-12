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
	private Collection<Formation> Formation;

	@ManyToMany
	@JoinTable(name = "expertise", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_expertise", nullable = true))
	@Null
	private Collection<Expertise> Expertise;

	@ManyToMany
	@JoinTable(name = "language", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_language", nullable = true))
	@Null
	private Collection<Langue> Langue;

	@ManyToMany
	@JoinTable(name = "user", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_user", nullable = true))
	@Null
	private Collection<User> User;

	@ManyToMany
	@JoinTable(name = "experiments", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_experiments", nullable = true))
	@Null
	private Collection<User> xperiments;

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

	public Collection<Formation> getFormation() {
		return Formation;
	}

	public void setFormation(Collection<Formation> formation) {
		Formation = formation;
	}

	public Collection<Expertise> getExpertise() {
		return Expertise;
	}

	public void setExpertise(Collection<Expertise> expertise) {
		Expertise = expertise;
	}

	public Collection<Langue> getLangue() {
		return Langue;
	}

	public void setLangue(Collection<Langue> langue) {
		Langue = langue;
	}

	public Collection<User> getUser() {
		return User;
	}

	public void setUser(Collection<User> user) {
		User = user;
	}

	public Collection<User> getXperiments() {
		return xperiments;
	}

	public void setXperiments(Collection<User> xperiments) {
		this.xperiments = xperiments;
	}

}
