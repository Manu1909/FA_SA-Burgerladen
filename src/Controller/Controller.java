package Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import backend.Datenbank;
import business.*;

public class Controller {

	//Variablen für Spielablauf
	private static final int gesamtSpielRunden = 12;
	private static int spielRunde = 0;
	
	//Hier werden alle teilnehmende Unternehmen gespeichert
	private static ArrayList<Unternehmen> unternehmen = new ArrayList<>();
	
	//Daten aus der Datenbank
	private static Kuehlraum[] kuehlraeume = Datenbank.kuehlraeume;
	private static Standort[] standorte = Datenbank.standorte;
	private static Innenausstattung[] innenausstattung = Datenbank.i;
	private static Ereignis[] ereignis = Datenbank.e;
	private static Lieferant[] fl = Datenbank.fl;
	private static Scanner scanner = new Scanner(System.in);
	private static int anzahlRunden = 0;
	private static boolean neuerSpieler = true;
	private static boolean lieferantOK;
	private static int kundenpool;
	private static int [] risikoEingetreten = new int [10];
	
	public static void main(String args[]){
		startGame();
		simuliereSpiel();
	}
	
	public static void setRunde(int z)
	{
		anzahlRunden = z;
	}
	
	public static int getRunde()
	{
		return anzahlRunden;
	}
	
	public static Unternehmen getUnternehmen(int n)
	{
		return unternehmen.get(n);
	}
	
	public static void neuesUnternehmen(Unternehmen p)
	{
		unternehmen.add(p);
	}
	
	//Methoden die das Spiel simulieren
	public static void simuliereSpiel(){

		
		while(anzahlRunden < 12){
			for (int j = 0; j < Datenbank.fl.length; j++) {
				Datenbank.fl[j].setVerbrauchteRessourcen(0);
				Datenbank.bl[j].setVerbrauchteRessourcen(0);
				Datenbank.sal[j].setVerbrauchteRessourcen(0);
				Datenbank.sol[j].setVerbrauchteRessourcen(0);
			}
			for (int i = 0; i < unternehmen.size(); i++) {
				if(anzahlRunden == 0){
					startGame();
				}else{


					Unternehmen u = unternehmen.get(i);


					if(anzahlRunden == 3){
						System.out.println("Für die " + Datenbank.c1.getBezeichnung() + "wurde angefragt ob Sie zusätzlich zu Ihrem Tagesgeschäft ein Caterin übernehmen wollen?");
						System.out.println("Wollen Sie ein Angebot für das Catering abgeben Ja = 1 und Nein = 0");
						int eingabe = scanner.nextInt();

						System.out.println("Ihre aktuelle Burger Qualität: " + u.getBurger().getQualitaet() + "/100");
						System.out.println("Bei Ihren aktuellen Lieferanten müssen Sie mit Kosten rechnen in Höhe von: " + u.berechneCateringKosten(Datenbank.c3));

						if(eingabe == 1){
							Datenbank.c1.addName(u.getName());
							System.out.println("Geben Sie hier Ihr Angebot ab");
							Datenbank.c1.addPreis(scanner.nextDouble());
							Datenbank.c1.addQualitaet(u.getBurger().getQualitaet());
						}
					}else if(anzahlRunden == 6){
						System.out.println("Für die " + Datenbank.c2.getBezeichnung() + "wurde angefragt ob Sie zusätzlich zu Ihrem Tagesgeschäft ein Caterin übernehmen wollen?");
						System.out.println("Wollen Sie ein Angebot für das Catering abgeben Ja = 1 und Nein = 0");
						int eingabe = scanner.nextInt();

						System.out.println("Ihre aktuelle Burger Qualität: " + u.getBurger().getQualitaet() + "/100");
						System.out.println("Bei Ihren aktuellen Lieferanten müssen Sie mit Kosten rechnen in Höhe von: " + u.berechneCateringKosten(Datenbank.c2));

						if(eingabe == 1){
							Datenbank.c2.addName(u.getName());
							System.out.println("Geben Sie hier Ihr Angebot ab");
							Datenbank.c2.addPreis(scanner.nextDouble());
							Datenbank.c2.addQualitaet(u.getBurger().getQualitaet());
						}

					}else if(anzahlRunden == 9){
						System.out.println("Für die " + Datenbank.c3.getBezeichnung() + "wurde angefragt ob Sie zusätzlich zu Ihrem Tagesgeschäft ein Caterin übernehmen wollen?");
						System.out.println("Wollen Sie ein Angebot für das Catering abgeben Ja = 1 und Nein = 0");
						int eingabe = scanner.nextInt();

						System.out.println("Ihre aktuelle Burger Qualität: " + u.getBurger().getQualitaet() + "/100");
						System.out.println("Bei Ihren aktuellen Lieferanten müssen Sie mit Kosten rechnen in Höhe von: " + u.berechneCateringKosten(Datenbank.c3));

						if(eingabe == 1){
							Datenbank.c3.addName(u.getName());
							System.out.println("Geben Sie hier Ihr Angebot ab");
							Datenbank.c3.addPreis(scanner.nextDouble());
							Datenbank.c3.addQualitaet(u.getBurger().getQualitaet());
						}
					}

					//Hier muss restliche Spiellogik entstehen
					ereignisTrittEin(0);

					//Personal bearbeiten
					System.out.println("M�chten sie Personal einstellen?");
					System.out.println("Aktuelle Anzahl: " + u.getPersonal().berechneAnzahl());
					System.out.println("Diesen Monat abgehauen: " + u.getPersonal().getAnzahlGefeuerte());
					System.out.print("Wie viele?");
					int eingabe;
					do{
						eingabe = scanner.nextInt();
						System.out.println("neue Anzahl: " + u.getPersonal().erhoeheAnzahl(eingabe));
					} while (u.getPersonal().getAnzahlAngestellte() + eingabe > 30);
					System.out.println("M�chten Sie Leute feuern?\nSie werden in der folgenden Periode gefeuert.");
					System.out.println("Wie viele?");
					do{
						eingabe = scanner.nextInt();
						u.getPersonal().feuern(eingabe);
					}while (u.getPersonal().getAnzahlAngestellte() - eingabe < 5);
					System.out.println("Neue Anzahl: " + u.getPersonal().getAnzahlAngestellte());
					System.out.println("Neue Personalkosten: " + u.getPersonal().berechneKosten());

					//LieferantenBestellung
					System.out.println("\nBitte wählen sie im Folgenden, für wie viele Burger sie Zutaten in dieser Periode kaufen wollen");

					int bestellMenge = 0;
					do{
						bestellMenge = scanner.nextInt();

						u.getBestellung().setzeBestellmenge(bestellMenge, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
						u.getStandort().getKuehlraum().wareEinlagern(u.getBestellung().getMenge());
						if (bestellMenge > u.getPersonal().berechneKapazitaet()){
							System.out.println("Sie haben leider nicht gen�gend Mitarbeiter, um diese Anzahl an Burger zu produzieren.\nMomentane Kapazit�t: " + u.getPersonal().berechneKapazitaet());
						}
					}while (u.getBestellung().getMenge() == 0 && bestellMenge !=0 && bestellMenge > u.getPersonal().berechneKapazitaet());





					zeigeLieferant(0);
					u.getBestellung().bestelleFleisch(Datenbank.fl[scanner.nextInt()-1]);




					zeigeLieferant(1);
					u.getBestellung().bestelleBrot(Datenbank.bl[scanner.nextInt()-1]);




					zeigeLieferant(2);
					u.getBestellung().bestelleSalat(Datenbank.sal[scanner.nextInt()-1]);



					zeigeLieferant(3);
					u.getBestellung().bestelleSosse(Datenbank.sol[scanner.nextInt()-1]);




					System.out.println("Ihre Bestellung kostet: " + u.getBestellung().berechneGesamtpreis() + "€");
					System.out.println("Die Qualitaet ihrer Burger betraegt: " + u.berechneBurgerQualitaet() + "/100");


					//Marketingauswahl
					System.out.println("\nMöchten Sie Marketing betreiben: ");
					zeigeMarketing();
					System.out.print("Wählen Sie hier: ");
					eingabe = scanner.nextInt()-1;
					if(eingabe!=-1){
						u.setMarketing(waehleMarketing(eingabe));
						u.betreibeMarketing();
					}

					System.out.println("Gesamtkosten: " + u.berechneRundenkosten());

					System.out.println("Letzte Periode kostete Ihr Burger: " + u.getBurger().getPreis());
					System.out.println("Wählen sie einen Preis für ihren Burger zwischen 5-25€: ");
					u.getBurger().setPreis(scanner.nextInt());

					unternehmensRundeBeenden(u);

				}


			}
			if(anzahlRunden == 3 || anzahlRunden ==  6|| anzahlRunden == 9){
				cateringAuswahlTreffen(anzahlRunden);
			}
			berechneKunden();
			for (int i = 0; i < unternehmen.size(); i++) {
				Unternehmen u = unternehmen.get(i);
				System.out.println("Anzahl Kunden " + u.getName() + ": " + u.getKunden());
				System.out.println("Kapitaldaten f�r: " + u.getName());
				System.out.println("Umsatz:" + u.berechneUmsatz());
				System.out.println("Gewinn: " + u.berechneGewinn(anzahlRunden));
				System.out.println("Neues Kapital: " + u.berechneKapital(false));

				u.setCatering(null);
			}

			for (int j = 0; j < Datenbank.fl.length; j++) {
				Datenbank.fl[j].berechneNeuenPreis();
				Datenbank.bl[j].berechneNeuenPreis();
				Datenbank.sal[j].berechneNeuenPreis();
				Datenbank.sol[j].berechneNeuenPreis();
			}
			anzahlRunden++;
		}
	}

	//Methode die das Catering dem Unternehmen zuweist
	public static void cateringAuswahlTreffen(int anzahlRunden) {
		String wahlUnternehmen = "";
		Catering c = null;

		if(anzahlRunden ==3){
			c = Datenbank.c1;
			wahlUnternehmen = Datenbank.c1.vergleichePreisLeistung();
		}else if(anzahlRunden == 6) {
			c = Datenbank.c2;
			wahlUnternehmen = Datenbank.c2.vergleichePreisLeistung();
		}else if(anzahlRunden == 9){
			c = Datenbank.c3;
			wahlUnternehmen = Datenbank.c3.vergleichePreisLeistung();
		}

		if(wahlUnternehmen != "Kein Angebot eingegangen"){
			for (int i = 0; i < unternehmen.size(); i++) {
				if(wahlUnternehmen == unternehmen.get(i).getName()){
					unternehmen.get(i).setCatering(c);
					unternehmen.get(i).berechneCatering();
					System.out.println(unternehmen.get(i).getName() + " hat Catering bekommen");
				}
			}
		}
	}

	//Methode die den Start des Spiels behandelt
	public static void startGame(){

		try {
			while (neuerSpieler){
				//Spielstart
				System.out.println("Herzlich Wilkommen");
				System.out.println("Bitte geben Sie fuer Ihren Burgerladen einen gewünschten Namen ein:" );

				String nameUnternehmen = scanner.next();

				Unternehmen u = new Unternehmen(nameUnternehmen);
				//u.setKapital(Datenbank.startKapital);
				System.out.println("Ihr Startkapital zu Beginn betr�gt: " + u.getKapital());
				unternehmen.add(u);

				System.out.println("Nachdem Sie Ihren Burgerladen benannt haben muessen Sie nun einen gegeigneten Standort auswaehlen");
				zeigeStandort();
				System.out.print("Bitte wählen Sie hier: ");
				u.setStandort(waehleStandort(scanner.nextInt() - 1));


				System.out.println("Fuer ihren Standort muessen sie noch zusaetzlich einen Kuehlraum wählen in dem Sie Ihre Burger-Zutaten kuehlen koennen");
				System.out.println("Hierfür stehen Ihnen folgende Möglichkeiten zur Verfügung");
				zeigeKuehlraume();
				System.out.print("Bitte wählen Sie hier: ");
				u.getStandort().setKuehlraum(waehleKuhlraum(scanner.nextInt() - 1));

				System.out.println("Damit ihr Burgerladen entsprechend eingerichtet werden kann müssen Sie sich noch für eine Innenausstattung entscheiden");
				System.out.println("Mit der Innenausstattung Ihres Burgerladen ist es Ihnen möglich den Kundenpool individuell zu erweitern");
				System.out.println("Folgende Einrichtungsarten stehen zur Verfügung");
				zeigeInnenausstattung();
				System.out.print("Bitte wählen Sie hier: ");
				u.getStandort().setInnenausstattung(waehleInnenausstattung(scanner.nextInt() - 1));

				System.out.println("Sie haben Sich f�r folgenden Standort entschieden: ");
				System.out.println("Standort: " + u.getStandort().getLage() + "; Kühlraum: " + u.getStandort().getKuehlraum().getLagerGroesse());
				System.out.println("Die gesamten Mietkosten f�r diesen Standort belaufen sich auf: " + u.getStandort().berechneMiete());
				System.out.println("Zusätzlich haben Sie sich für folgende Innenausstattung entschieden: " + u.getStandort().getInnenausstattung().getBezeichnung() + " Kostenpunkt: " + u.getStandort().getInnenausstattung().getKosten());

				//Personalwahl
				System.out.println("Damit ihr Burgerladen betrieben werden kann ben�tigen Sie mindestens 5 Mitarbeiter");
				System.out.println("1 Mitarbeiter kann innerhalb einer Periode maximal 300 Burger produzieren. Damit betr�gt die momentane Burgerkapazit�t 1500.");
				System.out.println("Das Gehalt betr�gt 2040 Euro im Monat");
				System.out.println("Wollen Sie Ihre Mitarbeiterkapazit�t erweitern?");
				u.getPersonal().erhoeheAnzahl((scanner.nextInt()));

				//LieferantenBestellung
				System.out.println("\nBitte wählen sie im Folgenden, für wie viele Burger sie Zutaten in dieser Periode kaufen wollen");

				int bestellMenge = 0;
				do{
					bestellMenge = scanner.nextInt();

					u.getBestellung().setzeBestellmenge(bestellMenge, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
					u.getStandort().getKuehlraum().wareEinlagern(u.getBestellung().getMenge());
					if (bestellMenge > u.getPersonal().berechneKapazitaet()){
						System.out.println("Sie haben leider nicht gen�gend Mitarbeiter, um diese Anzahl an Burger zu produzieren.\nMomentane Kapazit�t: " + u.getPersonal().berechneKapazitaet());
					}
				}while (u.getBestellung().getMenge() == 0 && bestellMenge !=0 && bestellMenge > u.getPersonal().berechneKapazitaet());




				zeigeLieferant(0);
				u.getBestellung().bestelleFleisch(Datenbank.fl[scanner.nextInt()-1]);




				zeigeLieferant(1);
				u.getBestellung().bestelleBrot(Datenbank.bl[scanner.nextInt()-1]);




				zeigeLieferant(2);
				u.getBestellung().bestelleSalat(Datenbank.sal[scanner.nextInt()-1]);



				zeigeLieferant(3);
				u.getBestellung().bestelleSosse(Datenbank.sol[scanner.nextInt()-1]);


				System.out.println("Ihre Bestellung kostet: " + u.getBestellung().berechneGesamtpreis() + "€");
				System.out.println("Die Qualitaet ihrer Burger betraegt: " + u.berechneBurgerQualitaet() + "/100");

				//Marketingauswahl
				System.out.println("\nMöchten Sie Marketing betreiben: ");
				zeigeMarketing();
				System.out.print("Wählen Sie hier: ");
				int eingabe = scanner.nextInt()-1;
				if(eingabe!=-1){
					u.setMarketing(waehleMarketing(eingabe));
					u.betreibeMarketing();
				}


				System.out.println("Unternehmen gegründet: ");
				System.out.println("Kosten: " + u.berechneGruendungsKosten());

				//Kreditwahl
				System.out.println("Sie haben jetzt die Möglichkeit einen Kredit zu wählen, damit Sie in den folgenden Perioden mehr finanziellen Spielraum haben: ");
				zeigeKredite();
				System.out.println("Bitte wählen sie: ");

				eingabe = (scanner.nextInt() - 1);
				if(eingabe == -1){
					System.out.println("Kein Kredit");
				}else{
					u.setKredit(waehleKredit(eingabe));
					System.out.println("Kosten: " + u.berechneGruendungsKosten());
				}

				System.out.println("Wählen sie einen Preis für ihren Burger zwischen 5-25€: ");
				u.getBurger().setPreis(scanner.nextInt());

				System.out.println("Soll ein weiteres Unternehmen gegründet werden? 1 = ja 0 = nein");
				if(scanner.nextInt() == 0){
					neuerSpieler = false;
				}

				u.berechneKundenzufriedenheit();
			}
			berechneKundenpool();
			berechneKunden();
			for (int i = 0; i < unternehmen.size(); i++) {
				Unternehmen u = unternehmen.get(i);
				System.out.println("Anzahl Kunden " + u.getName() + ": " + u.getKunden());
				System.out.println("Kapitaldaten f�r: " + u.getName());
				System.out.println("Umsatz:" + u.berechneUmsatz());
				System.out.println("Gewinn: " + u.berechneGewinn(anzahlRunden));
				System.out.println("Neues Kapital: " + u.berechneKapital(false));
			}

		
			anzahlRunden++;
			

		} catch (Exception e) {
			System.err.println(e);
		}
	}




	//Hilfsmethoden um elementare Spielergebnisse zu berechnen
	//Berechnet die Anzahl der Kunden für das entsprechende Unternehmen
	public static void berechneKunden(){
		int gesamtAnteil = 0;
		int[] anteileInnenausstattung = new int[3];
		int kunden = 0;
		int kundenanteil = 0;
		int poolVariable;

		berechneKundenpool();

		poolVariable = 300 - anzahlRunden*15;

		/*if(anzahlRunden < 4){
			poolVariable = 300;
		}
		else if(anzahlRunden < 8){
			poolVariable = 200;
		}
		else{
			poolVariable = 120;
		}*/

		for (int i = 0; i < unternehmen.size(); i++) {
			//Hier muss für jedes einzelne Unternehmen die Anzahl der Kunden berechnet und gesetzt werden
            //Kundenberechnung abhängig von der Innenausstattung fehlt noch
            gesamtAnteil += unternehmen.get(i).berechneKundenanteil();
			for (int j = 0; j < anteileInnenausstattung.length; j++) {
				if (unternehmen.get(i).getStandort().getInnenausstattung() == Datenbank.i[j]){
					anteileInnenausstattung[j] += unternehmen.get(i).berechneKundenanteil();
				}
			}

		}
		for (int i = 0; i < unternehmen.size(); i++) {
			kundenanteil = unternehmen.get(i).berechneKundenanteil();
			if(gesamtAnteil<=poolVariable){
				kunden = (kundenanteil*kundenpool/poolVariable);
			}
			else{
				kunden = kundenanteil*kundenpool/gesamtAnteil;
			}

			for (int j = 0; j < anteileInnenausstattung.length; j++) {
				if(anteileInnenausstattung[j]<=poolVariable && unternehmen.get(i).getStandort().getInnenausstattung() == Datenbank.i[j]){
					kunden += kundenanteil*Datenbank.i[j].getGroesseKundenpool()/poolVariable;
				}
				else if(unternehmen.get(i).getStandort().getInnenausstattung() == Datenbank.i[j]){
					kunden += kundenanteil*Datenbank.i[j].getGroesseKundenpool()/anteileInnenausstattung[j];
				}
			}

			//checke Inhalt Kuehlraum
			if(unternehmen.get(i).getStandort().getKuehlraum().getInhalt() < kunden){
				if(unternehmen.get(i).getMarketing()!=null){
					if(unternehmen.get(i).getMarketing().getBezeichnung().equals("Werbung21")){
						kunden = unternehmen.get(i).getStandort().getKuehlraum().getInhalt()/2;
					}
					else{
						kunden = unternehmen.get(i).getStandort().getKuehlraum().getInhalt();
					}
				}
				else{
					kunden = unternehmen.get(i).getStandort().getKuehlraum().getInhalt();
				}

			}
			
			//checke Personalkapazitaet
			if(unternehmen.get(i).getPersonal().berechneKapazitaet() < kunden){
				if(unternehmen.get(i).getMarketing()!=null){
					if(unternehmen.get(i).getMarketing().getBezeichnung().equals("Werbung21")){
						kunden = unternehmen.get(i).getPersonal().berechneKapazitaet()/2;
					}
					else{
						kunden = unternehmen.get(i).getPersonal().berechneKapazitaet();
					}
				}
				else{
					kunden = unternehmen.get(i).getPersonal().berechneKapazitaet();
				}
			}


			unternehmen.get(i).setKunden(kunden);
			//unternehmen.get(i).getStandort().getKuehlraum().wareEntnehmen(kunden);
			kunden = 0;
		}

	}

	//Funktionen zur Wahl eines Kühlraums, Standorts und Innenausstattung
	public static Innenausstattung waehleInnenausstattung(int auswahl) {
		return innenausstattung[auswahl];
	}
	
	public static Standort waehleStandort(int auswahl){
		Standort s;
		s = new Standort(Datenbank.standorte[auswahl].getLage(), Datenbank.standorte[auswahl].getMiete(), Datenbank.standorte[auswahl].getTraffic(), Datenbank.standorte[auswahl].getBekanntheit());
		return s;
	}
	
	public static Kuehlraum waehleKuhlraum(int index){
		Kuehlraum k;
		k = new Kuehlraum(kuehlraeume[index].getLagerGroesse(), kuehlraeume[index].getInhalt(), kuehlraeume[index].getMietZusatzKosten());
		return k;
	}

	public static Kredit waehleKredit(int auswahl){
		if(auswahl>=0){
			return Datenbank.k[auswahl];
		}
		else{
			return null;
		}

	}

	public static Marketing waehleMarketing(int auswahl){
		if(auswahl>=0){
			return Datenbank.marketing[auswahl];
		}
		else{
			return null;
		}
	}
	
	//Methode fuer das Auftreten von Ereignissen
	public static String [] ereignisTrittEin(int parameter) {
		int alteBekanntheit;
		int bekanntheitsVeraenderung;
		int kundenzufriedenheitsVeraenderung;
		String [] ereignisErgebnis = new String [unternehmen.size()];
		int [] initErgebnis = new int [unternehmen.size()];
		int checkArray = 0;
		if (parameter == 6){
			for (int i = 0; i < unternehmen.size(); i++) {
				if (unternehmen.get(i).getBestellung().getFleischlieferant().getRisikoQuote() == fl[2].getRisikoQuote()){
					if (risikoEingetreten[i] == 0){
						risikoEingetreten[i] = 1;
					}
				}
			}
			for (int i = 0; i < unternehmen.size(); i++) {
				if (risikoEingetreten[i] == 1){ //Ereignis Gammelfleischskandal
					alteBekanntheit = unternehmen.get(i).getBekanntheit();
					unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (int)(100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[2].getBekanntheit()));
					bekanntheitsVeraenderung = unternehmen.get(i).getBekanntheit() - alteBekanntheit;
					unternehmen.get(i).setKundenzufriedenheitsVeraenderung((int) (unternehmen.get(i).getKundenzufriedenheit()*(-0.01)*ereignis[2].getKundenzufriedenheit()));
					kundenzufriedenheitsVeraenderung = Math.abs(unternehmen.get(i).getKundenzufriedenheitsVeraenderung());
					risikoEingetreten[i] = 2;
					if (initErgebnis[i] == 0){
						ereignisErgebnis[i] = ("Es hat sich herausgestellt, dass Ihr Fleischlieferant Teil eines Gammelfleischskandals ist.\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " gesteigert und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesenkt.");
						initErgebnis[i] = 1;
					} else {
						ereignisErgebnis[i] += ("\nEs hat sich herausgestellt, dass Ihr Fleischlieferant Teil eines Gammelfleischskandals ist.\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " gesteigert und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesenkt.");
					}
				}
			}
			for (int i = 0; i < ereignisErgebnis.length; i++) {
				if (ereignisErgebnis[i] != null){
					System.out.println(ereignisErgebnis[i]);
				}
			}
		} else {
			for (int i = 0; i < Datenbank.fl.length; i++) {
				
					int zufallszahl = (int)(Math.random() * 100) + 1;
					if (zufallszahl <= fl[i].getRisikoQuote()){
						for (int j = 0; j < unternehmen.size(); j++) {
							if (unternehmen.get(j).getBestellung().getFleischlieferant().getRisikoQuote() == fl[i].getRisikoQuote()){
								if (risikoEingetreten[j] == 0){
									risikoEingetreten[j] = 1;
								}
							}
						}
						
					}
			}
			for (int i = 0; i < unternehmen.size(); i++) {
				int zufallszahl = (int)(Math.random() * 100) + 1;
				if (zufallszahl <= 100){ //Ereignis Adler Mannheim
					alteBekanntheit = unternehmen.get(i).getBekanntheit();
					unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (int)(100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[0].getBekanntheit()));
					bekanntheitsVeraenderung = unternehmen.get(i).getBekanntheit() - alteBekanntheit;
					unternehmen.get(i).setKundenzufriedenheitsVeraenderung((int) ((100-unternehmen.get(i).getKundenzufriedenheit())*0.01*ereignis[0].getKundenzufriedenheit()));
					kundenzufriedenheitsVeraenderung = Math.abs(unternehmen.get(i).getKundenzufriedenheitsVeraenderung());
					if (initErgebnis[i] == 0){
						ereignisErgebnis[i] = ("Das Adler Mannheim-Team war bei Ihnen zu Besuch!\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesteigert.");
						initErgebnis[i] = 1;
					} else {
						ereignisErgebnis[i] += ("\nDas Adler Mannheim-Team war bei Ihnen zu Besuch!\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesteigert.");
					}
				}
				
				if (2 < zufallszahl && zufallszahl<= 5){ //Ereignis Brandunfall
					alteBekanntheit = unternehmen.get(i).getBekanntheit();
					unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (int)(100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[1].getBekanntheit()));
					bekanntheitsVeraenderung = unternehmen.get(i).getBekanntheit() - alteBekanntheit;
					unternehmen.get(i).setKundenzufriedenheitsVeraenderung((int) (unternehmen.get(i).getKundenzufriedenheit()*(-0.01)*ereignis[1].getKundenzufriedenheit()));
					kundenzufriedenheitsVeraenderung = Math.abs(unternehmen.get(i).getKundenzufriedenheitsVeraenderung());
					unternehmen.get(i).setGewinn(unternehmen.get(i).getGewinn()-5000);
					if (initErgebnis[i] == 0){
						ereignisErgebnis[i] = ("In der Kueche kam es zu einem Brandunfall.\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " gesteigert und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesenkt.");
						initErgebnis[i] = 1;
					} else {
						ereignisErgebnis[i] += ("\nIn der Kueche kam es zu einem Brandunfall.\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " gesteigert und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesenkt.\nEs sind zudem Kosten von 5000,00 � entstanden.");
					}
				}
				
				if (risikoEingetreten[i] == 1){ //Ereignis Gammelfleischskandal
					alteBekanntheit = unternehmen.get(i).getBekanntheit();
					unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (int)(100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[2].getBekanntheit()));
					bekanntheitsVeraenderung = unternehmen.get(i).getBekanntheit() - alteBekanntheit;
					unternehmen.get(i).setKundenzufriedenheitsVeraenderung((int) (unternehmen.get(i).getKundenzufriedenheit()*(-0.01)*ereignis[2].getKundenzufriedenheit()));
					kundenzufriedenheitsVeraenderung = Math.abs(unternehmen.get(i).getKundenzufriedenheitsVeraenderung());
					risikoEingetreten[i] = 2;
					if (initErgebnis[i] == 0){
						ereignisErgebnis[i] = ("Es hat sich herausgestellt, dass Ihr Fleischlieferant Teil eines Gammelfleischskandals ist.\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " gesteigert und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesenkt.");
						initErgebnis[i] = 1;
					} else {
						ereignisErgebnis[i] += ("\nEs hat sich herausgestellt, dass Ihr Fleischlieferant Teil eines Gammelfleischskandals ist.\nDadurch hat sich die Bekanntheit des Unternehmens " + unternehmen.get(i).getName() + " um " + bekanntheitsVeraenderung + " gesteigert und ihre Kundenzufriedenheit um " + kundenzufriedenheitsVeraenderung + " gesenkt.");
					}
				}
			}
		}
		for (int i = 0; i < ereignisErgebnis.length; i++) {
			if (ereignisErgebnis[i] == null){
				checkArray ++;
			}
		}
		if (checkArray == 3){
			return null;
		} else {
			return ereignisErgebnis;
		}
		
		
	}
	
	//Methoden für die Anzeige der unterschiedlichen Optionen --> werden mit UI nicht mehr benötigt
	private static void zeigeInnenausstattung() {
		for (int i = 0; i < innenausstattung.length; i++) {
			System.out.println("Art der Einrichtung: " + innenausstattung[i].getBezeichnung());
			System.out.println("Zusätzlicher Kundenpool: " + innenausstattung[i].getGroesseKundenpool());
			System.out.println("Einmalige Kosten: " + innenausstattung[i].getKosten());
			System.out.println();
		}
		
	}
	
	private static void zeigeKuehlraume() {
		for (int i = 0; i < kuehlraeume.length; i++) {
			System.out.println("Kühlraum " + (i + 1) + ":");
			System.out.println("Lagerplatz: " + kuehlraeume[i].getLagerGroesse());
			System.out.println("Zusätzliche Mietkosten: " + kuehlraeume[i].getMietZusatzKosten());
			System.out.println();
		}
	}

	private static void zeigeStandort() {
		for (int i = 0; i < standorte.length; i++) {
			System.out.println("Standort " + (i + 1) + ": " + standorte[i].getLage());
			System.out.println("Miete: " + standorte[i].getMiete());
			System.out.println("Bekanntheit: " + standorte[i].getBekanntheit());
			System.out.println("Traffic (Laufkundschaft): " + standorte[i].getTraffic());
			System.out.println();
		}
	}

	private static void zeigeLieferant(int index) {
		Lieferant[] lieferanten = null;
		if(index ==  0){
			lieferanten = Datenbank.fl;
			System.out.println("Bitte wählen sie nun einen Fleischlieferanten");
		}
		if(index == 1){
			lieferanten = Datenbank.bl;
			System.out.println("Bitte wählen sie nun einen Brotieferanten");
		}
		if(index == 2){
			lieferanten = Datenbank.sal;
			System.out.println("Bitte wählen sie nun einen Salatlieferanten");
		}
		if(index == 3){
			lieferanten = Datenbank.sol;
			System.out.println("Bitte wählen sie nun einen Sossenlieferanten");
		}

		for (int i = 0; i < lieferanten.length; i++) {
			System.out.println("Lieferant " + (i+1));
			//System.out.println("Uebrige Ressourcen " + (i + 1) + ": " + lieferanten[i].berechneUebrigeRessourcen());
			System.out.println("Qualitaet: " + lieferanten[i].getQualitaet());
			System.out.println("Preis pro Gut: " + lieferanten[i].getPreisProGut());
			if (index == 0){
				System.out.println("Gammelfleischrisiko: " + lieferanten[i].getRisikoQuote() + "Prozent");
			}
			System.out.println();
		}
		
	}

	public static void zeigeKredite(){
		for (int i = 0; i < Datenbank.k.length; i++) {
			System.out.println("Kredit " + (i+1));
			System.out.println("Laufzeit: " + Datenbank.k[i].getLaufzeit());
			System.out.println("Zinsatz: " + Datenbank.k[i].getZinssatz());
			System.out.println("Betrag: " + Datenbank.k[i].getHoehe());
			System.out.println();
		}
	}

	public static void zeigeMarketing(){
		for (int i = 0; i < Datenbank.marketing.length; i++) {
			System.out.println("Art: " + Datenbank.marketing[i].getBezeichnung());
			System.out.println("Bekanntheitssteigerung: " + Datenbank.marketing[i].getBekanntheitssteigerung() + " - 10%");
			System.out.println("Kundenzufriedenheitssteigerung: " + Datenbank.marketing[i].getKundenzufriednenheitssteigerung() + " - 10%");
			System.out.println("Kosten: " + Datenbank.marketing[i].getKosten());
			System.out.println("Sofortige Steigerung: " + Datenbank.marketing[i].getProzent());
			System.out.println();
		}
	}

	public static int berechneKundenpool(){
		kundenpool = Datenbank.kundenpoolKonstante * unternehmen.size();
		//kundenpool = 15000;
		return kundenpool;
		//return 15000;
	}

	public static void unternehmensRundeBeenden(Unternehmen u){
		u.berechneKundenzufriedenheit();
		if(u.getKredit()!= null){
			if(anzahlRunden > u.getKredit().getLaufzeit()){
				u.setKredit(null);
			}
		}
	}

	public static void rundeBeenden(){
		if(anzahlRunden == 3 || anzahlRunden ==  6|| anzahlRunden == 9){
			cateringAuswahlTreffen(anzahlRunden);
		}
		berechneKunden();
		for (int i = 0; i < unternehmen.size(); i++) {
			Unternehmen u = unternehmen.get(i);
			u.berechneUmsatz();
			u.berechneGewinn(anzahlRunden);
			u.berechneKapital(false);

			u.setCatering(null);
			u.setMarketing(null);
		}

		for (int j = 0; j < Datenbank.fl.length; j++) {
			Datenbank.fl[j].berechneNeuenPreis();
			Datenbank.bl[j].berechneNeuenPreis();
			Datenbank.sal[j].berechneNeuenPreis();
			Datenbank.sol[j].berechneNeuenPreis();
			Datenbank.fl[j].setVerbrauchteRessourcen(0);
			Datenbank.bl[j].setVerbrauchteRessourcen(0);
			Datenbank.sal[j].setVerbrauchteRessourcen(0);
			Datenbank.sol[j].setVerbrauchteRessourcen(0);

		}
		anzahlRunden++;
	}

}
