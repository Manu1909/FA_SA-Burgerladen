package client;

import backend.Client;
import server.Lieferant;

public class Unternehmen {
	
	private double gewinn;
	private double kapital;
	private double umsatz;
	private int bekanntheit;
	private int kundenzufriedenheit;
	private String name;
	private Client client;
	private Standort standort;
	private Lieferant fleischlieferant;
	private Lieferant brotlieferant;
	private Lieferant salatlieferant;
	private Lieferant sossenlieferant;
	private Kredit kredit;

	public Unternehmen(String name, Client client) {
		this.name = name;
		this.client = client;
	}
	
	public void setzeStandort(Standort standort){
		this.standort = standort;
	}
	
	public void setzeLieferanten(Lieferant fleischlieferant, Lieferant brotlieferant, Lieferant salatlieferant, Lieferant sossenlieferant){
		this.fleischlieferant = fleischlieferant;
		this.brotlieferant = brotlieferant;
		this.salatlieferant = salatlieferant;
		this.sossenlieferant = sossenlieferant;
	}
	
	public void berechneKapital(){
		
	}
	

}
