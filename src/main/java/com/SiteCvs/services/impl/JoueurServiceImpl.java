package com.SiteCvs.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCvs.domain.Joueur;
import com.SiteCvs.repositories.JoueurRepository;
import com.SiteCvs.services.JoueurService;

@Service
public class JoueurServiceImpl implements JoueurService {

	private JoueurRepository JoueurRepository;

	@Autowired
	public void setJoueurRepository(JoueurRepository JoueurRepository) {
		this.JoueurRepository = JoueurRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Joueur> listAllJoueurs() {
		return IteratorUtils.toList(this.JoueurRepository.findAll().iterator());
	}

	@Override
	public Joueur getJoueurById(Integer id) {
		return this.JoueurRepository.findOne(id);
	}

	@Override
	public int getJoueurByName(String name) {
		
		@SuppressWarnings("unchecked")
		Collection<Joueur> joueurList = IteratorUtils.toList(this.JoueurRepository.findAll().iterator());

		int numJoueur = 0;
		
		for (Joueur elem : joueurList) {
			if (elem.getNomJoueur().equals(name)) {
				numJoueur = elem.getNumJoueur();
			}
		}
		return numJoueur;
	}
	
	@Override
	public Joueur updateJoueur(Joueur Joueur) {
		return this.JoueurRepository.save(Joueur);
	}

	@Override
	public void deleteJoueur(int id) {
		this.JoueurRepository.delete(id);
	}

	@Override
	public void deleteJoueurs() {
		this.JoueurRepository.deleteAll();
	}

	@Override
	public boolean getJoueurByGroupName(String groupName) {

		boolean res=false;
		@SuppressWarnings("unchecked")
		Collection<Joueur> joueurList = IteratorUtils.toList(this.JoueurRepository.findAll().iterator());

		for (Joueur elem : joueurList) {
			if (elem.getNomJoueur().equals(groupName)) {
				res = true;
			}
		}
		return res;
	}

	@Override
	public Joueur addJoueur(Joueur joueur) {
		return this.JoueurRepository.save(joueur);
	}

	@Override
	public String sarchJoueurByGroupName(int numJoueur) {
		@SuppressWarnings("unchecked")
		Collection<Joueur> collecJoueur = IteratorUtils.toList(this.JoueurRepository.findAll().iterator());

		String resName = "";
		for (Joueur listjoueur : collecJoueur) {
			if (listjoueur.getNumJoueur() == numJoueur) {
				resName = listjoueur.getNomJoueur();
			} else {
				resName = "Aucune equipe correspondante";
			}
		}
		return resName;
	}

}
