package business;

public class Burger {
	
	int preis;
	int qualitaet;
	int preisPunkte;
	
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
	
	
	public int berechneQualitaet(int qualitaetFL, int qualitaetBL, int qualitaetSAL, int qualitaetSOl){
		qualitaet = (int) (((qualitaetFL+qualitaetBL+qualitaetSAL+qualitaetSOl)/4.0) + 0.5);
		return qualitaet;
	}

	public int berechnePreisleistung(){
		return (qualitaet + berechnePreisPunkte())/2;
	}

	public int berechnePreisPunkte(){
		preisPunkte = (int)(-4.5*preis + 122.5);
		return preisPunkte;
	}

}
