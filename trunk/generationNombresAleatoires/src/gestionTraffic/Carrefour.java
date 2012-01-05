package gestionTraffic;

import generateur.GenerateurExponentielle;
import generateur.PositiveGaussian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Carrefour {
	
	/* Feux Verticaux */
	Feu feuV1, feuV2;
	/* Feux Horizontaux */
	Feu feuH1, feuH2;
	/* lambda de la route horizontale*/
	int lambdaHorizontal = 0;
	/* lambda de la route verticale*/
	int lambdaVertical = 0;
	/* Temps d'attente des feux verts de la route horizontale*/
	double tempsDattHorizontal = 0;
	/* Temps d'attente des feux verts de la route verticale*/
	double tempsDattVertical = 0;
	/* paramètres de la loi normale pour la route V */
	double moyenneV, ecartTypeV = 0;
	/* paramètres de la loi normale pour la route H */
	double moyenneH, ecartTypeH = 0;
	/* timer pour les temps d'attente */
	private Timer timerFeuxVertV;
	private Timer timerFeuxVertH;
	/* timer pour l'arrivée des voitures sur chaque feu */
	private Timer timerTraficV1;
	private Timer timerTraficV2;
	private Timer timerTraficH1;
	private Timer timerTraficH2;
	/* timer pour le départ des voitures */
	private Timer timerDepartH;
	private Timer timerDepartV;
	int tempsDepart = 1000;
	int baseDeTemps = 1000;
	private double trafficV1, trafficV2, trafficH1, trafficH2;
	
	public Carrefour(){
		Feu feuRouge = new Feu(0);
		Feu feuVert = new Feu(1);
		feuV1 = feuRouge;
		feuV2 = feuRouge;
		feuH1 = feuVert;
		feuH2 = feuVert;
		moyenneV = 20;
		ecartTypeV = 2;
		moyenneH = 40;
		ecartTypeH = 2;
		trafficV1 = 0.5d;
		trafficV2 = 0.5d;
		trafficH1 = 1d;
		trafficH2 = 1d;
		timerDepartV = new Timer(tempsDepart , new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				feuV1.removeVoitureFileCourante();
				feuV2.removeVoitureFileCourante();
			}
		});
		
		timerDepartH = new Timer(tempsDepart , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				feuH1.removeVoitureFileCourante();
				feuH2.removeVoitureFileCourante();
			}
		});
		
	}

	public void run(){
		
		attenteV(200);
		trafficV1(feuV1);
		trafficV2(feuV2);
		trafficH1(feuH1);
		trafficH2(feuH2);
		while(true);
			
	}
	
	public void trafficV1(Feu f){
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		double t = genExponentielle.generationAleatoire(trafficV1);
		final Feu fs = f;
		Integer i = (int) Math.round(t*baseDeTemps);
		timerTraficV1 = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fs.addVoitureFileCourante("FeuV1");
				ihm.IHMTestTimer.changeLabelTrafficV1(fs.getFileCourante());
				timerTraficV1.stop();
				trafficV1(fs);
			}
			
		});
		timerTraficV1.start();
	}
	
	public void trafficV2(Feu f){
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		double t = genExponentielle.generationAleatoire(trafficV2);
		final Feu fs = f;
		Integer i = (int) Math.round(t*baseDeTemps);
		timerTraficV2 = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fs.addVoitureFileCourante("FeuV2");
				ihm.IHMTestTimer.changeLabelTrafficV2(fs.getFileCourante());
				timerTraficV2.stop();
				trafficV2(fs);
			}
			
		});
		timerTraficV2.start();
	}
	
	public void trafficH1(Feu f){
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		double t = genExponentielle.generationAleatoire(trafficH1);
		final Feu fs = f;
		Integer i = (int) Math.round(t*baseDeTemps);
		timerTraficH1 = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fs.addVoitureFileCourante("FeuH1");
				ihm.IHMTestTimer.changeLabelTrafficH1(fs.getFileCourante());
				timerTraficH1.stop();
				trafficH1(fs);
			}
			
		});
		timerTraficH1.start();
	}
	
	public void trafficH2(Feu f){
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		double t = genExponentielle.generationAleatoire(trafficH2);
		final Feu fs = f;
		Integer i = (int) Math.round(t*baseDeTemps);
		timerTraficH2 = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fs.addVoitureFileCourante("FeuH2");
				ihm.IHMTestTimer.changeLabelTrafficH2(fs.getFileCourante());
				timerTraficH2.stop();
				trafficH2(fs);
			}
			
		});
		timerTraficH2.start();
	}
	
	public void attenteV(int i){
		timerFeuxVertV = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PositiveGaussian n = new PositiveGaussian(moyenneV, ecartTypeV); // Temps du feu vert d'après la loi normale
				tempsDattVertical = n.getRandomValue();
				//wait(tempsDattHorizontal);
				Integer i = (int) Math.round(tempsDattVertical*baseDeTemps);
				routeVerticaleAuVert();
				attenteH(i);
				timerFeuxVertV.stop();
			}
		});
		timerFeuxVertV.start();
	}
	
	public void attenteH(int i){
		timerFeuxVertH = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PositiveGaussian n = new PositiveGaussian(moyenneH, ecartTypeH); // Temps du feu vert d'après la loi normale
				tempsDattHorizontal = n.getRandomValue();
				//wait(tempsDattHorizontal);
				Integer i = (int) Math.round(tempsDattHorizontal*baseDeTemps);
				routeHorizontaleAuVert();
				attenteV(i);
				timerFeuxVertH.stop();
			}
		});
		timerFeuxVertH.start();
	}
	
	public void routeVerticaleAuVert(){
		timerDepartV.stop();
		timerDepartH.start();
		
		feuV1.passerAuVert("FeuV1");
		feuV2.passerAuVert("FeuV2");
		feuH1.passerAuRouge("FeuH1");
		feuH2.passerAuRouge("FeuH2");
		System.out.println("Route verticale verte / Route horizontale rouge");
	}
	
	public void routeHorizontaleAuVert(){
		timerDepartH.stop();
		timerDepartV.start();
		feuV1.passerAuRouge("FeuV1");
		feuV2.passerAuRouge("FeuV2");
		feuH1.passerAuVert("FeuH1");
		feuH2.passerAuVert("FeuH2");
		System.out.println("Route verticale rouge / Route horizontale verte");
	}
	

	
}
