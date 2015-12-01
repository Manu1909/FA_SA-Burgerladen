package frontend;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Catering extends JFrame{

	
	public Catering()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		JPanel head = new JPanel();
		JLabel heading = new JLabel("Bestellungen");
		head.add(heading);
		
		JFrame windowCatering = new JFrame("Burgerplanspiel - Bestellungen");
		windowCatering.add(head);
		windowCatering.setBounds(10,10,500,300);
		windowCatering.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		//wird nur bei Ausführung der Klasse gebraucht, eigentlich nicht relevant
		Catering catering = new Catering();
	}
}
