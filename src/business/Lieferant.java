package business;

public class Lieferant {

	private int ressourcen;
	private int verbrauchteRessourcen = 0;
	private int qualitaet;
	private double preisProGut;
	private int risikoQuote;
	private int preisKonstante = 5;

	
	public Lieferant(int ressourcen, int qualitaet, double preisProGut, int risikoQuote) {
		this.ressourcen = ressourcen;
		this.qualitaet = qualitaet;
		this.risikoQuote = risikoQuote;
		this.preisProGut = preisProGut;
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
