package business;

public class Burger {
	
	int preis;
	int qualitaet;
	int preisPunkte;

	
	
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
	
	//Qualität setzt sich aus der Qualität der Lieferanten zusammen
	public int berechneQualitaet(int qualitaetFL, int qualitaetBL, int qualitaetSAL, int qualitaetSOl){
		qualitaet = (int) (((qualitaetFL+qualitaetBL+qualitaetSAL+qualitaetSOl)/4.0) + 0.5);
		return qualitaet;
	}

	//Die Preispunkte werden hier doppelt gezählt, da sonst der Preis zu wenig gewichtet wird
	public int berechnePreisleistung(){
		return (qualitaet + berechnePreisPunkte()*2)/3;
	}

	//Der Preis wird durch eine Exponentialfunktion auf eine Skala von 0 bis 100 umgerechnet.
	//Somit kann der Preis mit anderen Kriterien verglichen werden
	public int berechnePreisPunkte(){
		preisPunkte = (int)(Math.exp(-0.2*(preis-6))*100);
		return preisPunkte;
	}

}
