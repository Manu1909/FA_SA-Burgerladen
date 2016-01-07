package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Burger;
import backend.Datenbank;
import business.Unternehmen;

public class BurgerTest {

	private Unternehmen u;
	
	@Before
	public void init(){
		u = new Unternehmen("test");
		u.getBestellung().setzeLieferanten(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
		u.getBurger().setPreis(15);
	}

	@Test
	public void testBerechneQualitaet() {
		assertTrue("Teste Qualität", 25==u.berechneBurgerQualitaet());
	}

	@Test
	public void testBerechnePreispunkte() {
		assertEquals(16, u.getBurger().berechnePreisPunkte(), 0);
	}

	@Test
	public void testBerechnePreisleistung() {
		u.berechneBurgerQualitaet();
		assertEquals(19, u.getBurger().berechnePreisleistung(), 0);
	}

}
