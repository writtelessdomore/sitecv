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
@Table(name = "language")
public class Langue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_language", nullable = false, unique = true)
	private int idLanguage;

	@ManyToMany
	@JoinTable(name = "curriculum_vitae", joinColumns = @JoinColumn(name = "id_language", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true))
	@Null
	private Collection<CurriculumVitae> idCv;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "body", nullable = false)
	private String body;

	public Langue() {
	}

	public int getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}

	public Collection<CurriculumVitae> getIdCv() {
		return idCv;
	}

	public void setIdCv(Collection<CurriculumVitae> idCv) {
		this.idCv = idCv;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
