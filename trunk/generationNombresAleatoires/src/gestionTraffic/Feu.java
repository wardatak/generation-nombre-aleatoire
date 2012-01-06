package gestionTraffic;

public class Feu {

	private int couleur; // 0 = ROUGE   1 = VERT
	private int fileCourante;
	
	public Feu(int couleur){
		this.couleur = couleur;
		fileCourante = 0;
	}

	public void passerAuRouge(String feu) {
		this.couleur = 0;
		//Paint component
		ihm.IHMTestTimer.changeBackgroundRouge(feu);
	}

	public void passerAuVert(String feu) {
		this.couleur = 1;
		//Paint component
		ihm.IHMTestTimer.changeBackgroundVert(feu);
	}

	public int getFileCourante() {
		return fileCourante;
	}

	public void addVoitureFileCourante(String feu) {
		this.fileCourante++;
		//System.out.println("\tarrivée voiture file");
		//ihm.IHMTestTimer.changeLabelTraffic(feu, this.fileCourante);
		
	}
	
	public void removeVoitureFileCourante() {
		//System.out.println("\t\t\t\t\t\t\t\tdepart voiture file");
		this.fileCourante--;
		if(this.fileCourante < 0){
			this.fileCourante = 0;
		}
	}
	
	public boolean isRed(){
		if(this.couleur == 0){
			return true;
		}else{
			return false;
		}
	}
	
}
