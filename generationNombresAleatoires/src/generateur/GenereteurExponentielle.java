package generateur;

import java.util.ArrayList;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi exponentielle
 * @author Kévin
 *
 */
public class GenereteurExponentielle extends Generateur{
	
	double nbUniforme;
	
	double lambda = 1;

	@Override
	public ArrayList<Double> generer(int nombreGeneration) {
		GenerateurUniforme uniforme = new GenerateurUniforme();
		double valeur = 0;
		
		for (int i=0; i<nombreGeneration; i++){
			// on récupère un nombre aléatoire généré avec la loi uniforme
			nbUniforme = uniforme.generer(1).get(0);
			
			// on injecte ce nombre dans la formule de la loi exponentielle
			valeur = -1/lambda * Math.log(nbUniforme);
			
			// on ajoute la valeur à l'ArrayList
			listeValeurs.add(valeur);
		}
		
		return listeValeurs;
	}

	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		// TODO Auto-generated method stub
		return 0;
	}

}
