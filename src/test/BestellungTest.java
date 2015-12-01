package test;

import static org.junit.Assert.*;

import business.*;
import org.junit.Before;
import org.junit.Test;

public class BestellungTest {

	//private Bestellung b;
	private Unternehmen u;
	
	@Before
	public void init(){
		u = new Unternehmen("test");
		//b = new Bestellung(u);
		Kuehlraum k3 = new Kuehlraum(2000, 0, 800);
		Standort s4 = new Standort("Quadrate",1300, 3, 4);
		s4.setKuehlraum(k3);
		u.setStandort(s4);
		//u.getStandort().setKuehlraum(k3);
		
		
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
		u.getBestellung().setzeBestellmenge(700, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		assertTrue("Bestellung zu groß", 0==u.getBestellung().getMenge());
		u.getBestellung().setzeBestellmenge(50, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		assertTrue("Bestellmenge ok", 50==u.getBestellung().getMenge());
	}
	
	@Test
	public void testBestelle() {
		u.getBestellung().setzeBestellmenge(50, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		u.bestellen(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
		assertEquals(950, u.getFleischlieferant().getVertrauchteRessourcen());
		assertEquals(950, u.getBrotlieferant().getVertrauchteRessourcen());
		assertEquals(950, u.getSalatlieferant().getVertrauchteRessourcen());
		assertEquals(950, u.getSossenlieferant().getVertrauchteRessourcen());
	}
	
	

}
