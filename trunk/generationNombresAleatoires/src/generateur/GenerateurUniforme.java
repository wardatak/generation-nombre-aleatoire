package generateur;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi uniforme
 * 
 * @author Kévin
 * 
 */
public class GenerateurUniforme extends Generateur {
	
	public GenerateurUniforme(){
		nom = "Loi Uniforme";
		nombreClasses = 10;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
	}

	/**
	 * Méthode qui génère des nombres aléatoire entre 0 et 1 suivant la loi uniforme
	 * 
	 * @param nombreAGenerer: le nombre de chiffre que l'on souhaite générer
	 * @return la liste des nombres générés aléatoirement
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
		return (double)1 / getNombreClasses() * nbGenerations ;
	}

}
