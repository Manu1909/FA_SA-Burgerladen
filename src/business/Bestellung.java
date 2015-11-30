package business;

public class Bestellung {
	
	private int menge = 0;
	private Lieferant fleischlieferant;
	private Lieferant brotlieferant;
	private Lieferant salatlieferant;
	private Lieferant sossenlieferant;
	private Unternehmen u;
	
	public Bestellung(Unternehmen u) {
		this.u = u;
	}
	
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
	
	public void setzeBestellmenge(int bestellmenge){
		boolean flok;
		boolean blok;
		boolean salok;
		boolean solok;
		boolean krok;

		if(u.getStandort().getKuehlraum().berechneFreienLagerplatz()>=bestellmenge){
			krok = true;
		}
		else{
			krok = false;
		}
		
		
		if(Datenbank.fl1.uebrigeRessourcen() >= bestellmenge || Datenbank.fl2.uebrigeRessourcen() >= bestellmenge || Datenbank.fl3.uebrigeRessourcen() >= bestellmenge){
			flok = true;
		}
		else{
			flok = false;
		}
		
		if(Datenbank.bl1.uebrigeRessourcen() >= bestellmenge || Datenbank.bl2.uebrigeRessourcen() >= bestellmenge || Datenbank.bl3.uebrigeRessourcen() >= bestellmenge){
			blok = true;
		}
		else{
			blok = false;
		}
		
		if(Datenbank.sal1.uebrigeRessourcen() >= bestellmenge || Datenbank.sal2.uebrigeRessourcen() >= bestellmenge || Datenbank.sal3.uebrigeRessourcen() >= bestellmenge){
			salok = true;
		}
		else{
			salok = false;
		}
		
		if(Datenbank.sol1.uebrigeRessourcen() >= bestellmenge || Datenbank.sol2.uebrigeRessourcen() >= bestellmenge || Datenbank.sol3.uebrigeRessourcen() >= bestellmenge){
			solok = true;
		}
		else{
			solok = false;
		}
		
		if(flok && blok && salok && solok && krok){
			menge = bestellmenge;
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
	
	
	public void bestelleFleisch(Lieferant fl){
		if(fl.checkRessourcen(menge)){
			fl.setVerbrauchteRessourcen(fl.getVertrauchteRessourcen()+menge);
			u.setFleischlieferant(fl);
		}
	}
	
	
	public void bestelleBrot(Lieferant bl){
		if(bl.checkRessourcen(menge)){
			bl.setVerbrauchteRessourcen(bl.getVertrauchteRessourcen()+menge);
			u.setBrotlieferant(bl);
		}
	}
	
	
	public void bestelleSalat(Lieferant sal){
		if(sal.checkRessourcen(menge)){
			sal.setVerbrauchteRessourcen(sal.getVertrauchteRessourcen()+menge);
			u.setSalatlieferant(sal);
		}
	}
	
	public void bestelleSosse(Lieferant sol){
		if(sol.checkRessourcen(menge)){
			sol.setVerbrauchteRessourcen(sol.getVertrauchteRessourcen()+menge);
			u.setSossenlieferant(sol);
		}
	}
	
	
	public void bestellen(Lieferant fl, Lieferant bl, Lieferant sal, Lieferant sol){
		bestelleFleisch(fl);
		bestelleBrot(bl);
		bestelleSalat(sal);
		bestelleSosse(sol);
	}

	public double berechneGesamtpreis(){
		return (u.getFleischlieferant().getPreisProGut() + u.getBrotlieferant().getPreisProGut() + u.getSalatlieferant().getPreisProGut() + u.getSossenlieferant().getPreisProGut())*menge;
	}
	

}
