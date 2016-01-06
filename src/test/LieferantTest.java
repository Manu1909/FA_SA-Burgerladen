package test;
import static org.junit.Assert.*;

import backend.Datenbank;
import org.junit.Before;
import org.junit.Test;

import business.Bestellung;
import business.Lieferant;
import business.Unternehmen;

public class LieferantTest {

	private Lieferant l;
	private Bestellung b;
	private Unternehmen u;
	private double startPreis;
	
	@Before
	public void init(){
		l = Datenbank.fl1;
		u = new Unternehmen("test");
		startPreis = l.getPreisProGut();
		//b = new Bestellung(u);

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
	public void testHoehererPreis() {
		l.setVerbrauchteRessourcen(8000);
		assertTrue("Test Preiserhoehung", l.getPreisProGut()<l.berechneNeuenPreis());

		l.setPreisProGut(startPreis);
	}

	@Test
	public void testNiedrigererPreis() {
		l.setVerbrauchteRessourcen(4000);
		assertTrue("Test niedrigerer Preis", l.getPreisProGut()>l.berechneNeuenPreis());

		l.setPreisProGut(startPreis);
	}

	@Test
	public void testErhoehungsGrenze() {
		l.setVerbrauchteRessourcen(20000);
		for (int i = 0; i < 5; i++) {
			l.berechneNeuenPreis();
		}
		assertEquals(startPreis*1.3, l.berechneNeuenPreis(), 0);

		l.setPreisProGut(startPreis);
	}

}
