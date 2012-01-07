package gestionTraffic;

import javax.swing.JFrame;

import ihm.IHMTestTimer;
import ihm.IHMTestTimerOld;

public class Feu {

	private int couleur; // 0 = ROUGE   1 = VERT
	private int fileCourante;
	private int dureeSecondeEtat = 0;
	
	public Feu(int couleur){
		this.couleur = couleur;
		fileCourante = 0;
	}

	public void passerAuRouge(String feu, JFrame parent) {
		this.couleur = 0;
		//Paint component
		if(parent instanceof  IHMTestTimerOld){
			((IHMTestTimerOld)parent).changeBackgroundRouge(feu);
		}else{
			((IHMTestTimer)parent).changeBackgroundRouge(feu);
		}
	}

	public void passerAuVert(String feu, JFrame parent) {
		this.couleur = 1;
		//Paint component
		if(parent instanceof  IHMTestTimerOld){
			((IHMTestTimerOld)parent).changeBackgroundVert(feu);
		}else{
			((IHMTestTimer)parent).changeBackgroundVert(feu);
		}
	}

	public int getFileCourante() {
		return fileCourante;
	}

	public void addVoitureFileCourante(String feu) {
		this.fileCourante++;
		//System.out.println("\tarrivée voiture file");
		//ihm.IHMTestTimer.changeLabelTraffic(feu, this.fileCourante);
		
	}
	
	public void removeVoitureFileCourante() {
		//System.out.println("\t\t\t\t\t\t\t\tdepart voiture file");
		this.fileCourante--;
		if(this.fileCourante < 0){
			this.fileCourante = 0;
		}
	}
	
	public int getDureeSecondeEtat() {
		return dureeSecondeEtat;
	}

	public void setDureeSecondeEtat(int dureeSecondeEtat) {
		this.dureeSecondeEtat = dureeSecondeEtat;
		if(this.dureeSecondeEtat < 0){
			this.dureeSecondeEtat = 0;
		}
	}
	
	public int decrementeDureeSecondeEtat() {
		dureeSecondeEtat--;
		if(dureeSecondeEtat < 0){
			dureeSecondeEtat = 0;
		}
		return dureeSecondeEtat;
	}

	
	public boolean isRed(){
		if(this.couleur == 0){
			return true;
		}else{
			return false;
		}
	}
	
}
