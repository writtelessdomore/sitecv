	package com.SiteCV.services;

import java.util.Collection;

import com.SiteCV.domain.Experiments;

public interface ExperimentsService {

	Collection<Experiments> listAllExperimentss();

	Experiments getExperimentsById(Integer id);

	Experiments addExperiments(Experiments Experiments);

	Experiments updateExperiments(Experiments Experiments);

	void deleteExperiments(int id);

	void deleteExperimentss();

}
