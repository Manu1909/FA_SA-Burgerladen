package business;

public class Kredit {
	
	private int laufzeit; //entspricht einer Periode = 3 Monate
	private int zinssatz;
	private int h�he; // Idee: H�he des Kredits selber bestimmen
	private double zinsen;

	public Kredit(int laufzeit, int zinssatz, int h�he) {
		this.laufzeit = laufzeit;
		this.zinssatz = zinssatz;
		this.h�he = h�he;
	}
	
	//Getter und Setter
	
	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}
	public void setZinssatz(int zinssatz) {
		this.zinssatz = zinssatz;
	}	
	public void setH�he(int h�he) {
		this.h�he = h�he;
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
	public int getH�he() {
		return h�he;
	}
	public double getZinsen(){
		return zinsen;
	}
	
	//Methoden
	public double berechneZinsen(){
		zinsen = (1+zinssatz*0.01)*h�he/laufzeit;
		return zinsen;
	}
}
