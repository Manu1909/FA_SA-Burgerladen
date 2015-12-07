package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NewPlayer extends JFrame implements ActionListener, ChangeListener, MouseListener{
	private JFrame spielerAufbau = new JFrame("Burgerplanspiel - Neuer Spieler");
	private String[] avLocations = {"Planken", "Jungbusch", "Paradeplatz"};
	
	private JPanel panelTop = new JPanel();
	private JPanel panelBody = new JPanel();
	private JPanel panelBottom = new JPanel();
	
	private JTextField name = new JTextField(15);
	
	private JList lLocation = new JList(avLocations);
	
	private JLabel locationInfo = new JLabel("Index 0");
	
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
		panelBody.add(lLocation);
		panelBody.add(locationInfo);
		
		lLocation.setSelectedIndex(0);
		lLocation.addMouseListener(this);
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
		Object s = e.getSource();
		if(s == lLocation)
		{
			if(lLocation.getSelectedIndex() == 0)
			{
				locationInfo.setText("Index 0");
			}
			if(lLocation.getSelectedIndex() == 1)
			{
				locationInfo.setText("Index 1");
			}
			if(lLocation.getSelectedIndex() == 2)
			{
				locationInfo.setText("Index 2");
			}
		}
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
