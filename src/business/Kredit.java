package business;

public class Kredit {
	
	private int laufzeit; //entspricht einer Periode = 3 Monate
	private int zinssatz;
	private int höhe; // Idee: Höhe des Kredits selber bestimmen
	private double zinsen;

	public Kredit(int laufzeit, int zinssatz, int höhe) {
		this.laufzeit = laufzeit;
		this.zinssatz = zinssatz;
		this.höhe = höhe;
	}
	
	//Getter und Setter
	
	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}
	public void setZinssatz(int zinssatz) {
		this.zinssatz = zinssatz;
	}	
	public void setHöhe(int höhe) {
		this.höhe = höhe;
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
	public int getHöhe() {
		return höhe;
	}
	public double getZinsen(){
		return zinsen;
	}
	
	//Methoden
	public double berechneZinsen(){
		zinsen = (1+zinssatz*0.01)*höhe/laufzeit;
		return zinsen;
	}
}
