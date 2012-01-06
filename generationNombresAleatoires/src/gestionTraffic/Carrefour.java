package gestionTraffic;

import generateur.GenerateurExponentielle;
import generateur.PositiveGaussian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

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
	int tempsDepart = 1; //Temps en seconde
	int baseDeTemps = 1000;
	private double trafficV1, trafficV2, trafficH1, trafficH2;
	
	public Carrefour(){
		feuV1 = new Feu(0);
		feuV2 = new Feu(0);
		feuH1 = new Feu(1);
		feuH2 = new Feu(1);
		moyenneV = 20;
		ecartTypeV = 2;
		moyenneH = 40;
		ecartTypeH = 2;
		trafficV1 = 0.5d;
		trafficV2 = 0.5d;
		trafficH1 = 0.5d;
		trafficH2 = 0.5d;
		timerDepartV = new Timer(tempsDepart * 1000 , new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				feuV1.removeVoitureFileCourante();
				ihm.IHMTestTimer.changeLabelTrafficV1(feuV1.getFileCourante());
				feuV2.removeVoitureFileCourante();
				ihm.IHMTestTimer.changeLabelTrafficV2(feuV2.getFileCourante());
				System.out.println("\t\t\t\t\t\t\t\tdepart voiture file V1 : " + feuV1.getFileCourante());
			}
		});
		
		timerDepartH = new Timer(tempsDepart * 1000 , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				feuH1.removeVoitureFileCourante();
				ihm.IHMTestTimer.changeLabelTrafficH1(feuH1.getFileCourante());
				feuH2.removeVoitureFileCourante();
				ihm.IHMTestTimer.changeLabelTrafficH2(feuH2.getFileCourante());
			}
		});
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
		initCarrefour();
		
	}
	
	public void initCarrefour(){
		moyenneV = 20;
		ecartTypeV = 2;
		moyenneH = 40;
		ecartTypeH = 2;
		
		System.out.println("Temps moyen feu vert V : " + moyenneV);
		System.out.println("Temps moyen feu rouge V : " + moyenneH);
		
		double tailleFileAttenteV = moyenneV * tempsDepart;
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
		System.out.println("Lambda  = " + lambdaV + ", moyenne : " + g.calculValeurMoyenne(lambdaV));
		trafficV1 = lambdaV;
		trafficV2 = lambdaV;
		System.out.println("==============================================");
		System.out.println("Temps moyen feu vert H : " + moyenneH);
		System.out.println("Temps moyen feu rouge H : " + moyenneV);
		
		double tailleFileAttenteH = moyenneH * tempsDepart;
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
		System.out.println("Lambda  = " + lambdaH + ", moyenne : " + g.calculValeurMoyenne(lambdaH));
		trafficH1 = lambdaH;
		trafficH2 = lambdaH;
		
	}

	public void run(){
		String format = "HH:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		Date current = new Date(new GregorianCalendar().getTime().getTime()); 
		System.out.println("Simulation lancée à : " + formater.format( current ));
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
		double reelleCumulee = genExponentielle.calculValeurReelleCumulee(20);
		double theoriqueCumulee = genExponentielle.calculValeurTheoriqueCumulee(20);
		final Feu fs = f;
		Integer i = (int) Math.round(t*baseDeTemps);
		timerTraficV1 = new Timer(i , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fs.addVoitureFileCourante("FeuV1");
				System.out.println("\tarrivée voiture file V1 : " + fs.getFileCourante());
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
		String format = "HH:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		Date current = new Date(new GregorianCalendar().getTime().getTime()); 
		System.out.println("Route verticale verte / Route horizontale rouge : " + formater.format( current ));
	}
	
	public void routeHorizontaleAuVert(){
		timerDepartH.stop();
		timerDepartV.start();
		feuV1.passerAuRouge("FeuV1");
		feuV2.passerAuRouge("FeuV2");
		feuH1.passerAuVert("FeuH1");
		feuH2.passerAuVert("FeuH2");
		String format = "HH:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		Date current = new Date(new GregorianCalendar().getTime().getTime()); 
		System.out.println("Route verticale verte / Route horizontale rouge : " + formater.format( current ));
	}
	

	
}
