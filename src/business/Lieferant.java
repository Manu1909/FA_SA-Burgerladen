package business;

public class Lieferant {

	private int RESSOURCEN;
	private int verbrauchteRessourcen = 0;
	private int qualität;
	private int preisProGut;
	
	public void setRessourcen(int ressourcen){
		RESSOURCEN = ressourcen;
	}
	
	public void setVerbrauchteRessourcen(int verbrauchteRessourcen){
		this.verbrauchteRessourcen = verbrauchteRessourcen;
	}
	
	public void setQualität(int qualität){
		this.qualität = qualität;
	}
	
	public void setPreisProGut(int PreisProGut){
		this.preisProGut = preisProGut;
	}
	
	public int getVertrauchteRessourcen(){
		return verbrauchteRessourcen;
	}
	
	public int getQualität(){
		return qualität;
	}
	
	public int getPreisProGut(){
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
