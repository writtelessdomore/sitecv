package com.SiteCV.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCV.domain.Expertise;
import com.SiteCV.repositories.ExpertiseRepository;
import com.SiteCV.services.ExpertiseService;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {

	private ExpertiseRepository ExpertiseRepository;

	@Autowired
	public void setExpertiseRepository(ExpertiseRepository ExpertiseRepository) {
		this.ExpertiseRepository = ExpertiseRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Expertise> listAllExpertises() {
		return IteratorUtils.toList(this.ExpertiseRepository.findAll().iterator());
	}

	@Override
	public Expertise getExpertiseById(Integer id) {
		return this.ExpertiseRepository.findOne(id);
	}

	
	@Override
	public Expertise updateExpertise(Expertise Expertise) {
		return this.ExpertiseRepository.save(Expertise);
	}

	@Override
	public void deleteExpertise(int id) {
		this.ExpertiseRepository.delete(id);
	}

	@Override
	public void deleteExpertises() {
		this.ExpertiseRepository.deleteAll();
	}


	@Override
	public Expertise addExpertise(Expertise Expertise) {
		return this.ExpertiseRepository.save(Expertise);
	}

}
