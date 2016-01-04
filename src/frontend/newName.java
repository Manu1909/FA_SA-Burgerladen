package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class newName extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel();
	private JTextField txtName = new JTextField();
	private JButton btnNext = new JButton("Weiter");
	int n;

	private String name;

	public static void main(String[] args) {
		// newName test = new newName();
	}

	public newName(int n) {
		this.n = n;
		buildWindow();
	}

	public void buildWindow() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel heading = new JLabel("<html><body><h2>Neues Unternehmen</h2></body></html>");
		heading.setBounds(126, 11, 220, 49);
		panel.add(heading);

		btnNext.setBounds(164, 196, 89, 23);
		btnNext.addActionListener(this);
		panel.add(btnNext);

		JLabel info = new JLabel("<html><body><h4>Schritt 1:</h4><p>Name Ihres Unternehmens::</p></body></html>");
		info.setBounds(89, 71, 257, 82);
		panel.add(info);

		txtName = new JTextField();
		txtName.setBounds(89, 144, 257, 20);
		panel.add(txtName);
		txtName.setColumns(10);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);

	}

	// ab hier Listener-Methoden
	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnNext) {
			boolean taken = false;
			for (int i = 0; i < 5; i++) {
				try {
					if (Controller.getUnternehmen(i).getName().equals(txtName.getText()))
						taken = true;
				} catch (Exception e1) {
				}
			}
			if (taken == false) {
				name = txtName.getText();
				newStore store = new newStore(name, n);
				frame.setVisible(false);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Dieser Name ist bereits vergeben.");
			}
		}
	}
}
