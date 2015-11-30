package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import business.Kuehlraum;
import business.Standort;

public class KuehlraumTest {

	private Kuehlraum k1;
	
	@Before
	public void init(){
		k1 = new Kuehlraum(1000, 0, 500);
	}
	
	@Test
	public void testWareEinlagern() {
		k1.wareEinlagern(500);
		assertTrue("Test Ware einlagern", true == k1.wareEinlagern(500));
	}

	@Test
	public void testWareEntnehmen() {
		k1.wareEinlagern(500);
		int neuerInhalt = k1.wareEntnehmen(400);
		assertTrue("Test Ware entnehmen", 100 == neuerInhalt);
	}

	@Test
	public void testBerechneFreienLagerplatz() {
		k1.wareEinlagern(800);
		k1.setInhalt(k1.wareEntnehmen(400));
		int aktuellerLagerplatz = k1.berechneFreienLagerplatz();
		
		assertTrue("Test berechne freien Lagerpaltz", 600 == aktuellerLagerplatz);
	}
	
	//TODO Video bei 29.02 weiterschauen
	//TODO In Methoden mit IF-Verzeigung alle möglichen Eingaben testen

}
