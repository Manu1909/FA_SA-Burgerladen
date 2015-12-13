package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Datenbank;
import business.Ereignis;
import business.Personal;

public class EreignisTest {

	Ereignis e;
	Personal p;
	
	@Before
	public void init(){
		Datenbank db = new Datenbank();
		e = db.getE1();
		p = new Personal(10);
	}
	
	@Test
	public void testGetBekanntheit(){
		assertTrue("Test getBekanntheit", 10 == e.getBekanntheit());
	}
	
	@Test 
	public void testSetBekanntheit(){
		e.setBekanntheit(11);;
		assertTrue("Test setBekanntheit", 11 == e.getBekanntheit());
	}
	
	@Test
	public void testGetKundenzufriedenheit(){
		assertTrue("Test getKundenzufriedenheit", -20 ==e.getKundenzufriedenheit());
	}
	
	@Test 
	public void testSetKundenzufriedenheit(){
		e.setKundenzufriedenheit(11);;
		assertTrue("Test setKundenzufriedenheit", 11 == e.getKundenzufriedenheit());
	}
}
