package test;

import Controller.Controller;
import business.Datenbank;
import business.Kuehlraum;
import business.Unternehmen;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by kochsiek on 28.12.2015.
 */
public class SpielablaufTest {

    ArrayList<Unternehmen> unternehmen = new ArrayList<>();
    int anzahlRunden;
    Kuehlraum k;
    private static Kuehlraum[] kuehlraeume = Datenbank.kuehlraeume;
    private int[] startPreise = {6, 8, 10};

    @Before
    public void init(){

        anzahlRunden = 0;

        for (int i = 0; i < 3; i++) {
            Controller.neuesUnternehmen(new Unternehmen("u"+i));
            unternehmen.add(Controller.getUnternehmen(i));
        }

        for (int i = 0; i < unternehmen.size(); i++) {
            unternehmen.get(i).getBestellung().setzeLieferanten(Datenbank.fl[i], Datenbank.bl[i], Datenbank.sal[i], Datenbank.sol[i]);
            unternehmen.get(i).setStandort(Datenbank.standorte[i]);
            k = new Kuehlraum(kuehlraeume[2].getLagerGroesse(), 0, kuehlraeume[2].getMietZusatzKosten());
            unternehmen.get(i).getStandort().setKuehlraum(k);

            unternehmen.get(i).berechneKundenzufriedenheit();
            //System.out.println("Bekanntheit " + unternehmen.get(i).getName() + ": " + unternehmen.get(i).getBekanntheit());
            //System.out.println("Kundenzufriedenheit " + unternehmen.get(i).getName() + ": " + unternehmen.get(i).getKundenzufriedenheit() + "\n");
        }

        unternehmen.get(0).setStandort(Datenbank.standorte[2]);
        unternehmen.get(0).getStandort().setInnenausstattung(Datenbank.i[2]);
        unternehmen.get(1).getStandort().setInnenausstattung(Datenbank.i[1]);
        unternehmen.get(2).getStandort().setInnenausstattung(Datenbank.i[0]);

        Controller.unternehmen = unternehmen;
    }

    @Test
    public void testSpielablauf() {

        while (anzahlRunden < 1) {
            for (int i = 0; i < unternehmen.size(); i++) {


                for (int j = 0; j < Datenbank.fl.length; j++) {
                    Datenbank.fl[j].setVerbrauchteRessourcen(0);
                    Datenbank.bl[j].setVerbrauchteRessourcen(0);
                    Datenbank.sal[j].setVerbrauchteRessourcen(0);
                    Datenbank.sol[j].setVerbrauchteRessourcen(0);
                }

                Unternehmen u = unternehmen.get(i);

                //Catering
                if (anzahlRunden == 3) {
                    //1. Catering
                    int eingabe = 1;

                    u.berechneCateringKosten(Datenbank.c1);

                    if (eingabe == 1) {
                        //Preisangebot für Catering
                        Datenbank.c1.addName(u.getName());
                        Datenbank.c1.addPreis(5000);
                        Datenbank.c1.addQualitaet(u.getBurger().getQualitaet());
                    }
                } else if (anzahlRunden == 6) {

                    //2. Catering
                    int eingabe = 1;

                    u.berechneCateringKosten(Datenbank.c2);

                    if (eingabe == 1) {
                        //Preisangebot für Catering
                        Datenbank.c2.addName(u.getName());
                        Datenbank.c2.addPreis(5000);
                        Datenbank.c2.addQualitaet(u.getBurger().getQualitaet());
                    }


                } else if (anzahlRunden == 9) {

                    //3. Catering
                    int eingabe = 1;

                    u.berechneCateringKosten(Datenbank.c3);

                    if (eingabe == 1) {
                        //Preisangebot für Catering
                        Datenbank.c3.addName(u.getName());
                        Datenbank.c3.addPreis(5000);
                        Datenbank.c3.addQualitaet(u.getBurger().getQualitaet());
                    }

                }

                Controller.ereignisTrittEin();

                //Personal bearbeiten
                /*u.getPersonal().berechneAnzahl();
                u.getPersonal().erhoeheAnzahl(2);
                u.getPersonal().feuern(1);*/


                //LieferantenBestellung

                //Setze Bestellmenge und bearbeite Personal
                int bestellMenge = 0;
                if(anzahlRunden<3){
                    bestellMenge = 1500;
                }
                else if(anzahlRunden < 6){
                    bestellMenge = 2300;
                    u.getPersonal().erhoeheAnzahl(1);
                }
                else{
                    bestellMenge = 3000;
                    if(anzahlRunden%2==0){
                        u.getPersonal().feuern(1);
                    }
                }



                u.getBestellung().setzeBestellmenge(bestellMenge, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
                u.getStandort().getKuehlraum().wareEinlagern(u.getBestellung().getMenge());


                u.getBestellung().bestelleFleisch(Datenbank.fl[i]);


                u.getBestellung().bestelleBrot(Datenbank.bl[i]);


                u.getBestellung().bestelleSalat(Datenbank.sal[i]);


                u.getBestellung().bestelleSosse(Datenbank.sol[i]);

                u.getBestellung().berechneGesamtpreis();
                u.berechneBurgerQualitaet();


                //Marketingauswahl
                int eingabe = -1;
                if(anzahlRunden == 0){
                    eingabe = 0;
                }

                if(anzahlRunden == 3 && i==0){
                    eingabe = 1;
                }

                if(anzahlRunden == 6 && i==0){
                    eingabe = 2;
                }

                if (eingabe != -1) {
                    u.setMarketing(Controller.waehleMarketing(eingabe));
                    u.betreibeMarketing();
                }

                u.berechneRundenkosten();

                //Setze BurgerPreis
                u.getBurger().setPreis(startPreise[i] + anzahlRunden/2);

                u.berechneKundenzufriedenheit();
            }

            //Catering aufrufen
            if (anzahlRunden == 3 || anzahlRunden == 6 || anzahlRunden == 9) {
                Controller.cateringAuswahlTreffen(anzahlRunden);
            }
            Controller.berechneKunden();

            //Zeige RundenGewinn und Anzahl Kunden
            for (int i = 0; i < unternehmen.size(); i++) {
                System.out.println("Runde: " + anzahlRunden);
                Unternehmen u = unternehmen.get(i);
                System.out.println("Anzahl Kunden " + u.getName() + ": " + u.getKunden());
                System.out.println("Gewinn " + u.getName() + ": " + u.berechneGewinn(anzahlRunden));
                System.out.println("Bekanntheit " + u.getName() + ": " + u.getBekanntheit());
                System.out.println("Kundenzufriedenheit " + u.getName() + ": " + u.getKundenzufriedenheit() + "\n");

                u.setCatering(null);
            }

            //Berechne neue Lieferantenpreise
            for (int j = 0; j < Datenbank.fl.length; j++) {
                Datenbank.fl[j].berechneNeuenPreis();
                Datenbank.bl[j].berechneNeuenPreis();
                Datenbank.sal[j].berechneNeuenPreis();
                Datenbank.sol[j].berechneNeuenPreis();
            }
            anzahlRunden++;

        }


    }




}
