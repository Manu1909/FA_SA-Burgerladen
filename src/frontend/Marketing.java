package frontend;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marketing extends JFrame implements ActionListener{
	private JButton back = new JButton("Zurück zur Übersicht");
	private JFrame windowMarketing = new JFrame("Burgerplanspiel - Marketing");
	
	public Marketing()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		JPanel head = new JPanel();
		JLabel heading = new JLabel("Hier können Sie Marketing-Aktionen wählen.");
		head.add(heading);
		
		JPanel body = new JPanel();
		body.add(back);
		back.addActionListener(this);
		
		
		
		windowMarketing.add(head, BorderLayout.NORTH);
		windowMarketing.add(body, BorderLayout.SOUTH);
		windowMarketing.setBounds(10,10,500,300);
		windowMarketing.setVisible(true);
//		windowMarketing.set();
		//windowMarketing.setDefaultCloseOperation();
	}
	
	public static void main(String[] args)
	{
		//wird nur bei Ausführung der Klasse gebraucht, eigentlich nicht relevant
		Marketing marketing = new Marketing();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object s = e.getSource();
		
		if(s == back)
		{
			//alernativ setEnabled
			frontend.Overview.window.setFocusableWindowState(true);
			windowMarketing.setVisible(false);
			windowMarketing.dispose();
		}
	}
}
