package business;

public class Innenausstattung {
	
	private String bezeichnung;
	private int groe�eKundenpool;
	private double kosten;
	
	
	public Innenausstattung(String bezeichnung, int kundenpool, int kosten){
		this.bezeichnung = bezeichnung;
		this.groe�eKundenpool = kundenpool;
		this.kosten = kosten;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getGroe�eKundenpool() {
		return groe�eKundenpool;
	}
	public void setGroe�eKundenpool(int groe�eKundenpool) {
		this.groe�eKundenpool = groe�eKundenpool;
	}
	public double getKosten() {
		return kosten;
	}
	public void setKosten(double kosten) {
		this.kosten = kosten;
	}
	
	
	

}
