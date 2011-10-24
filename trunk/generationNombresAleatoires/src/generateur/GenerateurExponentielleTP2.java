package generateur;

import java.util.ArrayList;
import java.util.List;

import JSci.maths.statistics.PoissonDistribution;


public class GenerateurExponentielleTP2 extends GenerateurExponentielle {
	
	private double alpha;
	
	public GenerateurExponentielleTP2(){
		nom = "Loi Exponentielle TP2";
		nbParametres = 1;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		lambda = 1;
		isCumule = true;
		pas = 1;
	}
	
	public GenerateurExponentielleTP2(double lambda){
		nom = "Loi Exponentielle TP2";
		nbParametres = 2;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		this.lambda = lambda;
		isCumule = true;
		pas = 1;
	}
	
	
	@Override
	public ArrayList<Classe> genererClasses(){
		Classe cl;
		double valMin;
		double valMax;
		rechercherMinMaxLoi(listeValeurs);
		ArrayList<Classe> listeTemp = new ArrayList<Classe>();
		alpha  =  pas * lambda;
		//valeurMinLoi = 0;
		//valeurMaxLoi = 20;
		for (int i=0; i<getNombreClasses(); i++){
			
			nombreClasses = (int) ((valeurMaxLoi - valeurMinLoi) / pas);
			valMin = valeurMinLoi + i*pas;
			valMax = valeurMinLoi + (i+1)*pas;
			cl = new Classe(valMin, valMax, calculValeurReelle(valMin, valMax), calculValeurTheorique(valMin, valMax));
			
			
			listeTemp.add(cl);
		}
		for(int i=0; i < 15; i++){
			nombreClasses =14;
	    		int effectif = 0;
	    		for(Classe c : listeTemp){
	    			if(c.getEffectifReel()== i){
	    				effectif ++;
	    			}
	    		}
	    		cl = new Classe(i, i+1, effectif, calculValeurTheorique(i, i+1));
	    		listeClasses.add(cl);
    	}
			
		return listeClasses;
	}
	
	@Override
	public double calculValeurReelleCumulee(double valMax) {
		double result = 0;
		int i = 0;
		while(result < valMax){
			result += listeValeurs.get(i);
			i++;
		}
		return i;
	}
	
	@Override
	public double calculValeurReelle(double valMin, double valMax) {
		double result = 0;
		int i = 0;
		int compteur = 0;
		while(result < valMin){
			i++;
			result += listeValeurs.get(i);
		}
		while(result < valMax){
			compteur++;
			i++;
			result += listeValeurs.get(i);
		}
		return compteur;
	}
	
	@Override
	public double calculValeurTheoriqueCumulee(double valMax) {
		PoissonDistribution p = new PoissonDistribution(alpha);
		return p.cumulative(valMax)*15;
	}

	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		PoissonDistribution p = new PoissonDistribution(alpha);
		return p.probability(valMin)*15;
	}

	@Override
	public void rechercherMinMaxLoi(List<Double> rslt){
		double min = rslt.get(0);
		double max = 0;
		for(int i = 1 ; i < rslt.size() ; i++){
			max += rslt.get(i);
		}
		valeurMinLoi = min;
		valeurMaxLoi = max;
	}
}
