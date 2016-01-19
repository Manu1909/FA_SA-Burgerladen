package backend;

import Controller.Controller;
import business.*;

public class Datenbank {

	
	public static final int startKapital = 55000;
	//Konstanten f�r den Kundenpool
	public static int kundenpool = 0;
	public static final int kundenpoolKonstante = 4000;
	public static final int kundenpoolModern = 1500;
	public static final int kundenpoolKlassisch = 1000;
	public static final int kundenpoolAmerican = 2000;
	
	//Daten für Standorte
	private static Standort s1 = new Standort("Jungbusch",1500, 40, 15);
	private static Standort s2 = new Standort("Quadrate",2500, 60, 20);
	private static Standort s3 = new Standort("Planken",3200, 75, 25);
	private static Standort s4 = new Standort("Kurpfalzer Strasse",3000, 70, 25);
	public static Standort[] standorte = {s1, s2, s3, s4};
	
	//Daten für Kühlräume
	private static Kuehlraum kr1 = new Kuehlraum(3000, 0, 300);
	private static Kuehlraum kr2 = new Kuehlraum(4000, 0, 500);
	private static Kuehlraum kr3 = new Kuehlraum(10000, 0, 800);
	public static Kuehlraum[] kuehlraeume = {kr1, kr2, kr3};
	
	//Daten für Innenausstattung
	private static Innenausstattung i1 = new Innenausstattung("Modern", kundenpoolModern, 40000);
	private static Innenausstattung i2 = new Innenausstattung("Klassisch", kundenpoolKlassisch, 33000);
	private static Innenausstattung i3 = new Innenausstattung("American", kundenpoolAmerican, 45000);
	public static Innenausstattung[] i = {i1,i2,i3};
	
	//Daten für Lieferanten
	public static Lieferant fl1 = new Lieferant(6000, 30, 0.68, 5);
	public static Lieferant fl2 = new Lieferant(5000, 50, 1.08, 4);
	public static Lieferant fl3 = new Lieferant(4000, 80, 1.66, 2);
	public static Lieferant[] fl = {fl1, fl2, fl3};
	  
	public static Lieferant bl1 = new Lieferant(6000, 30, 0.23, 0);
	public static Lieferant bl2 = new Lieferant(5000, 60, 0.30, 0);
	public static Lieferant bl3 = new Lieferant(4000, 90, 0.36, 0);
	public static Lieferant[] bl = {bl1, bl2, bl3};
	  
	public static Lieferant sal1 = new Lieferant(6000, 20, 0.05, 0);
	public static Lieferant sal2 = new Lieferant(5000, 50, 0.1, 0);
	public static Lieferant sal3 = new Lieferant(4000, 80, 0.2, 0);
	public static Lieferant[] sal = {sal1, sal2, sal3};
	  
	public static Lieferant sol1 = new Lieferant(6000, 20, 0.01, 0);
	public static Lieferant sol2 = new Lieferant(5000, 60, 0.03, 0);
	public static Lieferant sol3 = new Lieferant(4000, 90, 0.06, 0);
	public static Lieferant[] sol = {sol1, sol2, sol3};

	//Daten für Marketing
	public static Marketing flyer = new FlyerWerbung();
	public static Marketing werbung21 = new Werbung21();
	public static Marketing radio = new RadioWerbung();
	public static Marketing[] marketing = {flyer, werbung21, radio};
	
	//Daten f�r Kredite
	public static Kredit k1 = new Kredit(8, 3.49, 20000);
	public static Kredit k2 = new Kredit(8, 3.49, 30000);
	public static Kredit k3 = new Kredit(10, 3.46, 40000);
	public static Kredit[] k = {k1, k2, k3};
	
	//Daten f�r Ereignisse
	public static Ereignis e1 = new Ereignis(30, 10);
	public static Ereignis e2 = new Ereignis(5, 10);
	public static Ereignis e3 = new Ereignis(5, 20);
	public static Ereignis[] e = {e1, e2, e3};

	//Daten für Catering
	public static Catering c1 = new Catering("Mannheimer Morgen Firmenfeier", 1000, 5, 10);
	public static Catering c2 = new Catering("Sommerfest DHBW Mannheim", 2000, 10, 10);
	public static Catering c3 = new Catering("Meisterfeier Adler Mannheim", 5000, 15, 15);

	//private int konstante = 
	
	public Lieferant getFl1() {
		return fl1;
	}
	
	public Lieferant getFl2() {
		return fl2;
	}
	
	public Lieferant getFl3() {
		return fl3;
	}
	
	public Lieferant getBl1() {
		return bl1;
	}
	
	public Lieferant getBl2() {
		return bl2;
	}
	
	public Lieferant getBl3() {
		return bl3;
	}
	
	public Lieferant getSal1() {
		return sal1;
	}
	
	public Lieferant getSal2() {
		return sal2;
	}
	
	public Lieferant getSal3() {
		return sal3;
	}
	
	public Lieferant getSol1() {
		return sol1;
	}
	
	public Lieferant getSol2() {
		return sol2;
	}
	
	public Lieferant getSol3() {
		return sol3;
	}
	public Kredit getK1() {
		return k1;
	}
	public Kredit getK2() {
		return k2;
	}
	public Kredit getK3() {
		return k3;
	}
	public Ereignis getE1() {
		return e1;
	}
	public Ereignis getE2() {
		return e2;
	}
	public Ereignis getE3() {
		return e3;
	}
}
