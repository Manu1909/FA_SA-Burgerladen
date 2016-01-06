package test;

import Controller.Controller;
import backend.Datenbank;
import business.Kuehlraum;
import business.Unternehmen;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kochsiek on 28.12.2015.
 */
public class SpielablaufTest {

    ArrayList<Unternehmen> unternehmen =null;
    int anzahlRunden;
    Kuehlraum k;
    private static Kuehlraum[] kuehlraeume = Datenbank.kuehlraeume;
    private int[] startPreise = {10, 12, 14};
    private int bestellNummer;

   // @Before
    public void init(){

        unternehmen = new ArrayList<>();
        Controller.setRunde(anzahlRunden=0);

        for (int i = 0; i < 3; i++) {
            Controller.neuesUnternehmen(new Unternehmen("u"+i));
            unternehmen.add(Controller.getUnternehmen(i));
        }

        for (int i = 0; i < unternehmen.size(); i++) {
            unternehmen.get(i).getBestellung().setzeLieferanten(Datenbank.fl[i], Datenbank.bl[i], Datenbank.sal[i], Datenbank.sol[i]);
            unternehmen.get(i).setStandort(Controller.waehleStandort((i)));
            k = new Kuehlraum(kuehlraeume[2].getLagerGroesse(), 0, kuehlraeume[2].getMietZusatzKosten());
            unternehmen.get(i).getStandort().setKuehlraum(k);
            unternehmen.get(i).setKredit(Datenbank.k1);

            unternehmen.get(i).berechneKundenzufriedenheit();
            //System.out.println("Bekanntheit " + unternehmen.get(i).getName() + ": " + unternehmen.get(i).getBekanntheit());
            //System.out.println("Kundenzufriedenheit " + unternehmen.get(i).getName() + ": " + unternehmen.get(i).getKundenzufriedenheit() + "\n");
        }

        //unternehmen.get(0).setStandort(Datenbank.standorte[2]);
        unternehmen.get(0).getStandort().setInnenausstattung(Datenbank.i[2]);
        unternehmen.get(1).getStandort().setInnenausstattung(Datenbank.i[1]);
        unternehmen.get(2).getStandort().setInnenausstattung(Datenbank.i[0]);
    }

    @Test
    public void testSpielablauf() {

        init();
        simuliereSpielablauf(false);

        assertTrue("u1 soll gewonnen haben", unternehmen.get(1).getKapital()>unternehmen.get(0).getKapital() && unternehmen.get(1).getKapital()>unternehmen.get(2).getKapital());

        unternehmen = null;
    }

/*    @Test
    public void testSpielablaufMitEreignis(){
        //Spielablauf mit Ereignissen
        init();
        simuliereSpielablauf(true);
        unternehmen = null;
    }*/


    public void simuliereSpielablauf(boolean ereignis){
        while (anzahlRunden < 12) {
            for (int j = 0; j < Datenbank.fl.length; j++) {
                Datenbank.fl[j].setVerbrauchteRessourcen(0);
                Datenbank.bl[j].setVerbrauchteRessourcen(0);
                Datenbank.sal[j].setVerbrauchteRessourcen(0);
                Datenbank.sol[j].setVerbrauchteRessourcen(0);
            }


            for (int i = 0; i < unternehmen.size(); i++) {
                if(i==0){
                    bestellNummer = 0;
                }
                else{
                    bestellNummer = 2;
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
                        Datenbank.c2.addPreis(4000 + i*1000);
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

                if (anzahlRunden > 0 && ereignis){
                Controller.ereignisTrittEin();
                }


                //Setze Bestellmenge und bearbeite Personal
                int bestellMenge = 0;
                if(anzahlRunden < 3){
                    bestellMenge = 10000;
                }
                else if(anzahlRunden < 6){
                    bestellMenge = 4000;
                    u.getPersonal().berechneAnzahl();
                    u.getPersonal().erhoeheAnzahl(1);
                }
                else if(anzahlRunden<8){
                    bestellMenge = 5000;
                    u.getPersonal().berechneAnzahl();
                    u.getPersonal().erhoeheAnzahl(1);
                }
                else{
                    bestellMenge = 6000;
                    if(anzahlRunden%2==0){
                        u.getPersonal().berechneAnzahl();
                        //u.getPersonal().feuern(1);
                    }
                }


                if(u.getStandort().getKuehlraum().berechneFreienLagerplatz() < bestellMenge){
                    bestellMenge = u.getStandort().getKuehlraum().berechneFreienLagerplatz();
                }
                u.getBestellung().setzeBestellmenge(bestellMenge, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
                u.getStandort().getKuehlraum().wareEinlagern(u.getBestellung().getMenge());


                u.getBestellung().bestelleFleisch(Datenbank.fl[bestellNummer]);


                u.getBestellung().bestelleBrot(Datenbank.bl[bestellNummer]);


                u.getBestellung().bestelleSalat(Datenbank.sal[bestellNummer]);


                u.getBestellung().bestelleSosse(Datenbank.sol[bestellNummer]);

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
                /*if(anzahlRunden == 0){
                    u.getBurger().setPreis(startPreise[i]);
                }
                if(anzahlRunden%2 == 1){
                    u.getBurger().setPreis(startPreise[i] + anzahlRunden/2);
                }*/

                //u.getBurger().setPreis(startPreise[i] + anzahlRunden);
                u.getBurger().setPreis(startPreise[i]);

                Controller.unternehmensRundeBeenden(u);

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

                if(anzahlRunden == 10){
                    Controller.berechneKunden();
                }


                System.out.println("Miete: "+ u.getName()+ ": " + u.getStandort().getMiete());
                System.out.println("Personalkosten: "+ u.getName()+ ": " + u.getPersonal().berechneKosten());
                System.out.println("Anzahl Personal: "+ u.getName()+ ": " + u.getPersonal().berechneAnzahl());
                if(u.getMarketing() != null){
                    System.out.println("Marketing: " + u.getMarketing().getKosten());
                }
                System.out.println("Bestellungspreis: "+ u.getName()+ ": " + u.getBestellung().berechneGesamtpreis());
                System.out.println("Gesamtkosten: "+ u.getName()+ ": " + u.berechneRundenkosten() + "\n");
                System.out.println("Burger Preis " + u.getName()+ ": " + u.getBurger().getPreis());
                System.out.println("Burger Preisleistung " + u.getName()+ ": " + u.getBurger().berechnePreisleistung());
                System.out.println("Preispunkte "+ u.getName()+ ": " + u.getBurger().berechnePreisPunkte());
                System.out.println("Kundenanteil: " + u.getName()+ ": " + u.berechneKundenanteil());
                System.out.println("Anzahl Kunden " + u.getName() + ": " + u.getKunden());
                System.out.println("Gewinn " + u.getName() + ": " + u.berechneGewinn(anzahlRunden));
                System.out.println("Kapital " + u.getName() + ": " + u.berechneKapital(false));
                System.out.println("Bekanntheit " + u.getName() + ": " + u.getBekanntheit());
                System.out.println("Kundenzufriedenheit " + u.getName() + ": " + u.getKundenzufriedenheit() + "\n");
                //System.out.println("Preise Lieferant2: " + Datenbank.fl[2].getPreisProGut() +"\n");

                u.setCatering(null);
                u.setMarketing(null);
            }

            //Berechne neue Lieferantenpreise
            for (int j = 0; j < Datenbank.fl.length; j++) {
                Datenbank.fl[j].berechneNeuenPreis();
                Datenbank.bl[j].berechneNeuenPreis();
                Datenbank.sal[j].berechneNeuenPreis();
                Datenbank.sol[j].berechneNeuenPreis();
            }
            Controller.setRunde(++anzahlRunden);

        }
    }


}
