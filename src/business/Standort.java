package business;

public class Standort {
	
	private String lage;
	private double miete;
	private int traffic;
	private int bekanntheit;
	private Innenausstattung innenausstattung;
	private Kuehlraum kuehlraum;
	
	public Standort(String lage, double miete, int traffic, int bekanntheit){
		this.lage = lage;
		this.miete = miete;
		this.traffic  = traffic;
		this.bekanntheit = bekanntheit;
	}
	
	//Getter und Setter f�r Standort
	public String getLage() {
		return lage;
	}

	public void setLage(String lage) {
		this.lage = lage;
	}

	public double getMiete() {
		return miete;
	}

	public void setMiete(double miete) {
		this.miete = miete;
	}

	public int getTraffic() {
		return traffic;
	}

	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}

	public int getBekanntheit() {
		return bekanntheit;
	}

	public void setBekanntheit(int bekanntheit) {
		this.bekanntheit = bekanntheit;
	}
	
	public Innenausstattung getInnenausstattung() {
		return innenausstattung;
	}

	public void setInnenausstattung(Innenausstattung innenausstattung) {
		this.innenausstattung = innenausstattung;
	}
	
	public Kuehlraum getKuehlraum() {
		return kuehlraum;
	}


	public void setKuehlraum(Kuehlraum kuehlraum) {
		this.kuehlraum = kuehlraum;
	}


	//berechneMiete des kompletten Standorts
	public double berechneMiete(){
		miete = miete + getKuehlraum().getMietZusatzKosten();
		return miete;
	}

}
