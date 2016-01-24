package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.Datenbank;
import business.Ereignis;

public class EreignisTest {

	Ereignis e;
	
	@Before
	public void init(){
		Datenbank db = new Datenbank();
		e = db.getE1();
	}
	
	@Test
	public void testGetBekanntheit(){
		assertTrue("Test getBekanntheit", 30 == e.getBekanntheit());
	}
	
	@Test 
	public void testSetBekanntheit(){
		e.setBekanntheit(11);;
		assertTrue("Test setBekanntheit", 11 == e.getBekanntheit());
	}
	
	@Test
	public void testGetKundenzufriedenheit(){
		assertTrue("Test getKundenzufriedenheitsVeraenderung", 10 ==e.getKundenzufriedenheit());
	}
	
	@Test 
	public void testSetKundenzufriedenheit(){
		e.setKundenzufriedenheit(11);;
		assertTrue("Test setKundenzufriedenheitsVeraenderung", 11 == e.getKundenzufriedenheit());
	}
}
