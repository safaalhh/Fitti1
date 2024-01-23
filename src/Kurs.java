import java.util.ArrayList;

public class Kurs {

    private String name;
    private String beschreibung;
    private ArrayList<Mitglied> teilnehmer;

    public Kurs(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.teilnehmer = new ArrayList<>();
    }

    public void mitgliedHinzufuegen(Mitglied mitglied) {
        teilnehmer.add(mitglied);
        mitglied.anmeldenFürKurs(this);
    }

    public void mitgliedEntfernen(Mitglied mitglied) {
        teilnehmer.remove(mitglied);
        mitglied.abmeldenFürKurs(this);
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public ArrayList<Mitglied> getTeilnehmer() {
        return teilnehmer;
    }

    public void setKursname(String name) {
        this.name = name;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String toString() {
        return "Kurs: " + name + " - " + beschreibung;
    }
}

