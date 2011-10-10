package generateur;

/**
 * Classe m�re pour la g�n�ration de nombres
 * @author K�vin
 *
 */
public abstract class Generateur {
	
	/*
	 * Nom de la loi utilis�e
	 */
	protected String nom;

	/*
	 * Liste de nombres g�n�r�s al�atoirement
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
	 * Methode qui gen�re des nombres al�atoire
	 * @param nombreGeneration: le nombre de nombre g�n�r�s al�atoirement
	 * @return un tableau de nombres
	 */
	public abstract double[] generationNombre(int nombreGeneration);
	
	/**
	 * Methode qui calcule la valeur th�orique utilis� pour le test du Khi�
	 * @return la valeur th�orique
	 */
	public abstract double calculValeurTehorique();

}
