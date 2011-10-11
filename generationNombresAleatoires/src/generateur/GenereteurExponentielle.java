package generateur;

import java.util.ArrayList;

/**
 * Classe qui permet de g�n�rer des nombres al�atoires suivant la loi exponentielle
 * @author K�vin
 *
 */
public class GenereteurExponentielle extends Generateur{
	
	double nbUniforme;
	double lambda = 1;

	@Override
	public ArrayList<Double> generer(int nombreGeneration) {
		GenerateurUniforme uniforme = new GenerateurUniforme();
		double valeur = 0;
		ArrayList<Double> listUniforme = uniforme.generer(nombreGeneration);
		for (int i=0; i<nombreGeneration; i++){
			// on r�cup�re un nombre al�atoire g�n�r� avec la loi uniforme
			nbUniforme = listUniforme.get(i);
			
			// on injecte ce nombre dans la formule de la loi exponentielle
			valeur = -1/lambda * Math.log(nbUniforme);
			
			// on ajoute la valeur � l'ArrayList
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
