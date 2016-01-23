package business;


/**
 * @author entenmann
 */
public class Kuehlraum {
	
	private int lagerGroesse;
	private int inhalt;
	private double mietZusatzKosten;
	
	public Kuehlraum(int lagergroesse, int inhalt, double mietzusatzkosten){
		this.lagerGroesse = lagergroesse;
		this.inhalt = inhalt;
		this.mietZusatzKosten = mietzusatzkosten;
	}
	
	/*
	 * Get - und Setter Methoden der Klasse Kuehlraum 
	 */
	
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
	
	/**
	 * Ware wird nach vorheriger Prüfung  eingelagert
	 * @param menge
	 * @return inhalt
	 */
	public int wareEinlagern(int menge){
		if((inhalt + menge) > lagerGroesse || menge <= 0){
			return inhalt;
		}
		//Dem Inhalt die neu bestellte Menge hinzufï¿½gen

		inhalt += menge;
		
		return inhalt;
	}
	
	
	/**
	 * Entnahme der Ware nach vorheriger Prüfung
	 * @param entnahme
	 * @return inhalt
	 */
	public int wareEntnehmen(int entnahme){
		if(entnahme > lagerGroesse || entnahme > inhalt || entnahme <= 0){
			return inhalt;
		}
		int newInhalt = inhalt - entnahme;
		
		if(newInhalt >= 0){
			inhalt = newInhalt;
		}	
		
		return inhalt;
	}
	
	/**
	 * Berechnet den aktuell freien Lagerplatz
	 * @return freien Lagerplatz
	 */
	public int berechneFreienLagerplatz(){	
		return lagerGroesse - inhalt;
	}
	

}
