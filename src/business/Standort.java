package business;

public class Standort {
	
	private int miete;
	private int traffic;
	private int bekanntheit;
	private Kuehlraum kuehlraum;
	
	public Standort(int miete, int traffic, int bekanntheit, Kuehlraum kuehlraum){
		this.miete = miete;
		this.traffic  = traffic;
		this.bekanntheit = bekanntheit;
		this.kuehlraum = kuehlraum;
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
	
	public int berechneMiete(){
		return 0;
	}

}
