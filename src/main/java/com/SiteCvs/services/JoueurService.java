package com.SiteCvs.services;

import java.util.Collection;

import com.SiteCvs.domain.Joueur;

public interface JoueurService {

	Collection<Joueur> listAllJoueurs();

	Joueur getJoueurById(Integer id);

	Joueur addJoueur(Joueur joueur);

	boolean getJoueurByGroupName(String groupName);

	Joueur updateJoueur(Joueur joueur);

	void deleteJoueur(int id);

	void deleteJoueurs();

	String sarchJoueurByGroupName(int numJoueur);

	int getJoueurByName(String name);
}
