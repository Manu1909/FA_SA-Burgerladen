import business.Standort;
import business.Unternehmen;

public class Controller {

//	private static Standort s1 = new Standort(500, 4, 5, 500);
//	private static Standort s2 = new Standort(600, 2, 3, 300);
//	private static Standort s3 = new Standort(400, 3, 4, 200);
//	private static Standort s4 = new Standort(800, 2, 3, 300);
//	private static Standort s5 = new Standort(700, 3, 4, 200);
	
	public static void main(String args[]){
		
		Unternehmen u1 = new Unternehmen("Burger1");
		//u1.setStandort(s1);
		//u1.setLieferant(fleischlieferant, brotlieferant, salatlieferant, sossenlieferant);
		//u1.berechneKapital();
		
		System.out.println(u1.getStandort().getMiete());
	}
}
