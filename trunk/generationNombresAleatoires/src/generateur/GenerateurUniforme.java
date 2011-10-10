package generateur;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi uniforme
 * 
 * @author Kévin
 * 
 */
public class GenerateurUniforme extends Generateur {

	/**
	 * Méthode qui génére des nombres aléatoire entre 0 et 1 suivant la loi uniforme
	 * 
	 * @param nombreGeneration: le nombre de chiffre que l'on souhaite générer
	 * @return la liste des nombres générés aléatoirement
	 */
	@Override
	public double[] generationNombre(int nombreGeneration) {
		listeNombres = new double[nombreGeneration];

		for (int i = 0; i < nombreGeneration; i++) {
			listeNombres[i] = Math.random();
		}

		return listeNombres;
	}

	@Override
	public double calculValeurTheorique() {
		int valeurTheorique = 0;
		valeurTheorique = 1 / getNombreClasses();
		return valeurTheorique;
	}

}
