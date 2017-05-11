package com.SiteCvs.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCvs.domain.Pion;
import com.SiteCvs.repositories.PionRepository;
import com.SiteCvs.services.PionService;

@Service
public class PionServiceImpl implements PionService {

	private PionRepository PionRepository;

	@Autowired
	public void setPionRepository(PionRepository PionRepository) {
		this.PionRepository = PionRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Pion> listAllPions() {
		return IteratorUtils.toList(this.PionRepository.findAll().iterator());
	}

	@Override
	public Pion getLastPion() {

		Pion pion;
		@SuppressWarnings("unchecked")
		Collection<Pion> collecPion = IteratorUtils.toList(this.PionRepository.findAll().iterator());
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList myList = new ArrayList(collecPion);
		if (myList.isEmpty()) {
			pion = new Pion();
		} else {
			pion = (Pion) myList.get(myList.size() - 1);
		}
		return pion;
	}

	@Override
	public Pion getPionById(Integer id) {
		return this.PionRepository.findOne(id);
	}

	@Override
	public Pion updatePion(Pion Pion) {
		return this.PionRepository.save(Pion);
	}

	@Override
	public Pion addPion(Pion pion) {
		return this.PionRepository.save(pion);
	}

	@Override
	public void deletePion(int id) {
		this.PionRepository.delete(id);
	}

	@Override
	public void deletePions() {
		this.PionRepository.deleteAll();
	}

	@Override
	public boolean isExist(Pion pion) {

		boolean res = false;

		@SuppressWarnings("unchecked")
		Collection<Pion> listPion = IteratorUtils.toList(this.PionRepository.findAll().iterator());

		for (Pion piond : listPion) {
			if (piond.getNumero_colonne_dernier_coup() == pion.getNumero_colonne_dernier_coup()
					&& piond.getNumero_ligne_dernier_coup() == pion.getNumero_ligne_dernier_coup()) {
				res = true;
			}
		}
		return res;
	}

	@Override
	public int[][] getTabPion() {

		@SuppressWarnings("unchecked")
		Collection<Pion> listPion = IteratorUtils.toList(this.PionRepository.findAll().iterator());
		int[][] tab = new int[20][20];
		
		for (Pion piond : listPion) {
			for (int x = 1; x < 20; x++) {
				for (int y = 1; y < 20; y++) {
					if (piond.getNumero_colonne_dernier_coup() == y && piond.getNumero_ligne_dernier_coup() == x) {
						tab[x][y] = piond.getNuméro_joueur();
					} else {
						tab[x][y] = 0;
					}	
				}
			}
		}
		return tab;
	}

}
