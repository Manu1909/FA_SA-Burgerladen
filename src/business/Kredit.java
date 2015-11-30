package business;

public class Kredit {
	
	private int laufzeit; //entspricht einer Periode = 3 Monate
	private int zinssatz;
	private int hoehe; // Idee: H�he des Kredits selber bestimmen
	private double zinsen;

	public Kredit(int laufzeit, int zinssatz, int hoehe) {
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
	public void setZinsen(double zinsen){
		this.zinsen = zinsen;
	}
	public int getLaufzeit() {
		return laufzeit;
	}
	public int getZinssatz() {
		return zinssatz;
	}
	public int getHoehe() {
		return hoehe;
	}
	public double getZinsen(){
		return zinsen;
	}
	
	//Methoden
	public double berechneZinsen(){
		zinsen = (1+zinssatz*0.01)*hoehe/laufzeit;
		return zinsen;
	}
}
