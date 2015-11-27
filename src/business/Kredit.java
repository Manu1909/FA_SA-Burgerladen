package business;

public class Kredit {
	
	private int laufzeit;
	private int zinssatz; //Zinsen sind ja der eigentlich zu tilgende Betrag
	private int h�he;

	//Getter und Setter
	public int getLaufzeit() {
		return laufzeit;
	}
	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}
	public int getZinssatz() {
		return zinssatz;
	}
	public void setZinssatz(int zinssatz) {
		this.zinssatz = zinssatz;
	}
	public int getH�he() {
		return h�he;
	}
	public void setH�he(int h�he) {
		this.h�he = h�he;
	}
	//Berechne Zinsen f�r jede Periode
		public double berechneZinsen(){
			double Zinsen = (1+zinssatz*0.01)*h�he/laufzeit; // multipliziert mit 4 haben wir die Zinsen f�rs Jahr
				
			return Zinsen;
		}
}
