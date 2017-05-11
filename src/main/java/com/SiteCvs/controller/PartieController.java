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
import org.springframework.web.bind.annotation.RestController;

import com.SiteCvs.domain.Partie;
import com.SiteCvs.domain.Pion;
import com.SiteCvs.services.JoueurService;
import com.SiteCvs.services.PartieService;
import com.SiteCvs.services.PionService;


@RestController
@RequestMapping("/turn")
public class PartieController {

	@Resource
	private PartieService PartieService;

	@Resource
	private JoueurService JoueurService;
	
	@Resource
	private PionService PionService;

	@Autowired
	public void setPartieService(PartieService PartieService) {
		this.PartieService = PartieService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Partie> getAllParties() {
		return this.PartieService.listAllParties();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Partie updatePartie(@PathVariable(value = "id") int id, @RequestBody Partie Partie) {
		Partie.setIdPartie(id);
		return this.PartieService.updatePartie(Partie);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePartie(@PathVariable(value = "id") int id) {
		this.PartieService.deletePartie(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteParties() {
		this.PartieService.deleteParties();
	}
	
	@RequestMapping(value = "/{groupName}", method = RequestMethod.GET)
	public ResponseEntity<?> turn(@PathVariable String groupName) {
		
		String errorMessage;
		
		Pion lastPion;
		int lastEquipeNum;
		
		try {
			lastPion = this.PionService.getLastPion();
		} catch (Exception e) {
			errorMessage = "error Pion";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
			lastEquipeNum = this.JoueurService.getJoueurByName(groupName);
		} catch (Exception e) {
			errorMessage = "error Pion";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}

		int lastJoueur = lastPion.getNuméro_joueur();
			
		Partie partie = this.PartieService.getLastPartie();
		
		if(lastEquipeNum == lastJoueur){
			partie.setStatus(0);
		}else{
			partie.setStatus(1);
		}
		
		if(this.JoueurService.getJoueurByGroupName(groupName)){
			if(partie.isFinPartie()){
				errorMessage = "Fin de partie";
				return new ResponseEntity<>(errorMessage, HttpStatus.OK);
			}else{
			
				int[][] tab = this.PionService.getTabPion();
				partie.setTabPion(tab);
				return new ResponseEntity<>(partie, HttpStatus.OK);
			}
		}else{
			errorMessage = "Equipe non reconnue dans la partie";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}
	}

	public PartieService getPartieService() {
		return PartieService;
	}
}
