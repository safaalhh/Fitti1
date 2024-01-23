import java.util.ArrayList;

public class Kurs {

    private String name; // Attribute (Eigenschaften) der Klasse
    private String Beschreibung;

    public ArrayList<Mitglied> kursMitgliederListe;



    public Kurs(String name, String beschreibung) {
        this.name = name;
        this.Beschreibung = beschreibung;
    }

    public void mitgliedHinzufuegen(Mitglied mitglied) {
        kursMitgliederListe.add(mitglied);
    }

    public void mitgliedEntfernen(Mitglied mitglied) {
        kursMitgliederListe.remove(mitglied);
    }

    public String getName() { // ist das notwendig? - vielleicht
        return name;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }
    public String toString() {
        return "Kurs: " + name + " - " + Beschreibung;
    }

    public void setKursname(String name) { //set ist immer void
        this.name = name; //mit this greife ich auf das Attribut kursname zu was verändert werden soll
    }
    public void setBeschreibung(String beschreibung) {
        this.Beschreibung = beschreibung;
    }


    public ArrayList<Mitglied> getKursMitgliederListe() { //Liste soll zurückgegeben werden deswegen return, anstelle von Kursanzeigen weil kein Sinn so
        return kursMitgliederListe;
    }
}
