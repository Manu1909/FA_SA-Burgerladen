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
	
	public static void main(String args[]){
		startGame();
	}
	
	
	//Methoden die das Spiel simulieren
	public void simuliereSpiel(){
		int anzahlRunden = 0;
		
		while(anzahlRunden < 12){
			if(anzahlRunden == 0){
				startGame();
			}else{
				//Hier muss restliche Spiellogik entstehen
				//ereignisTrittEin();
				}
			anzahlRunden++;
		}
	}
	
	//Methode die den Start des Spiels behandelt
	public static void startGame(){
		//BufferedReader für Benutzereingabe
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in); //Todo macht manu

		try {
			//Spielstart
			System.out.println("Herzlich Wilkommen");
			System.out.println("Bitte geben Sie fuer Ihren Burgerladen einen gewünschten Namen ein:" );

			String nameUnternehmen = userIn.readLine();

			Unternehmen u1 = new Unternehmen(nameUnternehmen);

			System.out.println("Nachdem Sie Ihren Burgerladen benannt haben muessen Sie nun einen gegeigneten Standort auswaehlen");
			zeigeStandort();
			System.out.print("Bitte wählen Sie hier: ");
			u1.setStandort(waehleStandort(userIn.readLine()));


			System.out.println("Fuer ihren Standort muessen sie noch zusaetzlich einen Kuehlraum wählen in dem Sie Ihre Burger-Zutaten kuehlen koennen");
			System.out.println("Hierfür stehen Ihnen folgende Möglichkeiten zur Verfügung");
			zeigeKuehlraume();
			System.out.print("Bitte wählen Sie hier: ");
			u1.getStandort().setKuehlraum(waehleKuhlraum(userIn.readLine()));

			System.out.println("Damit ihr Burgerladen entsprechend eingerichtet werden kann müssen Sie sich noch für eine Innenausstattung entscheiden");
			System.out.println("Mit der Innenausstattung Ihres Burgerladen ist es Ihnen möglich den Kundenpool individuell zu erweitern");
			System.out.println("Folgende Einrichtungsarten stehen zur Verfügung");
			zeigeInnenausstattung();
			System.out.print("Bitte wählen Sie hier: ");
			u1.getStandort().setInnenausstattung(waehleInnenausstattung(userIn.readLine()));

			System.out.println("Sie haben Sich f�r folgenden Standort entschieden: ");
			System.out.println("Standort: " + u1.getStandort().getLage() + "; Kühlraum: " + u1.getStandort().getKuehlraum().getLagerGroesse());
			System.out.println("Die gesamten Mietkosten f�r diesen Standort belaufen sich auf: " + u1.getStandort().berechneMiete());
			System.out.println("Zusätzlich haben Sie sich für folgende Innenausstattung entschieden: " + u1.getStandort().getInnenausstattung().getBezeichnung() + " Kostenpunkt: " + u1.getStandort().getInnenausstattung().getKosten());

			//Personalwahl
			System.out.println("Damit ihr Burgerladen betrieben werden kann benötigen Sie mindestens 5 Mitarbeiter");
			System.out.println("5 Miarbeiter können 1000 Burger im Monat produzieren");
			System.out.println("Diese Kosten pro Mitarbeiter 2040€ im Monat");
			System.out.println("Wollen Sie Ihre Mitarbeiterkapazität erweitern?");
			u1.getPersonal().setAnzahlAngestellte(waehlePersonal(scanner.nextInt()));

			//LieferantenBestellung
			System.out.println("\nBitte wählen sie im Folgenden, für wie viele Burger sie Zutaten in dieser Periode kaufen wollen");

			int bestellMenge = userIn.read();

			u1.getBestellung().setzeBestellmenge(bestellMenge, u1.getStandort().getKuehlraum().berechneFreienLagerplatz());


			zeigeLieferant(0);
			u1.bestelleFleisch(Datenbank.fl[scanner.nextInt()-1]);

			zeigeLieferant(1);
			u1.bestelleBrot(Datenbank.bl[scanner.nextInt()-1]);

			zeigeLieferant(2);
			u1.bestelleSalat(Datenbank.sal[scanner.nextInt()-1]);

			zeigeLieferant(3);
			u1.bestelleSosse(Datenbank.sol[scanner.nextInt()-1]);

			System.out.println("Ihre Bestellung kostet: " + u1.getBestellung().berechneGesamtpreis() + "€");
			System.out.println("Die Qualitaet ihrer Burger betraegt: " + u1.berechneBurgerQualitaet() + "/100");

			//Marketingauswahl
			System.out.println("\nMöchten Sie Marketing betreiben: ");
			zeigeMarketing();
			System.out.print("Wählen Sie hier: ");
			u1.setMarketing(waehleMarketing(scanner.nextInt()-1));

			System.out.println("Unternehmen gegründet: ");
			System.out.println("Kosten: " + u1.berechneKostenOhneKredit());
			
			//Kreditwahl
			System.out.println("Sie haben jetzt die Möglichkeit einen Kredit zu wählen, damit Sie in den folgenden Perioden mehr finanziellen Spielraum haben: ");
			zeigeKredite();
			System.out.println("Bitte wählen sie: ");
			
			if((scanner.nextInt() - 1) == -1){
				System.out.println("Kein Kredit");
			}else{
				u1.setKredit(waehleKredit(scanner.nextInt()-1));
				System.out.println("Kosten: " + u1.berechneKostenMitKredit());
			}
		
			
			

		} catch (Exception e) {
			System.err.println(e);
		}
	}




	//Hilfsmethoden um elementare Spielergebnisse zu berechnen
	//Berechnet die Anzahl der Kunden für das entsprechende Unternehmen
	private void berechneKunden(){
		int gesamtAnteil = 0;
		int[] anteileInnenausstattung = new int[3];
		int kunden = 0;
		int kundenanteil = 0;

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
			if(gesamtAnteil<=100){
				kunden = kundenanteil/100*Datenbank.kundenpool;
			}
			else{
				kunden = kundenanteil/gesamtAnteil*Datenbank.kundenpool;
			}

			for (int j = 0; j < anteileInnenausstattung.length; j++) {
				if(anteileInnenausstattung[j]<=100){
					kunden += kundenanteil/100*Datenbank.i[j].getGroesseKundenpool();
				}
				else{
					kunden += kundenanteil/anteileInnenausstattung[j]*Datenbank.i[j].getGroesseKundenpool();
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
		int index = Integer.parseInt(auswahl);
		return standorte[index - 1];
	}
	
	public static Kuehlraum waehleKuhlraum(String auswahl){
		int index = Integer.parseInt(auswahl);
		return kuehlraeume[index -1];
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
			
			} else if (zufallszahl-3 <= 2){ //Ereignis Brandunfall
				System.out.println("In der Küche kam es zu einem Brandunfall.");
				unternehmen.get(i).setBekanntheit((int)(unternehmen.get(i).getBekanntheit() + (100-unternehmen.get(i).getBekanntheit())*0.01*ereignis[1].getBekanntheit()));
				unternehmen.get(i).setKundenzufriedenheit(unternehmen.get(i).getKundenzufriedenheit() + unternehmen.get(i).getKundenzufriedenheit()/100*ereignis[1].getKundenzufriedenheit());
				System.out.println("Dadurch hat sich Ihre Bekanntheit auf " + unternehmen.get(i).getBekanntheit() + "gesteigert und ihre Kundenzufriedenheit auf" + unternehmen.get(i).getKundenzufriedenheit() + "gesenkt");
			
			} else if (zufallszahl-3-unternehmen.get(i).getFleischlieferant().getRisikoQuote() <= 2){ //Ereignis Gammelfleisch
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
			System.out.println("Uebrige Ressourcen " + (i + 1) + ": " + lieferanten[i].uebrigeRessourcen());
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
