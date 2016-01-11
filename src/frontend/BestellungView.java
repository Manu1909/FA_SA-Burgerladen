package frontend;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import backend.Datenbank;

public class BestellungView extends JFrame implements ActionListener, MouseListener {
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
	private int n;

	public BestellungView(int n) {
		zeigeFensterBestellung();
		this.n = n;
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
		lblFleischErk.setText("<html><body><p>Kosten pro Burger: " + kostenFl[0] + " €" + "<br> Qualität: "
				+ qualitaetFl[0] + " Punkte" + "<br> Gammelfleischrisiko: " + risikoquoteFl[0]
				+ " Prozent </p><body></html>");
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
		Overview.getFrame().setFocusableWindowState(false);
		frameBestellungen.setUndecorated(true);
		frameBestellungen.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameBestellungen.setContentPane(contentPaneBestellungen);
		frameBestellungen.setBounds(100, 100, 600, 650);
		frameBestellungen.setVisible(true);
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
					Overview.verarbeiteBestellung(Integer.parseInt(txtBurgerZahl.getText()),
							"Bestellung:     " + txtBurgerZahl.getText() + " Burger");
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

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
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

}
