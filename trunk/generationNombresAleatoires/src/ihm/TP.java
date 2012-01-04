package ihm;

import generateur.GenerateurNormale;
import generateur.GenerateurUniforme;
import generateur.GenerateurExponentielle;
import generateur.PositiveGaussian;
import testeur.TestKhiDeux;

public class TP {

	public static void main(String[] argv){
		/*
		GenerateurUniforme genUniforme = new GenerateurUniforme();
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		TestKhiDeux khi2 = new TestKhiDeux();
		
		genExponentielle.generer(500000);
		genExponentielle.genererClasses();
				
		khi2.test(genExponentielle);
		*/
		GenerateurExponentielle genExponentielle = new GenerateurExponentielle();
		System.out.println(genExponentielle.generationAleatoire(0.001));
		PositiveGaussian n = new PositiveGaussian(30d, 5d);
		System.out.println(n.getRandomValue());
	}
}
