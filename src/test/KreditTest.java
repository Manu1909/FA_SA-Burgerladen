package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Kredit;
import backend.Datenbank;
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
	
	@Test
	public void testBerechneZinsaufwand() {
		k.setAnnuitaet(2631.62);
		assertTrue("Test berechneZinsaufwand", 131.62 == k.berechneZinsaufwand());
	}
	
	@Test
	public void testBerechneBereinigteAnnuitaet() {
		k.setZinsaufwand(131.62);
		assertTrue("Test berechneBereinigteAnnuitaet", 2500 == k.berechneBereinigteAnnuitaet());
	}
}
