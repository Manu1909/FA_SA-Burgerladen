package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NewPlayer extends JFrame implements ActionListener, ChangeListener, MouseListener{
	private JFrame spielerAufbau = new JFrame("Burgerplanspiel - Neuer Spieler");
	
	private JPanel panelTop = new JPanel();
	private JPanel panelBody = new JPanel();
	private JPanel panelBottom = new JPanel();
	
	private JComboBox cLocation = new JComboBox();
	
	private JScrollPane sLocation = new JScrollPane();
	
	private JTextField name = new JTextField(15);
	
	
	private JButton confirm = new JButton("Eingaben bestätigen");
	private JButton go = new JButton("Los geht's");
	
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
		panelBody.add(name);
		panelBody.add(cLocation);
		cLocation.addItem("Planken");
		cLocation.addItem("Jungbusch");
		
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
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
	
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
