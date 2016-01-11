package frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import backend.Datenbank;

public class CateringView extends JFrame implements ActionListener{
	private JFrame frameCatering = new JFrame();
	private JPanel contentPaneCatering = new JPanel();
	private JButton btnAngebotAbgeben = new JButton("Angebot abgeben");
	private JButton btnAuftragAblehnen = new JButton("Nein, danke!");
	private JTextField txtAngebotSumme = new JTextField();
	private String catering;
	private JLabel lblCateringtxt = new JLabel(catering);
	private int n;

	public CateringView(int n) {
		this.n = n;
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

		Overview.getFrame().setFocusableWindowState(false);
		frameCatering.setUndecorated(true);
		frameCatering.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frameCatering.setContentPane(contentPaneCatering);
		frameCatering.setBounds(100, 100, 500, 275);
		frameCatering.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnAngebotAbgeben) {
			try {
				Overview.verarbeiteCatering(Double.parseDouble(txtAngebotSumme.getText()));
				frameCatering.dispose();
			} catch (Exception e1) {
			}
		}
		if (s == btnAuftragAblehnen) {
			Overview.getFrame().setFocusableWindowState(true);
			frameCatering.dispose();
		}

		
	}
}
