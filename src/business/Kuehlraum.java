package business;

public class Kuehlraum {
	
	private int lagerGroesse;
	private int inhalt;
	private double mietZusatzKosten;
	
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
	
	
	//Entnehme Ware aus dem Lager
	public int wareEntnehmen(int entnahme){
		int newInhalt = 0;
			
		return newInhalt;
	}
	
	//Berechne den aktuell freiene Lagerplatz im Kühlraum
	public int berechneFreienLagerplatz(){	
		return lagerGroesse - inhalt;
	}
	

}
