package generateur;

/**
 * Classe qui permet de g�n�rer des nombres al�atoires suivant la loi uniforme
 * 
 * @author K�vin
 * 
 */
public class GenerateurUniforme extends Generateur {

	protected double[] listeNombres;

	/**
	 * M�thode qui g�n�re des nombres al�atoire entre 0 et 1 suivant la loi
	 * uniforme
	 * 
	 * @param nombreGeneration
	 *            : le nombre de chiffre que l'on souhaite g�n�rer
	 * @return la liste des nombres g�n�r�s al�atoirement
	 */
	public double[] generationNombre(int nombreGeneration) {
		listeNombres = new double[nombreGeneration];

		for (int i = 0; i < nombreGeneration; i++) {
			listeNombres[i] = Math.random();
		}

		return listeNombres;
	}

	@Override
	public double calculValeurTehorique() {
		// TODO Auto-generated method stub
		return 0;
	}

}
