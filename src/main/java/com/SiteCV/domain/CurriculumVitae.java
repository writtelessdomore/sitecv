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

	@Column(name = "divers", nullable = false)
	private String divers;

	@ManyToMany
	@JoinTable(name = "formation", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_formation", nullable = false))
	@Null
	private Collection<Formation> idFormation;

	@ManyToMany
	@JoinTable(name = "expertise", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_expertise", nullable = false))
	@Null
	private Collection<Expertise> idExpertise;

	@ManyToMany
	@JoinTable(name = "langue", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_langue", nullable = false))
	@Null
	private Collection<Langue> idLangue;

	@ManyToMany
	@JoinTable(name = "user", joinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_user", nullable = false))
	@Null
	private Collection<User> idUser;

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
}
