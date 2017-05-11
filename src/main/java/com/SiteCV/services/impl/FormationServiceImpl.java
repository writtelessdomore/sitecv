package com.SiteCV.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCV.domain.Formation;
import com.SiteCV.repositories.FormationRepository;
import com.SiteCV.services.FormationService;

@Service
public class FormationServiceImpl implements FormationService {

	private FormationRepository FormationRepository;

	@Autowired
	public void setFormationRepository(FormationRepository FormationRepository) {
		this.FormationRepository = FormationRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Formation> listAllFormations() {
		return IteratorUtils.toList(this.FormationRepository.findAll().iterator());
	}

	@Override
	public Formation getFormationById(Integer id) {
		return this.FormationRepository.findOne(id);
	}

	
	@Override
	public Formation updateFormation(Formation Formation) {
		return this.FormationRepository.save(Formation);
	}

	@Override
	public void deleteFormation(int id) {
		this.FormationRepository.delete(id);
	}

	@Override
	public void deleteFormations() {
		this.FormationRepository.deleteAll();
	}


	@Override
	public Formation addFormation(Formation Formation) {
		return this.FormationRepository.save(Formation);
	}

}
