import java.util.ArrayList;

public class Mitglied {
    private int Mitgliednummer;
    private String name;
    private String geburtsdatum;
    private String geschlecht;
    private ArrayList<Kurs> kurse;

    // Konstruktor
    public Mitglied(int Mitgliednummer, String Name, String Geburtsdatum, String Geschlecht, String kurseField) {
        this.Mitgliednummer = Mitgliednummer;
        this.name = Name;
        this.geburtsdatum = Geburtsdatum;
        this.geschlecht = Geschlecht;
        this.kurse = new ArrayList<>();
    }

    public void setMitgliedNummer(int mitgliedNummer) {
        this.Mitgliednummer = mitgliedNummer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    // Getter-Methoden
    public int getMitgliedNummer() {
        return Mitgliednummer;
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
        return "Mitgliedsnummer: " + Mitgliednummer + ", Name: " + name + ", Geburtsdatum: " + geburtsdatum +
                ", Geschlecht: " + geschlecht + ", Fitnesskurse: " + kurse;
    }
}
