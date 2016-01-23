package business;
/**
 * @author entenmann 
 */

import java.util.ArrayList;

public class Catering {

    private String bezeichnung;
    private int anzahlBurger;
    private int bekanntheitssteigerung;
    private int kundenzufriednenheitssteigerung;
    private double prozent;


    private Unternehmen u;

    private double preis;
    ArrayList<String> namenUnternehmen = new ArrayList<>();
    ArrayList<Double> preisAngebote = new ArrayList<>();
    ArrayList<Integer> qualitaet = new ArrayList<>();

    public Catering(String bezeichnung, int anzahlBurger, int bekanntheitssteigerung, int kundenzufriednenheitssteigerung) {
        this.bezeichnung = bezeichnung;
        this.anzahlBurger = anzahlBurger;
        this.bekanntheitssteigerung = bekanntheitssteigerung;
        this.kundenzufriednenheitssteigerung = kundenzufriednenheitssteigerung;
        this.prozent = 0.1;
    }

    /*
     * Get und Setter Methoden für Klasse Catering
     */
    
    public Unternehmen getU() {
        return u;
    }


    public void setU(Unternehmen u) {
        this.u = u;
    }

    public String getBezeichnung() {
        return bezeichnung;
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
    
    /**
     * Hier wird der Name des Unternehmens aufgenommen, welches ein Catering-Angebot
     * abgegeben hat
     * @param name
     */
    public void addName(String name) {
        namenUnternehmen.add(name);
    }

    /**
     * Hier wird der Preis des Unternehmens für das Catering-Angebot
     * aufgenommen
     * @param preis
     */
    public void addPreis(double preis) {
        preisAngebote.add(preis);
    }

    /**
     * Hier wird Qualität des Burges des entsprechenden Unternehmens
     * aufgenommen
     * @param quali
     */
    public void addQualitaet(int quali) {
        qualitaet.add(quali);
    }

    /**
     * Hier wird die aktuelle Bekanntheit des Unternehmens um die Bekanntheitssteigerung
     * durch das Catering erhöht
     * @param bekanntheit
     * @return bekanntheit
     */
    public int berechneBekanntheit(int bekanntheit) {
        bekanntheit = (int)(bekanntheit + bekanntheitssteigerung - bekanntheit*prozent + 0.5);

        return bekanntheit;
    }

    /**
     * Hier wird die aktuelle Kundenzufriedenheit des Unternehmens um die Kundenzufriedenheitssteigerung
     * durch das Catering erhöht
     * @param kundenzufriedenheit
     * @return kundenzufriedenheit
     */
    public int berechneKundenzufriedenheit(int kundenzufriedenheit) {
        kundenzufriedenheit = (int)(kundenzufriedenheit + kundenzufriednenheitssteigerung -kundenzufriedenheit*prozent+ 0.5);
        return kundenzufriedenheit;
    }

    /**
     * Vergleicht die eingegangenen Angebote und entscheidet welches Unternehmen den Zuschlag bekommt
     * Bei Angebotsgleichheit entscheidet Zufall
     * @return
     */
    public String vergleichePreisLeistung() {
        double bestesAngebot = 0;
        int index = 0;

        if (namenUnternehmen.size() > 1) {
            bestesAngebot = preisAngebote.get(0) / qualitaet.get(0);

            for (int i = 1; i < namenUnternehmen.size(); i++) {
                double preisLeistung = preisAngebote.get(i) / qualitaet.get(i);

                if (preisLeistung < bestesAngebot) {
                    bestesAngebot = preisLeistung;
                    index = i;
                }
                else if(preisLeistung == bestesAngebot){
                	int x = (int) (Math.random() * 10 + 1);
                	if(x < 5){
                		bestesAngebot = preisLeistung;
                		index = i;
                	}
                }
            }
        } else if(namenUnternehmen.size() == 1) {
        	  return namenUnternehmen.get(0);
        }else{
        	 return "Kein Angebot eingegangen";
        }

        return namenUnternehmen.get(index);
    }
}
