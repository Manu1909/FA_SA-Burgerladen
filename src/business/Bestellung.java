package business;

public class Bestellung {
	
	private int menge = 0;
	private Lieferant fleischlieferant;
	private Lieferant brotlieferant;
	private Lieferant salatlieferant;
	private Lieferant sossenlieferant;

	
	/*public Bestellung(Unternehmen u) {
		this.u = u;
	}*/
	
	public int getMenge(){
		return menge;
	}
	
	public void setMenge(int menge){
		this.menge = menge;
	}
	
	public Lieferant getFleischlieferant() {
		return fleischlieferant;
	}

	public void setFleischlieferant(Lieferant fleischlieferant) {
		this.fleischlieferant = fleischlieferant;
	}

	public Lieferant getBrotlieferant() {
		return brotlieferant;
	}

	public void setBrotlieferant(Lieferant brotlieferant) {
		this.brotlieferant = brotlieferant;
	}

	public Lieferant getSalatlieferant() {
		return salatlieferant;
	}

	public void setSalatlieferant(Lieferant salatlieferant) {
		this.salatlieferant = salatlieferant;
	}

	public Lieferant getSossenlieferant() {
		return sossenlieferant;
	}

	public void setSossenlieferant(Lieferant sossenlieferant) {
		this.sossenlieferant = sossenlieferant;
	}
	
	public void setzeLieferanten(Lieferant fleischlieferant, Lieferant brotlieferant, Lieferant salatlieferant, Lieferant sossenlieferant){
		setFleischlieferant(fleischlieferant);
		setBrotlieferant(brotlieferant);
		setSalatlieferant(salatlieferant);
		setSossenlieferant(sossenlieferant);
	}
	
	public void setzeBestellmenge(int bestellmenge, int freierLagerplatz){
		boolean fleischOK;
		boolean brotOK;
		boolean salatOK;
		boolean sosseOK;
		boolean lagerPlatzOK;

		menge = 0;
		if(freierLagerplatz>=bestellmenge){
			lagerPlatzOK = true;
		}
		else{
			lagerPlatzOK = false;
		}
		
		
		if(Datenbank.fl1.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.fl2.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.fl3.berechneUebrigeRessourcen() >= bestellmenge){
			fleischOK = true;
		}
		else{
			fleischOK = false;
		}
		
		if(Datenbank.bl1.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.bl2.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.bl3.berechneUebrigeRessourcen() >= bestellmenge){
			brotOK = true;
		}
		else{
			brotOK = false;
		}
		
		if(Datenbank.sal1.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.sal2.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.sal3.berechneUebrigeRessourcen() >= bestellmenge){
			salatOK = true;
		}
		else{
			salatOK = false;
		}
		
		if(Datenbank.sol1.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.sol2.berechneUebrigeRessourcen() >= bestellmenge || Datenbank.sol3.berechneUebrigeRessourcen() >= bestellmenge){
			sosseOK = true;
		}
		else{
			sosseOK = false;
		}
		
		if(fleischOK && brotOK && salatOK && sosseOK && lagerPlatzOK){
			menge = bestellmenge;
		}
		else if(!lagerPlatzOK){
			System.out.println("Nicht genügend Lagerplatz vorhanden");
		}
		else{
			System.out.println("Die Ressourcen der Lieferanten reichen nicht aus, um so viele Burger zu bestellen");
		}
	}
	
	
	public boolean pruefeAnzahlZutaten(int einzelneBestellmenge){
		if(einzelneBestellmenge==menge){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public boolean bestelleFleisch(Lieferant fl){
		if(fl.checkRessourcen(menge)){
			fl.setVerbrauchteRessourcen(fl.getVertrauchteRessourcen()+menge);
			fleischlieferant = fl;
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public boolean bestelleBrot(Lieferant bl){
		if(bl.checkRessourcen(menge)){
			bl.setVerbrauchteRessourcen(bl.getVertrauchteRessourcen()+menge);
			brotlieferant = bl;
			return true;
		}
		return false;
	}
	
	
	public boolean bestelleSalat(Lieferant sal){
		if(sal.checkRessourcen(menge)){
			sal.setVerbrauchteRessourcen(sal.getVertrauchteRessourcen()+menge);
			salatlieferant = sal;
			return true;
		}
		return false;
	}
	
	public boolean bestelleSosse(Lieferant sol){
		if(sol.checkRessourcen(menge)){
			sol.setVerbrauchteRessourcen(sol.getVertrauchteRessourcen()+menge);
			sossenlieferant = sol;
			return true;
		}
		return false;
	}
	
	
	/*public void bestellen(Lieferant fl, Lieferant bl, Lieferant sal, Lieferant sol){
		bestelleFleisch(fl);
		bestelleBrot(bl);
		bestelleSalat(sal);
		bestelleSosse(sol);
	}*/

	public double berechneGesamtpreis(){
		double preis = (fleischlieferant.getPreisProGut() + brotlieferant.getPreisProGut() + salatlieferant.getPreisProGut() + sossenlieferant.getPreisProGut())*menge;
		preis = Math.round(100.0*preis)/100.0;
		return preis;
	}
	

}
