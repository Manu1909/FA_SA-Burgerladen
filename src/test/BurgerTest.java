package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Burger;
import business.Datenbank;
import business.Unternehmen;

public class BurgerTest {
	
	private Burger b;
	private Unternehmen u;
	
	@Before
	public void init(){
		u = new Unternehmen("test");
		u.setzeLieferanten(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
	}

	@Test
	public void testBerechneQualitaet() {
		
		//assertEquals(3, b.getQualitaet());
		assertTrue("Teste Qualität", 3==u.berechneBurgerQualität());
	}

}
