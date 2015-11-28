package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Bestellung;
import business.Datenbank;
import business.Lieferant;
import business.Unternehmen;

public class BestellungTest {

	private Bestellung b;
	private Unternehmen u;
	
	@Before
	public void init(){
		u = new Unternehmen("test");
		b = new Bestellung(u);
		
		
		for(Lieferant fl:Datenbank.fl){
			fl.setVerbrauchteRessourcen(900);
		}
		
		for(Lieferant bl:Datenbank.bl){
			bl.setVerbrauchteRessourcen(900);
		}
		
		for(Lieferant sal:Datenbank.sal){
			sal.setVerbrauchteRessourcen(900);
		}
		
		for(Lieferant sol:Datenbank.sol){
			sol.setVerbrauchteRessourcen(900);
		}
	}
	
	@Test
	public void testSetzeBestellmenge() {
		b.setzeBestellmenge(700);
		assertEquals(0, b.getMenge());
		b.setzeBestellmenge(50);
		assertEquals(50, b.getMenge());
	}
	
	@Test
	public void testBestelle() {
		b.setzeBestellmenge(50);
		b.bestellen(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
		assertEquals(950, u.getFleischlieferant().getVertrauchteRessourcen());
		assertEquals(950, u.getBrotlieferant().getVertrauchteRessourcen());
		assertEquals(950, u.getSalatlieferant().getVertrauchteRessourcen());
		assertEquals(950, u.getSossenlieferant().getVertrauchteRessourcen());
	}
	
	

}
