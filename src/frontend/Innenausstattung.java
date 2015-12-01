package frontend;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Innenausstattung extends JFrame{

	
	public Innenausstattung()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		JPanel head = new JPanel();
		JLabel heading = new JLabel("Innenausstattung");
		head.add(heading);
		JFrame windowInterior = new JFrame("Burgerplanspiel - Innenausstattung");
		windowInterior.add(head);
		windowInterior.setBounds(10,10,500,300);
		windowInterior.setVisible(true);
		//windowMarketing.setDefaultCloseOperation();
	}
	
	public static void main(String[] args)
	{
		//wird nur bei Ausführung der Klasse gebraucht, eigentlich nicht relevant
		Innenausstattung interior = new Innenausstattung();
	}
}
