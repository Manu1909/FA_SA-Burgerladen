package business;

public class Burger {
	
	int preis;
	int qualität;
	
	public Burger() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setPreis(int preis){
		this.preis = preis;
	}
	
	public void setQualität(int qualität){
		this.qualität = qualität;
	}
	
	public int getPreis(){
		return preis;
	}
	
	public int getQualität(){
		return qualität;
	}
	
	
	public void berechneQualität(Unternehmen u){
		qualität = (int) (((u.getFleischlieferant().getQualität() + u.getBrotlieferant().getQualität() + u.getSalatlieferant().getQualität() + u.getSossenlieferant().getQualität())/4.0) + 0.5);
	}

}
