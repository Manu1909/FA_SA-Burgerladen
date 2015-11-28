package business;

public class Lieferant {

	private int RESSOURCEN;
	private int verbrauchteRessourcen = 0;
	private int qualität;
	private double preisProGut;
	
	public Lieferant(int RESSOURCEN, int qualität, double preisProGut) {
		this.RESSOURCEN = RESSOURCEN;
		this.qualität = qualität;
		this.preisProGut = preisProGut;
	}
	
	public void setRessourcen(int ressourcen){
		RESSOURCEN = ressourcen;
	}
	
	public void setVerbrauchteRessourcen(int verbrauchteRessourcen){
		this.verbrauchteRessourcen = verbrauchteRessourcen;
	}
	
	public void setQualität(int qualität){
		this.qualität = qualität;
	}
	
	public void setPreisProGut(double PreisProGut){
		this.preisProGut = preisProGut;
	}
	
	public int getVertrauchteRessourcen(){
		return verbrauchteRessourcen;
	}
	
	public int getQualität(){
		return qualität;
	}
	
	public double getPreisProGut(){
		return preisProGut;
	}
	

	public int übrigeRessourcen(){
		return RESSOURCEN-verbrauchteRessourcen;
	}
	
	public boolean checkRessourcen(int res){
		if(res>übrigeRessourcen()){
			return false;
		}
		return true;
	}
	
}
