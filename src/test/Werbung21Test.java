package test;
import static org.junit.Assert.*;

import business.Marketing;
import business.Unternehmen;
import business.Werbung21;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by kochsiek on 05.12.2015.
 */
public class Werbung21Test {
    Unternehmen u;
    Marketing werbung21;

    @Before
    public void init(){
        u = new Unternehmen("test");
        werbung21 = new Werbung21();
        u.setMarketing(werbung21);
        u.setBekanntheit(50);
        u.setKundenzufriedenheitsVeraenderung(50);
    }

    @Test
    public void testBetreibeMarketing(){
        u.betreibeMarketing();
        assertTrue("Test betreibe Marketing (Bekanntheit)", 55==u.getBekanntheit());
        assertTrue("Test betreibe Marketing (Kundenzufriedenheit)", 55==u.getKundenzufriedenheitsVeraenderung());
    }

    /*@Test
    public void testBerechneGewinn(){
        u.berechneGewinn();
    }*/
}
