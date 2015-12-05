package business;

public class Innenausstattung {
	
	private String bezeichnung;
	private int groeﬂeKundenpool;
	private double kosten;
	
	
	public Innenausstattung(String bezeichnung, int kundenpool, int kosten){
		this.bezeichnung = bezeichnung;
		this.groeﬂeKundenpool = kundenpool;
		this.kosten = kosten;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getGroeﬂeKundenpool() {
		return groeﬂeKundenpool;
	}
	public void setGroeﬂeKundenpool(int groeﬂeKundenpool) {
		this.groeﬂeKundenpool = groeﬂeKundenpool;
	}
	public double getKosten() {
		return kosten;
	}
	public void setKosten(double kosten) {
		this.kosten = kosten;
	}
	
	
	

}
