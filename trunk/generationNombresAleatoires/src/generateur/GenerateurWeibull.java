package generateur;

import java.util.ArrayList;

/**
 * Classe qui permet de g�n�rer des nombres al�atoires suivant la loi de Weibull
 * @author K�vin
 *
 */
public class GenerateurWeibull extends Generateur{

	double lambda;
	double k;
	double nbUniforme;
	
	public GenerateurWeibull(){
		nom = "Loi Weibull";
		nombreClasses = 20;
		nbParametres = 2;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		lambda = 1;
		k =1;
		isCumule = true;
	}
	
	public GenerateurWeibull(double lambda){
		nom = "Loi Weibull";
		nombreClasses = 20;
		nbParametres = 2;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		this.lambda = lambda;
		k =1;
		isCumule = true;
	}
	
	@Override
	public ArrayList<Double> generer(int nombreAGenerer) {
		nbGenerations = nombreAGenerer;
		GenerateurUniforme uniforme = new GenerateurUniforme();
		double valeur = 0;
		ArrayList<Double> listUniforme = uniforme.generer(nombreAGenerer);
		for (int i=0; i<nombreAGenerer; i++){
			// on r�cup�re un nombre al�atoire g�n�r� avec la loi uniforme
			nbUniforme = listUniforme.get(i);
			// on injecte ce nombre dans la formule de la loi exponentielle
			Double truc = Math.pow(-Math.log(1-nbUniforme), 1/k);
			
			valeur = truc/lambda;
			
			// on ajoute la valeur � l'ArrayList
			listeValeurs.add(valeur);
		}
		return listeValeurs;
	}

	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		return 0;
	}

	@Override
	public double calculValeurTheoriqueCumulee(double valMax) {
		Double truc = -Math.pow(valMax*lambda, k);
		Double resultat = 1 - Math.exp(truc);
		resultat *= nbGenerations;
		return resultat;
	}

}
