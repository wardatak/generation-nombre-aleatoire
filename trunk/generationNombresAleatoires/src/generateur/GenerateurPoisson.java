package generateur;

import java.util.ArrayList;
import JSci.maths.statistics.PoissonDistribution;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi de poisson
 * @author Kévin
 *
 */
public class GenerateurPoisson extends Generateur{

	double lambda;
	
	public GenerateurPoisson(){
		nom = "Loi Poisson";
		nombreClasses = 20;
		nbParametres = 1;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		lambda = 1;
		isCumule = false;
	}
	
	public GenerateurPoisson(double lambda){
		nom = "Loi Poisson";
		nombreClasses = 20;
		nbParametres = 1;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		this.lambda = lambda;
		isCumule = false;
	}
	
	
	@Override
	public ArrayList<Double> generer(int nombreAGenerer) {
		nbGenerations = nombreAGenerer;
		double s = 0;
		double r = 0;
		        
        for (int i = 0; i < nombreAGenerer; i++) {
            s = lambda;
            r = -1.0;
            while (s >= 0) {
                r++;
                s += Math.log(1-Math.random());
        }
            listeValeurs.add(r);
        }
		return listeValeurs;
	}

	@Override
	public double calculValeurTheoriqueCumulee(double valMax) {
		PoissonDistribution p = new PoissonDistribution(lambda);
		return p.cumulative(valMax)*nbGenerations;
	}


	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		PoissonDistribution p = new PoissonDistribution(lambda);
		return p.probability(valMin)*nbGenerations;
	}
}
