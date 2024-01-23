import java.util.ArrayList;

public class MitgliedManager {
    // Attribute
    public ArrayList<Mitglied> mitgliedListe;
    public ArrayList<Kurs> kursListe;


    // Constructor
    public MitgliedManager() {
        mitgliedListe = new ArrayList<Mitglied>();
        kursListe = new ArrayList<Kurs>();
        String filename = "Mitglieder.csv";
    }

    // Methoden
    public void neuesMitgliedHinzufuegen(int Mitgliednummer, String Name, String Geburtsdatum, String Geschlecht) {
        Mitglied tmpMitglied = new Mitglied(Mitgliednummer, Name, Geburtsdatum, Geschlecht); //Parameter?
        mitgliedListe.add(tmpMitglied);
        this.mitgliedInCsvSpeichern(newMitglied);
    }


    public void mitgliedLoeschen(Mitglied mitglied) {
        for (Kurs kurs : kursListe) {
            kurs.mitgliedEntfernen(mitglied);
        }
        mitgliedListe.remove(mitglied);
    }


            private void updateMitglieder() {
                mitglieder.clear();
                ArrayList<ArrayList<String>> rawMitglieder = CsvReader.readCSVFile(filename);
                lstIntoTickets(rawMitglieder);
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
            public void mitgliedInCsvSpeichern(Mitglied mitglied) {
                Mitglied matchingMitglied = this.getMitgliedWithSameId(Integer.toString(mitglied.getMitgliedId()));

                if (matchingMitglied == null) { // wenn es kein Ticket mit der Id gibt
                    mitglieder.add(mitglied);
                } else {
                    mitglieder.remove(matchingMitglied);
                    mitglieder.add(mitglied);
                }
                CsvReader.updateCsv(filename, mitgliederIntoLst());
            }

}





