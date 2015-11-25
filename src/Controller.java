import client.Standort;
import client.Unternehmen;

public class Controller {

	private static Standort s1 = new Standort(500, 4, 5, 500);
	private static Standort s2 = new Standort(600, 2, 3, 300);
	private static Standort s3 = new Standort(400, 3, 4, 200);
	
	public static void main(String args[]){
		
		Unternehmen u1 = new Unternehmen("Burger1");
		u1.setStandort(s1);
		//u1.setLieferant(fleischlieferant, brotlieferant, salatlieferant, sossenlieferant);
		//u1.berechneKapital();
		
	}
}
