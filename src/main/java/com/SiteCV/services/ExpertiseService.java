	package com.SiteCV.services;

import java.util.Collection;

import com.SiteCV.domain.Expertise;

public interface ExpertiseService {

	Collection<Expertise> listAllExpertises();

	Expertise getExpertiseById(Integer id);

	Expertise addExpertise(Expertise Expertise);

	Expertise updateExpertise(Expertise Expertise);

	void deleteExpertise(int id);

	void deleteExpertises();

}
