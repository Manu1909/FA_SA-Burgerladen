import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import business.*;

public class Controller {

	private static ArrayList<Standort> standorte = new ArrayList<>();
	private static Standort s1 = new Standort("Planken",1400, 3, 5);
	private static Standort s2 = new Standort("Jungbusch",1100, 2, 2);
	private static Standort s3 = new Standort("Kurpfalzer Strasse",1500, 4, 5);
	private static Standort s4 = new Standort("Quadrate",1300, 3, 4);
	
	private static ArrayList<Kuehlraum> kuehlraume = new ArrayList<>();
	private static Kuehlraum k1 = new Kuehlraum(1000, 0, 300);
	private static Kuehlraum k2 = new Kuehlraum(1500, 0, 500);
	private static Kuehlraum k3 = new Kuehlraum(2000, 0, 800);
	
	public static void main(String args[]){
		//BufferedReader f�r Benutzereingabe
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		
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
			
			System.out.println("Sie haben Sich f�r folgenden Standort entschieden: ");
			System.out.println("Standort: " + u1.getStandort().getLage() + "; K�hlraum: " + u1.getStandort().getKuehlraum().getLagerGroesse());
			System.out.println("Die gesamten Mietkosten f�r diesen Standort belaufen sich auf: " + u1.getStandort().berechneMiete());


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
			System.out.println("Die Qualitaet ihrer Burger betraegt: " + u1.berechneBurgerQualität() + "/10");
			
		} catch (Exception e) {
			System.err.println(e);
		}		
	}
	
	//Funktionen zur Wahl eines K�hlraums und eines Standorts
	public static Standort waehleStandort(String auswahl){
		int index = Integer.parseInt(auswahl);
		return standorte.get(index - 1);
	}
	
	public static Kuehlraum waehleKuhlraum(String auswahl){
		int index = Integer.parseInt(auswahl);
		return kuehlraume.get(index -1);
	}
	
	//Methoden f�r die Anzeige der unterschiedlichen Optionen
	private static void zeigeKuehlraume() {
		kuehlraume.add(k1);
		kuehlraume.add(k2);
		kuehlraume.add(k3);
		
		for (int i = 0; i < kuehlraume.size(); i++) {
			System.out.println("K�hlraum " + (i+1) + ":");
			System.out.println("Lagerplatz: " + kuehlraume.get(i).getLagerGroesse());
			System.out.println("Zus�tzliche Mietkosten: " + kuehlraume.get(i).getMietZusatzKosten());
			System.out.println();
		}
		
	}

	private static void zeigeStandort() {
		standorte.add(s1);
		standorte.add(s2);
		standorte.add(s3);
		standorte.add(s4);

		for (int i = 0; i < standorte.size(); i++) {
			System.out.println("Standort " + (i + 1) + ": " + standorte.get(i).getLage());
			System.out.println("Miete: " + standorte.get(i).getMiete());
			System.out.println("Bekanntheit: " + standorte.get(i).getBekanntheit());
			System.out.println("Traffic (Laufkundschaft): " + standorte.get(i).getTraffic());
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
			System.out.println();
		}
		
	}
}
