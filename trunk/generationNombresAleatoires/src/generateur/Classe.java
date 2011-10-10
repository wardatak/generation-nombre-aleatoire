package generateur;

/**
 * Classe qui permet de répartir les différents nombres aléatoires dans des classes
 * @author Kévin
 *
 */
public class Classe {
	
	protected double min;
	protected double max;
	protected double effectifReel;
	protected double effectifTheorique;
	protected int quantite;
	
	/**
	 * Constructeur avec parametres si on a le min et le max
	 * @param valMin : valeur minimum de la classe
	 * @param valMax : valeur maximum de la classe
	 * @param effectifReel : valeur theorique pour la classe
	 * @param effectifTheorique : valeur theorique pour la classe
	 */
	public Classe(double valMin, double valMax, double effectifReel, double effectifTheorique){
		setMin(valMin);
		setMax(valMax);
		setEffectifReel(effectifReel);
		setEffectifTheorique(effectifTheorique);
		setQuantite(0);
	}
	
	/**
	 * Constructeur avec parametres si on a que le min (pour la dernière classe)
	 * @param valMin : valeur minimum de la classe
	 * @param valTheorique : valeur theorique pour la classe
	 */
	public Classe(double valMin, double effectifReel, double effectifTheorique){
		setMin(valMin);
		setMax(-1);
		setEffectifReel(effectifReel);
		setEffectifTheorique(effectifTheorique);
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
	public int getQuantite() {
		return quantite;
	}
	protected void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getEffectifReel() {
		return effectifReel;
	}

	public void setEffectifReel(double effectifReel) {
		this.effectifReel = effectifReel;
	}

	public double getEffectifTheorique() {
		return effectifTheorique;
	}

	public void setEffectifTheorique(double effectifTheorique) {
		this.effectifTheorique = effectifTheorique;
	}
	
}
