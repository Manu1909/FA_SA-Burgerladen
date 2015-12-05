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
	public void testGetKosten(){
		assertTrue("Test getKosten", 0 ==p.getKosten());
	}
	
	@Test 
	public void testSetKosten(){
		p.setKosten(11);;
		assertTrue("Test setKosten", 11 == p.getKosten());
	}

	@Test
	public void testGetBurgerKapazität(){
		assertTrue("Test getBurgerKapazität", 0 ==p.getBurgerKapazität());
	}
	
	@Test 
	public void testSetBurgerKapazität(){
		p.setBurgerKapazität(11);;
		assertTrue("Test setBurgerKapazität", 11 == p.getBurgerKapazität());
	}

	@Test
	public void testErhöheAnzahl(){
		assertTrue("Test erhöheAnzahl", 11 == p.erhöheAnzahl());
	}
	
	@Test 
	public void testBerechneAnzahl(){
		assertTrue("Test berechneAnzahl", 10 == p.berechneAnzahl());
	}
	
	@Test
	public void testBerechneKosten(){
		assertTrue("Test berechneKosten", 10000 == p.berechneKosten());
	}
	
	@Test 
	public void testFeuern(){
		assertTrue("Test Feuern", 3 == p.feuern(3));
	}

	@Test
	public void testBerechneAnzahlBurger(){
		assertTrue("Test berechneAnzahlBurger", 1000 == p.berechneAnzahlBurger());
	}
}
