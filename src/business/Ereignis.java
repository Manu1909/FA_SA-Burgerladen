package business;

public class Ereignis {
	private int bekanntheit;
	private int kundenzufriedenheit;
	
	public Ereignis (int bekanntheit, int kundenzufriedenheit){
		this.bekanntheit = bekanntheit;
		this.kundenzufriedenheit = kundenzufriedenheit;
	}
	
	public void setBekanntheit(int bekanntheit) {
		this.bekanntheit = bekanntheit;
	}
	public void setKundenzufriedenheit(int kundenzufriedenheit) {
		this.kundenzufriedenheit = kundenzufriedenheit;
	}
	public int getBekanntheit() {
		return bekanntheit;
	}
	public int getKundenzufriedenheit() {
		return kundenzufriedenheit;
	}
}
