package ihm;

import generateur.GenerateurUniforme;
import generateur.GenerateurExponentielle;
import testeur.TestKhiDeux;

public class TP {

	public static void main(String[] argv){
		GenerateurUniforme genUniforme = new GenerateurUniforme();
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		TestKhiDeux khi2 = new TestKhiDeux();
		
		genExponentielle.generer(500000);
		genExponentielle.genererClasses();
				
		khi2.test(genExponentielle);
	}
}
