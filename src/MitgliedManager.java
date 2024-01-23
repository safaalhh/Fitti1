import java.util.ArrayList;

public class MitgliedManager {
    // Attribute
    public ArrayList<Mitglied> mitgliedListe;
    public ArrayList<Kurs> kursListe;
    private String filename = "Mitglieder.csv";


    // Constructor
    public MitgliedManager() {
        mitgliedListe = new ArrayList<Mitglied>();
        kursListe = new ArrayList<Kurs>();
    }

    // Methoden
    public void neuesMitgliedHinzufuegen(int Mitgliednummer, String Name, String Geburtsdatum, String Geschlecht) {
        Mitglied tmpMitglied = new Mitglied(Mitgliednummer, Name, Geburtsdatum, Geschlecht);
        mitgliedListe.add(tmpMitglied);
        this.mitgliedInCsvSpeichern(tmpMitglied); // Use tmpMitglied instead of newMitglied
    }


    public void mitgliedLoeschen(Mitglied mitglied) {
        for (Kurs kurs : kursListe) {
            kurs.mitgliedEntfernen(mitglied);
        }
        mitgliedListe.remove(mitglied);
    }


    private void updateMitglieder() {
        mitgliedListe.clear();
        ArrayList<ArrayList<String>> rawMitglieder = CsvReader.readCSVFile(filename);
        lstIntoTickets(rawMitglieder);
    }

    public void mitgliedLoeschen(Mitglied mitglied) {
        for (Kurs kurs : kursListe) {
            kurs.mitgliedEntfernen(mitglied);
        }
        mitgliedListe.remove(mitglied);
    }

            public void neuenKursAnlegen(int Kursnummer, String Kursname) {
                Kurs tmpKurs = new Kurs(Kursnummer, Kursname); //temp=temporär
                kursListe.add(tmpKurs);
                this.kursInCsvSpeichern(newKurs);
            }


            public void kursloeschen(Kurs kurs) {
                for (Mitglied mitglied : mitgliedListe) {
                    mitglied.abmeldenfuerKurs(kurs);
                }
                kursListe.remove(kurs);
            }
    private void mitgliedInCsvSpeichern(Mitglied mitglied) {
        Mitglied matchingMitglied = this.getMitgliedWithSameId(Integer.toString(mitglied.getMitgliedId()));

        if (matchingMitglied == null) {
            mitgliedListe.add(mitglied);
        } else {
            mitgliedListe.remove(matchingMitglied);
            mitgliedListe.add(mitglied);
        }
        CsvReader.updateCsv(filename, mitgliedIntoLst());
    }
    public void neuesMitgliedHinzufuegen(Mitglied mitglied) {

    }

}





