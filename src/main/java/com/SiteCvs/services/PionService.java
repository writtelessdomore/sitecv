package com.SiteCvs.services;

import java.util.Collection;

import com.SiteCvs.domain.Pion;

public interface PionService {

	Collection<Pion> listAllPions();

	Pion getPionById(Integer id);

	Pion updatePion(Pion pion);

	void deletePion(int id);

	void deletePions();
	
	boolean isExist(Pion pion);

	Pion addPion(Pion pion);

	Pion getLastPion();

	int[][] getTabPion();

}
