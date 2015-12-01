package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Kredit;
import business.Datenbank;
import business.Unternehmen;

public class KreditTest {
	
	private Kredit k;
	private Unternehmen u;
	
	@Before
	public void init(){
		k = new Kredit(0, 0, 0);
		u = new Unternehmen("test");
		u.waehleKredit(Datenbank.k1);
	}

	@Test
	public void testBerechneZinsen() {
		double zins = k.berechneZinsen(u);
		assertEquals(1100.0, zins, 1);
	}

}
