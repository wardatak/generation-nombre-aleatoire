package gestionTraffic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import generateur.GenerateurNormale;
import generateur.PositiveGaussian;

public class Carrefour {
	
	/** Feux Verticaux */
	Feu feuV1, feuV2;
	/** Feux Horizontaux */
	Feu feuH1, feuH2;
	/** lambda de la route horizontale*/
	int lambdaHorizontal = 0;
	/** lambda de la route verticale*/
	int lambdaVertical = 0;
	/** Temps d'attente des feux verts de la route horizontale*/
	double tempsDattHorizontal = 0;
	/** Temps d'attente des feux verts de la route verticale*/
	double tempsDattVertical = 0;
	/** paramètres de la loi normale pour la route V */
	double moyenneV, ecartTypeV = 0;
	/** paramètres de la loi normale pour la route H */
	double moyenneH, ecartTypeH = 0;
	/** timer pour les temps d'attente */
	private Timer timerFeux;
	private Timer timerFeux2;
	
	public Carrefour(){
		Feu feuRouge = new Feu(0);
		Feu feuVert = new Feu(1);
		feuV1 = feuRouge;
		feuV2 = feuRouge;
		feuH1 = feuVert;
		feuH2 = feuVert;
		moyenneV = 6;
		ecartTypeV = 1;
		moyenneH = 10;
		ecartTypeH = 2;
		
	}

	public void run(){
		
		attenteV(2000);
		while(true);
			
	}
	
	public void attenteV(int i){
		timerFeux = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PositiveGaussian n = new PositiveGaussian(moyenneV, ecartTypeV); // Temps du feu vert d'après la loi normale
				tempsDattVertical = n.getRandomValue();
				//wait(tempsDattHorizontal);
				Integer i = (int) Math.round(tempsDattVertical*100);
				routeVerticaleAuVert();
				attenteH(i);
				timerFeux.stop();
			}
		});
		timerFeux.start();
	}
	
	public void attenteH(int i){
		timerFeux2 = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PositiveGaussian n = new PositiveGaussian(moyenneH, ecartTypeH); // Temps du feu vert d'après la loi normale
				tempsDattHorizontal = n.getRandomValue();
				//wait(tempsDattHorizontal);
				Integer i = (int) Math.round(tempsDattHorizontal*100);
				routeHorizontaleAuVert();
				attenteV(i);
				timerFeux2.stop();
			}
		});
		timerFeux2.start();
	}
	
	public void routeVerticaleAuVert(){
		feuV1.passerAuVert();
		feuV2.passerAuVert();
		feuH1.passerAuRouge();
		feuH2.passerAuRouge();
		System.out.println("Route verticale verte / Route horizontale rouge");
	}
	
	public void routeHorizontaleAuVert(){
		feuV1.passerAuRouge();
		feuV2.passerAuRouge();
		feuH1.passerAuVert();
		feuH2.passerAuVert();
		System.out.println("Route verticale rouge / Route horizontale verte");
	}
	

	
}
