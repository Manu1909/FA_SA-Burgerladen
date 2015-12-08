package business;

/**
 * Created by kochsiek on 05.12.2015.
 */
public class RadioWerbung extends Marketing {
    public RadioWerbung() {
        bekanntheitssteigerung = 30;
        kundenzufriednenheitssteigerung = 0;
        kundenprozentsatz = 0.15;
        kosten = 6300;
        prozent = 0.1;
        bezeichnung = "Radio";
    }

    //Berechnet Bekanntheit abhängig von der bisherigen Bekanntheit
    @Override
    public int berechneBekanntheit(int bekanntheit) {
        bekanntheit = (int)(bekanntheit + bekanntheitssteigerung - bekanntheit*prozent + 0.5);
        return bekanntheit;
    }

    //Berechnet Kundenzufriedenheit abhängig von der bisherigen Kundenzufriedenheit
    @Override
    public int berechneKundenzufriedenheit(int kundenzufriedenheit) {
        kundenzufriedenheit = (int)(kundenzufriedenheit + kundenzufriednenheitssteigerung + 0.5);
        return kundenzufriedenheit;
    }
}
