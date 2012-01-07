package gestionTraffic;

import generateur.GenerateurExponentielle;
import generateur.PositiveGaussian;

import ihm.IHMTestTimerOld;
import ihm.IHMTestTimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Carrefour {
	private JFrame parent;
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
	private Timer timerTempsSimulation;
	int tempsDepart = 1; //Temps en seconde
	int baseDeTemps = 1000;
	private double trafficV1, trafficV2, trafficH1, trafficH2;
	
	public Carrefour(JFrame parent){
		initVariables(parent, 20, 2, 40, 2, 0.5, 0.5, 0.5, 0.5);
		
	}
	public Carrefour(JFrame parent, double moyenneV, double ecartTypeV, double moyenneH, double ecartTypeH, double trafficV1, 
			double trafficV2, double trafficH1, double trafficH2){
		initVariables(parent, moyenneV, ecartTypeV, moyenneH, ecartTypeH, trafficV1, trafficV2, trafficH1, trafficH2);
	}
	public void initVariables(JFrame parent, double moyenneV, double ecartTypeV, double moyenneH, double ecartTypeH, double trafficV1, 
			double trafficV2, double trafficH1, double trafficH2){
		this.parent = parent;
		feuV1 = new Feu(0);
		feuV2 = new Feu(0);
		feuH1 = new Feu(1);
		feuH2 = new Feu(1);
		this.moyenneV = moyenneV;
		this.ecartTypeV = ecartTypeV;
		this.moyenneH = moyenneH;
		this.ecartTypeH = ecartTypeH;
		this.trafficV1 = trafficV1;
		this.trafficV2 = trafficV2;
		this.trafficH1 = trafficH1;
		this.trafficH2 = trafficH2;
	}
	
	public void initCarrefourTimerDepart(){
		final JFrame parentFinal = parent;
		timerDepartV = new Timer((tempsDepart * baseDeTemps) , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!feuV1.isRed()){
					feuV1.removeVoitureFileCourante();
					if(parentFinal instanceof  IHMTestTimerOld){
						((IHMTestTimerOld)parentFinal).changeLabelTrafficV1(feuV1.getFileCourante());
					}else{
						((IHMTestTimer)parentFinal).changeLabelTrafficV1(feuV1.getFileCourante());
					}
					feuV2.removeVoitureFileCourante();
					if(parentFinal instanceof  IHMTestTimerOld){
						((IHMTestTimerOld)parentFinal).changeLabelTrafficV2(feuV2.getFileCourante());
					}else{
						((IHMTestTimer)parentFinal).changeLabelTrafficV2(feuV2.getFileCourante());
					}
					System.out.println("\t\t\t\t\t\t\t\tdepart voiture file V1 : " + feuV1.getFileCourante());
				}
			}
			
		});
		
		timerDepartH = new Timer((tempsDepart * baseDeTemps) , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!feuH1.isRed()){
					feuH1.removeVoitureFileCourante();
					if(parentFinal instanceof  IHMTestTimerOld){
						((IHMTestTimerOld)parentFinal).changeLabelTrafficH1(feuH1.getFileCourante());
					}else{
						((IHMTestTimer)parentFinal).changeLabelTrafficH1(feuH1.getFileCourante());
					}
					feuH2.removeVoitureFileCourante();
					if(parentFinal instanceof  IHMTestTimerOld){
						((IHMTestTimerOld)parentFinal).changeLabelTrafficH2(feuH2.getFileCourante());
					}else{
						((IHMTestTimer)parentFinal).changeLabelTrafficH2(feuH2.getFileCourante());
					}
				}
			}
		});
	}
	
	public void initCarrefourLambda(){
		
		System.out.println("Temps moyen feu vert V : " + moyenneV);
		System.out.println("Temps moyen feu rouge V : " + moyenneH);
		
		double tailleFileAttenteV = moyenneV * tempsDepart + 10;
		System.out.println("Taille file d'attente V : " + tailleFileAttenteV);
		double tempsMinEntreDeuxVoituresV = moyenneH / tailleFileAttenteV;
		System.out.println("Temps max entre 2 voitures sur la voie V : " + tempsMinEntreDeuxVoituresV);
		GenerateurExponentielle g = new GenerateurExponentielle();
		double lambdaV = g.trouverLambdaPourLaValeurSouhaitee(tempsMinEntreDeuxVoituresV);
		double tempsMoyenneCalculeeV = g.calculValeurMoyenne(lambdaV);
		while(tempsMoyenneCalculeeV < tempsMinEntreDeuxVoituresV){
			lambdaV = g.trouverLambdaPourLaValeurSouhaitee(tempsMinEntreDeuxVoituresV);
			tempsMoyenneCalculeeV = g.calculValeurMoyenne(lambdaV);
		}
		System.out.println("Temps voulu = " + tempsMinEntreDeuxVoituresV + ", lambda = " + lambdaV);
		System.out.println("Lambda  = " + lambdaV + ", moyenne : " + tempsMoyenneCalculeeV);
		if(parent instanceof  IHMTestTimerOld){
		}else{
			((IHMTestTimer)parent).changeLabelLambdaV1(lambdaV);
			((IHMTestTimer)parent).changeLabelLambdaV2(lambdaV);
		}
		trafficV1 = lambdaV;
		trafficV2 = lambdaV;
		System.out.println("==============================================");
		System.out.println("Temps moyen feu vert H : " + moyenneH);
		System.out.println("Temps moyen feu rouge H : " + moyenneV);
		
		double tailleFileAttenteH = moyenneH * tempsDepart  + 10;
		System.out.println("Taille file d'attente H : " + tailleFileAttenteH);
		double tempsMinEntreDeuxVoituresH = moyenneV / tailleFileAttenteH;
		System.out.println("Temps max entre 2 voitures sur la voie V : " + tempsMinEntreDeuxVoituresH);
		double lambdaH = g.trouverLambdaPourLaValeurSouhaitee(tempsMinEntreDeuxVoituresH);
		double tempsMoyenneCalculeeH = g.calculValeurMoyenne(lambdaH);
		while(tempsMoyenneCalculeeH < tempsMinEntreDeuxVoituresH){
			lambdaH = g.trouverLambdaPourLaValeurSouhaitee(tempsMinEntreDeuxVoituresH);
			tempsMoyenneCalculeeH = g.calculValeurMoyenne(lambdaH);
		}
		
		System.out.println("Temps voulu = " + tempsMinEntreDeuxVoituresH + ", lambda = " + lambdaH);
		System.out.println("Lambda  = " + lambdaH + ", moyenne : " + tempsMoyenneCalculeeH);
		if(parent instanceof  IHMTestTimerOld){
		}else{
			((IHMTestTimer)parent).changeLabelLambdaH1(lambdaH);
			((IHMTestTimer)parent).changeLabelLambdaH2(lambdaH);
		}
		trafficH1 = lambdaH;
		trafficH2 = lambdaH;
		/*GenerateurExponentielle g = new GenerateurExponentielle();
		System.out.println("Lambda  = 0.01, moyenne : " + g.calculValeurMoyenne(0.01));
		System.out.println("Lambda  = 0.05, moyenne : " + g.calculValeurMoyenne(0.05));
		System.out.println("Lambda  = 0.1, moyenne : " + g.calculValeurMoyenne(0.1));
		System.out.println("Lambda  = 0.5, moyenne : " + g.calculValeurMoyenne(0.5));
		System.out.println("Lambda  = 0.9, moyenne : " + g.calculValeurMoyenne(0.9));
		System.out.println("Lambda  = 1.5, moyenne : " + g.calculValeurMoyenne(1.5));
		System.out.println("Lambda  = 2, moyenne : " + g.calculValeurMoyenne(2));
		double l = g.trouverLambdaPourLaValeurSouhaitee(1);
		System.out.println("Temps voulu = 1s, lambda = " + l);
		System.out.println("Lambda  = " + l + ", moyenne : " + g.calculValeurMoyenne(l));*/
		
	}
	
	public void start(boolean calculAutoLambda) {
		stop();
		String format = "HH:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		Date current = new Date(new GregorianCalendar().getTime().getTime()); 
		System.out.println("Simulation lancée à : " + formater.format( current ));
		if(calculAutoLambda){
			initCarrefourLambda();
		}
		attenteH(200);
		trafficV1(feuV1);
		trafficV2(feuV2);
		trafficH1(feuH1);
		trafficH2(feuH2);
		//while(true);
		final Feu fsV1 = feuV1;
		final Feu fsV2 = feuV2;
		final Feu fsH1 = feuH1;
		final Feu fsH2 = feuH2;
		initCarrefourTimerDepart();
		timerTempsSimulation = new Timer(1000 , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(parent instanceof  IHMTestTimerOld){
				}else{
					((IHMTestTimer)parent).changeLabelTempsV1(fsV1.decrementeDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsV2(fsV2.decrementeDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsH1(fsH1.decrementeDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsH2(fsH2.decrementeDureeSecondeEtat());
				}
			}
			
		});
		timerTempsSimulation.start();
		timerDepartH.start();
		timerDepartV.start();
	}
	
	public void stop() {
		if(timerFeuxVertV != null){
			timerFeuxVertV.stop();
		}
		if(timerFeuxVertH != null){
			timerFeuxVertH.stop();
		}
		if(timerTraficV1 != null){
			timerTraficV1.stop();
		}
		if(timerTraficV2 != null){
			timerTraficV2.stop();
		}
		if(timerTraficH1 != null){
			timerTraficH1.stop();
		}
		if(timerTraficH2 != null){
			timerTraficH2.stop();
		}
		if(timerDepartH != null){
			timerDepartH.stop();
		}
		if(timerDepartV != null){
			timerDepartV.stop();
		}
		if(timerTempsSimulation != null){
			timerTempsSimulation.stop();
		}
		if(parent instanceof  IHMTestTimerOld){
		}else{
			((IHMTestTimer)parent).initFeux();
		}
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
				System.out.println("\tarrivée voiture file V1 : " + fs.getFileCourante());
				if(parent instanceof  IHMTestTimerOld){
					((IHMTestTimerOld)parent).changeLabelTrafficV1(fs.getFileCourante());
				}else{
					((IHMTestTimer)parent).changeLabelTrafficV1(fs.getFileCourante());
				}
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
				if(parent instanceof  IHMTestTimerOld){
					((IHMTestTimerOld)parent).changeLabelTrafficV2(fs.getFileCourante());
				}else{
					((IHMTestTimer)parent).changeLabelTrafficV2(fs.getFileCourante());
				}
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
				if(parent instanceof  IHMTestTimerOld){
					((IHMTestTimerOld)parent).changeLabelTrafficH1(fs.getFileCourante());
				}else{
					((IHMTestTimer)parent).changeLabelTrafficH1(fs.getFileCourante());
				}
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
				if(parent instanceof  IHMTestTimerOld){
					((IHMTestTimerOld)parent).changeLabelTrafficH2(fs.getFileCourante());
				}else{
					((IHMTestTimer)parent).changeLabelTrafficH2(fs.getFileCourante());
				}
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
				if(parent instanceof  IHMTestTimerOld){
				}else{
					feuV1.setDureeSecondeEtat(i/baseDeTemps);
					feuV2.setDureeSecondeEtat(i/baseDeTemps);
					((IHMTestTimer)parent).changeLabelTempsH1(feuV1.getDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsH2(feuV2.getDureeSecondeEtat());
					feuH1.setDureeSecondeEtat(i/baseDeTemps);
					feuH2.setDureeSecondeEtat(i/baseDeTemps);
					((IHMTestTimer)parent).changeLabelTempsH1(feuH1.getDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsH2(feuH2.getDureeSecondeEtat());
				}
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
				if(parent instanceof  IHMTestTimerOld){
				}else{
					feuV1.setDureeSecondeEtat(i/baseDeTemps);
					feuV2.setDureeSecondeEtat(i/baseDeTemps);
					((IHMTestTimer)parent).changeLabelTempsH1(feuV1.getDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsH2(feuV2.getDureeSecondeEtat());
					feuH1.setDureeSecondeEtat(i/baseDeTemps);
					feuH2.setDureeSecondeEtat(i/baseDeTemps);
					((IHMTestTimer)parent).changeLabelTempsH1(feuH1.getDureeSecondeEtat());
					((IHMTestTimer)parent).changeLabelTempsH2(feuH2.getDureeSecondeEtat());
				}
				routeHorizontaleAuVert();
				attenteV(i);
				timerFeuxVertH.stop();
			}
		});
		timerFeuxVertH.start();
	}
	
	public void routeVerticaleAuVert(){
		//timerDepartV.stop();
		//timerDepartH.start();
		
		feuV1.passerAuVert("FeuV1", parent);
		feuV2.passerAuVert("FeuV2", parent);
		feuH1.passerAuRouge("FeuH1", parent);
		feuH2.passerAuRouge("FeuH2", parent);
		String format = "HH:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		Date current = new Date(new GregorianCalendar().getTime().getTime()); 
		System.out.println("Route verticale verte / Route horizontale rouge : " + formater.format( current ));
	}
	
	public void routeHorizontaleAuVert(){
		//timerDepartH.stop();
		//timerDepartV.start();
		feuV1.passerAuRouge("FeuV1", parent);
		feuV2.passerAuRouge("FeuV2", parent);
		feuH1.passerAuVert("FeuH1", parent);
		feuH2.passerAuVert("FeuH2", parent);
		String format = "HH:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		Date current = new Date(new GregorianCalendar().getTime().getTime()); 
		System.out.println("Route verticale verte / Route horizontale rouge : " + formater.format( current ));
	}

	
	

	
}
