package business;

/**
 * Created by kochsiek on 05.12.2015.
 */
public class FlyerWerbung extends Marketing{

    public FlyerWerbung() {
        bekanntheitssteigerung = 7;
        kundenzufriednenheitssteigerung = 0;
        kundenprozentsatz = 0.1;
        kosten = 599;
        prozent = 0.1;
        bezeichnung = "Flyer";
    }

    // Die Bekanntheit steigert sich abhängig von der bisherigen Bekanntheit
    @Override
    public int berechneBekanntheit(int bekanntheit) {
        if(bekanntheit*prozent>=bekanntheitssteigerung){
            bekanntheit += 1;
        }
        else {
            bekanntheit = (int)(bekanntheit + bekanntheitssteigerung - bekanntheit*prozent + 0.5);
        }
        return bekanntheit;
    }


    // Die Kundenzufriedenheit steigert sich abhängig von der bisherigen kundenzufriedenheit
    @Override
    public int berechneKundenzufriedenheit(int kundenzufriedenheit) {
        kundenzufriedenheit = (int)(kundenzufriedenheit + kundenzufriednenheitssteigerung + 0.5);
        return kundenzufriedenheit;
    }
}
