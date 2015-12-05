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
	public void testGetBurgerKapazit�t(){
		assertTrue("Test getBurgerKapazit�t", 0 ==p.getBurgerKapazit�t());
	}
	
	@Test 
	public void testSetBurgerKapazit�t(){
		p.setBurgerKapazit�t(11);;
		assertTrue("Test setBurgerKapazit�t", 11 == p.getBurgerKapazit�t());
	}

	@Test
	public void testErh�heAnzahl(){
		assertTrue("Test erh�heAnzahl", 11 == p.erh�heAnzahl());
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
