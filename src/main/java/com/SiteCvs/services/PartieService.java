package com.SiteCvs.services;

import java.util.Collection;

import com.SiteCvs.domain.Partie;

public interface PartieService {
	
	Collection<Partie> listAllParties();

	Partie getPartieById(Integer id);
	
	Partie getLastPartie();
	
	Partie addPartie(Partie Partie);

	Partie updatePartie(Partie Partie);

	void deletePartie(int id);

	void deleteParties();

}
