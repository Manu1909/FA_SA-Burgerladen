package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import business.Datenbank;

public class Overview extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private String name = "";
	private String standort;
	private String innenausstattung;
	private String werbung;
	private int kredit;
	private int lagerPlatzGroesse;
	private int burgerPreis;
	private double kapital;
	private double schulden;
	private double umsatz;
	private double gewinn;
	private static business.Unternehmen un;

	private JTextField txtKapital = new JTextField();
	private JTextField txtSchulden = new JTextField();
	private JPanel contentPane = new JPanel();
	private JFrame frame = new JFrame("Überblick für ");
	private JMenuBar bar = new JMenuBar();
	private JMenu menuCatering = new JMenu("Catering");
	private JMenu menuMarketing = new JMenu("Marketing");
	private JMenu menuPreis = new JMenu("Preis festlegen");
	private JMenu menuBestellung = new JMenu("Bestellungen");
	private JMenu menuPersonal = new JMenu("Personal");
	private JLabel lblStandort = new JLabel();
	private JLabel lblMarketing = new JLabel();
	private JLabel lblKapital = new JLabel();
	private JLabel lblInfoText = new JLabel();
	private JLabel lblSchulden = new JLabel();
	private JLabel lblRangliste = new JLabel();
	private JLabel lblLetztePeriode = new JLabel();
	private JPanel panel = new JPanel();
	private JTextPane txtLetztePeriode = new JTextPane();
	private JTextPane txtRangliste = new JTextPane();

	// Variablen Marketing
	private JButton btnConfirm = new JButton("Bestätigen");
	private JPanel contentPaneMarketing = new JPanel();
	private String[] marketingOptionen = { Datenbank.marketing[0].getBezeichnung(),
			Datenbank.marketing[1].getBezeichnung(), Datenbank.marketing[2].getBezeichnung() };
	private int[] bekanntheitsPlus = { Datenbank.marketing[0].getBekanntheitssteigerung(),
			Datenbank.marketing[1].getBekanntheitssteigerung(), Datenbank.marketing[2].getBekanntheitssteigerung() };
	private int[] zufriedenheitsPlus = { Datenbank.marketing[0].getKundenzufriednenheitssteigerung(),
			Datenbank.marketing[1].getKundenzufriednenheitssteigerung(),
			Datenbank.marketing[2].getKundenzufriednenheitssteigerung() };
	private double[] marketingKosten = { Datenbank.marketing[0].getKosten(), Datenbank.marketing[1].getKosten(),
			Datenbank.marketing[2].getKosten() };

	private JList listMarketing = new JList(marketingOptionen);
	private JTextPane txtEffekte = new JTextPane();
	private JFrame frameMarketing = new JFrame("Burger im Quadrat - Marketing");

	// Variablen Preisfenster
	private JFrame framePreis = new JFrame();
	private JPanel contentPanePreis = new JPanel();
	private JTextField txtPreis = new JTextField();
	private JButton btnPreis = new JButton();

	// Variabeln Personalfenster
	private JFrame framePersonal = new JFrame();
	private JPanel contentPanePersonal = new JPanel();

	// Variablen Catering-Fenster
	private JFrame frameCatering = new JFrame();
	private JPanel contentPaneCatering = new JPanel();
	private JButton btnAngebotAbgeben = new JButton();
	private JButton btnAuftragAblehnen = new JButton();
	private JTextField txtAngebotSumme = new JTextField();

	public Overview(business.Unternehmen un) {
		this.un = un;
		this.name = un.getName();
		this.standort = un.getStandort().getLage();
		this.innenausstattung = un.getStandort().getInnenausstattung().getBezeichnung();
		this.kredit = un.getKredit().getHoehe();
		this.kapital = un.getKapital();
		try {
			this.umsatz = un.getUmsatz();
			this.gewinn = un.getGewinn();
			this.lagerPlatzGroesse = un.getStandort().getKuehlraum().getLagerGroesse();
			this.werbung = un.getMarketing().getBezeichnung();
			this.burgerPreis = un.getBurger().getPreis();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buildWindow();
	}

	public void buildWindow() {
		frame.setTitle("Überblick für " + name);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		positioniereLabelsOverview();
		positioniereTextFieldsOverview();

		JButton btnRundeBeenden = new JButton("Runde beenden");
		btnRundeBeenden.setBounds(344, 390, 150, 23);
		panel.add(btnRundeBeenden);

		positioniereTextPanesOverview();
		positioniereMenuOverview();

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		frame.setContentPane(contentPane);
		frame.setResizable(false);
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(1, 1, 900, 500);
		frame.setVisible(true);
	}

	private void positioniereTextPanesOverview() {
		txtLetztePeriode.setText("Umsatz: " + umsatz + "€\nGewinn: " + gewinn + "€");
		txtLetztePeriode.setBounds(130, 250, 151, 80);
		txtLetztePeriode.setEditable(false);
		panel.add(txtLetztePeriode);

		txtRangliste.setText("1. Spieler 1 \n2. Spieler 2\n3. Spieler 2\n4. Spieler 4");
		txtRangliste.setBounds(640, 248, 150, 69);
		txtRangliste.setEditable(false);
		panel.add(txtRangliste);
	}

	public void positioniereMenuOverview() {
		bar.setBounds(280, 10, 335, 20);

		menuCatering.addMouseListener(this);
		menuPreis.addMouseListener(this);
		menuMarketing.addMouseListener(this);
		menuBestellung.addMouseListener(this);
		menuPersonal.addMouseListener(this);

		bar.add(menuCatering);
		bar.add(menuPreis);
		bar.add(menuMarketing);
		bar.add(menuBestellung);
		bar.add(menuPersonal);
		panel.add(bar);
	}

	public void positioniereLabelsOverview() {
		lblInfoText.setText("<html><body><p>Dieses Fenster bietet ihnen eine Übersicht" + " über die wichtigsten "
				+ "Statistiken ihres Unternehmens. " + "Neben Kapital und Schulden erhalten Sie einen "
				+ "Einblick in die Rangliste und k�nnen mit der oberen Men�leiste"
				+ " zwischen den einzelnen Optionen navigieren" + "</p></body></html>");
		lblInfoText.setBounds(180, 11, 250, 266);
		panel.add(lblInfoText);

		lblKapital.setText("Kapital: ");
		lblKapital.setBounds(580, 66, 46, 14);
		panel.add(lblKapital);

		lblSchulden.setText("Schulden");
		lblSchulden.setBounds(580, 100, 75, 14);
		panel.add(lblSchulden);

		lblStandort.setText("<html><body><p>Standort: " + standort + "</p></body></html>");
		lblStandort.setBounds(580, 140, 130, 50);
		panel.add(lblStandort);

		lblMarketing.setText("Marketing-Aktion: " + werbung);
		lblMarketing.setBounds(580, 160, 130, 50);
		panel.add(lblMarketing);

		lblRangliste.setText("<html><body><h3>Rangliste:</h3></body></html>");
		lblRangliste.setBounds(640, 197, 75, 40);
		panel.add(lblRangliste);

		lblLetztePeriode.setText("<html><body><h3>Letzte Periode:</h3></body></html>");
		lblLetztePeriode.setBounds(130, 210, 120, 50);
		panel.add(lblLetztePeriode);
	}

	public void positioniereTextFieldsOverview() {
		txtKapital = new JTextField();
		txtKapital.setText("" + kapital);
		txtKapital.setBounds(650, 63, 86, 20);
		txtKapital.setEditable(false);
		panel.add(txtKapital);
		txtKapital.setColumns(10);

		txtSchulden = new JTextField();
		txtSchulden.setBounds(650, 100, 86, 20);
		txtSchulden.setEditable(false);
		panel.add(txtSchulden);
		txtSchulden.setColumns(10);
	}

	public void showWindowPreis() {
		contentPanePreis = new JPanel();
		contentPanePreis.setBorder(new EmptyBorder(5, 5, 5, 5));
		framePreis.setContentPane(contentPanePreis);
		contentPanePreis.setLayout(null);

		txtPreis.setBounds(43, 43, 40, 30);
		contentPanePreis.add(txtPreis);

		btnPreis.setText("Bestätigen");
		btnPreis.setBounds(100, 50, 120, 40);
		btnPreis.addActionListener(this);
		contentPanePreis.add(btnPreis);

		frame.setFocusableWindowState(false);
		framePreis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePreis.setBounds(100, 100, 450, 300);
		framePreis.setVisible(true);
	}

	public void showWindowMarketing() {
		contentPaneMarketing = new JPanel();
		contentPaneMarketing.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameMarketing.setContentPane(contentPaneMarketing);
		contentPaneMarketing.setLayout(null);

		listMarketing.setBounds(106, 62, 80, 54);
		listMarketing.setSelectedIndex(0);
		listMarketing.addMouseListener(this);
		contentPaneMarketing.add(listMarketing);

		int p = listMarketing.getSelectedIndex();
		txtEffekte.setText("Bekanntheitsgrad: +" + bekanntheitsPlus[p] + "\nKundenzufriedenheit: +"
				+ zufriedenheitsPlus[p] + "\nKosten: " + marketingKosten[p] + "€");
		txtEffekte.setBounds(192, 11, 150, 50);
		txtEffekte.setEditable(false);
		contentPaneMarketing.add(txtEffekte);

		btnConfirm.setBounds(171, 175, 100, 23);
		btnConfirm.addActionListener(this);
		contentPaneMarketing.add(btnConfirm);

		frame.setFocusableWindowState(false);
		frameMarketing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMarketing.setBounds(100, 100, 450, 300);
		frameMarketing.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object s = e.getSource();
		if (s == listMarketing) {
			int p = listMarketing.getSelectedIndex();
			txtEffekte.setText("Bekanntheitsgrad: +" + bekanntheitsPlus[p] + "\nKundenzufriedenheit: +"
					+ zufriedenheitsPlus[p] + "\nKosten: " + marketingKosten[p] + "€");
		}
		if (s == menuMarketing) {
			showWindowMarketing();
		}
		if (s == menuPreis) {
			showWindowPreis();
		}
		if (s == menuBestellung) {
			zeigeFensterBestellung();
		}
		if (s == menuCatering) {
			zeigeFensterCatering();
		}
		if (s == menuPersonal) {
			zeigeFensterPersonal();
		}
	}

	private void zeigeFensterPersonal() {

	}

	private void zeigeFensterCatering() {

	}

	private void zeigeFensterBestellung() {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnConfirm) {
			frameMarketing.setVisible(false);
			un.setMarketing(Controller.Controller.waehleMarketing(listMarketing.getSelectedIndex()));
			this.werbung = un.getMarketing().getBezeichnung();
			lblMarketing.setText("Marketing-Aktion:" + werbung);
			frame.setFocusableWindowState(true);
			frameMarketing.dispose();
		}
		if (s == btnPreis) {
			framePreis.setVisible(false);
			un.getBurger().setPreis(Integer.parseInt(txtPreis.getText()));
			frame.setFocusableWindowState(true);
			framePreis.dispose();
		}
	}
}
