package frontend;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class newStore extends JFrame{
	private JFrame windowNewStore = new JFrame("Burgerplanspiel - Marketing");
	
	private String[] locations = {"Planken","Jungbusch",""};
	private String[] interiorOptions = {"Option1", "Option2"};
	
	private JList lLocation = new JList(locations);
	private JList lInterior = new JList(interiorOptions);
	
	private JTextField name = new JTextField(20);
	
	private JLabel heading = new JLabel("<html><body><h1 align=center>Neuen Laden gründen</h1></body></html>");
	private JLabel infoName = new JLabel("<html><body><p align=center>Wählen Sie einen Namen für ihr Unternehmen.</p></body></html>");
	private JLabel nameOptionInfo = new JLabel("Option 1");
	private JLabel infoLocation = new JLabel("<html><body><p align=center>Wählen Sie einen Standort für ihr Unternehmen.</p></body></html>");
	private JLabel locationOptionInfo = new JLabel("Option 1");
	private JLabel infoInterior = new JLabel("<html><body><p align=center>Wählen Sie ihr Möbiliar.</p></body></html>");
	private JLabel interiorOptionInfo = new JLabel("Option 1");
	
	private JPanel panelTop = new JPanel();
	private JPanel panelBody = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JPanel panelName = new JPanel();
	private JPanel panelLocation = new JPanel();
	private JPanel panelInterior = new JPanel();
	
	private JButton confirm= new JButton("Spiel starten");
	
	
	public static void main(String[] args)
	{
		newStore store = new newStore();
	}
	
	public newStore()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		panelTop.add(heading);
		
		panelLocation.add(infoLocation, BorderLayout.NORTH);
		panelLocation.add(lLocation, BorderLayout.SOUTH);
		panelLocation.add(locationOptionInfo);
		
		panelName.add(infoName);
		panelName.add(name);
		panelName.add(nameOptionInfo);
		
		panelInterior.add(infoInterior);
		panelInterior.add(lInterior);
		panelInterior.add(interiorOptionInfo);
		
		panelBody.add(panelName, BorderLayout.NORTH);
		panelBody.add(panelLocation, BorderLayout.CENTER);
		panelBody.add(panelInterior, BorderLayout.SOUTH);
		
		panelBottom.add(confirm);
		
		windowNewStore.add(panelTop, BorderLayout.NORTH);
		windowNewStore.add(panelBody, BorderLayout.CENTER);
		windowNewStore.add(panelBottom, BorderLayout.SOUTH);
		windowNewStore.setBounds(1,1,400,300);
		windowNewStore.setExtendedState(MAXIMIZED_BOTH);
		windowNewStore.setDefaultCloseOperation(EXIT_ON_CLOSE);
		windowNewStore.setVisible(true);
	}
}
