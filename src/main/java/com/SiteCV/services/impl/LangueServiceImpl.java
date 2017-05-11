package com.SiteCV.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCV.domain.Langue;
import com.SiteCV.repositories.LangueRepository;
import com.SiteCV.services.LangueService;

@Service
public class LangueServiceImpl implements LangueService {

	private LangueRepository LangueRepository;

	@Autowired
	public void setLangueRepository(LangueRepository LangueRepository) {
		this.LangueRepository = LangueRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Langue> listAllLangues() {
		return IteratorUtils.toList(this.LangueRepository.findAll().iterator());
	}

	@Override
	public Langue getLangueById(Integer id) {
		return this.LangueRepository.findOne(id);
	}

	
	@Override
	public Langue updateLangue(Langue Langue) {
		return this.LangueRepository.save(Langue);
	}

	@Override
	public void deleteLangue(int id) {
		this.LangueRepository.delete(id);
	}

	@Override
	public void deleteLangues() {
		this.LangueRepository.deleteAll();
	}


	@Override
	public Langue addLangue(Langue Langue) {
		return this.LangueRepository.save(Langue);
	}

}
