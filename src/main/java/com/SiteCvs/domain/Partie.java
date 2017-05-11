package com.SiteCvs.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPartie;

	private int status;
	private int tabPion[][];
	private int nbTenaillesJ1;
	private int nbTenaillesJ2;
	private int dernierCoupX;
	private int dernierCoupY;
	private boolean prolongation;
	private boolean finPartie;
	private boolean detailFinPartie;
	private int numTour;

	public Partie() {
		super();
	}

	public Partie(int idPartie, int status, int[][] tabPion, int nbTenaillesJ1, int nbTenaillesJ2, int dernierCoupX,
			int dernierCoupY, boolean prolongation, boolean finPartie, boolean detailFinPartie, int numTour) {
		super();
		this.idPartie = idPartie;
		this.status = status;
		this.tabPion = tabPion;
		this.nbTenaillesJ1 = nbTenaillesJ1;
		this.nbTenaillesJ2 = nbTenaillesJ2;
		this.dernierCoupX = dernierCoupX;
		this.dernierCoupY = dernierCoupY;
		this.prolongation = prolongation;
		this.finPartie = finPartie;
		this.detailFinPartie = detailFinPartie;
		this.numTour = numTour;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int[][] getTabPion() {
		return tabPion;
	}

	public void setTabPion(int[][] tabPion) {
		this.tabPion = tabPion;
	}

	public int getNbTenaillesJ1() {
		return nbTenaillesJ1;
	}

	public void setNbTenaillesJ1(int nbTenaillesJ1) {
		this.nbTenaillesJ1 = nbTenaillesJ1;
	}

	public int getNbTenaillesJ2() {
		return nbTenaillesJ2;
	}

	public void setNbTenaillesJ2(int nbTenaillesJ2) {
		this.nbTenaillesJ2 = nbTenaillesJ2;
	}

	public int getDernierCoupX() {
		return dernierCoupX;
	}

	public void setDernierCoupX(int dernierCoupX) {
		this.dernierCoupX = dernierCoupX;
	}

	public int getDernierCoupY() {
		return dernierCoupY;
	}

	public void setDernierCoupY(int dernierCoupY) {
		this.dernierCoupY = dernierCoupY;
	}

	public boolean isProlongation() {
		return prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

	public boolean isFinPartie() {
		return finPartie;
	}

	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}

	public boolean isDetailFinPartie() {
		return detailFinPartie;
	}

	public void setDetailFinPartie(boolean detailFinPartie) {
		this.detailFinPartie = detailFinPartie;
	}

	public int getNumTour() {
		return numTour;
	}

	public void setNumTour(int numTour) {
		this.numTour = numTour;
	}

	@Override
	public String toString() {
		return "Partie [getIdPartie()=" + getIdPartie() + ", getStatus()=" + getStatus() + ", getTabPion()="
				+ Arrays.toString(getTabPion()) + ", getNbTenaillesJ1()=" + getNbTenaillesJ1() + ", getNbTenaillesJ2()="
				+ getNbTenaillesJ2() + ", getDernierCoupX()=" + getDernierCoupX() + ", getDernierCoupY()="
				+ getDernierCoupY() + ", isProlongation()=" + isProlongation() + ", isFinPartie()=" + isFinPartie()
				+ ", isDetailFinPartie()=" + isDetailFinPartie() + ", getNumTour()=" + getNumTour() + "]";
	}

}
