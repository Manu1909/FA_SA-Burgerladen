package frontend;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Overview extends JFrame implements MouseListener, MouseMotionListener{
	private JMenuBar menu = new JMenuBar();
	private JMenu overview = new JMenu("Übersicht");
	private JMenu orders = new JMenu("Bestellungen");
	private JMenu interior = new JMenu("Einrichtung");
	
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
		JPanel panel = new JPanel();
		JPanel panelContent = new JPanel();
		
		
		menu.add(overview);
		menu.add(orders);
		menu.add(interior);
		
		overview.setSelected(true);
		
		overview.addMouseListener(this);
		orders.addMouseListener(this);
		interior.addMouseListener(this);
		panel.add(menu);
		
		//panelContent
		JFrame window = new JFrame();
		window.setBounds(10, 10, 600, 400);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
		window.add(panel, BorderLayout.NORTH);
		window.add(panelContent, BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Object s = e.getSource();
		if(s == interior) 
		{
			overview.setSelected(false);
			interior.setSelected(true);
			orders.setSelected(false);
		}
		if(s == orders) 
		{
			overview.setSelected(false);
			interior.setSelected(false);
			orders.setSelected(true);
			//Popup öffnen, muss noch gelockt werden( unterfenster darf nicht geschlossen werden)
			Bestellungen orders = new Bestellungen();
		}
		if(s == overview) 
		{
			overview.setSelected(true);
			interior.setSelected(false);
			orders.setSelected(false);
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
