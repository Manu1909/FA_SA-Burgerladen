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
		Datenbank db = new Datenbank();
		k = db.getK1();
		u = new Unternehmen("test");
		u.waehleKredit(k);
	}

	@Test
	public void testBerechneAnnuitaet() {
		assertTrue("Test berechneAnnuitaet", 2631.62 == k.berechneAnnuitaet());
	}

}
