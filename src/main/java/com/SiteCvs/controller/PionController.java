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
@RequestMapping("/play")
public class PionController {

	@Resource
	private PionService PionService;

	@Resource
	private JoueurService JoueurService;

	@Resource
	private PartieService PartieService;

	@Autowired
	public void setPionService(PionService PionService) {
		this.PionService = PionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Pion> getAllPions() {
		return this.PionService.listAllPions();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pion getPionById(@PathVariable(value = "idPion") int idPion) {
		// find Pion by Id
		return this.PionService.getPionById(idPion);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Pion updatePion(@PathVariable(value = "id") int id, @RequestBody Pion Pion) {
		Pion.setIdPion(id);
		return this.PionService.updatePion(Pion);
	}

	@RequestMapping(value = "/getLastPion", method = RequestMethod.GET)
	public Pion getLastPion() {
		return this.PionService.getLastPion();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePion(@PathVariable(value = "id") int id) {
		this.PionService.deletePion(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deletePions() {
		this.PionService.deletePions();
	}

	@RequestMapping(value = "/{x}/{y}/{idJoueur}", method = RequestMethod.GET)
	public ResponseEntity<?> play(@PathVariable int x, @PathVariable int y, @PathVariable String idJoueur) {

		String errorMessage;
		Pion pion = new Pion();
		pion.setNumero_ligne_dernier_coup(x);
		pion.setNumero_colonne_dernier_coup(y);

		Partie partie;

		try {
			partie = this.PartieService.getLastPartie();
		} catch (Exception e) {
			partie = new Partie();
		}

		Pion lastPion;

		try {
			lastPion = this.PionService.getLastPion();
		} catch (Exception e) {
			errorMessage = "error Pion";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}

		int lastJoueur = lastPion.getNuméro_joueur();

		String lastEquipe;

		try {
			lastEquipe = this.JoueurService.sarchJoueurByGroupName(lastJoueur);
		} catch (Exception e) {
			errorMessage = "error Equipe";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}

		Boolean bool;

		try {
			bool = this.JoueurService.getJoueurByGroupName(idJoueur);
		} catch (Exception e) {
			errorMessage = "error JoueurByGroupName";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}

		if (bool) {

			if (lastEquipe.equals(idJoueur)) {
				errorMessage = "Ce n'est pas votre tour de jeux";
				return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
			} else {

				if (pion.getNumero_colonne_dernier_coup() > 0 && pion.getNumero_ligne_dernier_coup() > 0
						&& pion.getNumero_colonne_dernier_coup() < 20 && pion.getNumero_ligne_dernier_coup() < 20) {

					if (this.PionService.isExist(pion)) {
						errorMessage = "coup deja joue";
						return new ResponseEntity<>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
					} else {
						try {
							partie.setDernierCoupX(x);
							partie.setDernierCoupY(y);
							partie.setNumTour(partie.getNumTour() + 1);
							this.PartieService.updatePartie(partie);
							pion.setNuméro_joueur(this.JoueurService.getJoueurByName(idJoueur));
							this.PionService.addPion(pion);
							endPlay(partie);
							return new ResponseEntity<>(pion, HttpStatus.OK);
						} catch (Exception e) {
							return new ResponseEntity<>(e, HttpStatus.SERVICE_UNAVAILABLE);
						}
					}

				} else {
					errorMessage = "Votre pion est hors plateau";
					return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
				}
			}

		} else {
			errorMessage = "Votre equipe n'existe pas dans la partie";
			return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}
	}

	public PionService getPionService() {
		return PionService;
	}

	public void endPlay(Partie partie){
		
		int num_in_row=0;
		int[][] tab = this.PionService.getTabPion();
		for(int row = 0; row < tab.length; row++){
			for(int col = 0;col< tab[row].length;col++){
				for( int x_direction = -1; x_direction<2; x_direction++ ) {
					for( int y_direction = -1; y_direction<2; y_direction++ ) {
						if( x_direction != 0 || y_direction != 0 ) {
							if( tab[row][col] == 1 || tab[row][col] == 2) {
								num_in_row = count_player_in_row(tab, row, col, x_direction, y_direction, tab[row][col]);
								check_for_and_update_capture(partie,tab, row, col, x_direction, y_direction, tab[row][col]);
								if( num_in_row >= 5 ) {
								partie.setFinPartie(true);
								}
							}
						} 
					}
				}
			}
		}
	}
	
	public int count_player_in_row(int[][] tab, int row, int col, int x_direction, int y_direction,int numJoueur){
		int player_in_row_count = 1;
		while( true ){
			if(row + x_direction*player_in_row_count > -1 && row + x_direction*player_in_row_count < tab.length &&
				col + y_direction*player_in_row_count > -1 && col + y_direction*player_in_row_count < tab[row].length) {
				if( tab[row + x_direction*player_in_row_count][col + y_direction*player_in_row_count] == numJoueur){
					player_in_row_count++;
				} else {
					return player_in_row_count;
				}
			} else {
				return player_in_row_count;
			}
		}
	}
	
	public void check_for_and_update_capture(Partie partie,int[][] board,int player_num,int row, int col, int x_direction, int y_direction) {

		if( count_other_player_in_row(board, row, col, x_direction, y_direction, player_num) == 2 ) {
			if( row + 3*x_direction > -1 && row + 3*x_direction < board.length &&
				col + 3*y_direction > -1 && col + 3*y_direction < board.length) {
				if( board[row + 3*x_direction][col + 3*y_direction] == player_num ) {
					board[row + 2*x_direction][col + 2*y_direction] = 0;
					board[row + x_direction][col + y_direction] = 0;
					if(player_num == 1) {
						partie.setNbTenaillesJ1(partie.getNbTenaillesJ1()+1);
					} else {
						partie.setNbTenaillesJ2(partie.getNbTenaillesJ2()+1);
					}
				}
			}
		}
	}

	public int count_other_player_in_row(int[][] board, int row, int col, int x_direction,int y_direction,int player_num) {

		int player_in_row_count = 1;

		int other_player = 0; 

		if(player_num == 1) {
			other_player = 2;
		} else {
			other_player = 1;
		}
		while( true ){
			if(row + x_direction*player_in_row_count > -1 && row + x_direction*player_in_row_count < board.length &&
				col + y_direction*player_in_row_count > -1 && col + y_direction*player_in_row_count < board[row].length) {
				if( board[row + x_direction*player_in_row_count][col + y_direction*player_in_row_count] == other_player){
					player_in_row_count++;
				} else {
					return player_in_row_count - 1;
				}
			} else {
				return player_in_row_count - 1;
			}
		}
	}
}
