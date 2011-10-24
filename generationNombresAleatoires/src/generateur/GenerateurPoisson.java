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
		if (lambda < 1)
			lambda = 1;
		if (lambda > 20)
			lambda = 20;
		isCumule = false;
	}
	
	
	@Override
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
