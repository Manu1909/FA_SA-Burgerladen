package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import business.Datenbank;

public class Overview extends JFrame implements ActionListener, MouseListener {

	private String name = "";
	private String standort;
	private String innenausstattung;
	private String werbung;
	private String fleischLieferant;
	private String brotLieferant;
	private String salatLieferant;
	private String saucenLieferant;
	private int burgerZahl;
	private int n;
	private int kredit;
	private int lagerPlatzGroesse;
	private int burgerPreis;
	private int anzahlPersonal;
	private double kapital;
	private double schulden;
	private double gewinn;
	private static business.Unternehmen un;
	private static boolean alleGegruendet = false;

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
	private JLabel lblBestellung = new JLabel();
	private JLabel lblanzahlPersonal = new JLabel();
	private JLabel lblPreis = new JLabel();
	private JLabel lblInnenausstattung = new JLabel();
	private JPanel panel = new JPanel();
	private JTextPane txtLetztePeriode = new JTextPane();
	private JTextPane txtRangliste = new JTextPane();
	private JButton btnRundeBeenden = new JButton("Runde beenden");

	// Variablen Marketing
	private JButton btnConfirm = new JButton("Bestätigen");
	private JPanel contentPaneMarketing = new JPanel();
	private String[] marketingOptionen = { Datenbank.marketing[0].getBezeichnung(),
			Datenbank.marketing[1].getBezeichnung(), Datenbank.marketing[2].getBezeichnung(), "Kein Marketing" };
	private int[] bekanntheitsPlus = { Datenbank.marketing[0].getBekanntheitssteigerung(),
			Datenbank.marketing[1].getBekanntheitssteigerung(), Datenbank.marketing[2].getBekanntheitssteigerung() };
	private int[] zufriedenheitsPlus = { Datenbank.marketing[0].getKundenzufriednenheitssteigerung(),
			Datenbank.marketing[1].getKundenzufriednenheitssteigerung(),
			Datenbank.marketing[2].getKundenzufriednenheitssteigerung() };
	private double[] marketingKosten = { Datenbank.marketing[0].getKosten(), Datenbank.marketing[1].getKosten(),
			Datenbank.marketing[2].getKosten() };
	private JList listMarketing = new JList(marketingOptionen);
	private JLabel lblEffekte = new JLabel();
	private JFrame frameMarketing = new JFrame("Burger im Quadrat - Marketing");

	// Variablen Preisfenster
	private JFrame framePreis = new JFrame();
	private JPanel contentPanePreis = new JPanel();
	private JTextField txtPreis = new JTextField();
	private JButton btnPreis = new JButton();

	// Variabeln Personalfenster
	private JFrame framePersonal = new JFrame();
	private JPanel contentPanePersonal = new JPanel();
	private JTextField txtFeuern = new JTextField();
	private JTextField txtEinstellen = new JTextField();
	private JButton btnAbschicken = new JButton("Abschicken");

	// Variablen Catering-Fenster
	private JFrame frameCatering = new JFrame();
	private JPanel contentPaneCatering = new JPanel();
	private JButton btnAngebotAbgeben = new JButton();
	private JButton btnAuftragAblehnen = new JButton();
	private JTextField txtAngebotSumme = new JTextField();

	// Variablen Bestellungs-Fenster
	private JFrame frameBestellungen = new JFrame();
	private JPanel contentPaneBestellungen = new JPanel();
	private JTextField txtBurgerZahl = new JTextField(300);
	private JButton btnBestellungAbschicken = new JButton("Bestellung abschicken");
	private String[] fleischOpt = { "Sutro Großlieferant", "Metzgerei Zorn", "Ernas Fleischerei" };
	private JList listFleisch = new JList(fleischOpt);
	private JLabel lblFleischErk = new JLabel("");
	private String[] broetchenOpt = { "Sutro Großlieferant", "Brotfabrik Mannheim", "Tram GmbH" };
	private JList listBroetchen = new JList(broetchenOpt);
	private JLabel lblBroetchenErk = new JLabel("");
	private String[] salatOpt = { "Sutro Großlieferant", "Farmerland", "Tram GmbH" };
	private JList listSalat = new JList(salatOpt);
	private JLabel lblSalatErk = new JLabel("");;
	private String[] saucenOpt = { "Sutro Großlieferant", "Saucerie de Lyon", "Tram GmbH" };
	private JList listSauce = new JList(saucenOpt);
	private JLabel lblSaucenErk = new JLabel("");;
	private JButton btnGK = new JButton("Gesamtkosten berechnen");
	private JLabel lblGK = new JLabel("n/a");
	// Werte Fleisch
	private double[] kostenFl = { Datenbank.fl[0].getPreisProGut(), Datenbank.fl[1].getPreisProGut(),
			Datenbank.fl[2].getPreisProGut() };
	private int[] qualitaetFl = { Datenbank.fl[0].getQualitaet(), Datenbank.fl[1].getQualitaet(),
			Datenbank.fl[2].getQualitaet() };
	private int[] risikoquoteFl = { Datenbank.fl[0].getRisikoQuote(), Datenbank.fl[1].getRisikoQuote(),
			Datenbank.fl[2].getRisikoQuote() };
	// Werte Broetchen
	private double[] kostenBr = { Datenbank.bl[0].getPreisProGut(), Datenbank.bl[1].getPreisProGut(),
			Datenbank.bl[2].getPreisProGut() };
	private int[] qualitaetBr = { Datenbank.bl[0].getQualitaet(), Datenbank.bl[1].getQualitaet(),
			Datenbank.bl[2].getQualitaet(), };
	// Werte Salat
	private double[] kostenSa = { Datenbank.sal[0].getPreisProGut(), Datenbank.sal[1].getPreisProGut(),
			Datenbank.sal[2].getPreisProGut() };
	private int[] qualitaetSa = { Datenbank.sal[0].getQualitaet(), Datenbank.sal[1].getQualitaet(),
			Datenbank.sal[2].getQualitaet() };
	// Werte Sauce
	private double[] kostenSau = { Datenbank.sol[0].getPreisProGut(), Datenbank.sol[1].getPreisProGut(),
			Datenbank.sol[2].getPreisProGut() };
	private int[] qualitaetSau = { Datenbank.sol[0].getQualitaet(), Datenbank.sol[1].getQualitaet(),
			Datenbank.sol[2].getQualitaet() };

	public Overview(int n) {
		this.n = n;
		this.un = Controller.Controller.getUnternehmen(n);
		this.name = un.getName();
		this.standort = un.getStandort().getLage();
		this.innenausstattung = un.getStandort().getInnenausstattung().getBezeichnung();
		if (un.getKredit() != null)
			this.kredit = un.getKredit().getHoehe();
		else
			this.kredit = 0;
		this.kapital = un.getKapital();
		if (Controller.Controller.getRunde() < 1 && un.getKredit() != null) {
			Controller.Controller.getUnternehmen(n).setKapital(un.getKapital() + un.getKredit().getHoehe());
			this.kapital = un.getKapital();
		}
		this.anzahlPersonal = un.getPersonal().berechneAnzahl();
		try {
			this.gewinn = un.getGewinn();
			this.lagerPlatzGroesse = un.getStandort().getKuehlraum().getLagerGroesse();
			this.werbung = un.getMarketing().getBezeichnung();
			this.burgerPreis = un.getBurger().getPreis();

		} catch (Exception e) {
		}
		zeigeFensterOverview();
	}

	public void zeigeFensterOverview() {
		frame.setTitle("Überblick für " + name);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblInfoText = new JLabel(
				"<html><body>Dieses Fenster bietet ihnen eine Übersicht" + " über die wichtigsten "
						+ "Statistiken ihres Unternehmens. " + "Neben Kapital und Schulden erhalten Sie einen "
						+ "Einblick in die Rangliste und k�nnen mit der oberen Menüleiste"
						+ " zwischen den einzelnen Optionen navigieren" + "</body></html>");
		lblInfoText.setBounds(180, 5, 250, 266);
		panel.add(lblInfoText);

		JLabel lblKapital = new JLabel("Kapital: ");
		lblKapital.setBounds(580, 80, 46, 14);
		panel.add(lblKapital);

		JLabel lblSchulden = new JLabel("Schulden: ");
		lblSchulden.setBounds(580, 110, 75, 14);
		panel.add(lblSchulden);

		lblStandort.setText("Standort:         " + standort);
		lblStandort.setBounds(580, 140, 190, 50);
		panel.add(lblStandort);

		lblMarketing.setText("Marketing:      " + werbung);
		lblMarketing.setBounds(580, 160, 190, 50);
		panel.add(lblMarketing);

		lblanzahlPersonal.setText("Personal:        " + anzahlPersonal);
		lblanzahlPersonal.setBounds(580, 190, 120, 30);
		panel.add(lblanzahlPersonal);

		lblBestellung.setText("keine Bestellung");
		lblBestellung.setBackground(Color.RED);
		lblBestellung.setOpaque(true);
		lblBestellung.setBounds(580, 215, 160, 20);
		panel.add(lblBestellung);

		lblPreis.setText("Preis/Burger: " + un.getBurger().getPreis() + "€");
		lblPreis.setBounds(580, 230, 160, 30);
		panel.add(lblPreis);

		lblInnenausstattung.setText("Ausstattung:  " + innenausstattung);
		lblInnenausstattung.setBounds(580, 250, 160, 30);
		panel.add(lblInnenausstattung);

		JLabel lblRangliste = new JLabel("<html><body><h3>Rangliste:</h3></body></html>");
		lblRangliste.setBounds(350, 210, 75, 50);
		panel.add(lblRangliste);

		JLabel lblLetztePeriode = new JLabel("<html><body><h3>Letzte Periode:</h3></body></html>");
		lblLetztePeriode.setBounds(180, 210, 120, 50);
		panel.add(lblLetztePeriode);

		txtKapital = new JTextField();
		txtKapital.setText("" + kapital);
		txtKapital.setBounds(650, 77, 86, 20);
		txtKapital.setEditable(false);
		panel.add(txtKapital);
		txtKapital.setColumns(10);

		txtSchulden = new JTextField();
		txtSchulden.setBounds(650, 110, 86, 20);
		txtSchulden.setEditable(false);
		panel.add(txtSchulden);
		txtSchulden.setColumns(10);

		btnRundeBeenden.setBounds(344, 390, 150, 23);
		btnRundeBeenden.addActionListener(this);
		btnRundeBeenden.setEnabled(false);
		panel.add(btnRundeBeenden);

		try {
			txtLetztePeriode.setText("Umsatz: " + "€\nGewinn: " + gewinn + "€" + "\n" + "Kunden: "
					+ Controller.Controller.getUnternehmen(n).getKunden());
			txtLetztePeriode.setBounds(180, 250, 151, 52);
			txtLetztePeriode.setEditable(false);
			panel.add(txtLetztePeriode);
		} catch (Exception e) {
		}

		txtRangliste.setText("1. Spieler 1 \n2. Spieler 2\n3. Spieler 2\n4. Spieler 4");
		txtRangliste.setBounds(350, 250, 150, 69);
		txtRangliste.setEditable(false);
		panel.add(txtRangliste);

		bar.setBounds(260, 10, 360, 20);
		menuCatering.addMouseListener(this);
		menuPreis.addMouseListener(this);
		menuMarketing.addMouseListener(this);
		menuBestellung.addMouseListener(this);
		menuPersonal.addMouseListener(this);
		bar.add(menuPreis);
		bar.add(menuMarketing);
		bar.add(menuBestellung);
		bar.add(menuPersonal);
		bar.add(menuCatering);
		menuCatering.setEnabled(false);
		panel.add(bar);

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		if (Controller.Controller.getRunde() == 2 || Controller.Controller.getRunde() == 5
				|| Controller.Controller.getRunde() == 8) {
			JOptionPane.showMessageDialog(this, "In dieser Runde steht ein Catering-Auftrag zur Verfügung");
			menuCatering.setEnabled(true);
		}
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(1, 1, 900, 500);
		frame.setVisible(true);
	}

	public void zeigeFensterPreis() {
		contentPanePreis = new JPanel();
		contentPanePreis.setBorder(new EmptyBorder(5, 5, 5, 5));
		framePreis.setContentPane(contentPanePreis);
		contentPanePreis.setLayout(null);

		txtPreis.setBounds(43, 43, 40, 30);
		contentPanePreis.add(txtPreis);

		btnPreis.setText("Bestätigen");
		btnPreis.setBounds(100, 50, 120, 30);
		btnPreis.addActionListener(this);
		contentPanePreis.add(btnPreis);

		frame.setFocusableWindowState(false);
		framePreis.setUndecorated(true);
		framePreis.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		framePreis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePreis.setBounds(100, 100, 450, 300);
		framePreis.setVisible(true);
	}

	public void zeigeFensterMarketing() {
		contentPaneMarketing = new JPanel();
		contentPaneMarketing.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMarketing.setLayout(null);

		JLabel lblUeberschrift = new JLabel("<html><body><h2 align=center>Marketing</h2></body></html>");
		lblUeberschrift.setBounds(180, 10, 90, 30);
		contentPaneMarketing.add(lblUeberschrift);

		JLabel lblErklaerungMarketing = new JLabel(
				"<html><body>Legen Sie fest, wie ihr Unternehmen beworben werden soll:</body></html>");
		lblErklaerungMarketing.setBounds(106, 40, 230, 80);
		contentPaneMarketing.add(lblErklaerungMarketing);

		listMarketing.setBounds(106, 110, 80, 80);
		listMarketing.setSelectedIndex(0);
		listMarketing.addMouseListener(this);
		contentPaneMarketing.add(listMarketing);

		int p = listMarketing.getSelectedIndex();
		lblEffekte.setText("<html><body>Bekanntheitsgrad: +" + bekanntheitsPlus[p] + "<br>Kundenzufriedenheit: +"
				+ zufriedenheitsPlus[p] + "<br>Kosten: " + marketingKosten[p] + "€</body></html>");
		lblEffekte.setBounds(192, 120, 150, 50);
		contentPaneMarketing.add(lblEffekte);

		btnConfirm.setBounds(171, 240, 100, 23);
		btnConfirm.addActionListener(this);
		contentPaneMarketing.add(btnConfirm);

		frame.setFocusableWindowState(false);
		frameMarketing.setUndecorated(true);
		frameMarketing.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameMarketing.setContentPane(contentPaneMarketing);
		frameMarketing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMarketing.setBounds(100, 100, 450, 300);
		frameMarketing.setVisible(true);
	}

	private void zeigeFensterPersonal() {
		contentPanePersonal = new JPanel();
		contentPanePersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePersonal);
		contentPanePersonal.setLayout(null);

		JLabel lblPersonal = new JLabel("<html><body><h2>Personal</h2></body></html>");
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setBounds(10, 11, 442, 33);
		contentPanePersonal.add(lblPersonal);

		JLabel lblPersonalerk = new JLabel("PersonalErk");
		lblPersonalerk.setBounds(77, 63, 301, 61);
		contentPanePersonal.add(lblPersonalerk);

		JLabel lblEinstellen = new JLabel("Personal einstellen");
		lblEinstellen.setBounds(59, 134, 112, 14);
		contentPanePersonal.add(lblEinstellen);

		txtEinstellen = new JTextField();
		txtEinstellen.setText("0");
		txtEinstellen.setBounds(240, 131, 161, 20);
		contentPanePersonal.add(txtEinstellen);
		txtEinstellen.setColumns(10);

		JLabel lblFeuern = new JLabel("Personal feuern");
		lblFeuern.setBounds(59, 178, 97, 14);
		contentPanePersonal.add(lblFeuern);

		txtFeuern = new JTextField();
		txtFeuern.setText("0");
		txtFeuern.setBounds(240, 175, 161, 20);
		contentPanePersonal.add(txtFeuern);
		txtFeuern.setColumns(10);

		btnAbschicken.setBounds(199, 269, 89, 23);
		btnAbschicken.addActionListener(this);
		contentPanePersonal.add(btnAbschicken);

		frame.setFocusableWindowState(false);
		framePersonal.setUndecorated(true);
		framePersonal.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		framePersonal.setContentPane(contentPanePersonal);
		framePersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePersonal.setBounds(100, 100, 501, 364);
		framePersonal.setVisible(true);
	}

	private void zeigeFensterCatering() {

	}

	private void zeigeFensterBestellung() {
		// contentPane-Settings
		contentPaneBestellungen = new JPanel();
		contentPaneBestellungen.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		contentPaneBestellungen.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPaneBestellungen.setLayout(null);

		// Überschrift
		JLabel lblBestellungen = new JLabel("<html><body><h2>Bestellungen</h2></body></html>");
		lblBestellungen.setBounds(5, 5, 574, 33);
		lblBestellungen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPaneBestellungen.add(lblBestellungen);

		// Burger
		JLabel lblBestellung = new JLabel("Ich bestelle für");
		lblBestellung.setBounds(27, 76, 116, 14);
		contentPaneBestellungen.add(lblBestellung);
		txtBurgerZahl.setBounds(120, 73, 86, 20);
		contentPaneBestellungen.add(txtBurgerZahl);
		txtBurgerZahl.setColumns(10);
		JLabel lblBurger = new JLabel("Burger" + "          (Lagerinhalt: "
				+ Controller.Controller.getUnternehmen(n).getStandort().getKuehlraum().getInhalt() + "/"
				+ Controller.Controller.getUnternehmen(n).getStandort().getKuehlraum().getLagerGroesse() + ")");
		lblBurger.setBounds(240, 76, 200, 14);
		contentPaneBestellungen.add(lblBurger);

		// Fleisch
		listFleisch.setBounds(120, 104, 137, 62);
		listFleisch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFleisch.addMouseListener(this);
		contentPaneBestellungen.add(lblFleischErk);
		listFleisch.setSelectedIndex(0);
		int a = listFleisch.getSelectedIndex();
		lblFleischErk.setText("<html><body><p>" + "Kosten pro Burger: " + kostenFl[a] + " €" + "<br> Qualität: "
				+ qualitaetFl[a] + " Punkte" + "<br> Gammelfleischrisiko: " + risikoquoteFl[a] + " Prozent "
				+ "</p><body></html>");
		contentPaneBestellungen.add(listFleisch);
		JLabel lblFleisch = new JLabel("Fleisch");
		lblFleisch.setBounds(27, 101, 83, 14);
		contentPaneBestellungen.add(lblFleisch);
		lblFleischErk.setBounds(284, 104, 202, 48);

		// Brötchen
		JLabel lblBroetchen = new JLabel("Brötchen");
		lblBroetchen.setBounds(27, 193, 83, 14);
		contentPaneBestellungen.add(lblBroetchen);
		listBroetchen.setBounds(120, 193, 137, 62);
		listBroetchen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listBroetchen.addMouseListener(this);
		listBroetchen.setSelectedIndex(0);
		int b = listBroetchen.getSelectedIndex();
		lblBroetchenErk.setText("<html><body><p>Kosten pro Burger: " + kostenBr[b] + " €" + "<br> Qualität: "
				+ qualitaetBr[b] + " Punkte. <body></html>");
		contentPaneBestellungen.add(listBroetchen);
		lblBroetchenErk.setBounds(284, 193, 202, 62);
		contentPaneBestellungen.add(lblBroetchenErk);

		// Salatwahl
		JLabel lblSalat = new JLabel("Salat");
		lblSalat.setBounds(27, 299, 46, 14);
		contentPaneBestellungen.add(lblSalat);
		listSalat.setBounds(120, 287, 137, 62);
		listSalat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSalat.addMouseListener(this);
		listSalat.setSelectedIndex(0);
		int c = listSalat.getSelectedIndex();
		lblSalatErk.setText("<html><body><p>Kosten pro Burger: " + kostenSa[c] + " €" + "<br> Qualität: "
				+ qualitaetSa[c] + " Punkte. <body></html>");
		contentPaneBestellungen.add(listSalat);
		lblSalatErk.setBounds(284, 287, 202, 62);
		contentPaneBestellungen.add(lblSalatErk);

		// Sauce
		JLabel lblSauce = new JLabel("Sauce");
		lblSauce.setBounds(27, 398, 46, 14);
		contentPaneBestellungen.add(lblSauce);
		listSauce.setBounds(120, 389, 137, 62);
		listSauce.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSauce.addMouseListener(this);
		listSauce.setSelectedIndex(0);
		int d = listSauce.getSelectedIndex();
		lblSaucenErk.setText("<html><body><p>Kosten pro Burger: " + kostenSau[d] + " €" + "<br> Qualität: "
				+ qualitaetSau[d] + " Punkte. <body></html>");
		contentPaneBestellungen.add(listSauce);
		lblSaucenErk.setBounds(284, 389, 202, 62);
		contentPaneBestellungen.add(lblSaucenErk);

		// Gesamtkosten
		btnGK.setBounds(120, 493, 179, 23);
		btnGK.addActionListener(this);
		contentPaneBestellungen.add(btnGK);
		lblGK.setBounds(392, 497, 150, 14);
		contentPaneBestellungen.add(lblGK);

		// Abschicken
		btnBestellungAbschicken.setBounds(222, 552, 147, 23);
		btnBestellungAbschicken.addActionListener(this);
		contentPaneBestellungen.add(btnBestellungAbschicken);

		// Frame-Settings
		frame.setFocusableWindowState(false);
		frameBestellungen.setUndecorated(true);
		frameBestellungen.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameBestellungen.setContentPane(contentPaneBestellungen);
		frameBestellungen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBestellungen.setBounds(100, 100, 600, 650);
		frameBestellungen.setVisible(true);
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
		// Fenster öffnen, falls kein anderes geöffnet ist
		if (frame.getFocusableWindowState() == true) {
			if (s == menuMarketing) {
				zeigeFensterMarketing();
			}
			if (s == menuPreis) {
				zeigeFensterPreis();
			}
			if (s == menuBestellung) {
				zeigeFensterBestellung();
			}
			if (s == menuCatering && menuCatering.isEnabled()) {
				zeigeFensterCatering();
			}
			if (s == menuPersonal && menuPersonal.isEnabled()) {
				zeigeFensterPersonal();
			}
		}

		if (s == listMarketing) {
			int p = listMarketing.getSelectedIndex();
			if (p < 3)
				lblEffekte
						.setText("<html><body>Bekanntheitsgrad: +" + bekanntheitsPlus[p] + "<br>Kundenzufriedenheit: +"
								+ zufriedenheitsPlus[p] + "<br>Kosten: " + marketingKosten[p] + "€</body></html>");
			else
				lblEffekte.setText("<html><body><br>Keine Effekte</body></html>");
		}
		if (s == listFleisch) {
			int a = listFleisch.getSelectedIndex();
			lblFleischErk.setText("<html><body><p>Kosten pro Burger: " + kostenFl[a] + " €" + "<br> Qualität: "
					+ qualitaetFl[a] + " Punkte" + "<br> Gammelfleischrisiko: " + risikoquoteFl[a]
					+ " Prozent </p><body></html>");
		} else if (s == listBroetchen) {
			int b = listBroetchen.getSelectedIndex();
			lblBroetchenErk.setText("<html><body><p>Kosten pro Burger: " + kostenBr[b] + " €" + "<br> Qualität: "
					+ qualitaetBr[b] + " Punkte. <body></html>");
		} else if (s == listSalat) {
			int c = listSalat.getSelectedIndex();
			lblSalatErk.setText("<html><body><p>Kosten pro Burger: " + kostenSa[c] + " €" + "<br> Qualität: "
					+ qualitaetSa[c] + " Punkte. <body></html>");
		} else if (s == listSauce) {
			int d = listSauce.getSelectedIndex();
			lblSaucenErk.setText("<html><body><p>Kosten pro Burger: " + kostenSau[d] + " €" + "<br> Qualität: "
					+ qualitaetSau[d] + " Punkte. <body></html>");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnConfirm) {
			frameMarketing.setVisible(false);
			if (listMarketing.getSelectedIndex() < 3)
				Controller.Controller.getUnternehmen(n)
						.setMarketing(Controller.Controller.waehleMarketing(listMarketing.getSelectedIndex()));
			else
				Controller.Controller.getUnternehmen(n).setMarketing(Controller.Controller.waehleMarketing(-1));

			un = Controller.Controller.getUnternehmen(n);
			if (un.getMarketing() != null)
				this.werbung = un.getMarketing().getBezeichnung();
			else
				this.werbung = "keine";
			lblMarketing.setText("Marketing:      " + werbung);
			frame.setFocusableWindowState(true);
			frameMarketing.dispose();
		}
		if (s == btnPreis) {
			try {
				burgerPreis = Integer.parseInt(txtPreis.getText());
				Controller.Controller.getUnternehmen(n).getBurger().setPreis(Integer.parseInt(txtPreis.getText()));
				un = Controller.Controller.getUnternehmen(n);
				lblPreis.setText("Preis/Burger: " + burgerPreis + "€");
				frame.setFocusableWindowState(true);
				framePreis.setVisible(false);
				framePreis.dispose();
			} catch (NumberFormatException e1) {
			}
		}
		if (s == btnAbschicken) {
			framePersonal.setVisible(false);
			Controller.Controller.getUnternehmen(n).getPersonal()
					.erhoeheAnzahl(Integer.parseInt(txtEinstellen.getText()));
			Controller.Controller.getUnternehmen(n).getPersonal().feuern(Integer.parseInt(txtFeuern.getText()));
			un = Controller.Controller.getUnternehmen(n);
			lblanzahlPersonal.setText("Personal:        " + un.getPersonal().berechneAnzahl());
			menuPersonal.setEnabled(false);
			frame.setFocusableWindowState(true);
			framePersonal.dispose();
		}
		if (s == btnBestellungAbschicken) {
			try {
				if (Integer.parseInt(txtBurgerZahl.getText()) <= Controller.Controller.getUnternehmen(n).getPersonal()
						.berechneKapazitaet()) {
					// Bestellung übergeben
					Controller.Controller.getUnternehmen(n).getBestellung().bestellen(
							Datenbank.fl[listFleisch.getSelectedIndex()],
							Datenbank.bl[listBroetchen.getSelectedIndex()], Datenbank.sal[listSalat.getSelectedIndex()],
							Datenbank.sol[listSauce.getSelectedIndex()]);
					Controller.Controller.getUnternehmen(n).getBestellung()
							.setzeBestellmenge(Integer.parseInt(txtBurgerZahl.getText()), Controller.Controller
									.getUnternehmen(n).getStandort().getKuehlraum().berechneFreienLagerplatz());
					un = Controller.Controller.getUnternehmen(n);
					burgerZahl = Integer.parseInt(txtBurgerZahl.getText());
					fleischLieferant = listFleisch.getSelectedValue().toString();
					brotLieferant = listBroetchen.getSelectedValue().toString();
					salatLieferant = listSalat.getSelectedValue().toString();
					saucenLieferant = listSauce.getSelectedValue().toString();
					lblBestellung.setOpaque(false);
					lblBestellung.setText("Bestellung:     " + txtBurgerZahl.getText() + " Burger");
					btnRundeBeenden.setEnabled(true);
					frame.repaint();
				} else
					JOptionPane.showMessageDialog(this,
							"Sie haben nicht genug Mitarbeiter um diese Menge an Burgern zu vearbeiten");
				frame.setFocusableWindowState(true);
				frameBestellungen.setVisible(false);
				frameBestellungen.dispose();
			} catch (NumberFormatException e1) {
			} catch (HeadlessException e1) {
			}
		}
		if (s == btnGK) {
			if (txtBurgerZahl.getText().equals("")) {
			} else {
				double GK = (Datenbank.fl[listFleisch.getSelectedIndex()].getPreisProGut()
						+ Datenbank.bl[listBroetchen.getSelectedIndex()].getPreisProGut()
						+ Datenbank.sal[listSalat.getSelectedIndex()].getPreisProGut()
						+ Datenbank.sol[listSauce.getSelectedIndex()].getPreisProGut())
						* Integer.parseInt(txtBurgerZahl.getText());
				lblGK.setText("Bestellkosten: " + GK + "€");
			}
		}
		if (frame.getFocusableWindowState()) {
			if (s == btnRundeBeenden && btnRundeBeenden.isEnabled()) {
				Controller.Controller.ereignisTrittEin();
				Controller.Controller.getUnternehmen(n).betreibeMarketing();
				Controller.Controller.getUnternehmen(n).getStandort().getKuehlraum().wareEinlagern(burgerZahl);
				Controller.Controller.getUnternehmen(n).berechneCatering();
				Controller.Controller.getUnternehmen(n).berechneKundenzufriedenheit();
				Controller.Controller.berechneKunden();
				Controller.Controller.getUnternehmen(n).setGewinn(
						Controller.Controller.getUnternehmen(n).berechneGewinn(Controller.Controller.getRunde()));
				Controller.Controller.getUnternehmen(n).setKapital(Controller.Controller.getUnternehmen(n).getKapital()
						+ Controller.Controller.getUnternehmen(n).berechneGewinn(Controller.Controller.getRunde()));
				Controller.Controller.getUnternehmen(n).getStandort().getKuehlraum()
						.wareEntnehmen(Controller.Controller.getUnternehmen(n).getKunden());
				if (n == StartGame.getI() - 1) { //
					alleGegruendet = true;
					// Neue Preise auf Grundlage der Verkaufszahlen
					for (int j = 0; j < Datenbank.fl.length; j++) {
						Datenbank.fl[j].berechneNeuenPreis();
						Datenbank.bl[j].berechneNeuenPreis();
						Datenbank.sal[j].berechneNeuenPreis();
						Datenbank.sol[j].berechneNeuenPreis();
					}
					frame.setVisible(false);
					RundenUbersicht ende = new RundenUbersicht();
					frame.dispose();
				} else if (alleGegruendet) {
					if (n < StartGame.getI() - 1) {
						frame.setVisible(false);
						Overview nextUN = new Overview(n + 1);
						frame.dispose();
					}
				} else {
					if (n < StartGame.getI() - 1) {
						frame.setVisible(false);
						newName nextUN = new newName(n + 1);
						frame.dispose();
					}
				}
			}
		}
	}
}
