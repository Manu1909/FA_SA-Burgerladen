package frontend;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Overview extends JFrame implements MouseListener, MouseMotionListener{
	
	private String name = "";
	private String location;
	private String interior;
	private int credit;
	private int storageArea;
	
	private JTextField txtCapital = new JTextField();
	private int capital;
	private JTextField txtDebts = new JTextField();
	private int debts;
	private JPanel contentPane = new JPanel();
	public static JFrame frame = new JFrame("Überblick für ");
	private JMenu catering = new JMenu("Catering");
	private JMenu marketing = new JMenu("Marketing");
	private JMenu price = new JMenu("Preis festlegen");
	private JMenu orders = new JMenu("Bestellungen");
	private business.Unternehmen un;
	
	public void setActive(boolean p)
	{
		frame.setFocusableWindowState(p);
	}
	
	public Overview(business.Unternehmen un)
	{
		this.un = un;
		this.name = un.getName();
//		this.location = un.getStandort().getLage();
//		this.interior = un.getStandort().getInnenausstattung().getBezeichnung();
//		this.credit = un.getKredit().getHoehe();
//		this.storageArea = un.getStandort().getKuehlraum().getLagerGroesse();
		buildWindow();
	}
	
	public static void main(String args[])
	{
//		Overview test = new Overview();
	}
	
	public void buildWindow()
	{
		frame.setTitle("Überblick für " + name);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		
		JLabel infoText = new JLabel("<html><body><p>Dieses Fenster bietet ihnen eine Übersicht"
				+ " über die wichtigsten "
				+ "Statistiken ihres Unternehmens. "
				+ "Neben Kapital und Schulden erhalten Sie einen "
				+ "Einblick in die Rangliste und k�nnen mit der oberen Men�leiste"
				+ " zwischen den einzelnen Optionen navigieren"
				+ "</p></body></html>");
		infoText.setBounds(180, 11, 250, 266);
		panel.add(infoText);
		
		JLabel lblKapital = new JLabel("Kapital");
		lblKapital.setBounds(580, 66, 46, 14);
		panel.add(lblKapital);
		
		JLabel lblSchulden = new JLabel("Schulden");
		lblSchulden.setBounds(580, 100, 75, 14);
		panel.add(lblSchulden);
		
		JLabel lblLocation = new JLabel("Standort: " );
		lblLocation.setBounds(580, 140, 90, 14);
		panel.add(lblLocation);
		
		txtCapital = new JTextField();
		txtCapital.setBounds(650, 63, 86, 20);
		txtCapital.setEditable(false);
		panel.add(txtCapital);
		txtCapital.setColumns(10);
		
		txtDebts = new JTextField();
		txtDebts.setBounds(650, 100, 86, 20);
		txtDebts.setEditable(false);
		panel.add(txtDebts);
		txtDebts.setColumns(10);
		
		JLabel lblRangliste = new JLabel("<html><body><h3>Rangliste:</h3></body></html>");
		lblRangliste.setBounds(640, 197, 75, 40);
		panel.add(lblRangliste);
		
		JLabel lblLastPeriod = new JLabel("<html><body><h3>Letzte Periode:</h3></body></html>");
		lblLastPeriod.setBounds(130, 210, 120, 50);
		panel.add(lblLastPeriod);
		
		JTextPane txtLastPeriod = new JTextPane();
		txtLastPeriod.setText("Umsatz:  �");
		txtLastPeriod.setBounds(130, 250, 151, 80);
		panel.add(txtLastPeriod);
		
		JTextPane txtLadder = new JTextPane();
		txtLadder.setText("1. Spieler 1 \n2. Spieler 2\n3. Spieler 2\n4. Spieler 4");
		txtLadder.setBounds(640, 248, 150, 69);
		txtLadder.setEditable(false);
		panel.add(txtLadder);
		
		JButton btnRundeBeenden = new JButton("Runde beenden");
		btnRundeBeenden.setBounds(344, 390, 150, 23);
		panel.add(btnRundeBeenden);
		
		JMenuBar bar = new JMenuBar();
		bar.setBounds(280,10, 335,20);
		
		catering.addMouseListener(this);
		price.addMouseListener(this);
		marketing.addMouseListener(this);
		orders.addMouseListener(this);
		
		bar.add(catering);
		bar.add(price);
		bar.add(marketing);
		bar.add(orders);
		
		panel.add(bar);
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(1,1, 900, 500);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Object s = e.getSource();
		
		if(s == marketing)
		{
			frame.setFocusableWindowState(false);
			Marketing marketing = new Marketing();
		}
		if(s == orders)
		{
			frame.setFocusableWindowState(false);
			Bestellungen marketing = new Bestellungen();
		}
		if(s == catering)
		{
			frame.setFocusableWindowState(false);
			Catering catering = new Catering();
		}
		if(s == price)
		{
			frame.setFocusableWindowState(false);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
