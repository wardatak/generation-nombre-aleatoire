package generateur;

/**
 * Classe qui permet de répartir les différents nombres aléatoires dans des classes
 * @author Kévin
 *
 */
public class ClasseNombre {
	
	protected double min;
	protected double max;
	protected double valeurTheorique;
	protected int quantite;
	
	/**
	 * Constructeur avec parametres si on a le min et le max
	 * @param valMin : valeur minimum de la classe
	 * @param valMax : valeur maximum de la classe
	 * @param valTheorique : valeur theorique pour la classe
	 */
	public ClasseNombre(double valMin, double valMax, double valTheorique){
		setMin(valMin);
		setMax(valMax);
		setValeurTheorique(valTheorique);
		setQuantite(0);
	}
	
	/**
	 * Constructeur avec parametres si on a que le min (pour la dernière classe)
	 * @param valMin : valeur minimum de la classe
	 * @param valTheorique : valeur theorique pour la classe
	 */
	public ClasseNombre(double valMin, double valTheorique){
		setMin(valMin);
		setMax(-1);
		setValeurTheorique(valTheorique);
		setQuantite(0);
	}
	
	/**
	 * Incremente la quantite de 1
	 */
	public void incrementer(){
		setQuantite(getQuantite() + 1);
	}
	
	/**
	 * Verifie que la valeur en parametre fait partie de cette classe et incremente la quantité
	 * @param val : valeur à verifier
	 * @return vrai si la valeur fait partie de la classe
	 */
	public boolean verifierAppartenance(double val){
		boolean result = false;
		if(getMax() != -1){
			if((val >= getMin()) & (val < getMax())){
				result = true;
				incrementer();
			}else{
				result = false;
			}
		}else{
			if(val >= getMin()){
				result = true;
				incrementer();
			}else{
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * Getter de la variable min
	 * @return min
	 */
	public double getMin() {
		return min;
	}
	
	/**
	 * Setter de la variable min
	 * @param nouvelle valeur de min
	 */
	public void setMin(double min) {
		this.min = min;
	}
	
	/**
	 * Getter de la variable max
	 * @return max
	 */
	public double getMax() {
		return max;
	}
	
	/**
	 * Setter de la variable max
	 * @param nouvelle valeur de max
	 */
	public void setMax(double max) {
		this.max = max;
	}
	
	/**
	 * Getter de la variable valeurTheorique
	 * @return valeurTheorique
	 */
	public double getValeurTheorique() {
		return valeurTheorique;
	}
	
	/**
	 * Setter de la variable valeurTheorique
	 * @param nouvelle valeur de valeurTheorique
	 */
	public void setValeurTheorique(double valeurTheorique) {
		this.valeurTheorique = valeurTheorique;
	}
	
	/**
	 * Getter de la variable quantite
	 * @return quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	
	/**
	 * Setter de la variable quantite
	 * @param nouvelle valeur de quantite
	 */
	protected void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
