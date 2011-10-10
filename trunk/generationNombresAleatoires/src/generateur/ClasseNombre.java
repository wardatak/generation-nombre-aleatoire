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
	
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getValeurTheorique() {
		return valeurTheorique;
	}
	public void setValeurTheorique(double valeurTheorique) {
		this.valeurTheorique = valeurTheorique;
	}
	public int getQuantite() {
		return quantite;
	}
	protected void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
