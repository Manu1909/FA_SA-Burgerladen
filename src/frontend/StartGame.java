package frontend;

import java.awt.Color;
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

	public static int getUnZahl() { //gibt UN-Zahl zurück
		return unZahl;
	}

	public static int getI() {//gibt UN-Zahl zurück
		return i;
	}

	public StartGame() {
		buildWindow();
	}

	public void buildWindow() {//Fenster aufbauen und anzeigen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon("logoJavaBG.PNG");
		JLabel label = new JLabel(icon);
		label.setBounds(120, 10, icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(label);
		
		txtUNZahl.setBounds(200, 330, 50, 14);
		contentPane.add(txtUNZahl);

		btnGo.setBounds(180, 380, 90, 23);
		btnGo.addActionListener(this);
		contentPane.add(btnGo);

		JLabel info = new JLabel("<html><body><p align = center>"
				+ "Herzlich Willkommen bei Burger im Quadrat! Bei diesem Unternehmensplanspiel gründen "
				+ "Sie und Ihre Mitspieler ein Burgerrestaurant und betreiben es in einem Zeitraum von vier Jahren. "
				+ "Eine Runde ist genau ein Quartal, also drei Monate lang."
				+ "Das Spiel findet im Hot-Seat-Verfahren statt: Also beginnt ein Spieler, danach geben die Mitspieler ihre Werte ein. " 
				+ "Zuerst geben Sie jedoch bitte an wie viele Spieler an dieser Spielrunde teilnehmen:"
				+ "</p></body></html>");
		info.setBounds(89, 130, 290, 180);
		contentPane.add(info);

//		contentPane.setBackground(new Color(239,237, 227));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 450);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == btnGo) {
			if(Controller.Controller.getRunde()<11)
			try {
				i = Integer.parseInt(txtUNZahl.getText());
				unZahl = i;
				if (i > 0) {
					for (int n = 0; n < i; n++) {//Unternehmen anlegen
						Controller.Controller.neuesUnternehmen(new business.Unternehmen("un" + n));
						frame.setVisible(false);
					}
					newName giveName = new newName(0); //Gründung starten
					frame.dispose();
				}
			} catch (NumberFormatException e1) {
			}
		}
		
	}
}
