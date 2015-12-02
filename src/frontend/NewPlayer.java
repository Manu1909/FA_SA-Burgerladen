package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewPlayer extends JFrame implements ActionListener{
	private JFrame spielerAufbau = new JFrame("Burgerplanspiel - Neuer Spieler");
	private JButton go = new JButton("Los geht's");
	private JButton finish = new JButton("Spiel starten");
	private JButton next = new JButton("Nächster Schritt");
	private JPanel panelTop = new JPanel();
	private JPanel panelBody = new JPanel();
	
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
		panelTop.add(go);
		
		spielerAufbau.add(panelTop, BorderLayout.NORTH);
		spielerAufbau.add(panelBody, BorderLayout.CENTER);
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
			go.setVisible(false);
//			panelTop.remove(go);
//			panelTop.revalidate();
//			panelTop.repaint();
		}
	}
}
