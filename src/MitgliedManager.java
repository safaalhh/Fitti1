import java.util.ArrayList;

public class MitgliedManager {
    //Attribute
    public ArrayList<Mitglied> mitgliedListe;
    public ArrayList<Kurs> kursListe;

    private ArrayList<Kurs> kurse;

    //Constructor
    public MitgliedManager() {
        mitgliedListe = new ArrayList<Mitglied>();
        kursListe = new ArrayList<Kurs>();
    }

    //Methoden
    public void neuesMitgliedHinzufuegen(Mitglied mitglied) {
        mitgliedListe.add(mitglied);
    }

    public void neuesMitgliedAnlegen(int Mitgliednummer, String Name, String Geburtsdatum, String Geschlecht) {
        Mitglied tmpMitglied = new Mitglied(Mitgliednummer, Name, Geburtsdatum, Geschlecht);
        mitgliedListe.add(tmpMitglied);
    }

    public void neuenKursAnlegen(int Kursnummer, String Kursname) {
        Kurs tmpKurs = new Kurs(Kursnummer, Kursname); //temp=temporär
        kursListe.add(tmpKurs);
    }

    public void mitgliedLoeschen(Mitglied mitglied) {
        for (Kurs kurs : kursListe) {
            kurs.mitgliedEntfernen(mitglied);
        }
        mitgliedListe.remove(mitglied);
    }




    }

