package test;

import Controller.Controller;
import backend.Datenbank;
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

        Controller.setRunde(10);

        for (int i = 0; i < 3; i++) {
            Controller.neuesUnternehmen(new Unternehmen("u"+i));
            unternehmen.add(Controller.getUnternehmen(i));
            unternehmen.get(i).getBestellung().setzeLieferanten(Datenbank.fl[i], Datenbank.bl[i], Datenbank.sal[i], Datenbank.sol[i]);
            unternehmen.get(i).setStandort(Controller.waehleStandort(2));
            unternehmen.get(i).getStandort().setKuehlraum(Datenbank.kuehlraeume[2]);
            unternehmen.get(i).getStandort().getKuehlraum().setInhalt(6000);
            unternehmen.get(i).setBekanntheit(20 + i*10);
            unternehmen.get(i).setKundenzufriedenheitsVeraenderung(20+i*10);
            unternehmen.get(i).getBurger().setPreis(10);
            unternehmen.get(i).berechneBurgerQualitaet();
            unternehmen.get(i).berechneKundenzufriedenheit();
            unternehmen.get(i).getPersonal().setAnzahlAngestellte(10);
            unternehmen.get(i).getStandort().setInnenausstattung(Controller.waehleInnenausstattung(2));
        }


    }

    @Test
    public void testBerechneKunden() {
        //System.out.println("Kundenpool: " + Controller.berechneKundenpool());
        Controller.berechneKunden();
        /*for (int i = 0; i < unternehmen.size(); i++) {
            System.out.println("Kunden " + unternehmen.get(i).getName() + ": " + unternehmen.get(i).getKunden());
        }*/


        assertEquals(3916, unternehmen.get(0).getKunden(), 0);
        assertEquals(4666, unternehmen.get(1).getKunden(), 0);
        assertEquals(5415, unternehmen.get(2).getKunden(), 0);
    }

}
