package business;

public class Burger {
	
	int preis;
	int qualit�t;
	
	public Burger() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setPreis(int preis){
		this.preis = preis;
	}
	
	public void setQualit�t(int qualit�t){
		this.qualit�t = qualit�t;
	}
	
	public int getPreis(){
		return preis;
	}
	
	public int getQualit�t(){
		return qualit�t;
	}
	
	
	public void berechneQualit�t(Unternehmen u){
		qualit�t = (int) (((u.getFleischlieferant().getQualit�t() + u.getBrotlieferant().getQualit�t() + u.getSalatlieferant().getQualit�t() + u.getSossenlieferant().getQualit�t())/4.0) + 0.5);
	}

}
