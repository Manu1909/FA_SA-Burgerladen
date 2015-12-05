package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Standort;

public class InnenausstattungTest {

	Standort s1;
	
	@Before
	public void init(){
		s1 = new Standort("Quadrate", 3000, 4, 3);
		s1.setInnenausstattung(new business.Innenausstattung("Modern", 3000, 50000));
	}
	
	@Test
	public void testGetBezeichnung(){
		assertTrue("Test getBezeichnung", "Modern" == s1.getInnenausstattung().getBezeichnung());
	}
	
	@Test 
	public void testSetBezeichnung(){
		s1.getInnenausstattung().setBezeichnung("Alternativ");
		assertTrue("Test setBezeichnung", "Alternativ" == s1.getInnenausstattung().getBezeichnung());
	}
	
	@Test
	public void testGetGroe�eKundenpool() {
		assertTrue("Test getGroe�eKundenpool", 3000 == s1.getInnenausstattung().getGroe�eKundenpool());
	}

	@Test
	public void testSetGroe�eKundenpool() {
		s1.getInnenausstattung().setGroe�eKundenpool(4000);
		assertTrue("Test setGroe�eKundenpool", 4000 == s1.getInnenausstattung().getGroe�eKundenpool());
	}

	@Test
	public void testGetKosten() {
		assertTrue("Test getKosten", 50000 == s1.getInnenausstattung().getKosten());
	}

	@Test
	public void testSetKosten() {
		s1.getInnenausstattung().setKosten(40000);
		assertTrue("Test setGroe�eKundenpool", 40000 == s1.getInnenausstattung().getKosten());
	}

}
