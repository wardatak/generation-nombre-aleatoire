package generateur;

import java.util.ArrayList;

import JSci.maths.statistics.NormalDistribution;
import JSci.maths.statistics.PoissonDistribution;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi normale
 * @author Kévin
 *
 */
public class GenerateurNormale extends Generateur{
	
	private double moyenne;
	private double ecartType;
	
	public GenerateurNormale(Double moyenne, Double ecartType){
		this.moyenne = moyenne;
        this.ecartType = ecartType;
        nom = "Loi Normale";
		//nombreClasses = 20;
		nbParametres = 2;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		isCumule = false;
	}

	@Override
	public ArrayList<Double> generer(int nombreGeneration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		return 0;
	}
	
	public double calculValeurTheorique(double evenement) {
		NormalDistribution n = new NormalDistribution(moyenne, ecartType);
		return n.probability(evenement);
	}

	@Override
	public double calculValeurTheoriqueCumulee(double valMax) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
