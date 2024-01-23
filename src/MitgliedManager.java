import java.util.ArrayList;
import java.util.Objects;

public class MitgliedManager {
    // Attribute
    private ArrayList<Mitglied> mitgliedListe;
    private ArrayList<Kurs> kursListe;
    private String filename;

    // Constructor
    public MitgliedManager() {
        mitgliedListe = new ArrayList<Mitglied>();
        kursListe = new ArrayList<Kurs>();
        filename = "Mitglieder.csv";
    }
    // Methoden
    public ArrayList<Mitglied> getMitgliedListe(){
        return mitgliedListe;
    }

    public ArrayList<Kurs> getKursListe(){
        return kursListe;
    }

    public Mitglied neuesMitgliedHinzufuegen(int Mitgliednummer, String Name, String Geburtsdatum, String Geschlecht) {
        Mitglied tmpMitglied = new Mitglied(Mitgliednummer, Name, Geburtsdatum, Geschlecht); //Parameter?
        mitgliedListe.add(tmpMitglied);
        //this.mitgliedInCsvSpeichern(tmpMitglied);
        return tmpMitglied;
    }

    public void neuesMitgliedHinzufuegen(Mitglied mitglied){
        mitgliedListe.add(mitglied);
       // this.mitgliedInCsvSpeichern(mitglied);
    }


    public void mitgliedLoeschen(Mitglied mitglied) {
        for (Kurs kurs : kursListe) {
            kurs.mitgliedEntfernen(mitglied);
        }
        mitgliedListe.remove(mitglied);
    }

    public Kurs getKursByName(String kursName) {
        for (Kurs kurs : kursListe) {
            if (kurs.getName().equals(kursName)) {
                return kurs;
            }
        }
        return null;
    }
    private void updateMitglieder() {
        ArrayList<ArrayList<String>> rawMitglieder = CsvReader.readCSVFile(filename);
        //lstIntoTickets(rawMitglieder);
    }

    public void neuenKursAnlegen(String Kursname,String beschreibung) {
        Kurs tmpKurs = new Kurs(Kursname, beschreibung);
        kursListe.add(tmpKurs);
       //this.kursInCsvSpeichern(newKurs);
    }


    public void kursloeschen(Kurs kurs) {
        for (Mitglied mitglied : mitgliedListe) {
            mitglied.abmeldenFuerKurs(kurs);
        }
        kursListe.remove(kurs);
    }

    /**public void mitgliedInCsvSpeichern(Mitglied mitglied) {
        Mitglied matchingMitglied = this.getMitgliedWithSameId(Integer.toString(mitglied.getMitgliedId()));

        if (matchingMitglied == null) {
            mitglieder.add(mitglied);
        } else {
            mitglieder.remove(matchingMitglied);
            mitglieder.add(mitglied);
        }
        CsvReader.updateCsv(filename, mitgliederIntoLst());
    }*/

    public void mitgliedZuKursHinzufuegen(Mitglied selectedMitglied, Kurs selectedKurs) {
        for (Mitglied mitglied: mitgliedListe){
            if (mitglied.getMitgliedNummer()==selectedMitglied.getMitgliedNummer() && Objects.equals(mitglied.getName(), selectedMitglied.getName())){
                mitglied.anmeldenFuerKurs(selectedKurs);

            }
        }
        for (Kurs kurs:kursListe){
            if (Objects.equals(kurs.getName(), selectedKurs.getName())){
                kurs.mitgliedHinzufuegen(selectedMitglied);
            }
        }
    }
}





