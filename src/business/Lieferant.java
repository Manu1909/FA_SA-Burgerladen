package business;

public class Lieferant {

	private int RESSOURCEN;
	private int verbrauchteRessourcen = 0;
	private int qualitaet;
	private double preisProGut;
	
	public Lieferant(int RESSOURCEN, int qualitaet, double preisProGut) {
		this.RESSOURCEN = RESSOURCEN;
		this.qualitaet = qualitaet;
		this.preisProGut = preisProGut;
	}
	
	public void setRessourcen(int ressourcen){
		RESSOURCEN = ressourcen;
	}
	
	public void setVerbrauchteRessourcen(int verbrauchteRessourcen){
		this.verbrauchteRessourcen = verbrauchteRessourcen;
	}
	
	public void setQualitaet(int qualitaet){
		this.qualitaet = qualitaet;
	}
	
	public void setPreisProGut(double PreisProGut){
		this.preisProGut = preisProGut;
	}
	
	public int getVertrauchteRessourcen(){
		return verbrauchteRessourcen;
	}
	
	public int getQualitaet(){
		return qualitaet;
	}
	
	public double getPreisProGut(){
		return preisProGut;
	}
	

	public int uebrigeRessourcen(){
		return RESSOURCEN-verbrauchteRessourcen;
	}
	
	public boolean checkRessourcen(int res){
		if(res>uebrigeRessourcen()){
			return false;
		}
		return true;
	}
	
}
