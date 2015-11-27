package business;

public class Kredit {
	
	private int laufzeit;
	private int zinssatz; //Zinsen sind ja der eigentlich zu tilgende Betrag
	private int höhe;

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
	public int getHöhe() {
		return höhe;
	}
	public void setHöhe(int höhe) {
		this.höhe = höhe;
	}
	//Berechne Zinsen für jede Periode
		public double berechneZinsen(){
			double Zinsen = (1+zinssatz*0.01)*höhe/laufzeit; // multipliziert mit 4 haben wir die Zinsen fürs Jahr
				
			return Zinsen;
		}
}
