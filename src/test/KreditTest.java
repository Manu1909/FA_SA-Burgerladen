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
		k = new Kredit(8, 10, 8000);
		u = new Unternehmen("test");
		u.waehleKredit(Datenbank.k1);
	}

	@Test
	public void testBerechneZinsen() {
		k.berechneZinsen();
		assertEquals(1100.0, k.getZinsen(), 1);
	}

}
