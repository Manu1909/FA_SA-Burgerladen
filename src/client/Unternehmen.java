package client;

import backend.Client;

public class Unternehmen {
	
	private double gewinn;
	private double kapital;
	private double umsatz;
	private int bekanntheit;
	private int kundenzufriedenheit;
	private String name;
	private Client client;

	public Unternehmen(String name, Client client) {
		this.name = name;
		this.client = client;
	}
	
	public void berechneKapital(){
		
	}
	
	

}
