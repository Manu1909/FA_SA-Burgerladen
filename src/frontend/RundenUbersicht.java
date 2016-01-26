package frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import Controller.Controller;

public class RundenUbersicht extends JFrame implements ActionListener {
	private JButton btnWeiter = new JButton();
	private business.Unternehmen un;
	JFrame frame = new JFrame();
	JPanel contentPane = new JPanel();

	public RundenUbersicht() {
		buildWindow();
	}

	private void buildWindow() {
		contentPane.setLayout(null);

		JLabel lblText = new JLabel("Rundenübersicht (Runde " + (Controller.getRunde() + 1) + ")");
		lblText.setBounds(175, 11, 200, 14);
		contentPane.add(lblText);
		frame.setContentPane(contentPane);

		btnWeiter.setBounds(175, 372, 150, 23);
		btnWeiter.setText("Nächste Runde");
		btnWeiter.addActionListener(this);
		contentPane.add(btnWeiter);

		JLabel lblRunde = new JLabel("Gewinne:");
		lblRunde.setBounds(70, 50, 100, 14);
		contentPane.add(lblRunde);

		if (Controller.getRunde() >= 11) {
			lblRunde.setText("Kapitalstände:");
			int[] reihenf = frontend.Overview.getReihenfolgeKapital();
			String reihenfolge = "";
			reihenfolge += "1. " + (Controller.getUnternehmen(reihenf[0]).getName()) + ": "
					+ (Controller.getUnternehmen(reihenf[0]).getKapital()) + " €";
			for (int m = 1; m < reihenf.length; m++) {
				reihenfolge += "\n" + (m + 1) + ". " + Controller.getUnternehmen(reihenf[m]).getName() + ": "
						+ (Controller.getUnternehmen(reihenf[m]).getKapital()) + " €";
			}
			lblText.setText("<html><body><h1>" + Controller.getUnternehmen(reihenf[0]).getName() + " hat gewonnen!");
			lblText.setBounds(170, 11, 250, 30);
			btnWeiter.setText("Spiel beenden");
			JPanel panel = new JPanel();
			JTextPane txtUb = new JTextPane();
			txtUb.setBounds(70, 73, 365, 242);
			txtUb.setEditable(false);
			txtUb.setText(reihenfolge);
			panel.add(txtUb);
			panel.setBackground(Color.WHITE);
			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(69, 73, 365, 242);
			contentPane.add(scrollPane);
		}
		if (Controller.getRunde() < 11) {
			int[] reihenf = frontend.Overview.getReihenfolgeGewinn();
			String reihenfolge = "";
			reihenfolge += "1. " + (Controller.getUnternehmen(reihenf[0]).getName()) + ": "
					+ (Controller.getUnternehmen(reihenf[0]).getGewinn()) + " €" + " ("
					+ Controller.getUnternehmen(reihenf[0]).getKunden() + " Kunden)";
			for (int m = 1; m < reihenf.length; m++) {
				reihenfolge += "\n" + (m + 1) + ". " + Controller.getUnternehmen(reihenf[m]).getName() + ": "
						+ (Controller.getUnternehmen(reihenf[m]).getGewinn()) + " €" + " ("
						+ Controller.getUnternehmen(reihenf[m]).getKunden() + " Kunden)";
			}

			JPanel panel = new JPanel();
			JTextPane txtUb = new JTextPane();
			txtUb.setBounds(70, 73, 365, 242);
			txtUb.setEditable(false);
			txtUb.setText(reihenfolge);
			panel.add(txtUb);
			panel.setBackground(Color.WHITE);
			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(69, 73, 365, 242);
			contentPane.add(scrollPane);
		}
		frame.setBounds(500, 400, 500, 465);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnWeiter) {
			if (Controller.getRunde() < 12) {
				frame.dispose();
				Overview overview = new Overview(0);
			}
		}
	}
}
