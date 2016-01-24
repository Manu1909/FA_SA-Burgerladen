package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Personal;

public class PersonalTest {

	Personal p;
	
	@Before
	public void init(){
		p = new Personal(10);
	}
	
	@Test
	public void testGetAnzahlAngestellte(){
		assertTrue("Test getAnzahlAngestellte", 10 == p.getAnzahlAngestellte());
	}
	
	@Test 
	public void testSetAnzahlAngestellte(){
		p.setAnzahlAngestellte(11);;
		assertTrue("Test setAngestellte", 11 == p.getAnzahlAngestellte());
	}
	
	@Test
	public void testGetAnzahlGefeuerte(){
		assertTrue("Test getAnzahlGefeuerte", 0 == p.getAnzahlGefeuerte());
	}
	
	@Test 
	public void testSetAnzahlGefeuerte(){
		p.setAnzahlGefeuerte(11);;
		assertTrue("Test setAnzahlGefeuerte", 11 == p.getAnzahlGefeuerte());
	}
	
	@Test
	public void testBerechneKapazitaet(){
		assertTrue("Test berechneKapazitaet", 6000 == p.berechneKapazitaet());
	}

	@Test
	public void testErhoeheAnzahl(){
		assertTrue("Test erhoeheAnzahl", 11 == p.erhoeheAnzahl(1));
	}
	
	@Test 
	public void testBerechneAnzahl(){
		assertTrue("Test berechneAnzahl", 10 == p.berechneAnzahl());
	}
	
	@Test
	public void testBerechneKosten(){
		assertTrue("Test berechneKosten", 42000 == p.berechneKosten());
	}
	
	@Test 
	public void testFeuern(){
		assertTrue("Test Feuern", 3 == p.feuern(3));
	}
}
