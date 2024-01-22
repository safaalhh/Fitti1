import java.util.ArrayList;

public class Anwesenheit {
    // Attribute
    String mitglied;
    int startzeit;
    int endzeit;
    ArrayList<Zeiteintrag> zeiteintraege = new ArrayList<>();
    static ArrayList<Anwesenheit> anwesenheitszeiten = new ArrayList<>();

    // Constructor
    public Anwesenheit(String mitglied, int startzeit, int endzeit) {
        this.mitglied = mitglied;
        this.startzeit = startzeit;
        this.endzeit = endzeit;
    }

    // Method to add attendance
    public void anwesenheitHinzufuegen(String mitglied, int startzeit, int endzeit) {
        Anwesenheit eintrag = new Anwesenheit(mitglied, startzeit, endzeit);
        anwesenheitszeiten.add(eintrag);
    }

    // Method to modify attendance
    public void anwesenheitAendern(String mitglied, int index, int neueStartzeit, int neueEndzeit) {
        for (Anwesenheit eintrag : anwesenheitszeiten) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                if (index >= 0 && index < zeiteintraege.size()) {
                    Zeiteintrag zeiteintrag = zeiteintraege.get(index);
                    zeiteintrag.startzeit = neueStartzeit;
                    zeiteintrag.endzeit = neueEndzeit;
                }
            }
        }
    }

    // Method to delete attendance
    public void anwesenheitLoeschen(String mitglied, int index) {
        for (Anwesenheit eintrag : anwesenheitszeiten) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                if (index >= 0 && index < zeiteintraege.size()) {
                    zeiteintraege.remove(index);
                }
            }
        }
    }

    // Method to display attendance for a specific member
    public void anzeigenAnwesenheitMitglied(String mitglied) {
        for (Anwesenheit eintrag : anwesenheitszeiten) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                System.out.println("Anwesenheitszeiten für Mitglied " + mitglied + ":");
                for (Zeiteintrag zeiteintra : zeiteintraege) {
                    System.out.println("Startzeit: " + zeiteintra.startzeit + ", Endzeit: " + zeiteintra.endzeit);
                }
            }
        }
    }

    // Method to display total attendance time for a specific member
    public void anzeigenGesamteAnwesenheit(String mitglied) {
        for (Anwesenheit eintrag : anwesenheitszeiten) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                int gesamteAnwesenheitszeit = 0;
                for (Zeiteintrag zeiteintrag : zeiteintraege) {
                    gesamteAnwesenheitszeit += zeiteintrag.endzeit - zeiteintrag.startzeit;
                }
                System.out.println("Gesamte Anwesenheitszeit für Mitglied " + mitglied + ": " + gesamteAnwesenheitszeit);
            }
        }
    }

    // Inner class for Zeiteintrag
    private class Zeiteintrag {
        int startzeit;
        int endzeit;

        public Zeiteintrag(int startzeit, int endzeit) {
            this.startzeit = startzeit;
            this.endzeit = endzeit;
        }
    }
}
