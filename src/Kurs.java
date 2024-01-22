import java.util.ArrayList;

public class Kurs {

    public int kursnummer; // Attribute (Eigenschaften) der Klasse
    public String kursname;

    public ArrayList<Mitglied> kursMitgliederListe;


    public Kurs(int Kursnummer, String Kursname) { // konstruktor der die objekte ausführt
        this.kursnummer = Kursnummer; // trägt die objekte ein
        this.kursname = Kursname;
        this.kursMitgliederListe = new ArrayList<Mitglied>(); // Liste wird initialisiert
    }

    public void mitgliedHinzufuegen(Mitglied mitglied) {
        kursMitgliederListe.add(mitglied);
    }

    public void mitgliedEntfernen(Mitglied mitglied) {
        kursMitgliederListe.remove(mitglied);
    }

    public String getKursname() { // ist das notwendig? - vielleicht
        return kursname;
    }

    public void setKursname(String neuerKursname) { //set ist immer void
        this.kursname = neuerKursname; //mit this greife ich auf das Attribut kursname zu was verändert werden soll
    }

    public ArrayList<Mitglied> getKursMitgliederListe() { //Liste soll zurückgegeben werden deswegen return, anstelle von Kursanzeigen weil kein Sinn so
        return kursMitgliederListe;
    }
}
