package business;
public class Datenbank {
		
	//Konstanten für den Kundenpool
	private static final int kundenpool = 10000;
	private static final int kundenpoolModern = 2000;
	private static final int kundenpoolKlassisch = 1000;
	private static final int kundenpoolAlternativ = 1500;
	
	//Daten für Standorte
	private static Standort s1 = new Standort("Planken",1400, 3, 5);
	private static Standort s2 = new Standort("Jungbusch",1100, 2, 2);
	private static Standort s3 = new Standort("Kurpfalzer Strasse",1500, 4, 5);
	private static Standort s4 = new Standort("Quadrate",1300, 3, 4);
	public static Standort[] standorte = {s1, s2, s3, s4};
	
	//Daten für Kühlräume
	private static Kuehlraum kr1 = new Kuehlraum(1000, 0, 300);
	private static Kuehlraum kr2 = new Kuehlraum(1500, 0, 500);
	private static Kuehlraum kr3 = new Kuehlraum(2000, 0, 800);
	public static Kuehlraum[] kuehlraeume = {kr1, kr2, kr3};
	
	//Daten für Innenausstattung
	private static Innenausstattung i1 = new Innenausstattung("Modern", kundenpoolModern, 50000);
	private static Innenausstattung i2 = new Innenausstattung("Klassisch", kundenpoolKlassisch, 40000);
	private static Innenausstattung i3 = new Innenausstattung("Alternativ", kundenpoolAlternativ, 30000);
	public static Innenausstattung[] i = {i1,i2,i3};
	
	//Daten für Lieferante
	public static Lieferant fl1 = new Lieferant(1000, 3, 0.3, 0.05);
	public static Lieferant fl2 = new Lieferant(1500, 5, 0.5, 0.04);
	public static Lieferant fl3 = new Lieferant(1300, 8, 0.7, 0.02);
	public static Lieferant[] fl = {fl1, fl2, fl3};
	  
	public static Lieferant bl1 = new Lieferant(1000, 3, 0.25, 0);
	public static Lieferant bl2 = new Lieferant(1500, 6, 0.35, 0);
	public static Lieferant bl3 = new Lieferant(1300, 9, 0.45, 0);
	public static Lieferant[] bl = {bl1, bl2, bl3};
	  
	public static Lieferant sal1 = new Lieferant(1000, 2, 0.05, 0);
	public static Lieferant sal2 = new Lieferant(1500, 5, 0.1, 0);
	public static Lieferant sal3 = new Lieferant(1300, 8, 0.2, 0);
	public static Lieferant[] sal = {sal1, sal2, sal3};
	  
	public static Lieferant sol1 = new Lieferant(1000, 2, 0.05, 0);
	public static Lieferant sol2 = new Lieferant(1500, 6, 0.1, 0);
	public static Lieferant sol3 = new Lieferant(1300, 9, 0.15, 0);
	public static Lieferant[] sol = {sol1, sol2, sol3};
	
	//Daten für Kredite
	public static Kredit k1 = new Kredit(8, 10, 8000);
	public static Kredit k2 = new Kredit(6, 8, 5000);
	public static Kredit k3 = new Kredit(4, 6, 2000);
	public static Kredit[] k = {k1, k2, k3};
	
	//Daten für Ereignisse
	public static Ereignis e1 = new Ereignis(10, -20);
	public static Ereignis e2 = new Ereignis(5, -10);
	public static Ereignis e3 = new Ereignis(20, 10);
	public static Ereignis[] e = {e1, e2, e3};
	
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
