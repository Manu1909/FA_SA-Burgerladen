package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class newGame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newGame frame = new newGame();
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
	public newGame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInsertTextHere = new JLabel("Insert Text here");
		lblInsertTextHere.setBounds(10, 11, 295, 266);
		panel.add(lblInsertTextHere);
		
		JLabel lblKapital = new JLabel("Kapital");
		lblKapital.setBounds(387, 66, 46, 14);
		panel.add(lblKapital);
		
		JLabel lblSchulden = new JLabel("Schulden");
		lblSchulden.setBounds(387, 149, 46, 14);
		panel.add(lblSchulden);
		
		textField = new JTextField();
		textField.setBounds(446, 63, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(446, 146, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRangliste = new JLabel("Rangliste");
		lblRangliste.setBounds(387, 197, 46, 14);
		panel.add(lblRangliste);
		
		JTextPane txtpnText = new JTextPane();
		txtpnText.setText("Text");
		txtpnText.setBounds(381, 221, 151, 80);
		panel.add(txtpnText);
		
		JTextPane txtpnText_1 = new JTextPane();
		txtpnText_1.setText("Text");
		txtpnText_1.setBounds(56, 248, 233, 69);
		panel.add(txtpnText_1);
		
		JButton btnRundeBeenden = new JButton("Runde beenden");
		btnRundeBeenden.setBounds(344, 390, 89, 23);
		panel.add(btnRundeBeenden);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(288, 11, 107, 22);
		panel.add(mnNewMenu);
		
		JMenuBar menuBar = new JMenuBar();
		mnNewMenu.add(menuBar);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuBar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("New menu item");
		menuBar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("New menu item");
		menuBar.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("New menu item");
		menuBar.add(menuItem_3);
	}
}
