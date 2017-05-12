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
@Table(name = "langue")
public class Langue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_langue", nullable = false, unique = true)
	private int idLangue;

	@ManyToMany
	@JoinTable(name = "curriculum_vitae", joinColumns = @JoinColumn(name = "id_langue", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true))
	@Null
	private Collection <CurriculumVitae> idCv;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "details", nullable = false)
	private String details;

	public Langue() {
	}

	public int getIdLangue() {
		return idLangue;
	}

	public void setIdLangue(int idLangue) {
		this.idLangue = idLangue;
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

	public Collection<CurriculumVitae> getIdCv() {
		return idCv;
	}

	public void setIdCv(Collection<CurriculumVitae> idCv) {
		this.idCv = idCv;
	}


}
