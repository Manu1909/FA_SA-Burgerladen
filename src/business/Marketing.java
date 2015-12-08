package business;

/**
 * Created by kochsiek on 05.12.2015.
 */
public abstract class Marketing {
    protected int bekanntheitssteigerung;
    protected int kundenzufriednenheitssteigerung;
    protected double kundenprozentsatz;
    protected double prozent;
    protected double kosten;
    protected String bezeichnung;


    public abstract int berechneBekanntheit(int bekanntheit);
    public abstract int berechneKundenzufriedenheit(int kundenzufriedenheit);

    public double getKundenprozentsatz() {
        return kundenprozentsatz;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public double getKosten() {
        return kosten;
    }

    public double getProzent() {
        return prozent;
    }

    public int getBekanntheitssteigerung() {
        return bekanntheitssteigerung;
    }

    public int getKundenzufriednenheitssteigerung() {
        return kundenzufriednenheitssteigerung;
    }
}
