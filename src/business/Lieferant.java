package business;

public class Lieferant {

	private int RESSOURCEN;
	private int verbrauchteRessourcen = 0;
	private int qualit�t;
	private int preisProGut;
	
	public void setRessourcen(int ressourcen){
		RESSOURCEN = ressourcen;
	}
	
	public void setVerbrauchteRessourcen(int verbrauchteRessourcen){
		this.verbrauchteRessourcen = verbrauchteRessourcen;
	}
	
	public void setQualit�t(int qualit�t){
		this.qualit�t = qualit�t;
	}
	
	public void setPreisProGut(int PreisProGut){
		this.preisProGut = preisProGut;
	}
	
	public int getVertrauchteRessourcen(){
		return verbrauchteRessourcen;
	}
	
	public int getQualit�t(){
		return qualit�t;
	}
	
	public int getPreisProGut(){
		return preisProGut;
	}
	

	public int �brigeRessourcen(){
		return RESSOURCEN-verbrauchteRessourcen;
	}
	
	public boolean checkRessourcen(int res){
		if(res>�brigeRessourcen()){
			return false;
		}
		return true;
	}
}
