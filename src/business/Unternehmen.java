package business;

import backend.Client;

public class Unternehmen {
	
	private double gewinn;
	private double kapital;
	private double umsatz;
	private int bekanntheit;
	private int kundenzufriedenheit;
	private String name;
	private Standort standort;
	private Lieferant fleischlieferant;
	private Lieferant brotlieferant;
	private Lieferant salatlieferant;
	private Lieferant sossenlieferant;
	private Kredit kredit;
	private Bestellung bestellung;
	private Burger burger;
	private Catering catering;
	private Personal personal;
	
	// Konstruktor mit Übergabe von name
	public Unternehmen(String name) {
		this.name = name;
		bestellung = new Bestellung();
		burger = new Burger();
	}
	
	//Getter und Setter für alle Attribute
	public double getGewinn() {
		return gewinn;
	}

	public void setGewinn(double gewinn) {
		this.gewinn = gewinn;
	}

	public double getKapital() {
		return kapital;
	}

	public void setKapital(double kapital) {
		this.kapital = kapital;
	}

	public double getUmsatz() {
		return umsatz;
	}

	public void setUmsatz(double umsatz) {
		this.umsatz = umsatz;
	}

	public int getBekanntheit() {
		return bekanntheit;
	}

	public void setBekanntheit(int bekanntheit) {
		this.bekanntheit = bekanntheit;
	}

	public int getKundenzufriedenheit() {
		return kundenzufriedenheit;
	}

	public void setKundenzufriedenheit(int kundenzufriedenheit) {
		this.kundenzufriedenheit = kundenzufriedenheit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Standort getStandort() {
		return standort;
	}

	public void setStandort(Standort standort) {
		this.standort = standort;
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
	
	public Kredit getKredit() {
		return kredit;
	}
	
	public void setKredit(Kredit kredit) {
		this.kredit = kredit;
	}

	public Bestellung getBestellung() {
		return bestellung;
	}

	public Burger getBurger() {
		return burger;
	}
	
	public Catering getCatering() {
		return catering;
	}

	public void setCatering(Catering catering) {
		this.catering = catering;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	public void setzeLieferanten(Lieferant fleischlieferant, Lieferant brotlieferant, Lieferant salatlieferant, Lieferant sossenlieferant){
		setFleischlieferant(fleischlieferant);
		setBrotlieferant(brotlieferant);
		setSalatlieferant(salatlieferant);
		setSossenlieferant(sossenlieferant);
	}
	
	public void berechneKapital(){
		
	}
	
	public void waehleKredit(Kredit k){
		setKredit(kredit);
	}

	public void bestelleFleisch(Lieferant fl){
		bestellung.bestelleFleisch(fl);
		fleischlieferant = fl;
	}

	public void bestelleBrot(Lieferant bl){
		bestellung.bestelleBrot(bl);
		brotlieferant = bl;
	}

	public void bestelleSalat(Lieferant sal){
		bestellung.bestelleSalat(sal);
		salatlieferant = sal;
	}

	public void bestelleSosse(Lieferant sol){
		bestellung.bestelleSosse(sol);
		sossenlieferant = sol;
	}

	public void bestellen(Lieferant fl, Lieferant bl, Lieferant sal, Lieferant sol){
		bestelleFleisch(fl);
		bestelleBrot(bl);
		bestelleSalat(sal);
		bestelleSosse(sol);
	}

	public int berechneBurgerQualität(){
		return burger.berechneQualitaet(fleischlieferant.getQualitaet(), brotlieferant.getQualitaet(), salatlieferant.getQualitaet(), sossenlieferant.getQualitaet());
	}
}
