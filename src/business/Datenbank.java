package business;
public class Datenbank {
	
	public static Lieferant fl1 = new Lieferant(1000, 3, 0.3);
	public static Lieferant fl2 = new Lieferant(1500, 5, 0.5);
	public static Lieferant fl3 = new Lieferant(1300, 8, 0.7);
	public static Lieferant[] fl = {fl1, fl2, fl3};
	  
	public static Lieferant bl1 = new Lieferant(1000, 3, 0.25);
	public static Lieferant bl2 = new Lieferant(1500, 6, 0.35);
	public static Lieferant bl3 = new Lieferant(1300, 9, 0.45);
	public static Lieferant[] bl = {bl1, bl2, bl3};
	  
	public static Lieferant sal1 = new Lieferant(1000, 2, 0.05);
	public static Lieferant sal2 = new Lieferant(1500, 5, 0.1);
	public static Lieferant sal3 = new Lieferant(1300, 8, 0.2);
	public static Lieferant[] sal = {sal1, sal2, sal3};
	  
	public static Lieferant sol1 = new Lieferant(1000, 2, 0.05);
	public static Lieferant sol2 = new Lieferant(1500, 6, 0.1);
	public static Lieferant sol3 = new Lieferant(1300, 9, 0.15);
	public static Lieferant[] sol = {sol1, sol2, sol3};
	
	public static Kredit k1 = new Kredit(8, 10, 8000);
	public static Kredit k2 = new Kredit(6, 8, 5000);
	public static Kredit k3 = new Kredit(4, 6, 2000);
	public static Kredit[] k = {k1, k2, k3};
	
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
}
