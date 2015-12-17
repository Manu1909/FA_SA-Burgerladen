package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Personal extends JFrame {

	private JPanel contentPane;
	private JTextField textEinstellen;
	private JTextField textFeuern;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal frame = new Personal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Personal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonal = new JLabel("Personal");
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPersonal.setBounds(10, 11, 442, 14);
		contentPane.add(lblPersonal);
		
		JLabel lblPersonalerk = new JLabel("PersonalErk");
		lblPersonalerk.setBounds(77, 63, 301, 61);
		contentPane.add(lblPersonalerk);
		
		JLabel lblEinstellen = new JLabel("Personal einstellen");
		lblEinstellen.setBounds(59, 134, 112, 14);
		contentPane.add(lblEinstellen);
		
		textEinstellen = new JTextField();
		textEinstellen.setText("0");
		textEinstellen.setBounds(240, 131, 161, 20);
		contentPane.add(textEinstellen);
		textEinstellen.setColumns(10);
		
		JLabel lblFeuern = new JLabel("Personal feuern");
		lblFeuern.setBounds(59, 178, 97, 14);
		contentPane.add(lblFeuern);
		
		textFeuern = new JTextField();
		textFeuern.setText("0");
		textFeuern.setBounds(240, 175, 161, 20);
		contentPane.add(textFeuern);
		textFeuern.setColumns(10);
		
		JButton btnAbschicken = new JButton("Abschicken");
		btnAbschicken.setBounds(199, 269, 89, 23);
		contentPane.add(btnAbschicken);
	}
}
