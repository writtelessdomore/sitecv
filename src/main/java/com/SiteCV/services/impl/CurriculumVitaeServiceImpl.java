package com.SiteCV.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCV.domain.CurriculumVitae;
import com.SiteCV.repositories.CurriculumVitaeRepository;
import com.SiteCV.services.CurriculumVitaeService;

@Service
public class CurriculumVitaeServiceImpl implements CurriculumVitaeService {

	private CurriculumVitaeRepository CurriculumVitaeRepository;

	@Autowired
	public void setCurriculumVitaeRepository(CurriculumVitaeRepository CurriculumVitaeRepository) {
		this.CurriculumVitaeRepository = CurriculumVitaeRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<CurriculumVitae> listAllCurriculumVitaes() {
		return IteratorUtils.toList(this.CurriculumVitaeRepository.findAll().iterator());
	}

	@Override
	public CurriculumVitae getCurriculumVitaeById(Integer id) {
		return this.CurriculumVitaeRepository.findOne(id);
	}

	
	@Override
	public CurriculumVitae updateCurriculumVitae(CurriculumVitae CurriculumVitae) {
		return this.CurriculumVitaeRepository.save(CurriculumVitae);
	}

	@Override
	public void deleteCurriculumVitae(int id) {
		this.CurriculumVitaeRepository.delete(id);
	}

	@Override
	public void deleteCurriculumVitaes() {
		this.CurriculumVitaeRepository.deleteAll();
	}


	@Override
	public CurriculumVitae addCurriculumVitae(CurriculumVitae CurriculumVitae) {
		return this.CurriculumVitaeRepository.save(CurriculumVitae);
	}

}
