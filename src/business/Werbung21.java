package business;

/**
 * Created by kochsiek on 05.12.2015.
 */
public class Werbung21 extends Marketing{
    public Werbung21() {

        bekanntheitssteigerung = 10;
        kundenzufriednenheitssteigerung = 10;
        kundenprozentsatz = 0.1;
        kosten = 19;
        prozent = 0.1;
        bezeichnung = "Werbung21";


    }

    // Die Bekanntheit steigert sich abhängig von der bisherigen Bekanntheit
    @Override
    public int berechneBekanntheit(int bekanntheit) {
        bekanntheit = (int)(bekanntheit + bekanntheitssteigerung - bekanntheit*prozent + 0.5);

        return bekanntheit;
    }

    // Die Kundenzufriedenheit steigert sich abhängig von der bisherigen kundenzufriedenheit
    @Override
    public int berechneKundenzufriedenheit(int kundenzufriedenheit) {
        kundenzufriedenheit = (int)(kundenzufriedenheit + kundenzufriednenheitssteigerung -kundenzufriedenheit*prozent+ 0.5);
        return kundenzufriedenheit;
    }
}
