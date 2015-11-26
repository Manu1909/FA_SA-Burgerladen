package client;

public class Standort {
	
	private int miete;
	private int traffic;
	private int bekanntheit;
	private int kuehlgroesse;
	
	public Standort(int miete, int traffic, int bekanntheit, int kuehlgroeße){
		this.miete = miete;
		this.traffic  = traffic;
		this.bekanntheit = bekanntheit;
		this.kuehlgroesse = kuehlgroeße;
	}
	
	

	//Getter und Setter für Standort
	public int getMiete() {
		return miete;
	}

	public void setMiete(int miete) {
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

	public int getKuehlgroesse() {
		return kuehlgroesse;
	}

	public void setKuehlgroesse(int kuehlgroesse) {
		this.kuehlgroesse = kuehlgroesse;
	}
	
	
	public int berechneMiete(){
		return 0;
	}

}
