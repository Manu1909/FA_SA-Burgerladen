package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StartGame extends JFrame implements ActionListener {

	private static int i;
	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel();
	private JButton btnGo = new JButton("Start");
	private JTextField txtUNZahl = new JTextField();
	private static int unZahl;

	public static void main(String[] args) {
		StartGame test = new StartGame();
	}

	public static int getUnZahl() {
		return unZahl;
	}

	public static int getI() {
		return i;
	}

	public StartGame() {
		buildWindow();
	}

	public void buildWindow() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JLabel icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(1, 1, 300, 200);
		contentPane.add(icon);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.setLayout(null);

		JLabel heading = new JLabel("<html><body><h1 align=center>Burger im Quadrat</h1></body></html>");
		heading.setBounds(102, 11, 220, 49);
		contentPane.add(heading);

		txtUNZahl.setBounds(200, 230, 50, 14);
		contentPane.add(txtUNZahl);

		btnGo.setBounds(180, 280, 90, 23);
		btnGo.addActionListener(this);
		contentPane.add(btnGo);

		JLabel info = new JLabel("<html><body><p align = center>"
				+ "In diesem Unternehmensplanspiel gründen Sie und Ihre Gegenspieler je einen Burgerladen"
				+ " in der Innenstadt Mannheims. Über eine Zeitspanne von vier Jahren leiten Sie die Geschicke des Ladens und beeinflussen seinen"
				+ " Erfolg durch Marketing und eine eigene Bestell- und Personalpolitik. <br>Das Spiel dauert zwölf Spielrunden, die je eine"
				+ " Zeitspanne von drei Monaten abdecken. Am Ende der zwölften Spielrunde gewinnt derjenige, der den höchsten Gewinn erzielt hat."
				+ "</p></body></html>");
		info.setBounds(89, 50, 290, 180);
		contentPane.add(info);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 400);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnGo) {
			try {
				i = Integer.parseInt(txtUNZahl.getText());
				unZahl = i;
				if (i > 0) {
					for (int n = 0; n < i; n++) {
						Controller.Controller.neuesUnternehmen(new business.Unternehmen("un" + n));
						frame.setVisible(false);
					}
					newName giveName = new newName(0);
					frame.dispose();
				}
			} catch (NumberFormatException e1) {
			}
		}
	}
}
