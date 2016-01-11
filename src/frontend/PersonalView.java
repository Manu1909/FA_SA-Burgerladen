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

public class PersonalView extends JFrame implements ActionListener {

	// Variabeln Personalfenster
	private JFrame framePersonal = new JFrame();
	private JPanel contentPanePersonal = new JPanel();
	private JTextField txtFeuern = new JTextField();
	private JTextField txtEinstellen = new JTextField();
	private JButton btnAbschicken = new JButton("Abschicken");
	private int n;

	public PersonalView(int n) {
		this.n = n;
		zeigeFensterPersonal();
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

		Overview.getFrame().setFocusableWindowState(false);
		framePersonal.setUndecorated(true);
		framePersonal.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		framePersonal.setContentPane(contentPanePersonal);
		framePersonal.setBounds(100, 100, 501, 364);
		framePersonal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnAbschicken) {
			try {
				int einstellen = Integer.parseInt(txtEinstellen.getText());
				int feuern = Integer.parseInt(txtFeuern.getText());
				Overview.verarbeitePersonal(einstellen, feuern);
				framePersonal.dispose();
			} catch (NumberFormatException e1) {
			}
		}

	}

}
