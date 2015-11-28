package business;

public class Lieferant {

	private int RESSOURCEN;
	private int verbrauchteRessourcen = 0;
	private int qualit�t;
	private double preisProGut;
	
	public Lieferant(int RESSOURCEN, int qualit�t, double preisProGut) {
		this.RESSOURCEN = RESSOURCEN;
		this.qualit�t = qualit�t;
		this.preisProGut = preisProGut;
	}
	
	public void setRessourcen(int ressourcen){
		RESSOURCEN = ressourcen;
	}
	
	public void setVerbrauchteRessourcen(int verbrauchteRessourcen){
		this.verbrauchteRessourcen = verbrauchteRessourcen;
	}
	
	public void setQualit�t(int qualit�t){
		this.qualit�t = qualit�t;
	}
	
	public void setPreisProGut(double PreisProGut){
		this.preisProGut = preisProGut;
	}
	
	public int getVertrauchteRessourcen(){
		return verbrauchteRessourcen;
	}
	
	public int getQualit�t(){
		return qualit�t;
	}
	
	public double getPreisProGut(){
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
