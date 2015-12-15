package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class newStore extends JFrame implements ActionListener, MouseListener{
	private JFrame frame = new JFrame("Burger im Quadrat -  Laden gründen");
	private JPanel contentPane = new JPanel();
	
	private String location = "";
	private String interior = "";   //////////Wie werden diese Werte übergeben?
	private String credit;
	private String storageArea ="";
	private String name = "";
	
	private String[] locations = {"Planken","Jungbusch","Kurpfälzer Str.", "Option 4"};
	private String[] interiorOptions = {"Option1", "Option2", "Opption 3"};
	private String[] storageOptions = {"groß (+ X€ )","mittel (+ X€ )","klein (+ X€ )"};
	private String[] creditOptions = {"€", "€", "€", "kein Kredit"};
	
	private JList listLocations = new JList(locations);
	private JList listInterior = new JList(interiorOptions);
	private JList listCredit = new JList(creditOptions);
	private JComboBox comboBox = new JComboBox(storageOptions);
	
	private JButton btnConfirm = new JButton("Bestätigen");
	
	private JLabel tipLocations = new JLabel("<html><body><p>Vorteil: Hoher Verkehr"
			+ "<br>Nachteil: Lieferung"
			+ "<br>Kosten: X€"
			+ "</p></body></html>");
	private JLabel tipInterior = new JLabel("Tet");
	private JLabel tipCredit = new JLabel("Info");
	
	
	public static void main(String[] args)
	{
		newStore store = new newStore("");
	}
	
	public newStore(String name)
	{
		this.name = name;
		buildWindow();
	}
	
	public void buildWindow()
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel heading = new JLabel("<html><body><h2>"+name+"</h2></body></html>");
		heading.setBounds(381, 0, 220, 49);
		panel.add(heading);
		
		//Abschnitt Standort
		JLabel infoLocation = new JLabel("<html><body><h3>Schritt 2:</h3><p>Wählen Sie hier den Standort aus:</p></body></html>");
		infoLocation.setBounds(300, 39, 257, 82);
		panel.add(infoLocation);
		
		listLocations.setBounds(300, 109, 90, 75);
		listLocations.setSelectedIndex(0);
		listLocations.addMouseListener(this);
		panel.add(listLocations);
	
		tipLocations.setBounds(400, 117, 138, 55);
		panel.add(tipLocations);
	
		comboBox.setBounds(570, 126, 112, 25);
		panel.add(comboBox);
		
		///////Abschnitt Inneneinrichtung
		JLabel infoInterior = new JLabel("<html><body><p>Wählen Sie die Inneneinrichtung:</p></body></html>");
		infoInterior.setBounds(300, 170, 257, 82);
		panel.add(infoInterior);
		
		listInterior.setBounds(300, 222, 90, 56);
		listInterior.setSelectedIndex(0);
		listInterior.addMouseListener(this);
		panel.add(listInterior);
		
		tipInterior.setBounds(400, 210, 138, 55);
		panel.add(tipInterior);
		
		//Abschnitt Kredit
		JLabel infoCredit = new JLabel("<html><body><p>Optional: Nehmen Sie einen Kredit auf:</p></body></html>");
		infoCredit.setBounds(300, 268, 257, 82);
		panel.add(infoCredit);
		
		listCredit.setSelectedIndex(0);
		listCredit.addMouseListener(this);
		listCredit.setBounds(300, 320, 90, 72);
		panel.add(listCredit);
		
		tipCredit.setBounds(400, 319, 138, 55);
		panel.add(tipCredit);
		
		/////////////////////
		btnConfirm.setBounds(427, 420, 95, 23);
		btnConfirm.addActionListener(this);
		panel.add(btnConfirm);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 900, 500);
		frame.setVisible(true);
	}
	
	/////////////////Listener-Methoden
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Object s = e.getSource();
		if(s == listLocations)
		{
			int p = listLocations.getSelectedIndex();
			
			if(p == 0)
			{
				tipLocations.setText("");
			}
			else if(p == 1)
			{
				tipLocations.setText("");
			}
			else if(p == 2)
			{
				tipLocations.setText("");
			}
			else if(p == 3)
			{
				tipLocations.setText("");
			}
		}
		if(s == listInterior)
		{
			int p = listInterior.getSelectedIndex();
			
			if(p == 0)
			{
				tipInterior.setText("");
			}
			else if(p == 1)
			{
				tipInterior.setText("");
			}
			else if(p == 2)
			{
				tipInterior.setText("");
			}
		}
		if(s == listCredit)
		{
			int p = listCredit.getSelectedIndex();
			
			if(p == 0)
			{
				tipCredit.setText("");
			}
			else if(p == 1)
			{
				tipCredit.setText("");
			}
			else if(p == 2)
			{
				tipCredit.setText("");
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object s = e.getSource();
		if(s == btnConfirm)
		{
			location = listLocations.getSelectedValue().toString();
			interior = listInterior.getSelectedValue().toString();
			credit = listCredit.getSelectedValue().toString();
			storageArea = comboBox.getSelectedItem().toString(); 
			Overview overview = new Overview(name,location, credit ,interior, storageArea);
			frame.setVisible(false);
			frame.dispose();
		}
	}
}
