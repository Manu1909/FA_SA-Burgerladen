package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Catering;
import backend.Datenbank;
import business.Unternehmen;

/**
 * @author entenmann
 *
 */
public class CateringTest {
	
	Unternehmen u1;
	Catering c1;
	Catering c2;
	
	@Before
	public void init(){
		u1 = new Unternehmen("test1");
		c1 = Datenbank.c1;
		c2 = Datenbank.c2;
	}

	@Test
	public void testAddName() {
		c1.addName(u1.getName());
		String nameUnternehmen = "";
		
		for (int i = 0; i < c1.getNamenUnternehmen().size(); i++) {
			nameUnternehmen = c1.getNamenUnternehmen().get(i);
		}
		
		assertTrue("Test addName", nameUnternehmen == "test1");
	}

	@Test
	public void testAddPreis() {
		c1.addPreis(5000);
		double preisUnternehmen = 0;
		
		for (int i = 0; i < c1.getPreisAngebote().size(); i++) {
			preisUnternehmen = c1.getPreisAngebote().get(i);
		}
		
		assertTrue("Test addPreis", preisUnternehmen == 5000);
	}

	@Test
	public void testAddQualitaet() {
		c1.addQualitaet(67);
		int qualitaetUnternehmen = 0;
		
		for (int i = 0; i < c1.getQualitaet().size(); i++) {
			qualitaetUnternehmen = c1.getQualitaet().get(i);
		}
		
		assertTrue("Test addQualit�t", qualitaetUnternehmen == 67);
	}

	@Test
	public void testBerechneBekanntheit() {
	
		Catering c = Datenbank.c2;
		int result = c.berechneBekanntheit(40);
		
		assertTrue("test berechneBekanntheit Catering", result == 46);
	}
	
	


	@Test
	public void testBerechneKundenzufriedenheit() {
		Catering c = Datenbank.c2;
		int result = c.berechneKundenzufriedenheit(40);
		
		assertTrue("test berechneBekanntheit Catering", result == 46);
	}

	@Test
	public void testVergleichePreisLeistung() {
		Unternehmen u2 = new Unternehmen("test2");
		
		c2.addName(u1.getName());
		c2.addPreis(10000);
		c2.addQualitaet(55);
		
		c2.addName(u2.getName());
		c2.addPreis(11000);
		c2.addQualitaet(55);
		
		String result = c2.vergleichePreisLeistung();
		
		assertTrue("Test vergleichePreisLeistung", result == "test1");

	}
		
	@Test
	public void testVergleichePreisLeistungOhneAngebote() {
		
		String result = Datenbank.c3.vergleichePreisLeistung();
		
		assertTrue("Test vergleichePreisLeistung", result == "Kein Angebot eingegangen");

	}

}
