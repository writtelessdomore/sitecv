package com.SiteCvs.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCvs.domain.Joueur;
import com.SiteCvs.domain.Partie;
import com.SiteCvs.services.JoueurService;
import com.SiteCvs.services.PartieService;

@RestController
@RequestMapping("/connect")
public class JoueurController {

	@Resource
	private JoueurService JoueurService;

	@Resource
	private PartieService PartieServices;

	@Autowired
	public void setJoueurService(JoueurService JoueurService) {
		this.JoueurService = JoueurService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Joueur> getAllJoueurs() {
		return this.JoueurService.listAllJoueurs();
	}		

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Joueur updateJoueur(@PathVariable(value = "id") int id, @RequestBody Joueur Joueur) {
		Joueur.setIdJoueur(id);
		return this.JoueurService.updateJoueur(Joueur);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteJoueur(@PathVariable(value = "id") int id) {
		this.JoueurService.deleteJoueur(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteJoueurs() {
		this.JoueurService.deleteJoueurs();
	}

	@RequestMapping(value = "/getByGroupName/{GroupName}", method = RequestMethod.GET)
	public boolean getJoueursByGroupName(@RequestParam("GroupName") String groupName) {
		return this.JoueurService.getJoueurByGroupName(groupName);
	}

	@RequestMapping(value = "/{GroupName}", method = RequestMethod.GET)
	public ResponseEntity<?> connect(@PathVariable("GroupName") String groupName) {
		String errorMessage;
		Joueur joueur = new Joueur();
		joueur.setNomJoueur(groupName);

		Partie partie = new Partie();

		Collection<Joueur> listJoueur = this.JoueurService.listAllJoueurs();
		if (listJoueur.size() >= 2) {
			errorMessage = "Il y'a déja 2 équipes";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}

		if (listJoueur.isEmpty()) {
			joueur.setNumJoueur(1);
			;
		}

		for (Joueur joueurs : listJoueur) {
			if (joueurs.getNomJoueur().equals(groupName)) {
				errorMessage = "Nom de joueur Deja utilise";
				return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
			} else {
				if (listJoueur.size() == 1) {
 					this.PartieServices.updatePartie(partie);
					joueur.setNumJoueur(2);
				}
			}
		}
		try {
			this.JoueurService.addJoueur(joueur);
			return new ResponseEntity<>(joueur, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	public JoueurService getJoueurService() {
		return JoueurService;
	}

}
