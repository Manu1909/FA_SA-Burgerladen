package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import business.Kuehlraum;
import business.Standort;

public class StandortTest {

	private Standort s1;
	
	@Before
	public void init() {
		s1 = new Standort("Planken", 1100, 3, 5);
	}

	@Test
	public void testBerechneMiete() {
		s1.setKuehlraum(new Kuehlraum(1000, 0, 500));
		s1.berechneMiete();
		assertTrue("Test berechne Miete", 1600 == s1.getMiete());
	}
	
	@Test(expected=RuntimeException.class)
	public void testBerechneMieteKeinKuehlraum(){
		double miete = s1.berechneMiete();
	}


}
