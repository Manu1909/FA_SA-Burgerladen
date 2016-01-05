package business;

public class Kredit {
	
	private int laufzeit; //entspricht einer Periode = 3 Monate
	private double zinssatz;
	private int hoehe; // Idee: H�he des Kredits selber bestimmen
	private double annuitaet;
	private double zinsaufwand;
	private double bereinigteAnnuitaet;

	public Kredit(int laufzeit, double zinssatz, int hoehe) {
		this.laufzeit = laufzeit;
		this.zinssatz = zinssatz;
		this.hoehe = hoehe;
	}
	
	//Getter und Setter
	
	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}
	public void setZinssatz(int zinssatz) {
		this.zinssatz = zinssatz;
	}	
	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}
	public void setAnnuitaet(double annuitaet){
		this.annuitaet = annuitaet;
	}
	public void setZinsaufwand(double zinsaufwand){
		this.zinsaufwand = zinsaufwand;
	}
	public void setBereinigteAnnuitaet(double bereinigteAnnuitaet){
		this.bereinigteAnnuitaet = bereinigteAnnuitaet;
	}
	public int getLaufzeit() {
		return laufzeit;
	}
	public double getZinssatz() {
		return zinssatz;
	}
	public int getHoehe() {
		return hoehe;
	}
	public double getAnnuitaet(){
		return annuitaet;
	}
	public double getZinsaufwand(){
		return zinsaufwand;
	}
	public double getBereinigteAnnuitaet(){
		return bereinigteAnnuitaet;
	}
	
	// Methoden
	public double berechneAnnuitaet(){
		annuitaet = hoehe*(Math.pow((1+zinssatz*0.01), laufzeit/4)*(zinssatz*0.01/(Math.pow((1+zinssatz*0.01), laufzeit/4)-1)))/4;
		annuitaet = Math.round(100.0 * annuitaet) / 100.0;
		return annuitaet;
	}

	public double berechneZinsaufwand() {
		zinsaufwand = annuitaet*laufzeit - hoehe;
		zinsaufwand = Math.round(100.0 * zinsaufwand) / 100.0;
		return zinsaufwand;
	}
	
	public double berechneBereinigteAnnuitaet() {
		bereinigteAnnuitaet = annuitaet - (zinsaufwand/laufzeit);
		return bereinigteAnnuitaet;
	}
}
