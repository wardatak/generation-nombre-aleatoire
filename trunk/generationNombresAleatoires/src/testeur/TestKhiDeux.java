package testeur;

import generateur.Generateur;

public class TestKhiDeux {
		
	public boolean test(Generateur gen){
		        
        Double q = 0.0;
      //Calcul de Q
        for (int i = 0; i < gen.getNombreClasses(); i++) {
        	Double valeurTheorique = gen.getListeClasses().get(i).getEffectifTheorique();
        	Double valeurEffective = gen.getListeClasses().get(i).getEffectifReel();
	        Double difference = valeurEffective - valeurTheorique;
	        System.out.println("Classe n°"+(i+1)+" différence = "+difference+" | Val theorique "+valeurTheorique+" | Val effective "+gen.getListeClasses().get(i).getEffectifReel());
	        difference = Math.pow(difference, 2); //Passage de la différence au carré
	        q += (difference / valeurTheorique); 
        }

        //Precision : colonne de la table du Khi
        // 0 => 10%   1 => 5%   2 => 2.5%   3 => 1%
        int precision = 1;
        
        //Calcul du degré de liberté
        int degres = (gen.getNombreClasses() - 1 - gen.getNbParametres());
        
        //Verification dans la table du khi²
        if (q > TableduKhi[degres][precision]) {
            System.out.println("Le test du Khi² ne valide pas la génération de la "+gen.getNom());
        } else {
            System.out.println("Le test du Khi² valide la génération de la "+gen.getNom());
        }
        System.out.println("Q réel == "+q+" | Q théorique (table khi²) == "+TableduKhi[degres][precision]+" | Degré de liberté == "+degres);
		return false;
	}
	
	/**
	 * Table du khi uniquement pour alpha < 10%
	 */
	 private static final Double[][] TableduKhi = {
		 //10%, 5%,  2.5%, 1%
         {2.71, 3.84, 5.02, 6.63},
         {4.60, 5.99, 7.38, 9.21},
         {6.25, 7.81, 9.35, 11.34},
         {7.78, 9.49, 11.10, 13.28},
         {9.24, 11.07, 12.80, 15.09},
         {10.64, 12.59, 14.00, 16.81},
         {12.02, 14.07, 16.00, 18.47},
         {13.36, 15.51, 17.50, 20.09},
         {14.68, 16.92, 19.00, 21.67},
         {15.99, 18.31, 20.05, 23.21},
         {17.27, 19.67, 21.90, 24.72},
         {18.55, 21.03, 23.30, 26.22},
         {19.81, 22.36, 24.70, 27.69},
         {21.06, 23.68, 26.10, 29.14},
         {22.31, 25.00, 27.50, 30.58},
         {23.54, 26.30, 28.80, 32.00},
         {24.77, 27.59, 30.20, 33.41},
         {25.99, 28.87, 31.30, 34.80},
         {27.20, 30.14, 32.90, 36.19},
         {28.41, 31.41, 34.20, 37.57},
         {29.61, 32.67, 37.50, 38.93},
         {30.81, 33.92, 36.80, 40.29},
         {32.01, 35.17, 38.10, 41.64}
	 };
	 
}
