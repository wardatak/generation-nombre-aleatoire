package generateur;

import java.util.ArrayList;

/**
 * Classe qui permet de générer des nombres aléatoires suivant la loi de poisson
 * @author Kévin
 *
 */
public class GenerateurPoisson extends Generateur{

	double nbUniforme;
	double lambda;
	
	public GenerateurPoisson(){
		nom = "Loi Poison";
		nombreClasses = 20;
		nbParametres = 1;
		listeValeurs = new ArrayList<Double>();
		listeClasses = new ArrayList<Classe>();
		lambda = 8;
	}
	
	@Override
	public ArrayList<Double> generer(int nombreAGenerer) {
		nbGenerations = nombreAGenerer;
		GenerateurUniforme uniforme = new GenerateurUniforme();
		double valeur = 0;
		double s = 0;
		double r = 0;
		ArrayList<Double> listUniforme = uniforme.generer(nombreAGenerer);
		        
        /*for (int i = 0; i < nombreAGenerer; i++) {
        	// on récupère un nombre aléatoire généré avec la loi uniforme
			nbUniforme = listUniforme.get(i);
            s = lambda;
            r = -1.0;
            while (s >= 0) {
                    r++;
                    s += Math.log(1-nbUniforme);
            }
            listeValeurs.add(r);
        }*/
		double t =0;
		
		for (int i=0; i<nombreAGenerer; i++){
			// on récupère un nombre aléatoire généré avec la loi uniforme
			nbUniforme = listUniforme.get(i);
			t = lambda;
			r = -1.0;
			// on injecte ce nombre dans la formule de la loi exponentielle
			while(t >= 1){
				r++;
				t += Math.log(1 - nbUniforme);
				//t += -1/lambda * Math.log(nbUniforme);
			}
			// on ajoute la valeur à l'ArrayList
			listeValeurs.add(r);
		}
		return listeValeurs;
	}

	@Override
	public double calculValeurTheorique(double valMin, double valMax) {
		// TODO Auto-generated method stub
		return 0;
	}

}
