import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import business.Kuehlraum;
import business.Standort;
import business.Unternehmen;

public class Controller {

	private static ArrayList<Standort> standorte = new ArrayList<>();
	private static Standort s1 = new Standort("Planken",1400, 3, 5);
	private static Standort s2 = new Standort("Jungbusch",1100, 2, 2);
	private static Standort s3 = new Standort("Kurpfalzer Straße",1500, 4, 5);
	private static Standort s4 = new Standort("Quadrate",1300, 3, 4);
	
	private static ArrayList<Kuehlraum> kuehlraume = new ArrayList<>();
	private static Kuehlraum k1 = new Kuehlraum(1000, 0, 300);
	private static Kuehlraum k2 = new Kuehlraum(1500, 0, 500);
	private static Kuehlraum k3 = new Kuehlraum(2000, 0, 800);
	
	public static void main(String args[]){
		//BufferedReader für Benutzereingabe
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			//Spielstart
			System.out.println("Herzlich Wilkommen");
			System.out.println("Bitte geben Sie für Ihren Burgerladen einen gwünschten Namen ein:" );
			
			String nameUnternehmen = userIn.readLine();
					
			Unternehmen u1 = new Unternehmen(nameUnternehmen);
			
			System.out.println("Nachdem Sie Ihren Burgerladen benannt haben müssen Sie nun einen gegeigneten Standort auswählen");
			zeigeStandort();
			System.out.print("Bitte wählen Sie hier: ");
			u1.setStandort(waehleStandort(userIn.readLine()));
			
			
			System.out.println("Für ihren Standort müssen sie noch zusätzlich einen Kühlraum wählen in dem Sie Ihre Burger-Zutaten kühlen können");
			System.out.println("Hierfür stehen Ihnen folgende Möglichkeiten zur Verfügung");
			zeigeKühlraume();
			System.out.print("Bitte wählen Sie hier: ");
			u1.getStandort().setKuehlraum(waehleKuhlraum(userIn.readLine()));
			
			System.out.println("Sie haben Sich für folgenden Standort entschieden: ");
			System.out.println("Standort: " + u1.getStandort().getLage() + "; Kühlraum: " + u1.getStandort().getKuehlraum().getLagerGroesse());
			System.out.println("Die gesamten Mietkosten für diesen Standort belaufen sich auf: " + u1.getStandort().berechneMiete());
			
			
		} catch (Exception e) {
			System.err.println(e);
		}		
	}
	
	//Funktionen zur Wahl eines Kühlraums und eines Standorts
	public static Standort waehleStandort(String auswahl){
		int index = Integer.parseInt(auswahl);
		return standorte.get(index - 1);
	}
	
	public static Kuehlraum waehleKuhlraum(String auswahl){
		int index = Integer.parseInt(auswahl);
		return kuehlraume.get(index -1);
	}
	
	//Methoden für die Anzeige der unterschiedlichen Optionen
	private static void zeigeKühlraume() {
		kuehlraume.add(k1);
		kuehlraume.add(k2);
		kuehlraume.add(k3);
		
		for (int i = 0; i < kuehlraume.size(); i++) {
			System.out.println("Kühlraum " + (i+1) + ":");
			System.out.println("Lagerplatz: " + kuehlraume.get(i).getLagerGroesse());
			System.out.println("Zusätzliche Mietkosten: " + kuehlraume.get(i).getMietZusatzKosten());
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
}
