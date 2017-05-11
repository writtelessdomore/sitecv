	package com.SiteCV.services;

import java.util.Collection;

import com.SiteCV.domain.CurriculumVitae;

public interface CurriculumVitaeService {

	Collection<CurriculumVitae> listAllCurriculumVitaes();

	CurriculumVitae getCurriculumVitaeById(Integer id);

	CurriculumVitae addCurriculumVitae(CurriculumVitae CurriculumVitae);

	CurriculumVitae updateCurriculumVitae(CurriculumVitae CurriculumVitae);

	void deleteCurriculumVitae(int id);

	void deleteCurriculumVitaes();

}
