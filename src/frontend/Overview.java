package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import backend.Datenbank;

public class Overview extends JFrame implements ActionListener, MouseListener {

	private static String werbung;
	private String ereignisErgebnis;
	private int burgerZahl;
	private int n; // Unternehmensnummer
	private static boolean alleGegruendet = false;
	private int feuern;
	private int einstellen;

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
	private JTextPane txtRanglisteKapital = new JTextPane();
	private JTextPane txtRanglisteGewinn = new JTextPane();
	private JButton btnRundeBeenden = new JButton("Runde beenden");

	// Variablen Bestellung
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

	// Variablen Preis-Fenster
	private JFrame framePreis = new JFrame();
	private JPanel contentPanePreis = new JPanel();
	private JTextField txtPreis = new JTextField();
	private JButton btnPreis = new JButton();
	JLabel preisErk = new JLabel(
			"<html><body>Legen sie einen Burgerpreis zwischen 0 und 25 € fest." + "</body></html>");

	// Variabelen Catering
	private JFrame frameCatering = new JFrame();
	private JPanel contentPaneCatering = new JPanel();
	private JButton btnAngebotAbgeben = new JButton("Angebot abgeben");
	private JButton btnAuftragAblehnen = new JButton("Nein, danke!");
	private JTextField txtAngebotSumme = new JTextField();
	private String catering;
	private JLabel lblCateringtxt = new JLabel(catering);

	// variablen personal
	private JFrame framePersonal = new JFrame();
	private JPanel contentPanePersonal = new JPanel();
	private JTextField txtFeuern = new JTextField();
	private JTextField txtEinstellen = new JTextField();
	private JButton btnAbschicken = new JButton("Abschicken");

	public Overview(int n) {
		this.n = n;
		try {
			this.werbung = Controller.getUnternehmen(n).getMarketing().getBezeichnung();
		} catch (Exception e) {
			this.werbung = "nichts";
		}
		zeigeFensterOverview();
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
				+ Controller.getUnternehmen(n).getStandort().getKuehlraum().getInhalt() + "/"
				+ Controller.getUnternehmen(n).getStandort().getKuehlraum().getLagerGroesse() + ")");
		lblBurger.setBounds(240, 76, 200, 14);
		contentPaneBestellungen.add(lblBurger);

		// Fleisch
		listFleisch.setBounds(120, 104, 137, 62);
		listFleisch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFleisch.setSelectedIndex(0);
		listFleisch.addMouseListener(this);
		lblFleischErk
				.setText("<html><body><p>Kosten pro Burger: " + kostenFl[0] + " €" + "<br> Qualität: " + qualitaetFl[0]
						+ " Punkte" + "<br> Gammelfleischrisiko: " + risikoquoteFl[0] + " Prozent </p><body></html>");
		contentPaneBestellungen.add(lblFleischErk);
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
		listBroetchen.setSelectedIndex(0);
		listBroetchen.addMouseListener(this);
		lblBroetchenErk.setText("<html><body><p>Kosten pro Burger: " + kostenBr[0] + " €" + "<br> Qualität: "
				+ qualitaetBr[0] + " Punkte. <body></html>");
		contentPaneBestellungen.add(listBroetchen);
		lblBroetchenErk.setBounds(284, 193, 202, 62);
		contentPaneBestellungen.add(lblBroetchenErk);

		// Salatwahl
		JLabel lblSalat = new JLabel("Salat");
		lblSalat.setBounds(27, 299, 46, 14);
		contentPaneBestellungen.add(lblSalat);
		listSalat.setBounds(120, 287, 137, 62);
		listSalat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSalat.setSelectedIndex(0);
		listSalat.addMouseListener(this);
		lblSalatErk.setText("<html><body><p>Kosten pro Burger: " + kostenSa[0] + " €" + "<br> Qualität: "
				+ qualitaetSa[0] + " Punkte. <body></html>");
		contentPaneBestellungen.add(listSalat);
		lblSalatErk.setBounds(284, 287, 202, 62);
		contentPaneBestellungen.add(lblSalatErk);

		// Sauce
		JLabel lblSauce = new JLabel("Sauce");
		lblSauce.setBounds(27, 398, 46, 14);
		contentPaneBestellungen.add(lblSauce);
		listSauce.setBounds(120, 389, 137, 62);
		listSauce.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSauce.setSelectedIndex(0);
		listSauce.addMouseListener(this);
		lblSaucenErk.setText("<html><body><p>Kosten pro Burger: " + kostenSau[0] + " €" + "<br> Qualität: "
				+ qualitaetSau[0] + " Punkte. <body></html>");
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
		frameBestellungen.setUndecorated(true);
		frameBestellungen.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameBestellungen.setContentPane(contentPaneBestellungen);
		frameBestellungen.setBounds(100, 100, 600, 650);
		frameBestellungen.setLocationRelativeTo(null);
		frameBestellungen.setVisible(true);
	}

	public void zeigeFensterOverview() {
		frame.setTitle(
				"Überblick für " + Controller.getUnternehmen(n).getName() + " (Runde " + Controller.getRunde() + ")");
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

		lblStandort.setText("Standort:         " + Controller.getUnternehmen(n).getStandort().getLage());
		lblStandort.setBounds(580, 150, 190, 14);
		panel.add(lblStandort);

		lblMarketing.setText("Marketing:      " + werbung);
		lblMarketing.setBounds(580, 170, 190, 14);
		panel.add(lblMarketing);

		lblanzahlPersonal
				.setText("Personal:        " + Controller.getUnternehmen(n).getPersonal().getAnzahlAngestellte());
		lblanzahlPersonal.setBounds(580, 190, 120, 14);
		panel.add(lblanzahlPersonal);

		lblBestellung.setText("keine Bestellung");
		lblBestellung.setBackground(Color.RED);
		lblBestellung.setOpaque(true);
		lblBestellung.setBounds(580, 210, 160, 14);
		panel.add(lblBestellung);

		lblPreis.setText("Preis/Burger: " + Controller.getUnternehmen(n).getBurger().getPreis() + "€");
		lblPreis.setBounds(580, 230, 190, 14);
		panel.add(lblPreis);

		lblInnenausstattung.setText(
				"Ausstattung:  " + Controller.getUnternehmen(n).getStandort().getInnenausstattung().getBezeichnung());
		lblInnenausstattung.setBounds(580, 250, 160, 14);
		panel.add(lblInnenausstattung);

		txtKapital = new JTextField();
		txtKapital.setBounds(650, 77, 86, 20);
		txtKapital.setEditable(false);
		panel.add(txtKapital);
		txtKapital.setColumns(10);

		txtSchulden = new JTextField();
		txtSchulden.setBounds(650, 110, 86, 20);
		txtSchulden.setEditable(false);
		panel.add(txtSchulden);
		txtSchulden.setColumns(10);

		if (Controller.getUnternehmen(n).getKapital() >= 0) {
			txtKapital.setText("" + Controller.getUnternehmen(n).getKapital() + " €");
			txtSchulden.setText("" + 0 + " €");
		} else {
			txtSchulden.setText("" + Math.abs(Controller.getUnternehmen(n).getKapital()) + " €");
			txtKapital.setText("" + 0 + " €");
		}

		btnRundeBeenden.setBounds(345, 390, 150, 23);
		btnRundeBeenden.addActionListener(this);
		btnRundeBeenden.setEnabled(false);
		panel.add(btnRundeBeenden);

		JLabel lblLetztePeriode = new JLabel("<html><body><h3>Letzte Periode:</h3></body></html>");
		lblLetztePeriode.setBounds(580, 270, 120, 50);
		panel.add(lblLetztePeriode);
		try {
			txtLetztePeriode.setText("Umsatz: " + Controller.getUnternehmen(n).getUmsatz() + "€\nGewinn: "
					+ Controller.getUnternehmen(n).getGewinn() + "€" + "\n" + "Kunden: "
					+ Controller.getUnternehmen(n).getKunden());
			txtLetztePeriode.setBounds(580, 310, 151, 52);
			txtLetztePeriode.setEditable(false);
			panel.add(txtLetztePeriode);
		} catch (Exception e) {
		}

		int[] ranglisteKapital = getReihenfolgeKapital();
		int[] ranglisteGewinn = getReihenfolgeGewinn();
		String rangKapital = "";
		String rangGewinn = "";
		rangKapital += "1. " + Controller.getUnternehmen(ranglisteKapital[0]).getName() + " "
				+ Controller.getUnternehmen(ranglisteKapital[0]).getKapital() + " €";
		rangGewinn += "1. " + (Controller.getUnternehmen(ranglisteKapital[0]).getName()) + " "
				+ (Controller.getUnternehmen(ranglisteKapital[0]).getGewinn()) + " €";
		for (int p = 1; p < ranglisteKapital.length; p++) {
			rangKapital += "\n" + (p + 1) + ". " + Controller.getUnternehmen(ranglisteKapital[p]).getName() + " "
					+ Controller.getUnternehmen(ranglisteKapital[p]).getKapital() + " €";
			rangGewinn += "\n" + (p + 1) + ". " + Controller.getUnternehmen(ranglisteKapital[p]).getName() + " "
					+ (Controller.getUnternehmen(ranglisteKapital[p]).getGewinn()) + " €";
		}

		JPanel panelKapital = new JPanel();
		panelKapital.setBackground(Color.WHITE);
		JLabel lblRanglisteKapital = new JLabel("<html><body><h3>Kapital</h3></body></html>");
		lblRanglisteKapital.setBounds(345, 270, 150, 50);
		txtRanglisteKapital.setText(rangKapital);
		txtRanglisteKapital.setEditable(false);
		txtRanglisteKapital.setBounds(150, 310, 150, 69);
		panelKapital.add(txtRanglisteKapital);
		JScrollPane scrollPaneKapital = new JScrollPane (panelKapital, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneKapital.setBounds(345, 310, 150, 69);
		panel.add(scrollPaneKapital);

		JPanel panelGewinn = new JPanel();
		panelGewinn.setBackground(Color.WHITE);
		JLabel lblRanglisteGewinn = new JLabel("<html><body><h3>Gewinn letzte Runde</h3></body></html>");
		lblRanglisteGewinn.setBounds(150, 270, 150, 50);
		txtRanglisteGewinn.setText(rangGewinn);
		txtRanglisteGewinn.setBounds(150, 310, 150, 69);
		txtRanglisteGewinn.setEditable(false);
		panelGewinn.add(txtRanglisteGewinn);
		JScrollPane scrollPaneGewinn = new JScrollPane (panelGewinn, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneGewinn.setBounds(150, 310, 150, 69);
		panel.add(scrollPaneGewinn);

		if (Controller.getRunde() == 0) {
			panel.remove(scrollPaneKapital);
			panel.remove(lblRanglisteKapital);
			panel.remove(txtLetztePeriode);
			panel.remove(lblLetztePeriode);
			panel.remove(scrollPaneGewinn);
			panel.remove(lblRanglisteGewinn);
		}

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

		if (Controller.getRunde() == 3 || Controller.getRunde() == 6 || Controller.getRunde() == 9) {
			JOptionPane.showMessageDialog(this, "In dieser Runde steht ein Catering-Auftrag zur Verfügung");
			menuCatering.setEnabled(true);
		}
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(1, 1, 900, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
		listMarketing.addMouseListener(this);
		contentPaneMarketing.add(listMarketing);

		lblEffekte.setBounds(192, 120, 150, 50);
		contentPaneMarketing.add(lblEffekte);

		btnConfirm.setBounds(171, 240, 100, 23);
		btnConfirm.addActionListener(this);
		contentPaneMarketing.add(btnConfirm);

		frame.setFocusableWindowState(false);
		frameMarketing.setUndecorated(true);
		frameMarketing.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameMarketing.setContentPane(contentPaneMarketing);
		frameMarketing.setBounds(100, 100, 450, 300);
		frameMarketing.setLocationRelativeTo(null);
		frameMarketing.setVisible(true);
	}

	public void zeigeFensterPersonal() {
		contentPanePersonal = new JPanel();
		contentPanePersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		framePersonal.setContentPane(contentPanePersonal);
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
		txtEinstellen.setBounds(240, 131, 161, 20);
		contentPanePersonal.add(txtEinstellen);
		txtEinstellen.setColumns(10);

		JLabel lblFeuern = new JLabel("Personal feuern");
		lblFeuern.setBounds(59, 178, 97, 14);
		contentPanePersonal.add(lblFeuern);

		txtFeuern = new JTextField();
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
		framePersonal.setBounds(100, 100, 501, 364);
		framePersonal.setLocationRelativeTo(null);
		framePersonal.setVisible(true);
	}

	public void zeigeFensterPreis() {
		contentPanePreis = new JPanel();
		contentPanePreis.setBorder(new EmptyBorder(5, 5, 5, 5));
		framePreis.setContentPane(contentPanePreis);
		contentPanePreis.setLayout(null);

		JLabel lblPreisHead = new JLabel("<html><body><h2>Preis wählen</h2></body></html>");
		lblPreisHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreisHead.setBounds(10, 5, 442, 33);
		contentPanePreis.add(lblPreisHead);

		txtPreis.setBounds(205, 100, 50, 23);
		contentPanePreis.add(txtPreis);

		preisErk.setBounds(145, 40, 200, 40);
		preisErk.setHorizontalAlignment(SwingConstants.CENTER);
		preisErk.setOpaque(false);
		contentPanePreis.add(preisErk);

		btnPreis.setText("Bestätigen");
		btnPreis.setBounds(170, 150, 120, 23);
		btnPreis.addActionListener(this);
		contentPanePreis.add(btnPreis);

		frame.setFocusableWindowState(false);
		framePreis.setUndecorated(true);
		framePreis.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		framePreis.setBounds(100, 100, 450, 200);
		framePreis.setLocationRelativeTo(null);
		framePreis.setVisible(true);
	}

	public void zeigeFensterCatering() {
		if (Controller.getRunde() == 3) {
			catering = "<html><body>Der 'Mannheimer Morgen' möchte bei einem städtischen Burgerladen für eine Firmenfeier 1000 Burger bestellen. Möchten Sie ein Angebot abgeben?</html></body>";
		} else if (Controller.getRunde() == 6) {
			catering = "<html><body>Es ist wieder Zeit für das Sommerfest an der DHBW Mannheim! Sie können ein Angebot für 2000 Burger abgeben.</html></body>";
		} else if (Controller.getRunde() == 9) {
			catering = "<html><body>Die Adler Mannheim sind Meister! Bei der angemessenen Feier dürfen auf keinen Fall die besten Burger Mannheims fehlen. Möchten Sie an der Ausschreibung für 5000 Burger teilnehmen?</html></body>";
		} else {
			catering = "Keine Catering-Ausschreibungen verfügbar.";
		}
		contentPaneCatering.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneCatering.setLayout(null);
		JLabel lblCatering = new JLabel("<html><body><h2>Catering</h2></body></html>");
		lblCatering.setBounds(5, 5, 474, 30);
		lblCatering.setHorizontalAlignment(SwingConstants.CENTER);
		contentPaneCatering.add(lblCatering);

		lblCateringtxt.setText(catering);
		lblCateringtxt.setBounds(145, 25, 250, 150);
		lblCateringtxt.setHorizontalAlignment(SwingConstants.CENTER);
		contentPaneCatering.add(lblCateringtxt);

		txtAngebotSumme.setBounds(176, 150, 144, 20);
		contentPaneCatering.add(txtAngebotSumme);
		txtAngebotSumme.setColumns(10);

		btnAngebotAbgeben.setBounds(97, 200, 134, 23);
		contentPaneCatering.add(btnAngebotAbgeben);
		btnAngebotAbgeben.addActionListener(this);

		btnAuftragAblehnen.setBounds(273, 200, 134, 23);
		contentPaneCatering.add(btnAuftragAblehnen);
		btnAuftragAblehnen.addActionListener(this);

		frame.setFocusableWindowState(false);
		frameCatering.setUndecorated(true);
		frameCatering.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameCatering.setContentPane(contentPaneCatering);
		frameCatering.setBounds(100, 100, 500, 275);
		frameCatering.setLocationRelativeTo(null);
		frameCatering.setVisible(true);

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
			if (s == menuPersonal) {
				zeigeFensterPersonal();
			}
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
		if (s == listMarketing) {
			int p = listMarketing.getSelectedIndex();
			if (p < 3)
				lblEffekte
						.setText("<html><body>Bekanntheitsgrad: +" + bekanntheitsPlus[p] + "<br>Kundenzufriedenheit: +"
								+ zufriedenheitsPlus[p] + "<br>Kosten: " + marketingKosten[p] + "€</body></html>");
			else
				lblEffekte.setText("<html><body><br>Keine Effekte</body></html>");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnBestellungAbschicken) {
			try {
				if (Integer.parseInt(txtBurgerZahl.getText())
						+ Controller.getUnternehmen(n).getStandort().getKuehlraum().getInhalt() <= Controller
								.getUnternehmen(n).getStandort().getKuehlraum().getLagerGroesse()) {
					// Bestellung übergeben
					Controller.getUnternehmen(n).getBestellung().bestellen(Datenbank.fl[listFleisch.getSelectedIndex()],
							Datenbank.bl[listBroetchen.getSelectedIndex()], Datenbank.sal[listSalat.getSelectedIndex()],
							Datenbank.sol[listSauce.getSelectedIndex()]);
					Controller.getUnternehmen(n).getBestellung().setzeBestellmenge(
							Integer.parseInt(txtBurgerZahl.getText()),
							Controller.getUnternehmen(n).getStandort().getKuehlraum().berechneFreienLagerplatz());
					burgerZahl = Integer.parseInt(txtBurgerZahl.getText());
					lblBestellung.setText("Bestellung:     " + Integer.parseInt(txtBurgerZahl.getText()) + " Burger");
					lblBestellung.setOpaque(false);
					btnRundeBeenden.setEnabled(true);
					frame.setFocusableWindowState(true);
					frameBestellungen.dispose();

				} else
					JOptionPane.showMessageDialog(this, "Ihr Kühlraum hat nicht genug Platz für die Bestellung");
			} catch (Exception e1) {
			}
		}
		if (s == btnGK) {
			if (txtBurgerZahl.getText().equals("")) {
			} else {
				try {
					double GK = (Datenbank.fl[listFleisch.getSelectedIndex()].getPreisProGut()
							+ Datenbank.bl[listBroetchen.getSelectedIndex()].getPreisProGut()
							+ Datenbank.sal[listSalat.getSelectedIndex()].getPreisProGut()
							+ Datenbank.sol[listSauce.getSelectedIndex()].getPreisProGut())
							* Integer.parseInt(txtBurgerZahl.getText());
					GK = Math.round(100.0 * GK) / 100.0;
					lblGK.setText("Bestellkosten: " + GK + "€");
				} catch (Exception e1) {
				}
			}
		}
		if (s == btnPreis) {
			try {
				if(Integer.parseInt(txtPreis.getText())>= 0 && Integer.parseInt(txtPreis.getText()) <= 25)
				{
					Controller.getUnternehmen(n).getBurger().setPreis(Integer.parseInt(txtPreis.getText()));
					lblPreis.setText("Preis/Burger: " + Controller.getUnternehmen(n).getBurger().getPreis() + "€");
					frame.setFocusableWindowState(true);
					framePreis.dispose();
				}
				else
					preisErk.setBackground(Color.RED);
					preisErk.setOpaque(true);
			} catch (Exception e1) {
				preisErk.setBackground(Color.RED);
				preisErk.setOpaque(true);
			}
		}
		if (s == btnAngebotAbgeben) {
			frame.setFocusableWindowState(true);
			frameCatering.dispose();
		}
		if (s == btnAuftragAblehnen) {
			frame.setFocusableWindowState(true);
			frameCatering.dispose();
		}
		if (s == btnAbschicken) {
			frame.setFocusableWindowState(true);
			framePersonal.dispose();
		}
		if (s == btnConfirm) {
			if (listMarketing.getSelectedIndex() < 3)
				Controller.getUnternehmen(n).setMarketing(Controller.waehleMarketing(listMarketing.getSelectedIndex()));
			else
				Controller.getUnternehmen(n).setMarketing(Controller.waehleMarketing(-1));
			if (Controller.getUnternehmen(n).getMarketing() != null) {
				lblMarketing.setText("Marketing:      " + Controller.getUnternehmen(n).getMarketing().getBezeichnung());
			} else
				lblMarketing.setText("Marketing:      nichts");
			frame.setFocusableWindowState(true);
			frameMarketing.dispose();
		}
		if (frame.getFocusableWindowState()) {
			if (s == btnRundeBeenden && btnRundeBeenden.isEnabled()) {
				try {
					if (Controller.getRunde() == 3) {
						Datenbank.c1.addPreis(Double.parseDouble(txtAngebotSumme.getText()));
						Datenbank.c1.addQualitaet(Controller.getUnternehmen(n).getBurger().getQualitaet());
					}
					if (Controller.getRunde() == 6) {
						Datenbank.c2.addPreis(Double.parseDouble(txtAngebotSumme.getText()));
						Datenbank.c2.addQualitaet(Controller.getUnternehmen(n).getBurger().getQualitaet());
					}
					if (Controller.getRunde() == 9) {
						Datenbank.c3.addPreis(Double.parseDouble(txtAngebotSumme.getText()));
						Datenbank.c3.addQualitaet(Controller.getUnternehmen(n).getBurger().getQualitaet());
					}
				} catch (Exception e2) {
				}

				try {
					Controller.getUnternehmen(n).getPersonal().erhoeheAnzahl(Integer.parseInt(txtEinstellen.getText()));
				} catch (Exception e1) {
				}
				try {
					Controller.getUnternehmen(n).getPersonal().feuern(Integer.parseInt(txtFeuern.getText()));
				} catch (Exception e1) {
				}
				Controller.getUnternehmen(n).betreibeMarketing();
				Controller.getUnternehmen(n).getStandort().getKuehlraum().wareEinlagern(burgerZahl);
				Controller.getUnternehmen(n).berechneCatering();
				Controller.unternehmensRundeBeenden(Controller.getUnternehmen(n));
				if (n == StartGame.getI() - 1) {
					alleGegruendet = true;
					String[] ereignisErgebnis = Controller.ereignisTrittEin(0);
					if (ereignisErgebnis != null){
  						JOptionPane.showMessageDialog(this, ereignisErgebnis);
  					}
					if (Controller.getRunde() == 3 || Controller.getRunde() == 6 || Controller.getRunde() == 9)
						Controller.cateringAuswahlTreffen(Controller.getRunde());
					RundenUbersicht ende = new RundenUbersicht();
					frame.dispose();
				} else if (alleGegruendet) {
					if (n < StartGame.getI() - 1) {
						frame.dispose();
						Overview nextUN = new Overview(n + 1);
					}
				} else {
					if (n < StartGame.getI() - 1) {
						frame.dispose();
						newName nextUN = new newName(n + 1);
					}
				}
			}
		}
	}

	public int[] getReihenfolgeKapital() {
		int[] i = new int[StartGame.getUnZahl()];
		for (int z = 0; z < i.length; z++) {
			i[z] = z;
		}
		for (int j = 0; j < i.length; j++) {
			for (int z = 0; z < i.length - j - 1; z++) {
				if (Controller.getUnternehmen(i[z]).getKapital() < Controller.getUnternehmen(i[z + 1]).getKapital()) {
					int tmp = i[z];
					i[z] = i[z + 1];
					i[z + 1] = tmp;
				}
			}
		}
		return i;
	}

	public int[] getReihenfolgeGewinn() {
		int[] i = new int[StartGame.getUnZahl()];
		for (int z = 0; z < i.length; z++) {
			i[z] = z;
		}
		for (int j = 0; j < i.length; j++) {
			for (int z = 0; z < i.length - j - 1; z++) {
				if (Controller.getUnternehmen(i[z]).getGewinn() < Controller.getUnternehmen(i[z + 1]).getGewinn()) {
					int tmp = i[z];
					i[z] = i[z + 1];
					i[z + 1] = tmp;
				}
			}
		}
		return i;
	}
}
