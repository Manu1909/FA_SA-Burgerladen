package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Start extends JFrame implements ActionListener, ChangeListener, MouseListener{
	private JFrame spielerAufbau = new JFrame("Burgerplanspiel - Neuer Spieler");
	
	private JPanel panelTop = new JPanel();
	private JPanel panelBody = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JLabel heading = new JLabel("<html><body><h1 align=center>Burger im Quadrat</h1></body></html>");
	private JLabel info = new JLabel("<html><body><p>In diesem Unternehmensplanspiel "
			+ "gründen Sie einen Burgerladen in der Innenstadt Mannheims."
			+ "<br> "
			+ "Dabei haben stehen X Standorte für ihren Laden zur Auswahl. "
			+ "Das Spiel ist in 12 Spielrunden aufgeteilt,"
			+ "<br> die jeweils 3 Monate im Leben des Unternehmens darstellen"
			+ "<br> "
			+ "<br>Klicken Sie auf den Button am unteren Bildschirmrand, um loszulegen"
			+ "</p></html></body>");
	
	private JTextField name = new JTextField(15);
	
	private JButton go = new JButton("Los geht's");
	
	public static void main(String[] args) 
	{
		Start start = new Start();
	}

	public Start()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{	
		panelTop.add(heading);
		panelBody.add(info);
		panelBottom.add(go);
		
		
		/////////////////
		go.addActionListener(this);
		spielerAufbau.add(panelTop, BorderLayout.NORTH);
		spielerAufbau.add(panelBody, BorderLayout.CENTER);
		spielerAufbau.add(panelBottom, BorderLayout.SOUTH);
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
			newStore store = new newStore();
			spielerAufbau.setVisible(false);
			spielerAufbau.dispose();
		}
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Object s = e.getSource();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
