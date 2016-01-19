package frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
		JLabel lblText = new JLabel("Rundenzusammenfassung");
		lblText.setBounds(185, 11, 134, 14);
		contentPane.add(lblText);
		frame.setContentPane(contentPane);
		
		btnWeiter.setBounds(207, 372, 65, 23);
		btnWeiter.setText("Weiter");
		btnWeiter.addActionListener(this);
		contentPane.add(btnWeiter);
		
		JLabel lblRunde = new JLabel("Runde:");
		lblRunde.setBounds(126, 38, 46, 14);
		contentPane.add(lblRunde);
		
		JLabel lblzahl = new JLabel(""+Controller.getRunde());
		lblzahl.setBounds(293, 38, 46, 14);
		contentPane.add(lblzahl);
		
		int[] reihenf = frontend.Overview.getReihenfolgeGewinn();
		String reihenfolge = "";
		reihenfolge += "1. " + (Controller.getUnternehmen(reihenf[0]).getName()) + " "
				+ (Controller.getUnternehmen(reihenf[0]).getGewinn()) + " â‚¬";
		for (int m = 1; m < reihenf.length; m++) {
			reihenfolge += "\n" + (m + 1) + ". " + Controller.getUnternehmen(reihenf[m]).getName() + " "
					+ (Controller.getUnternehmen(reihenf[m]).getGewinn()) + " â‚¬";
		}
		
		JPanel panel = new JPanel();
		JTextPane txtUb = new JTextPane();
		txtUb.setBounds(69, 73, 365, 242);
		txtUb.setEditable(false);
		txtUb.setText(reihenfolge);
		panel.add(txtUb);
		panel.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(69, 73, 365, 242);
		contentPane.add(scrollPane);
		
		
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
