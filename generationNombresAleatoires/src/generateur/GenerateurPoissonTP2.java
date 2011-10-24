package generateur;

import java.util.ArrayList;

public class GenerateurPoissonTP2 extends GenerateurPoisson {
	
	int intervalle;
	@Override
	public ArrayList<Classe> genererClasses(){
		Classe c = null;
		double valMin;
		double valMax;
		
		rechercherMinMaxLoi(listeValeurs);
		setNombreClasses((int) ((valeurMaxLoi - valeurMinLoi)/intervalle));
		for (int i=0; i<getNombreClasses(); i++){
			
			valMin = valeurMinLoi + i*intervalle;
			valMax = valeurMinLoi + (i+1)*intervalle;
			
			c = new Classe(valMin, valMax, calculValeurReelle(valMin,valMax),calculValeurTheorique(valMin, valMax));
			listeClasses.add(c);
		}
		return listeClasses;
	}
	
	@Override
	public ArrayList<Double> generer(int nombreAGenerer) {
		GenerateurExponentielle exp = new GenerateurExponentielle();
		return exp.generer(nombreAGenerer);
	}

}
