package frontend;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marketing extends JFrame{

	
	public Marketing()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		JPanel head = new JPanel();
		JLabel heading = new JLabel("Marketing");
		head.add(heading);
		
		JFrame windowMarketing = new JFrame("Burgerplanspiel - Marketing");
		windowMarketing.add(head);
		windowMarketing.setBounds(10,10,500,300);
		windowMarketing.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		//wird nur bei Ausführung der Klasse gebraucht, eigentlich nicht relevant
		Marketing marketing = new Marketing();
	}
}
