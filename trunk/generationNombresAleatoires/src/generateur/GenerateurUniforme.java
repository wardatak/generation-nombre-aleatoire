package generateur;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe qui permet de g�n�rer des nombres al�atoires suivant la loi uniforme
 * 
 * @author K�vin
 * 
 */
public class GenerateurUniforme extends Generateur {
	double cumul;
	
	public GenerateurUniforme(){
		nom = "Loi Uniforme";
		nombreClasses = 20;
		nbParametres = 0;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		cumul = 0;
	}

	/**
	 * M�thode qui g�n�re des nombres al�atoire entre 0 et 1 suivant la loi uniforme
	 * 
	 * @param nombreAGenerer: le nombre de chiffre que l'on souhaite g�n�rer
	 * @return la liste des nombres g�n�r�s al�atoirement
	 */
	@Override
	public ArrayList<Double> generer(int nombreAGenerer) {
		listeValeurs = new ArrayList<Double>();
		Random random = new Random();
		nbGenerations = nombreAGenerer;

		for (int i = 0; i < nombreAGenerer; i++) {
			listeValeurs.add(random.nextDouble());
		}

		return listeValeurs;
	}

	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		cumul += (double)1 / getNombreClasses() * nbGenerations ;
		return cumul;
	}

}
