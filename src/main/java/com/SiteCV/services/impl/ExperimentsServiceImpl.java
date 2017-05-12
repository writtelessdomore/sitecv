package com.SiteCV.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCV.domain.Experiments;
import com.SiteCV.repositories.ExperimentsRepository;
import com.SiteCV.services.ExperimentsService;

@Service
public class ExperimentsServiceImpl implements ExperimentsService {

	private ExperimentsRepository ExperimentsRepository;

	@Autowired
	public void setExperimentsRepository(ExperimentsRepository ExperimentsRepository) {
		this.ExperimentsRepository = ExperimentsRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Experiments> listAllExperimentss() {
		return IteratorUtils.toList(this.ExperimentsRepository.findAll().iterator());
	}

	@Override
	public Experiments getExperimentsById(Integer id) {
		return this.ExperimentsRepository.findOne(id);
	}

	
	@Override
	public Experiments updateExperiments(Experiments Experiments) {
		return this.ExperimentsRepository.save(Experiments);
	}

	@Override
	public void deleteExperiments(int id) {
		this.ExperimentsRepository.delete(id);
	}

	@Override
	public void deleteExperimentss() {
		this.ExperimentsRepository.deleteAll();
	}


	@Override
	public Experiments addExperiments(Experiments Experiments) {
		return this.ExperimentsRepository.save(Experiments);
	}

}
