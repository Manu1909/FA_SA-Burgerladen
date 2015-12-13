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
		l = new Lieferant(1000, 3, 0.3, 5);
		u = new Unternehmen("test");
		//b = new Bestellung(u);
		
		l.setVerbrauchteRessourcen(920);
	}
	
	@Test
	public void testUebrigeRessourcen() {
		assertEquals(80, l.uebrigeRessourcen());
	}
	
	@Test
	public void testCheckRessourcen() {
		assertEquals(false, l.checkRessourcen(100));
		assertEquals(true, l.checkRessourcen(20));
	}

}
