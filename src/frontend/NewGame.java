package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class NewGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGame frame = new NewGame();
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
	public NewGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(192, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(106, 62, 63, 54);
		contentPane.add(list);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(244, 62, 103, 54);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(171, 175, 89, 23);
		contentPane.add(btnNewButton);
	}
}
