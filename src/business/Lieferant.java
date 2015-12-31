package business;

public class Lieferant {

	private int ressourcen;
	private int verbrauchteRessourcen = 0;
	private int qualitaet;
	private double preisProGut;
	private double startPreis;
	private int risikoQuote;
	private int risikoEingetreten;
	private int preisKonstante = 8;

	
	public Lieferant(int ressourcen, int qualitaet, double startPreis, int risikoQuote, int risikoEingetreten) {
		this.ressourcen = ressourcen;
		this.qualitaet = qualitaet;
		this.risikoQuote = risikoQuote;
		this.startPreis = startPreis;
		this.preisProGut = startPreis;
		this.risikoEingetreten = risikoEingetreten;
	}
	
	public void setRessourcen(int ressourcen){
		this.ressourcen = ressourcen;
	}
	
	public void setVerbrauchteRessourcen(int verbrauchteRessourcen){
		this.verbrauchteRessourcen = verbrauchteRessourcen;
	}
	
	public void setQualitaet(int qualitaet){
		this.qualitaet = qualitaet;
	}
	
	
	public void setPreisProGut(double PreisProGut){
		this.preisProGut = preisProGut;
	}
	
	public void setRisikoQuote(int risikoQuote){
		this.risikoQuote = risikoQuote;
	}
	
	public void setRisikoEingetreten(int risikoEingetreten){
		this.risikoEingetreten = risikoEingetreten;
	}
	
	public int getVertrauchteRessourcen(){
		return verbrauchteRessourcen;
	}
	
	public int getQualitaet(){
		return qualitaet;
	}
	

	public double getPreisProGut(){
		return preisProGut;
	}
	
	public int getRisikoQuote(){
		return risikoQuote;
	}
	
	public int getRisikoEingetreten(){
		return risikoEingetreten;
	}


	//Methode wird gebraucht bei begrenzten Ressourcen
	/*public int berechneUebrigeRessourcen(){
		return ressourcen -verbrauchteRessourcen;
	}*/

	public double berechneNeuenPreis(){
		double preisveraenderung = 1.00*verbrauchteRessourcen/ressourcen;
		if(preisveraenderung<(1/2.00)){
			preisveraenderung = 1/2.00;
		}
		else if(preisveraenderung>(3/2.00)){
			preisveraenderung = 3/2.00;
		}

		preisProGut = preisProGut-((1-preisveraenderung)/preisKonstante)*preisProGut;
		preisProGut = Math.round(100.0*preisProGut)/100.0;

		if(preisProGut > 1.5*startPreis){
			preisProGut = 1.5*startPreis;
		}
		else if(preisProGut < 0.5*startPreis){
			preisProGut = 0.5*startPreis;
		}
		return preisProGut;
	}
	
	//Wenn die Lieferanten begrenzte Ressourcen haben ist diese Methode von Nöten
	/*public boolean checkRessourcen(int res){
		if(res> berechneUebrigeRessourcen()){
			return false;
		}
		return true;
	}*/
	
}
