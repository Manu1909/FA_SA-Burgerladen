package business;

public class Burger {
	
	int preis;
	int qualitaet;
	
	public Burger() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setPreis(int preis){
		this.preis = preis;
	}
	
	public void setQualitaet(int qualitaet){
		this.qualitaet = qualitaet;
	}
	
	public int getPreis(){
		return preis;
	}
	
	public int getQualitaet(){
		return qualitaet;
	}
	
	
	public int berechneQualitaet(Unternehmen u){
		qualitaet = (int) (((u.getFleischlieferant().getQualitaet() + u.getBrotlieferant().getQualitaet() + u.getSalatlieferant().getQualitaet() + u.getSossenlieferant().getQualitaet())/4.0) + 0.5);
		return qualitaet;
	}

}
