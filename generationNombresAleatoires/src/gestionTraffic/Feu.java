package gestionTraffic;

public class Feu {

	private int couleur; // 0 = ROUGE   1 = VERT
	private int fileCourante;
	
	public Feu(int couleur){
		this.couleur = couleur;
		fileCourante = 0;
	}

	public void passerAuRouge() {
		this.couleur = 0;
		//Paint component
	}

	public void passerAuVert() {
		this.couleur = 1;
		//Paint component
	}

	public int getFileCourante() {
		return fileCourante;
	}

	public void setFileCourante(int fileCourante) {
		this.fileCourante = fileCourante;
	}
	
	public boolean isRed(){
		if(this.couleur == 0){
			return true;
		}else{
			return false;
		}
	}
	
}
