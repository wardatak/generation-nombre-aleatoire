package generateur;

/**
 * Classe mère pour la génération de nombres
 * @author Kévin
 *
 */
public abstract class Generateur {
	
	/*
	 * Nom de la loi utilisée
	 */
	protected String nom;

	/*
	 * Liste de nombres générés aléatoirement
	 */
	protected double[] listeNombres;
	
	/**
	 * Getter pour la variable Nom
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour la variable Nom
	 * @param nom: le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour la variable listeNombres
	 * @return la liste des nombres
	 */
	public double[] getListeNombres() {
		return listeNombres;
	}

	/**
	 * Setter pour la variable listeNombres
	 * @param listeNombres: la nouvelle liste des nombres
	 */
	public void setListeNombres(double[] listeNombres) {
		this.listeNombres = listeNombres;
	}
	
	/**
	 * Methode qui genère des nombres aléatoire
	 * @param nombreGeneration: le nombre de nombre générés aléatoirement
	 * @return un tableau de nombres
	 */
	public abstract double[] generationNombre(int nombreGeneration);
	
	/**
	 * Methode qui calcule la valeur théorique utilisé pour le test du Khi²
	 * @return la valeur théorique
	 */
	public abstract double calculValeurTehorique();

}
