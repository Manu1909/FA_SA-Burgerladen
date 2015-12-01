package frontend;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bestellungen extends JFrame{

	
	public Bestellungen()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		JPanel head = new JPanel();
		JLabel heading = new JLabel("Bestellungen");
		head.add(heading);
		
		JFrame windowOrders = new JFrame("Burgerplanspiel - Bestellungen");
		windowOrders.add(head);
		windowOrders.setBounds(10,10,500,300);
		windowOrders.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		//wird nur bei Ausführung der Klasse gebraucht, eigentlich nicht relevant
		Bestellungen orders = new Bestellungen();
	}
}
