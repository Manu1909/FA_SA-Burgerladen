package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import business.Catering;
import business.Unternehmen;

public class CateringTest {
	
	Unternehmen u1;
	Unternehmen u2;
	Catering c1;
	
	@Before
	public void init(){
		c1 = new Catering("Catering Geburtstag", 500, 2000);
		u1 = new Unternehmen("Burgerbude1");
		u2 = new Unternehmen("Burgerbude2");
	}

	@Test
	@Ignore
	public void testCatering() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetBezeichnung() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetMindestAngebot() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetAnzahlBurger() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetPreis() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSetPreis() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetNamenUnternehmen() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetPreisAngebote() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSetPreisAngebote() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetQualitaet() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAddName() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAddPreis() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAddQualitaet() {
		fail("Not yet implemented");
	}

	@Test
	public void testVergleichePreisLeistung() {
		c1.addName(u1.getName());
		c1.addPreis(5000);
		c1.addQualitaet(60);
		
		c1.addName(u2.getName());
		c1.addPreis(3000);
		c1.addQualitaet(50);
		
		String ergebnis = c1.vergleichePreisLeistung();
		
		assertTrue("Test vergleiche Catering Angebote", "Burgerbude2" == ergebnis);
		
	}
	
	@Test
	public void testVergleichePreisLeistungOhneAngebot() {	
		String ergebnis = c1.vergleichePreisLeistung();
		
		assertTrue("Test vergleiche Catering Angebote ohne Wert", "Kein Angebot eingegangen" == ergebnis);
		
	}

}
