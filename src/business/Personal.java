package business;

public class Personal {
	
	public int anzahlAngestellte;
	public int [] gefeuerteNachPeriode = new int[2];
	public int anzahlGefeuerte = gefeuerteNachPeriode[0]+gefeuerteNachPeriode[1];
	public double kosten; //Kosten pro Personal...
	public int hoechstanzahl = 30;
	public int mindestanzahl = 5;
	public int burgerKapazitaet; // ...sowie Burger pro Personal m�ssen noch recherchiert werden
	
	public Personal(int anzahlAngestellte){
		this.anzahlAngestellte = anzahlAngestellte;
	}
	
	public void setAnzahlAngestellte(int anzahlAngestellte) {
		this.anzahlAngestellte = anzahlAngestellte;
	}
	public void setAnzahlGefeuerte(int anzahlGefeuerte) {
		this.anzahlGefeuerte = anzahlGefeuerte;
	}
	public void setKosten(int kosten) {
		this.kosten = kosten;
	}
	public void setBurgerKapazitaet(int burgerKapazitaet) {
		this.burgerKapazitaet = burgerKapazitaet;
	}
	public int getAnzahlAngestellte() {
		return anzahlAngestellte;
	}
	public int getAnzahlGefeuerte() {
		return anzahlGefeuerte;
	}
	public double getKosten() {
		return kosten;
	}
	public int getBurgerKapazitaet() {
		return burgerKapazitaet;
	}

	public int erhoeheAnzahl(){
		if (anzahlAngestellte < hoechstanzahl){
			anzahlAngestellte ++;
		} else {
			System.out.println("H�chstanzahl an Personal erreicht. Anzahl der Angestellten bleibt gleich.");
		}
		return anzahlAngestellte;
	}
	public int berechneAnzahl(){
		anzahlAngestellte = anzahlAngestellte-gefeuerteNachPeriode[1];
		gefeuerteNachPeriode[1] = gefeuerteNachPeriode[0];
		gefeuerteNachPeriode[0] = 0;
		return anzahlAngestellte;
	}
	public double berechneKosten(){
		kosten = anzahlAngestellte*1000; // Beispielwert: Kosten pro Personal
		return kosten;
	}
	public int feuern(int anzahl){
		if (anzahlAngestellte - anzahl >= 5){
			gefeuerteNachPeriode[0] = anzahl;
		} else {
			System.out.println("Mindestanzahl an Personal unterschritten.");
		}
		return gefeuerteNachPeriode[0];
	}
	public int berechneAnzahlBurger(){
		burgerKapazitaet = anzahlAngestellte*100; //Beispielwert: Anzahl Burger pro Personal
		return burgerKapazitaet;
	}
}
