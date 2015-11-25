import client.Standort;
import client.Unternehmen;

public class Controller {

	static Standort s1 = new Standort(500, 4, 5, 500);
	
	public static void main(String args[]){
		
		Unternehmen u1 = new Unternehmen("Burger1", null);
		u1.setzeStandort(s1);
		
		
	 //TODO Getter in Unternehmen
		
	}
}
