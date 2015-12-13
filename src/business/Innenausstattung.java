package business;

public class Innenausstattung {
	
	private String bezeichnung;
	private int groesseKundenpool;
	private double kosten;
	
	
	public Innenausstattung(String bezeichnung, int kundenpool, int kosten){
		this.bezeichnung = bezeichnung;
		this.groesseKundenpool = kundenpool;
		this.kosten = kosten;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getGroesseKundenpool() {
		return groesseKundenpool;
	}
	public void setGroesseKundenpool(int groesseKundenpool) {
		this.groesseKundenpool = groesseKundenpool;
	}
	public double getKosten() {
		return kosten;
	}
	public void setKosten(double kosten) {
		this.kosten = kosten;
	}
}
