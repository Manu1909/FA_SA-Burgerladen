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
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import backend.Datenbank;

public class MarketingView extends JFrame implements ActionListener, MouseListener {
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
	private int n;

	public MarketingView(int n) {
		this.n = n;
		zeigeFensterMarketing();
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

		Overview.getFrame().setFocusableWindowState(false);
		frameMarketing.setUndecorated(true);
		frameMarketing.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameMarketing.setContentPane(contentPaneMarketing);
		frameMarketing.setBounds(100, 100, 450, 300);
		frameMarketing.setVisible(true);
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
		if (s == btnConfirm) {
			if (listMarketing.getSelectedIndex() < 3)
				Controller.getUnternehmen(n)
						.setMarketing(Controller.waehleMarketing(listMarketing.getSelectedIndex()));
			else
				Controller.getUnternehmen(n).setMarketing(Controller.waehleMarketing(-1));

			if (Controller.getUnternehmen(n).getMarketing() != null)
				Overview.verarbeiteMarketing(Controller.getUnternehmen(n).getMarketing().getBezeichnung());
			else
				Overview.verarbeiteMarketing("nichts");
			frameMarketing.dispose();
		}
	}
}
