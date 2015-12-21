package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Bestellung;
import business.Lieferant;
import business.Unternehmen;

public class LieferantTest {

	private Lieferant l;
	private Bestellung b;
	private Unternehmen u;
	
	@Before
	public void init(){
		l = new Lieferant(1000, 3, 0.3, 5, 0);
		u = new Unternehmen("test");
		//b = new Bestellung(u);
		
		l.setVerbrauchteRessourcen(920);
	}

	//Die beiden Tests wären nur von Nöten, wenn Lieferanten begrenzte Ressourcen hätten
	/*@Test
	public void testUebrigeRessourcen() {
		assertEquals(80, l.berechneUebrigeRessourcen());
	}*/
	
	/*@Test
	public void testCheckRessourcen() {
		assertEquals(false, l.checkRessourcen(100));
		assertEquals(true, l.checkRessourcen(20));
	}*/

	@Test
	public void testBerechneNeuenPreis() {
		l.setVerbrauchteRessourcen(520);
		assertTrue("Test Preisberechnung", 0.27==l.berechneNeuenPreis());

	}

}
