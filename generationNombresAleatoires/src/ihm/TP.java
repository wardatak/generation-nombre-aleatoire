package ihm;

import generateur.GenerateurUniforme;
import testeur.TestKhiDeux;

public class TP {

	public static void main(String[] argv){
		GenerateurUniforme genUniforme = new GenerateurUniforme();
		TestKhiDeux khi2 = new TestKhiDeux();
		
		genUniforme.generer(3000000);
		genUniforme.genererClasses();
				
		khi2.test(genUniforme);
	}
}
