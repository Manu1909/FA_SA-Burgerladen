package frontend;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Overview extends JFrame implements MouseListener, MouseMotionListener{
	
	private JTextField capital = new JTextField();
	private JTextField debts = new JTextField();
	private JPanel contentPane = new JPanel();
	public static JFrame frame = new JFrame();
	private JMenu catering = new JMenu("Ausstattung");
	private JMenu marketing = new JMenu("Marketing");
	private JMenu price = new JMenu("Preis festlegen");
	private JMenu orders = new JMenu("Bestellungen");
	
	public Overview()
	{
		buildWindow();
	}
	
	public static void main(String args[])
	{
		Overview test = new Overview();
	}
	
	public void buildWindow()
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		
		JLabel lblInsertTextHere = new JLabel("Insert Text here");
		lblInsertTextHere.setBounds(10, 11, 295, 266);
		panel.add(lblInsertTextHere);
		
		JLabel lblKapital = new JLabel("Kapital");
		lblKapital.setBounds(387, 66, 46, 14);
		panel.add(lblKapital);
		
		JLabel lblSchulden = new JLabel("Schulden");
		lblSchulden.setBounds(387, 149, 46, 14);
		panel.add(lblSchulden);
		
		capital = new JTextField();
		capital.setBounds(446, 63, 86, 20);
		panel.add(capital);
		capital.setColumns(10);
		
		debts = new JTextField();
		debts.setBounds(446, 146, 86, 20);
		panel.add(debts);
		debts.setColumns(10);
		
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
		
		JMenuBar bar = new JMenuBar();
		bar.setBounds(280,10, 335,20);
		
		catering.addMouseListener(this);
		price.addMouseListener(this);
		marketing.addMouseListener(this);
		orders.addMouseListener(this);
		
		bar.add(catering);
		bar.add(price);
		bar.add(marketing);
		bar.add(orders);
		
		panel.add(bar);
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		frame.add(panel);
		frame.setBounds(1,1, 900, 500);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Object s = e.getSource();
		
		if(s == marketing)
		{
			frame.setFocusableWindowState(false);
			Marketing marketing = new Marketing();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
