package test;

import Controller.Controller;
import business.Datenbank;
import business.Unternehmen;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kochsiek on 22.12.2015.
 */
public class ControllerTest {

    ArrayList<Unternehmen> unternehmen= new ArrayList<>();


    @Before
    public void init(){


        for (int i = 0; i < 3; i++) {
            Controller.neuesUnternehmen(new Unternehmen("u"+i));
            unternehmen.add(Controller.getUnternehmen(i));
        }

        for (Unternehmen u:unternehmen) {
            u.getBestellung().setzeLieferanten(Datenbank.fl1, Datenbank.bl1, Datenbank.sal1, Datenbank.sol1);
            u.setStandort(Datenbank.standorte[1]);
            u.getStandort().setKuehlraum(Datenbank.kuehlraeume[2]);
            u.getStandort().getKuehlraum().setInhalt(5000);
            u.setBekanntheit(50);
            u.setKundenzufriedenheitsVeraenderung(50);
            u.getBurger().setPreis(10);
        }

    }

    @Test
    public void testBerechneKunden() {
        Controller.berechneKunden();
        assertEquals(1932, unternehmen.get(1).getKunden());
    }

}
