package generateur;

import java.util.ArrayList;

/**
 * Classe m�re pour la g�n�ration de nombres
 * @author K�vin
 *
 */
public abstract class Generateur {
	
	/**********************
	 *      VARIBLES      *
	 **********************/
	
	/*
	 * Nom de la loi utilis�e
	 */
	protected String nom;

	/*
	 * Liste de nombres g�n�r�s al�atoirement
	 */
	protected double[] listeNombres;
	
	/*
	 * Le nombre de classes
	 */
	protected int nombreClasses;
	
	/*
	 * La liste des classes 
	 */
	protected ArrayList<ClasseNombre> listeClasses;
	
	/*
	 * Valeur min pour cette loi
	 */
	protected double valeurMinLoi;
	
	/*
	 *  Valeur max pour cette loi
	 */
	protected double valeurMaxLoi;
	
	/*
	 * Pas entre 2 classes
	 */
	protected double pas;
	
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
	 * Getter pour la variable nombreClasses
	 * @return le nombre de classes
	 */
	public int getNombreClasses() {
		return nombreClasses;
	}

	/**
	 * Setter pour la variable nombreClasses
	 * @param nombreClasses: le nouveau nombre de classes
	 */
	public void setNombreClasses(int nombreClasses) {
		this.nombreClasses = nombreClasses;
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
	public abstract double calculValeurTheorique();
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<ClasseNombre> genererClasses(){
		ClasseNombre nb;
		double valMin;
		double valMax;
		for (int i=0; i<getNombreClasses(); i++){
			pas = (valeurMaxLoi - valeurMinLoi) / getNombreClasses();
			valMin = valeurMinLoi + i*pas;
			valMax = valeurMinLoi + (i+1)*pas;
			if (i == getNombreClasses()-1){
				nb = new ClasseNombre(valMin, valMax, calculValeurTheorique());
			}else{
				nb = new ClasseNombre(valMin, calculValeurTheorique());
			}
			listeClasses.add(nb);
		}
		return listeClasses;
	}
	
	/**
	 * Recherche des valeurs min et max du tableau de valeurs generees
	 * @param tab : tableau de valeurs generees
	 */
	public void rechercherMinMaxLoi(double[] tab){
		double min = tab[0];
		double max = tab[0];
		for(int i = 1 ; i < tab.length ; i++){
			if(min > tab[i]){
				min = tab[i];
			}
			if(max < tab[i]){
				max = tab[i];
			}	
		}
		valeurMinLoi = min;
		valeurMaxLoi = max;
	}
}
