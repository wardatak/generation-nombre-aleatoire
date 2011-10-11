package ihm;

import generateur.GenerateurUniforme;
import java.util.ArrayList;
import testeur.TestKhiDeux;

public class TP {

	public static void main(String[] argv){
		GenerateurUniforme genUniforme = new GenerateurUniforme();
		TestKhiDeux khi2 = new TestKhiDeux();
		
		
		ArrayList<Double> resultat = genUniforme.generer(300);
		genUniforme.generer(30000);
		genUniforme.genererClasses();
				
		khi2.test(genUniforme);
	}
}
