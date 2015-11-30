package business;

public class Kuehlraum {
	
	private int lagerGroesse;
	private int inhalt;
	private double mietZusatzKosten;
	
	public Kuehlraum(int lagergroesse, int inhalt, double mietzusatzkosten){
		this.lagerGroesse = lagergroesse;
		this.inhalt = inhalt;
		this.mietZusatzKosten = mietzusatzkosten;
	}
	
	//Getter und Setter
	public int getLagerGroesse() {
		return lagerGroesse;
	}
	public void setLagerGroesse(int lagerGroesse) {
		this.lagerGroesse = lagerGroesse;
	}
	public int getInhalt() {
		return inhalt;
	}
	public void setInhalt(int inhalt) {
		this.inhalt = inhalt;
	}
	public double getMietZusatzKosten() {
		return mietZusatzKosten;
	}
	public void setMietZusatzKosten(double mietZusatzKosten) {
		this.mietZusatzKosten = mietZusatzKosten;
	}
	
	
	public boolean wareEinlagern(int menge){
		//Wenn bestellte Menge und aktueller Inhalt die Lagergöße übertreffen muss eine Fehlermeldung ausgegeben werden
		if((inhalt + menge) > lagerGroesse){
			return false;
		}
		//Dem Inhalt die neu bestellte Menge hinzufügen
		inhalt = inhalt + menge;
		
		return true;
	}
	
	
	//Entnehme Ware aus dem Lager
	public int wareEntnehmen(int entnahme){
		if(entnahme > lagerGroesse){
			return 0;
		}
		int newInhalt = inhalt - entnahme;
		
		if(newInhalt >= 0){
			inhalt = newInhalt;
		}	
		//Aufzurufende Funktion muss prüfen ob Wert negativ oder nicht
		//Wenn negativ dann muss Fehlermeldung kommen
		//Wenn positiv wird Inhalt aktualisiert und Bestellung kann abgeschlossen werden.
		
		return newInhalt;
	}
	
	//Berechne den aktuell freiene Lagerplatz im Kühlraum
	public int berechneFreienLagerplatz(){	
		return lagerGroesse - inhalt;
	}
	

}
