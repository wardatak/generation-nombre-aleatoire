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
