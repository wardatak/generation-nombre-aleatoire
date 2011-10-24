package generateur;

import java.util.ArrayList;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi exponentielle
 * @author Kévin
 *
 */
public class GenerateurExponentielle extends Generateur{
	
	double nbUniforme;
	double lambda;
	
	public GenerateurExponentielle(){
		nom = "Loi Exponentielle";
		nombreClasses = 20;
		nbParametres = 1;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		lambda = 1;
		isCumule = true;
	}

	@Override
	public ArrayList<Double> generer(int nombreAGenerer) {
		nbGenerations = nombreAGenerer;
		GenerateurUniforme uniforme = new GenerateurUniforme();
		double valeur = 0;
		ArrayList<Double> listUniforme = uniforme.generer(nombreAGenerer);
		for (int i=0; i<nombreAGenerer; i++){
			// on récupère un nombre aléatoire généré avec la loi uniforme
			nbUniforme = listUniforme.get(i);
			
			// on injecte ce nombre dans la formule de la loi exponentielle
			valeur = -1/lambda * Math.log(nbUniforme);
			
			// on ajoute la valeur à l'ArrayList
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
		Double resultat = 1 - Math.exp(-lambda *valMax);
		resultat *= nbGenerations;
		return resultat;
	}

}
