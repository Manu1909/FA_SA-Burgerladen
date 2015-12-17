package frontend;

import business.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.TextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Catering extends JFrame implements ActionListener{
	


	private JPanel contentPane;
	JTextField textField = new JTextField(300);
	JButton btnNewButton = new JButton("Nein, danke!");
	JButton btnAngebotAbgeben = new JButton("Angebot abgeben");
	JLabel lblCateringtxt = new JLabel("CateringTxt");
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catering frame = new Catering();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Catering() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCatering = new JLabel("Catering");
		lblCatering.setBounds(5, 5, 474, 20);
		lblCatering.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatering.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCatering);
		
		
		lblCateringtxt.setBounds(5, 67, 474, 189);
		lblCateringtxt.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCateringtxt);
		
		
		textField.setBounds(176, 247, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnAngebotAbgeben.setBounds(97, 322, 134, 23);
		contentPane.add(btnAngebotAbgeben);
		btnAngebotAbgeben.addActionListener(this);
		
		
		btnNewButton.setBounds(273, 322, 134, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String ang;
		int angebot;
		
		if (e.getSource() == btnNewButton){
			angebot = 0;
			//TODO Werte an die Businessebene / Backend weitergeben
			this.dispose();
			
		}
		if(e.getSource() ==btnAngebotAbgeben){
			ang = textField.getText();
			angebot = Integer.parseInt(ang);
			//TODO Werte an die Businessebene / Backend weitergeben
			this.dispose();
		}
		
		
	}

}
