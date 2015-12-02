package frontend;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Overview extends JFrame implements MouseListener, MouseMotionListener{
	private JMenuBar menu = new JMenuBar();
	private JMenu overview = new JMenu("Übersicht");
	private JMenu orders = new JMenu("Bestellungen");
	private JMenu interior = new JMenu("Einrichtung");
	private JMenu catering = new JMenu("Catering");
	private JMenu marketing = new JMenu("Marketing");
	public static JFrame window = new JFrame();
	
	public Overview()
	{
		buildWindow();
	}
	
	public Overview(String player)//noch weitere wichtige Attribute ergänzen
	{
		
	}
	
	public static void main(String args[])
	{
		Overview test = new Overview();
	}
	
	public void setFokus(boolean p)
	{
		window.setFocusableWindowState(p);
	}
	
	public void buildWindow()
	{
		JPanel panel = new JPanel();
		JPanel panelContent = new JPanel();
		
		menu.add(orders);
		menu.add(interior);
		menu.add(catering);
		menu.add(marketing);
		
		//Listener
		orders.addMouseListener(this);
		interior.addMouseListener(this);
		catering.addMouseListener(this);
		marketing.addMouseListener(this);
		panel.add(menu);
		
		//panelContent
		window.setBounds(10, 10, 600, 400);
		window.setExtendedState(Frame.MAXIMIZED_BOTH);
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
			Innenausstattung interior = new Innenausstattung();
		}
		if(s == marketing)
		{
			Marketing marketing = new Marketing();
			window.setFocusableWindowState(false);
		}
		if(s == orders) 
		{
			Bestellungen orders = new Bestellungen();	
		}
		if(s == catering) 
		{
			Catering orders = new Catering();	
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
