package generateur;

import JSci.maths.statistics.PoissonDistribution;


public class GenerateurExponentielleTP2 extends GenerateurExponentielle {
	
	
	
	
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
