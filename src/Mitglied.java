import java.util.ArrayList;

import java.util.ArrayList;

public class Mitglied {
    private int Mitgliednummer;
    private String name;
    private String geburtsdatum;
    private String geschlecht;
    private ArrayList<Kurs> kurse;
    private ArrayList<Zeiteintrag> anwesenheitszeiten;
    private int gesamtAnwesenheitszeit = 0;

    public Mitglied(int Mitgliednummer, String Name, String Geburtsdatum, String Geschlecht) {
        this.Mitgliednummer = Mitgliednummer;
        this.name = Name;
        this.geburtsdatum = Geburtsdatum;
        this.geschlecht = Geschlecht;
        this.kurse = new ArrayList<Kurs>();
        this.anwesenheitszeiten = new ArrayList<>();
    }
    public void addOrEditAttendance(int startzeit, int endzeit) {
        Zeiteintrag zeiteintrag = new Zeiteintrag(startzeit, endzeit);

        for (Zeiteintrag existing : anwesenheitszeiten) {
            if (existing.overlaps(zeiteintrag)) {
                System.out.println("Error: Overlapping entry");
                return;
            }
        }
        anwesenheitszeiten.add(zeiteintrag);
    }
    public void addAnwesenheitszeit(int anwesenheitszeit) {
        gesamtAnwesenheitszeit += anwesenheitszeit;
    }
    public ArrayList<Zeiteintrag> getAnwesenheitszeiten() {
        return anwesenheitszeiten;
    }
    private static class Zeiteintrag {
        int startzeit;
        int endzeit;

        public Zeiteintrag(int startzeit, int endzeit) {
            this.startzeit = startzeit;
            this.endzeit = endzeit;
        }
        public boolean overlaps(Zeiteintrag other) {
            return startzeit < other.endzeit && endzeit > other.startzeit;
        }
    }

    public int getGesamtAnwesenheitszeit() {
        return gesamtAnwesenheitszeit;
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

    public void kursBeitreten(Kurs kurs) {
        kurs.mitgliedHinzufuegen(this);
    }

    // Weitere Methoden
    public void anmeldenFuerKurs(Kurs kurs) {
        kurse.add(kurs);
    }

    public void abmeldenFuerKurs(Kurs kurs) {
        kurse.remove(kurs);
    }
    @Override
    public String toString() {
        return "Mitglied{" +
                "Mitgliedsnummer=" + Mitgliednummer +
                ", Name='" + name + '\'' +
                ", Geburtsdatum='" + geburtsdatum + '\'' +
                ", Geschlecht='" + geschlecht + '\'' +
                '}';
    }

    public ArrayList<Kurs> getKurse() {
        return kurse;
    }
}
