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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class PreisView extends JFrame implements ActionListener{
		private JFrame framePreis = new JFrame();
		private JPanel contentPanePreis = new JPanel();
		private JTextField txtPreis = new JTextField();
		private JButton btnPreis = new JButton();
		private int n;
		
	public PreisView(int n)
	{
		this.n = n;
		zeigeFensterPreis();
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

		JLabel preisErk = new JLabel(
				"<html><body>Legen Sie den Preis fest, zu dem ihre Burger verkauft werden sollen. " + "</body></html>");
		preisErk.setBounds(125, 40, 200, 40);
		contentPanePreis.add(preisErk);

		btnPreis.setText("Bestätigen");
		btnPreis.setBounds(170, 150, 120, 23);
		btnPreis.addActionListener(this);
		contentPanePreis.add(btnPreis);

		Overview.getFrame().setFocusableWindowState(false);
		framePreis.setUndecorated(true);
		framePreis.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		framePreis.setBounds(100, 100, 450, 200);
		framePreis.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnPreis) {
			try {
				Controller.getUnternehmen(n).getBurger().setPreis(Integer.parseInt(txtPreis.getText()));
				Overview.verarbeitePreis("Preis/Burger: " + Integer.parseInt(txtPreis.getText()) + "€");
				framePreis.dispose();
			} catch (Exception e1) {
			}
		}
	}
}
