package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.Datenbank;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class Bestellungen extends JFrame implements ActionListener, MouseListener{
	

	private JPanel contentPane;
	JTextField BurgerZahl = new JTextField(300);
	JButton btnBestellungAbschicken = new JButton("Bestellung abschicken");
	
	String[] fleischOpt = {"Sutro Großlieferant", "Metzgerei Zorn", "Ernas Fleischerei"};
	JList listFleisch = new JList(fleischOpt);
	JLabel lblFleischErk =new JLabel("");
	
	
	String[] broetchenOpt = {"Sutro Großlieferant", "Brotfabrik Mannheim", "Tram GmbH"};
	JList listBroetchen = new JList(broetchenOpt);
	JLabel lblBroetchenErk=new JLabel("");;
	
	String[] salatOpt = {"Sutro Großlieferant", "Farmerland", "Tram GmbH"};
	JList listSalat = new JList(salatOpt);
	JLabel lblSalatErk=new JLabel("");;
	
	String [] saucenOpt = {"Sutro Großlieferant", "Saucerie de Lyon", "Tram GmbH"};
	JList listSauce = new JList(saucenOpt);
	JLabel lblSaucenErk=new JLabel("");;
	
	JButton btnGK = new JButton("Gesamtkosten berechnen");
	JLabel lblGK = new JLabel("n/a");
	
	//Werte Fleisch
	private double[] kostenFl = {Datenbank.fl[0].getPreisProGut(),
			Datenbank.fl[1].getPreisProGut(),
			Datenbank.fl[2].getPreisProGut()};
	
	private int[] qualitaetFl = {Datenbank.fl[0].getQualitaet(),
			Datenbank.fl[1].getQualitaet(),
			Datenbank.fl[2].getQualitaet()};
	
	private int[] risikoquoteFl = {Datenbank.fl[0].getRisikoQuote(),
			Datenbank.fl[1].getRisikoQuote(),
			Datenbank.fl[2].getRisikoQuote()};
	
	//Werte Broetchen
	private double[] kostenBr = {Datenbank.bl[0].getPreisProGut(),
			Datenbank.bl[1].getPreisProGut(),
			Datenbank.bl[2].getPreisProGut()};
	
	private int[] qualitaetBr = {Datenbank.bl[0].getQualitaet(),
			Datenbank.bl[1].getQualitaet(),
			Datenbank.bl[2].getQualitaet(),	};
	
	//Werte Salat
	private double[] kostenSa = {Datenbank.sal[0].getPreisProGut(),
			Datenbank.sal[1].getPreisProGut(),
			Datenbank.sal[2].getPreisProGut()};
	
	private int[] qualitaetSa = {Datenbank.sal[0].getQualitaet(),
			Datenbank.sal[1].getQualitaet(),
			Datenbank.sal[2].getQualitaet()};
	
	//Werte Sauce
	private double[] kostenSau = {Datenbank.sol[0].getPreisProGut(),
			Datenbank.sol[1].getPreisProGut(),
			Datenbank.sol[2].getPreisProGut()};
	private int[] qualitaetSau = {Datenbank.sol[0].getQualitaet(),
			Datenbank.sol[1].getQualitaet(),
			Datenbank.sol[2].getQualitaet()};
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bestellungen frame = new Bestellungen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Bestellungen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBestellungen = new JLabel("Bestellungen");
		lblBestellungen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBestellungen.setBounds(5, 5, 574, 33);
		lblBestellungen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBestellungen);
		
		//Burger	
		
		JLabel lblBestellung = new JLabel("Ich bestelle für");
		lblBestellung.setBounds(27, 76, 116, 14);
		contentPane.add(lblBestellung);
		BurgerZahl.setBounds(120, 73, 86, 20);
		contentPane.add(BurgerZahl);
		BurgerZahl.setColumns(10);
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setBounds(240, 76, 46, 14);
		contentPane.add(lblBurger);
		
		//Fleisch
		
		listFleisch.setBounds(120, 104, 137, 62);
		listFleisch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFleisch.addMouseListener(this);
		contentPane.add(lblFleischErk);
		listFleisch.setSelectedIndex(0);
		int a= listFleisch.getSelectedIndex();
		lblFleischErk.setText("<html><body><p>Kosten pro Burger: " + kostenFl[a] +" €"
				+ "<br> Qualität: "+ qualitaetFl[a] + " Punkte"
				+ "<br> Gammelfleischrisiko: "+ risikoquoteFl[a]+ " Prozent </p><body></html>");
		
		contentPane.add(listFleisch);	
		JLabel lblFleisch = new JLabel("Fleisch");
		lblFleisch.setBounds(27, 101, 83, 14);
		contentPane.add(lblFleisch);
		lblFleischErk.setBounds(284, 104, 202, 48);
		
		
		//Brötchen
		
		JLabel lblBroetchen = new JLabel("Brötchen");
		lblBroetchen.setBounds(27, 193, 83, 14);
		contentPane.add(lblBroetchen);
		listBroetchen.setBounds(120, 193, 137, 62);
		listBroetchen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listBroetchen.addMouseListener(this);
		listBroetchen.setSelectedIndex(0);
		int b= listBroetchen.getSelectedIndex();
		lblBroetchenErk.setText("<html><body><p>Kosten pro Burger: " + kostenBr[b] +" €"
				+ "<br> Qualität: "+ qualitaetBr[b] + " Punkte. <body></html>");
		contentPane.add(listBroetchen);
		lblBroetchenErk.setBounds(284, 193, 202, 62);
		contentPane.add(lblBroetchenErk);
		
		//Salatwahl
		
		JLabel lblSalat = new JLabel("Salat");
		lblSalat.setBounds(27, 299, 46, 14);
		contentPane.add(lblSalat);
		listSalat.setBounds(120, 287, 137, 62);
		listSalat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSalat.addMouseListener(this);
		listSalat.setSelectedIndex(0);
		int c= listSalat.getSelectedIndex();
		lblSalatErk.setText("<html><body><p>Kosten pro Burger: " + kostenSa[c] +" €"
				+ "<br> Qualität: "+ qualitaetSa[c] + " Punkte. <body></html>");
		contentPane.add(listSalat);
		lblSalatErk.setBounds(284, 287, 202, 62);
		contentPane.add(lblSalatErk);
		
		//Sauce
		
		JLabel lblSauce = new JLabel("Sauce");
		lblSauce.setBounds(27, 398, 46, 14);
		contentPane.add(lblSauce);
		listSauce.setBounds(120, 389, 137, 62);
		listSauce.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSauce.addMouseListener(this);
		listSauce.setSelectedIndex(0);
		int d= listSauce.getSelectedIndex();
		lblSaucenErk.setText("<html><body><p>Kosten pro Burger: " + kostenSau[d] +" €"
				+ "<br> Qualität: "+ qualitaetSau[d] + " Punkte. <body></html>");
		contentPane.add(listSauce);
		lblSaucenErk.setBounds(284, 389, 202, 62);
		contentPane.add(lblSaucenErk);
		
		//Gesamtkosten
		
		btnGK.setBounds(120, 493, 179, 23);
		contentPane.add(btnGK);
		lblGK.setBounds(392, 497, 46, 14);
		contentPane.add(lblGK);
		
		//Abschicken
		
		
		btnBestellungAbschicken.setBounds(222, 552, 147, 23);
		contentPane.add(btnBestellungAbschicken);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(s==btnBestellungAbschicken){
			
			
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		Object s = e.getSource();
		
		if (s== listFleisch){
			int a = listFleisch.getSelectedIndex();
			lblFleischErk.setText("<html><body><p>Kosten pro Burger: " + kostenFl[a] +" €"
					+ "<br> Qualität: "+ qualitaetFl[a] + " Punkte"
					+ "<br> Gammelfleischrisiko: "+ risikoquoteFl[a]+ " Prozent </p><body></html>");
		} else if (s == listBroetchen){
			int b = listBroetchen.getSelectedIndex();
			lblBroetchenErk.setText("<html><body><p>Kosten pro Burger: " + kostenBr[b] +" €"
					+ "<br> Qualität: "+ qualitaetBr[b] + " Punkte. <body></html>");
		} else if (s== listSalat){
			int c= listSalat.getSelectedIndex();
			lblSalatErk.setText("<html><body><p>Kosten pro Burger: " + kostenSa[c] +" €"
					+ "<br> Qualität: "+ qualitaetSa[c] + " Punkte. <body></html>");
		} else if (s== listSauce){
			int d= listSauce.getSelectedIndex();
			lblSaucenErk.setText("<html><body><p>Kosten pro Burger: " + kostenSau[d] +" €"
					+ "<br> Qualität: "+ qualitaetSau[d] + " Punkte. <body></html>");
		}
		
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
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


	
	
		
		
	}//public class