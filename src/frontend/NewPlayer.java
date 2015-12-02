package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewPlayer extends JFrame implements ActionListener{
	private JFrame spielerAufbau = new JFrame("Burgerplanspiel - Neuer Spieler");
	private JButton go = new JButton("Los geht's");
	private JButton finish = new JButton("Spiel starten");
	private JButton next = new JButton("N‰chster Schritt");
	private JPanel panelTop = new JPanel();
	private JPanel panelBody = new JPanel();
	
	private int n;
	private int p;
	//Unternehmensinfos erstes Fenster
	private String location;
	private String cmpname;

	
	public static void main(String[] args) 
	{
		NewPlayer start = new NewPlayer();
	}

	public NewPlayer()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		JLabel introduction = new JLabel("<html><body><h1 "
				+ "color=red>Burgerplanspiel</h1>"
				+ "<br>Textzeile2</body></html>");
		panelTop.add(introduction);
		panelTop.add(go);
		
		go.addActionListener(this);
		spielerAufbau.add(panelTop, BorderLayout.CENTER);
		spielerAufbau.add(panelBody, BorderLayout.SOUTH);
		spielerAufbau.setBounds(1,1,400,300);
		spielerAufbau.setExtendedState(MAXIMIZED_BOTH);
		spielerAufbau.setDefaultCloseOperation(EXIT_ON_CLOSE);
		spielerAufbau.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object s = e.getSource();// TODO Auto-generated method stub
		if(s == go)
		{
			while( p != 1)
			{
				cmpname = JOptionPane.showInputDialog("Bitte geben Sie ihrem Laden einen Namen");
				Object[] yesno = {"Nein", "Ja"};
				p = JOptionPane.showOptionDialog(null,
		            "Sind Sie sicher, dass ihr Laden '"+ cmpname +"' heiﬂen soll?",
		            "Best‰tigung",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.DEFAULT_OPTION,
		            null,
		            yesno,
		            yesno[1]);
			}
	
			
			if(p == 1){
			Object[] options = {"Planken","Jungbusch", "Schloss" };       
			n = JOptionPane.showOptionDialog(null,
			           "W‰hlen Sie den Standort ihres Ladens",
			           "Standortwahl",
			           JOptionPane.YES_NO_OPTION,
			           JOptionPane.DEFAULT_OPTION,
			           null,
			           options,
			           options[1]);
			}
		
		}
	}
}
