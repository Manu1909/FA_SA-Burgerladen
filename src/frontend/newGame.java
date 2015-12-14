package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class newGame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel heading = new JLabel("<html><body><h2>Neues Unternehmen</h2></body></html>");
		heading.setBounds(126, 11, 220, 49);
		panel.add(heading);
		
		JButton btnGo = new JButton("Los geht's!");
		btnGo.setBounds(164, 196, 89, 23);
		panel.add(btnGo);
		
		JLabel info = new JLabel("<html><body><h4>Schritt 1:</h4><p>Bitte geben Sie ihrem Unternehmen einen Namen:</p></body></html>");
		info.setBounds(89, 71, 257, 82);
		panel.add(info);
		
		textField = new JTextField();
		textField.setBounds(89, 144, 257, 20);
		panel.add(textField);
		textField.setColumns(10);
	}
}
