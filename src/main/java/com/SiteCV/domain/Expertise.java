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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "expertise")
public class Expertise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_expertise", nullable = false, unique = true)
	private int idExpertise;

	@ManyToMany
	@JoinTable(name = "curriculum_vitae", joinColumns = @JoinColumn(name = "id_expertise", nullable = true), inverseJoinColumns = @JoinColumn(name = "id_curriculum_vitae", nullable = true))
	@Null
	private Collection<CurriculumVitae> idCv;

	@Column(name = "titre", nullable = false)
	private String title;

	@Column(name = "body", nullable = false)
	private String body;

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

	public String getBody() {
		return body;
	}

	public void setBody(String corps) {
		this.body = corps;
	}

	@JsonIgnore
	public Collection<CurriculumVitae> getIdCv() {
		return idCv;
	}

	public void setIdCv(Collection<CurriculumVitae> idCv) {
		this.idCv = idCv;
	}

}
