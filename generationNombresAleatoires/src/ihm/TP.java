package ihm;

import java.util.ArrayList;

import testeur.TestKhiDeux;
import generateur.GenerateurUniforme;

public class TP {

	public static void main(String[] argv){
		GenerateurUniforme genUniforme = new GenerateurUniforme();
		TestKhiDeux khi2 = new TestKhiDeux();
		
		try{
			ArrayList<Double> resultat = genUniforme.generer(300);
			System.out.println(genUniforme.generer(30000));
			System.out.println(genUniforme.genererClasses());
			
		}catch(Exception E){
			System.out.println(E);
		}
	}
}
