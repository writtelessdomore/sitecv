	package com.SiteCV.services;

import java.util.Collection;

import com.SiteCV.domain.Formation;

public interface FormationService {

	Collection<Formation> listAllFormations();

	Formation getFormationById(Integer id);

	Formation addFormation(Formation Formation);

	Formation updateFormation(Formation Formation);

	void deleteFormation(int id);

	void deleteFormations();

}
