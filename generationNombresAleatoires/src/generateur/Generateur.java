package generateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe mère pour la génération de nombres
 * @author Kévin
 *
 */
public abstract class Generateur {
	
	/**********************
	 *      VARIBLES      *
	 **********************/
	
	/** Nom de la loi utilisée */
	protected String nom;

	/** Liste des valeurs générées aléatoirement */
	protected ArrayList<Double> listeValeurs;
	
	/** Le nombre de générations à réaliser */
	protected int nbGenerations;
	
	/** Le nombre de classes */
	protected int nombreClasses;
	
	/** La liste des classes */
	protected ArrayList<Classe> listeClasses;
	
	/** Valeur min pour cette loi */
	protected double valeurMinLoi;
	
	/**  Valeur max pour cette loi */
	protected double valeurMaxLoi;
	
	/** Pas entre 2 classes */
	protected double pas;
	
	/** nombre de paramètres*/
	protected int nbParametres;
	
	protected boolean isCumule;


	/**
	 * Methode qui genère des nombres aléatoire
	 * @param nombreGeneration: le nombre de nombre générés aléatoirement
	 * @return un tableau de nombres
	 */
	public abstract ArrayList<Double> generer(int nombreGeneration);
	
	/**
	 * Methode qui calcule la valeur théorique cumulée utilisé pour le test du Khi²
	 * @return la valeur théorique
	 */
	public abstract double calculValeurTheoriqueCumulee(double valMax);
	
	/**
	 * Methode qui calcule la valeur théorique utilisé pour le test du Khi²
	 * @return la valeur théorique
	 */
	public abstract double calculValeurTheorique(double valMin, double valMax);
	
	/**
	 * Methode qui calcule la valeur réelle cumuléee utilisé pour le test du Khi²
	 * @return la valeur réelle
	 */
	public double calculValeurReelleCumulee(double valMax){
		double resultat = 0;
		for(int i = 0; i < listeValeurs.size(); i++){
			if(listeValeurs.get(i) < valMax){
				resultat++;
			}
		}
		return resultat;
	}
	
	/**
	 * Methode qui calcule la valeur réelle utilisé pour le test du Khi²
	 * @return la valeur réelle
	 */
	public double calculValeurReelle(double valMin, double valMax){
		double resultat = 0;
		for(int i = 0; i < listeValeurs.size(); i++){
			if(listeValeurs.get(i) < valMax && listeValeurs.get(i) >= valMin){
				resultat++;
			}
		}
		return resultat;
	}
	/**
	 * Renvoie une liste de classes initialisées
	 * @return
	 */
	public ArrayList<Classe> genererClasses(){
		Classe cl;
		double valMin;
		double valMax;
		//rechercherMinMaxLoi(listeValeurs);
		valeurMinLoi = 0;
		valeurMaxLoi = 20;
		for (int i=0; i<getNombreClasses(); i++){
			pas = (valeurMaxLoi - valeurMinLoi) / getNombreClasses();
			valMin = valeurMinLoi + i*pas;
			valMax = valeurMinLoi + (i+1)*pas;
			if(this.isCumule){
				cl = new Classe(valMin, valMax, calculValeurReelleCumulee(valMax), calculValeurTheoriqueCumulee(valMax));
			}else{
				cl = new Classe(valMin, valMax, calculValeurReelle(valMin, valMax), calculValeurTheorique(valMin, valMax));
			}
			listeClasses.add(cl);
		}
		return listeClasses;
	}
	
	/**
	 * Recherche des valeurs min et max du tableau de valeurs generees
	 * @param tab : tableau de valeurs generees
	 */
	public void rechercherMinMaxLoi(List<Double> rslt){
		double min = rslt.get(0);
		double max = rslt.get(0);
		for(int i = 1 ; i < rslt.size() ; i++){
			if(min > rslt.get(i)){
				min = rslt.get(i);
			}
			if(max < rslt.get(i)){
				max = rslt.get(i);
			}	
		}
		valeurMinLoi = min;
		valeurMaxLoi = max;
	}
	
	
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
	 * Getter pour la variable listeValeurs
	 * @return la liste des valeurs
	 */
	public ArrayList<Double> getListeValeurs() {
		return listeValeurs;
	}

	/**
	 * Setter pour la variable listeValeurs
	 * @param listeNombres: la nouvelle liste des valeurs
	 */
	public void setListeNombres(ArrayList<Double> listeValeurs) {
		this.listeValeurs = listeValeurs;
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
	
	public int getNbGenerations() {
		return nbGenerations;
	}

	public void setNbGenerations(int nbGenerations) {
		this.nbGenerations = nbGenerations;
	}

	/**
	 * @return the listeClasses
	 */
	public ArrayList<Classe> getListeClasses() {
		return listeClasses;
	}

	/**
	 * @param listeClasses the listeClasses to set
	 */
	public void setListeClasses(ArrayList<Classe> listeClasses) {
		this.listeClasses = listeClasses;
	}

	/**
	 * @return the valeurMinLoi
	 */
	public double getValeurMinLoi() {
		return valeurMinLoi;
	}

	/**
	 * @param valeurMinLoi the valeurMinLoi to set
	 */
	public void setValeurMinLoi(double valeurMinLoi) {
		this.valeurMinLoi = valeurMinLoi;
	}

	/**
	 * @return the valeurMaxLoi
	 */
	public double getValeurMaxLoi() {
		return valeurMaxLoi;
	}

	/**
	 * @param valeurMaxLoi the valeurMaxLoi to set
	 */
	public void setValeurMaxLoi(double valeurMaxLoi) {
		this.valeurMaxLoi = valeurMaxLoi;
	}

	/**
	 * @return the pas
	 */
	public double getPas() {
		return pas;
	}

	/**
	 * @param pas the pas to set
	 */
	public void setPas(double pas) {
		this.pas = pas;
	}

	/**
	 * @param listeValeurs the listeValeurs to set
	 */
	public void setListeValeurs(ArrayList<Double> listeValeurs) {
		this.listeValeurs = listeValeurs;
	}

	/**
	 * @return the nbParametres
	 */
	public int getNbParametres() {
		return nbParametres;
	}

	/**
	 * @param nbParametres the nbParametres to set
	 */
	public void setNbParametres(int nbParametres) {
		this.nbParametres = nbParametres;
	}
	
}
