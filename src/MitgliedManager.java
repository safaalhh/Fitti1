import java.util.ArrayList;

public class MitgliedManager {
    // Attribute
    public ArrayList<Mitglied> mitgliedListe;
    public ArrayList<Kurs> kursListe;

    private ArrayList<Kurs> kurse;

    // Constructor
    public MitgliedManager() {
        mitgliedListe = new ArrayList<Mitglied>();
        kursListe = new ArrayList<Kurs>();
    }

    // Methoden
    public void neuesMitgliedHinzufuegen(Mitglied mitglied) {
        mitgliedListe.add(mitglied);
    }

    public void neuesMitgliedAnlegen(int mitgliednummer, String name, String geburtsdatum, String geschlecht, String kurse) {
        Mitglied tmpMitglied = new Mitglied(mitgliednummer, name, geburtsdatum, geschlecht, kurse);
        mitgliedListe.add(tmpMitglied);
    }

    public void neuenKursAnlegen(String Kursname, String Beschreibung) {
        Kurs tmpKurs = new Kurs(Kursname,Beschreibung); // temp=temporär
        kursListe.add(tmpKurs);
    }

    public void mitgliedLoeschen(Mitglied mitglied) {
        for (Kurs kurs : kursListe) {
            kurs.mitgliedEntfernen(mitglied);
        }
        mitgliedListe.remove(mitglied);
    }

}

