import java.util.ArrayList;

public class Mitglied {
    private int mitgliedNummer;
    private String name;
    private String geburtsdatum;
    private String geschlecht;
    private ArrayList<Kurs> kurse;

    // Konstruktor
    public Mitglied(int mitgliedNummer, String name, String geburtsdatum, String geschlecht) {
        this.mitgliedNummer = mitgliedNummer;
        this.name = name;
        this.geburtsdatum = geburtsdatum;
        this.geschlecht = geschlecht;
        this.kurse = new ArrayList<>();
    }

    public Mitglied(String mitgliedNummer, String name, String geburtsdatum, String geschlecht, String kurse) {
        this.mitgliedNummer = Integer.parseInt(mitgliedNummer);
        this.name = name;
        this.geburtsdatum = geburtsdatum;
        this.geschlecht = geschlecht;
        this.kurse = new ArrayList<>();
    }

    // Getter-Methoden
    public int getMitgliedNummer() {
        return mitgliedNummer;
    }

    public String getName() {
        return name;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public ArrayList<Kurs> getKurse() {
        return kurse;
    }

    // Weitere Methoden
    public void anmeldenFürKurs(Kurs kurs) {
        kurse.add(kurs);
    }

    public void abmeldenFürKurs(Kurs kurs) {
        kurse.remove(kurs);
    }

    @Override
    public String toString() {
        return "Mitgliedsnummer: " + mitgliedNummer + ", Name: " + name + ", Geburtsdatum: " + geburtsdatum +
                ", Geschlecht: " + geschlecht + ", Fitnesskurse: " + kurse;
    }
}
