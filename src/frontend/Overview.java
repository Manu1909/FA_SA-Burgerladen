package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
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

import Controller.Controller;
import backend.Datenbank;

public class Overview extends JFrame implements ActionListener, MouseListener {

	private static String werbung;
	private String ereignisErgebnis;
	private static int burgerZahl;
	private int n; // Unternehmensnummer
	private static boolean alleGegruendet = false;
	private static double cateringAngebot;
	private static int feuern;
	private static int einstellen;

	private JTextField txtKapital = new JTextField();
	private JTextField txtSchulden = new JTextField();
	private JPanel contentPane = new JPanel();
	private static JFrame frame = new JFrame("Überblick für ");
	private JMenuBar bar = new JMenuBar();
	private JMenu menuCatering = new JMenu("Catering");
	private JMenu menuMarketing = new JMenu("Marketing");
	private JMenu menuPreis = new JMenu("Preis festlegen");
	private JMenu menuBestellung = new JMenu("Bestellungen");
	private JMenu menuPersonal = new JMenu("Personal");
	private JLabel lblStandort = new JLabel();
	private static JLabel lblMarketing = new JLabel();
	private static JLabel lblBestellung = new JLabel();
	private JLabel lblanzahlPersonal = new JLabel();
	private static JLabel lblPreis = new JLabel();
	private JLabel lblInnenausstattung = new JLabel();
	private JPanel panel = new JPanel();
	private JTextPane txtLetztePeriode = new JTextPane();
	private JTextPane txtRanglisteKapital = new JTextPane();
	private JTextPane txtRanglisteGewinn = new JTextPane();
	private static JButton btnRundeBeenden = new JButton("Runde beenden");

	// Variablen Marketing

	// Variablen Bestellungs-Fenster

	public Overview(int n) {
		this.n = n;
		try {
			this.werbung = Controller.getUnternehmen(n).getMarketing().getBezeichnung();
		} catch (Exception e) {
			this.werbung = "nichts";
		}
		zeigeFensterOverview();
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void verarbeitePersonal(int neu, int weg) {
		frame.setFocusableWindowState(true);
		feuern = weg;
		einstellen = neu;
	}

	public static void verarbeiteCatering(double angebot) {
		frame.setFocusableWindowState(true);
		cateringAngebot = angebot;
	}

	public static void verarbeiteBestellung(int n, String textBestellung) {
		burgerZahl = n;
		lblBestellung.setOpaque(false);
		lblBestellung.setText(textBestellung);
		btnRundeBeenden.setEnabled(true);
		frame.repaint();
		frame.setFocusableWindowState(true);
	}

	public static void verarbeiteMarketing(String text) {
		lblMarketing.setText("Marketing:      " + text);
		frame.setFocusableWindowState(true);
	}

	public static void verarbeitePreis(String text) {
		lblPreis.setText(text);
		frame.setFocusableWindowState(true);
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

		JLabel lblRanglisteKapital = new JLabel("<html><body><h3>Kapital</h3></body></html>");
		lblRanglisteKapital.setBounds(345, 270, 150, 50);
		panel.add(lblRanglisteKapital);
		txtRanglisteKapital.setText(rangKapital);
		txtRanglisteKapital.setBounds(345, 310, 150, 69);
		txtRanglisteKapital.setEditable(false);
		panel.add(txtRanglisteKapital);

		JLabel lblRanglisteGewinn = new JLabel("<html><body><h3>Gewinn letzte Runde</h3></body></html>");
		lblRanglisteGewinn.setBounds(150, 270, 150, 50);
		panel.add(lblRanglisteGewinn);
		txtRanglisteGewinn.setText(rangGewinn);
		txtRanglisteGewinn.setBounds(150, 310, 150, 69);
		txtRanglisteGewinn.setEditable(false);
		panel.add(txtRanglisteGewinn);

		if (Controller.getRunde() == 0) {
			panel.remove(txtRanglisteKapital);
			panel.remove(lblRanglisteKapital);
			panel.remove(txtLetztePeriode);
			panel.remove(lblLetztePeriode);
			panel.remove(txtRanglisteGewinn);
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
		frame.setVisible(true);
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
				MarketingView marketing = new MarketingView(n);
			}
			if (s == menuPreis) {
				PreisView preis = new PreisView(n);
			}
			if (s == menuBestellung) {
				BestellungView bestellung = new BestellungView(n);
			}
			if (s == menuCatering && menuCatering.isEnabled()) {
				CateringView catering = new CateringView(n);
			}
			if (s == menuPersonal && menuPersonal.isEnabled()) {
				PersonalView personal = new PersonalView(n);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();

		if (frame.getFocusableWindowState()) {
			if (s == btnRundeBeenden && btnRundeBeenden.isEnabled()) {
				try {
					if (Controller.getRunde() == 3) {
						Datenbank.c1.addPreis(cateringAngebot);
						Datenbank.c1.addQualitaet(Controller.getUnternehmen(n).getBurger().getQualitaet());
					}
					if (Controller.getRunde() == 6) {
						Datenbank.c2.addPreis(cateringAngebot);
						Datenbank.c2.addQualitaet(Controller.getUnternehmen(n).getBurger().getQualitaet());
					}
					if (Controller.getRunde() == 9) {
						Datenbank.c3.addPreis(cateringAngebot);
						Datenbank.c3.addQualitaet(Controller.getUnternehmen(n).getBurger().getQualitaet());
					}
				} catch (Exception e2) {
				}
				try {
					Controller.getUnternehmen(n).getPersonal().erhoeheAnzahl(einstellen);
					Controller.getUnternehmen(n).getPersonal().feuern(feuern);
				} catch (Exception e1) {
				}
				Controller.getUnternehmen(n).betreibeMarketing();
				Controller.getUnternehmen(n).getStandort().getKuehlraum().wareEinlagern(burgerZahl);
				Controller.getUnternehmen(n).berechneCatering();
				Controller.unternehmensRundeBeenden(Controller.getUnternehmen(n));
				if (n == StartGame.getI() - 1) {
					alleGegruendet = true;
					String ereignisErgebnis = Controller.ereignisTrittEin();
					if (Controller.getRunde() == 3 || Controller.getRunde() == 6 || Controller.getRunde() == 9)
						Controller.cateringAuswahlTreffen(Controller.getRunde());
					RundenUbersicht ende = new RundenUbersicht(ereignisErgebnis);
					frame.dispose();
				} else if (alleGegruendet) {
					if (n < StartGame.getI() - 1) {
						Overview nextUN = new Overview(n + 1);
						frame.dispose();
					}
				} else {
					if (n < StartGame.getI() - 1) {
						newName nextUN = new newName(n + 1);
						frame.dispose();
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
