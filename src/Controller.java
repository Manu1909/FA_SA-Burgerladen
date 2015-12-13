import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

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
	private static Scanner scanner = new Scanner(System.in); //Todo macht manu
	private static int anzahlRunden = 0;
	private static boolean neuerSpieler = true;
	private static boolean lieferantOK;
	
	public static void main(String args[]){
		startGame();
		simuliereSpiel();
	}
	
	
	//Methoden die das Spiel simulieren
	public static void simuliereSpiel(){

		
		while(anzahlRunden < 12){
			for (int i = 0; i < unternehmen.size(); i++) {
				if(anzahlRunden == 0){
					startGame();
				}else{
					for (int j = 0; j < Datenbank.fl.length; j++) {
						Datenbank.fl[j].setVerbrauchteRessourcen(0);
						Datenbank.bl[j].setVerbrauchteRessourcen(0);
						Datenbank.sal[j].setVerbrauchteRessourcen(0);
						Datenbank.sol[j].setVerbrauchteRessourcen(0);
					}

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
					ereignisTrittEin();

					//Personal bearbeiten
					System.out.println("Möchten sie Personal einstellen?");
					System.out.println("Aktuelle Anzahl: " + u.getPersonal().berechneAnzahl());
					System.out.print("Wie viele?");
					int eingabe = scanner.nextInt();
					System.out.println("neue Anzahl: " + u.getPersonal().erhoeheAnzahl(eingabe));
					System.out.println("Möchten Sie Leute feuern?\nSie werden nach einer Periode gefeuert.");
					System.out.println("Wie viele?");
					eingabe = scanner.nextInt();
					System.out.println("Diesen Monat abgehauen: " + u.getPersonal().feuern(eingabe));
					System.out.println("Neue Anzahl: " + u.getPersonal().berechneAnzahl());
					System.out.println("Neue Personalkosten: " + u.getPersonal().berechneKosten());

					//LieferantenBestellung
					System.out.println("\nBitte wählen sie im Folgenden, für wie viele Burger sie Zutaten in dieser Periode kaufen wollen");

					int bestellMenge = 0;
					do{
						bestellMenge = scanner.nextInt();

						u.getBestellung().setzeBestellmenge(bestellMenge, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
					}while (u.getBestellung().getMenge() == 0 && bestellMenge !=0);




					do{
						zeigeLieferant(0);
						lieferantOK = u.bestelleFleisch(Datenbank.fl[scanner.nextInt()-1]);
					}while (!lieferantOK);


					do{
						zeigeLieferant(1);
						lieferantOK = u.bestelleBrot(Datenbank.bl[scanner.nextInt()-1]);
					}while (!lieferantOK);


					do{
						zeigeLieferant(2);
						lieferantOK = u.bestelleSalat(Datenbank.sal[scanner.nextInt()-1]);
					}while (!lieferantOK);

					do{
						zeigeLieferant(3);
						lieferantOK = u.bestelleSosse(Datenbank.sol[scanner.nextInt()-1]);
					}while (!lieferantOK);



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

				}

			}
			if(anzahlRunden == 3 || anzahlRunden ==  6|| anzahlRunden == 9){
				cateringAuswahlTreffen(anzahlRunden);
			}
			berechneKunden();
			for (int i = 0; i < unternehmen.size(); i++) {
				Unternehmen u = unternehmen.get(i);
				System.out.println("Anzahl Kunden " + u.getName() + ": " + u.getKunden());
				System.out.println("Gewinn " + u.getName() + ": " + u.berechneGewinn(anzahlRunden));

				u.setCatering(null);
			}

			anzahlRunden++;
		}
	}

	//Methode die das Catering dem Unternehmen zuweist
	private static void cateringAuswahlTreffen(int anzahlRunden) {
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
		//BufferedReader für Benutzereingabe
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));


		try {
			while (neuerSpieler){
				//Spielstart
				System.out.println("Herzlich Wilkommen");
				System.out.println("Bitte geben Sie fuer Ihren Burgerladen einen gewünschten Namen ein:" );

				String nameUnternehmen = userIn.readLine();

				Unternehmen u = new Unternehmen(nameUnternehmen);
				unternehmen.add(u);

				System.out.println("Nachdem Sie Ihren Burgerladen benannt haben muessen Sie nun einen gegeigneten Standort auswaehlen");
				zeigeStandort();
				System.out.print("Bitte wählen Sie hier: ");
				u.setStandort(waehleStandort(userIn.readLine()));


				System.out.println("Fuer ihren Standort muessen sie noch zusaetzlich einen Kuehlraum wählen in dem Sie Ihre Burger-Zutaten kuehlen koennen");
				System.out.println("Hierfür stehen Ihnen folgende Möglichkeiten zur Verfügung");
				zeigeKuehlraume();
				System.out.print("Bitte wählen Sie hier: ");
				u.getStandort().setKuehlraum(waehleKuhlraum(userIn.readLine()));

				System.out.println("Damit ihr Burgerladen entsprechend eingerichtet werden kann müssen Sie sich noch für eine Innenausstattung entscheiden");
				System.out.println("Mit der Innenausstattung Ihres Burgerladen ist es Ihnen möglich den Kundenpool individuell zu erweitern");
				System.out.println("Folgende Einrichtungsarten stehen zur Verfügung");
				zeigeInnenausstattung();
				System.out.print("Bitte wählen Sie hier: ");
				u.getStandort().setInnenausstattung(waehleInnenausstattung(userIn.readLine()));

				System.out.println("Sie haben Sich f�r folgenden Standort entschieden: ");
				System.out.println("Standort: " + u.getStandort().getLage() + "; Kühlraum: " + u.getStandort().getKuehlraum().getLagerGroesse());
				System.out.println("Die gesamten Mietkosten f�r diesen Standort belaufen sich auf: " + u.getStandort().berechneMiete());
				System.out.println("Zusätzlich haben Sie sich für folgende Innenausstattung entschieden: " + u.getStandort().getInnenausstattung().getBezeichnung() + " Kostenpunkt: " + u.getStandort().getInnenausstattung().getKosten());

				//Personalwahl
				System.out.println("Damit ihr Burgerladen betrieben werden kann benötigen Sie mindestens 5 Mitarbeiter");
				System.out.println("5 Miarbeiter können 1000 Burger im Monat produzieren");
				System.out.println("Diese Kosten pro Mitarbeiter 2040€ im Monat");
				System.out.println("Wollen Sie Ihre Mitarbeiterkapazität erweitern?");
				u.getPersonal().setAnzahlAngestellte(waehlePersonal(scanner.nextInt()));

				//LieferantenBestellung
				System.out.println("\nBitte wählen sie im Folgenden, für wie viele Burger sie Zutaten in dieser Periode kaufen wollen");

				int bestellMenge = 0;
				do{
					bestellMenge = scanner.nextInt();

					u.getBestellung().setzeBestellmenge(bestellMenge, u.getStandort().getKuehlraum().berechneFreienLagerplatz());
				}while (u.getBestellung().getMenge() == 0 && bestellMenge !=0);



				do{
					zeigeLieferant(0);
					lieferantOK = u.bestelleFleisch(Datenbank.fl[scanner.nextInt()-1]);
				}while (!lieferantOK);


				do{
					zeigeLieferant(1);
					lieferantOK = u.bestelleBrot(Datenbank.bl[scanner.nextInt()-1]);
				}while (!lieferantOK);


				do{
					zeigeLieferant(2);
					lieferantOK = u.bestelleSalat(Datenbank.sal[scanner.nextInt()-1]);
				}while (!lieferantOK);

				do{
					zeigeLieferant(3);
					lieferantOK = u.bestelleSosse(Datenbank.sol[scanner.nextInt()-1]);
				}while (!lieferantOK);


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
			}

			berechneKunden();

			for (int i = 0; i < unternehmen.size(); i++) {
				Unternehmen u = unternehmen.get(i);
				System.out.println("Anzahl Kunden " + u.getName() + ": " + u.getKunden());
				System.out.println("Gewinn " + u.getName() + ": " + u.berechneGewinn(anzahlRunden));
			}




		
			anzahlRunden++;
			

		} catch (Exception e) {
			System.err.println(e);
		}
	}




	//Hilfsmethoden um elementare Spielergebnisse zu berechnen
	//Berechnet die Anzahl der Kunden für das entsprechende Unternehmen
	private static void berechneKunden(){
		int gesamtAnteil = 0;
		int[] anteileInnenausstattung = new int[3];
		int kunden = 0;
		int kundenanteil = 0;
		int poolVariable;

		if(anzahlRunden < 4){
			poolVariable = 200;
		}
		if(anzahlRunden < 8){
			poolVariable = 150;
		}
		else{
			poolVariable = 100;
		}

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
				kunden = (kundenanteil*Datenbank.kundenpool/poolVariable);
			}
			else{
				kunden = kundenanteil*Datenbank.kundenpool/gesamtAnteil;
			}

			for (int j = 0; j < anteileInnenausstattung.length; j++) {
				if(anteileInnenausstattung[j]<=poolVariable){
					kunden += kundenanteil*Datenbank.i[j].getGroesseKundenpool()/poolVariable;
				}
				else{
					kunden += kundenanteil*Datenbank.i[j].getGroesseKundenpool()/anteileInnenausstattung[j];
				}
			}

			//checke Inhalt Kühlraum
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

			unternehmen.get(i).setKunden(kunden);
			kunden = 0;
		}




	}
		
	//Funktionen zur Wahl eines Kühlraums, Standorts und Innenausstattung
	private static Innenausstattung waehleInnenausstattung(String auswahl) {
		int index = Integer.parseInt(auswahl);
		return innenausstattung[index - 1];
	}
	
	public static Standort waehleStandort(String auswahl){
		Standort s;
		int index = Integer.parseInt(auswahl);
		s = new Standort(standorte[index - 1].getLage(), standorte[index - 1].getMiete(), standorte[index - 1].getTraffic(), standorte[index - 1].getBekanntheit());
		return s;
	}
	
	public static Kuehlraum waehleKuhlraum(String auswahl){
		Kuehlraum k;
		int index = Integer.parseInt(auswahl);
		k = new Kuehlraum(kuehlraeume[index -1].getLagerGroesse(), kuehlraeume[index -1].getInhalt(), kuehlraeume[index -1].getMietZusatzKosten());
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

	//Personal zu Beginn waehlen
	private static int waehlePersonal(int i) {
		if(i == 0){
			return 5;
		}else{
			return  5 + i;
		}
	}
	
	//Methode für das Auftreten von Ereignissen
	private static void ereignisTrittEin() {
		for (int i = 0; i < unternehmen.size(); i++) {
			int zufallszahl = (int)(Math.random() * 100) + 1;
			if (zufallszahl <= 2){ //Ereignis Adler Mannheim
				System.out.println("Das Adler Mannheim-Team war bei Ihnen zu Besuch!");
				unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[0].getBekanntheit()));
				unternehmen.get(i).setKundenzufriedenheit(unternehmen.get(i).getKundenzufriedenheit() + unternehmen.get(i).getKundenzufriedenheit()/100*ereignis[0].getKundenzufriedenheit());
				System.out.println("Dadurch hat sich Ihre Bekanntheit auf " + unternehmen.get(i).getBekanntheit() + "und ihre Kundenzufriedenheit auf" + unternehmen.get(i).getKundenzufriedenheit() + "gesteigert.");
			
			} else if (2< zufallszahl && zufallszahl<= 5){ //Ereignis Brandunfall
				System.out.println("In der Küche kam es zu einem Brandunfall.");
				unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[1].getBekanntheit()));
				unternehmen.get(i).setKundenzufriedenheit(unternehmen.get(i).getKundenzufriedenheit() + unternehmen.get(i).getKundenzufriedenheit()/100*ereignis[1].getKundenzufriedenheit());
				System.out.println("Dadurch hat sich Ihre Bekanntheit auf " + unternehmen.get(i).getBekanntheit() + "gesteigert und ihre Kundenzufriedenheit auf" + unternehmen.get(i).getKundenzufriedenheit() + "gesenkt");
			
			} else if (5 < zufallszahl && zufallszahl <= 5 + unternehmen.get(i).getFleischlieferant().getRisikoQuote()){ //Ereignis Gammelfleisch
				System.out.println("Es hat sich herausgestellt, dass ihr Lieferant Teil eines Gammelfleischskandals ist.");
				unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[2].getBekanntheit()));
				unternehmen.get(i).setKundenzufriedenheit(unternehmen.get(i).getKundenzufriedenheit() + unternehmen.get(i).getKundenzufriedenheit()/100*ereignis[2].getKundenzufriedenheit());
				System.out.println("Dadurch hat sich Ihre Bekanntheit auf " + unternehmen.get(i).getBekanntheit() + "gesteigert und ihre Kundenzufriedenheit auf" + unternehmen.get(i).getKundenzufriedenheit() + "gesenkt");
			}
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
			System.out.println("Kühlraum " + (i+1) + ":");
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
			System.out.println("Uebrige Ressourcen " + (i + 1) + ": " + lieferanten[i].berechneUebrigeRessourcen());
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

}
