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

public class StartGame extends JFrame implements ActionListener{
	
	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel();
	private JButton btnGo = new JButton("Start");
	private JTextField txtUNZahl = new JTextField();
	
	public static void main(String[] args)
	{
		StartGame test = new StartGame();
	}
	
	public StartGame()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("<html><body><h1>Burger im Quadrat</h1></body></html>");
		heading.setBounds(102, 11, 220, 49);
		contentPane.add(heading);
		
		JLabel img = new JLabel(new ImageIcon("rot.jpg"));
		img.setBounds(1,1,20,40);
		contentPane.add(img);
		
		txtUNZahl.setBounds(200, 180, 50, 14);
		contentPane.add(txtUNZahl);
		
		btnGo.setBounds(180, 230, 90, 23);
		btnGo.addActionListener(this);
		contentPane.add(btnGo);
		
		JLabel info = new JLabel("<html><body><p1>In diesem Unternehmensplanspiel gr\u00FCnden"
				+ "<br>Sie einen Burgerladen in der Innenstadt Mannheims."
				+ "</p></body></html>");
		info.setBounds(89, 71, 260, 82);
		contentPane.add(info);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object s = e.getSource();
		if(s == btnGo)
		{
			int i = Integer.parseInt(txtUNZahl.getText());
			for(int n = 0; n < i; n++)
			{
				Controller.Controller.neuesUnternehmen(new business.Unternehmen("un" + n));
				frame.setVisible(false);
				System.out.println(Controller.Controller.getUnternehmen(n).getName());
				newName giveName = new newName();
			}
			frame.dispose();
		}
	}
}
