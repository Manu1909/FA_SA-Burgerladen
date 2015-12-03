package business;

import java.util.ArrayList;

public class Catering {
	
		private String bezeichnung;
		private int anzahlBurger;
		private double mindestAngebot;
		
		private double preis;
		ArrayList<String> namenUnternehmen = new ArrayList<>();
		ArrayList<Double> preisAngebote = new ArrayList<>();
		ArrayList<Integer> qualitaet = new ArrayList<>();
		
		public Catering(String bezeichnung, int anzahlBurger, double mindestAngebot){
			this.bezeichnung = bezeichnung;
			this.anzahlBurger = anzahlBurger;
			this.mindestAngebot = mindestAngebot;
		}
		
		
		public String getBezeichnung() {
			return bezeichnung;
		}

		public double getMindestAngebot() {
			return mindestAngebot;
		}

	
		public int getAnzahlBurger() {
			return anzahlBurger;
		}

		public double getPreis() {
			return preis;
		}


		public void setPreis(double preis) {
			this.preis = preis;
		}


		public ArrayList<String> getNamenUnternehmen() {
			return namenUnternehmen;
		}

		public ArrayList<Double> getPreisAngebote() {
			return preisAngebote;
		}


		public void setPreisAngebote(ArrayList<Double> preisAngebote) {
			this.preisAngebote = preisAngebote;
		}


		public ArrayList<Integer> getQualitaet() {
			return qualitaet;
		}
		
		public void addName(String name){
			namenUnternehmen.add(name);
		}
		
		public void addPreis(double preis){
			preisAngebote.add(preis);
		}
		
		public void addQualitaet(int quali){
			qualitaet.add(quali);
		}

	
		public String vergleichePreisLeistung(){
			
			//TODO vergleiche PreisLeistung und gebe bestes Angebot wieder zurück
			
			return "Unternehmensname";
		}

		

}
