package test;

import static org.junit.Assert.*;

import backend.Datenbank;
import business.*;
import org.junit.Before;
import org.junit.Test;

public class BestellungTest {

	//private Bestellung b;
	private Unternehmen u;
	
	@Before
	public void init(){
		u = new Unternehmen("test");
		Kuehlraum k3 = new Kuehlraum(2000, 0, 800);
		Standort s4 = new Standort("Quadrate",1300, 3, 4);
		s4.setKuehlraum(k3);
		u.setStandort(s4);

	}
	
	@Test
	public void testSetzeBestellmenge() {
		u.getBestellung().setzeBestellmenge(7000, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		assertTrue("Bestellung zu groß", 0==u.getBestellung().getMenge());
		u.getBestellung().setzeBestellmenge(50, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		assertTrue("Bestellmenge ok", 50==u.getBestellung().getMenge());
	}
	
	@Test
	public void testBestelle() {
		u.getBestellung().setzeBestellmenge(950, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		u.getBestellung().bestellen(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
		assertEquals(950, u.getBestellung().getFleischlieferant().getVertrauchteRessourcen(), 0);
		assertEquals(950, u.getBestellung().getBrotlieferant().getVertrauchteRessourcen(), 0);
		assertEquals(950, u.getBestellung().getSalatlieferant().getVertrauchteRessourcen(), 0);
		assertEquals(950, u.getBestellung().getSossenlieferant().getVertrauchteRessourcen(), 0);
	}

	@Test
	public void testBerechneKosten() {
		u.getBestellung().setzeBestellmenge(2000, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
		u.getBestellung().bestellen(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
		//assertTrue("Test berechne Bestellkosten", 1940 == u.getBestellung().berechneGesamtpreis());
		assertEquals(1940, u.getBestellung().berechneGesamtpreis(), 0);

	}
	
	

}
