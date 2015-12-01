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
	
	//Test für Ware einlagern
	@Test
	public void testWareEinlagern() {
		int neuerInhalt = k1.wareEinlagern(500);
		assertTrue("Test Ware einlagern", 500 == neuerInhalt);
	}

	@Test
	public void testWareEinlagernMenge(){
		k1.setInhalt(500);
		int neuerInhalt = k1.wareEinlagern(600);
		assertTrue("Test Ware einlagern Menge zu groß", 500 == neuerInhalt);
	}
	
	@Test
	public void testWareEinlagernNegativ(){
		k1.setInhalt(500);
		int neuerInhalt = k1.wareEinlagern(-100);
		assertTrue("Test Ware einlagern Menge zu groß", 500 == neuerInhalt);
	}
	
	@Test
	public void testWareEinlagernNull(){
		k1.setInhalt(500);
		int neuerInhalt = k1.wareEinlagern(0);
		assertTrue("Test Ware einlagern Menge zu groß", 500 == neuerInhalt);
	}
		
	
	//Test für Ware entnehmen
	@Test
	public void testWareEntnehmen() {
		k1.setInhalt(500);
		int neuerInhalt = k1.wareEntnehmen(400);
		assertTrue("Test Ware entnehmen", 100 == neuerInhalt);
	}
	
	@Test
	public void testWareEntnehmenOver(){
		k1.setInhalt(600);
		int neuerInhalt = k1.wareEntnehmen(700);
		assertTrue("Test Entnahme Menge zu groß", 600 == neuerInhalt);
	}
	
	@Test
	public void testWareEntnehmenNegativ(){
		k1.setInhalt(500);
		int neuerInhalt = k1.wareEntnehmen(-200);
		assertTrue("Test Entnahme Menge negativ", 500 == neuerInhalt);
	}
	
	@Test
	public void testWareEntnehmenNull(){
		k1.setInhalt(500);
		int neuerInhalt = k1.wareEntnehmen(0);
		assertTrue("Test Entnahme Menge negativ", 500 == neuerInhalt);
	}
	

	
	//Test für Berechnung des Lagerplatzes
	@Test
	public void testBerechneFreienLagerplatz() {
		k1.setInhalt(800);
		k1.setInhalt(k1.wareEntnehmen(400));
		int aktuellerLagerplatz = k1.berechneFreienLagerplatz();
		
		assertTrue("Test berechne freien Lagerpaltz", 600 == aktuellerLagerplatz);
	}
	

	//TODO In Methoden mit IF-Verzeigung alle möglichen Eingaben testen
	//TODO Fragen nach Tests mit Paramtern
	//TODO Fragen nach try-catch
	
}
