import java.util.ArrayList;

public class Anwesenheit {
    private int dauer;
    String mitglied;
    int startzeit;
    int endzeit;
    ArrayList<Zeiteintrag> zeiteintraege = new ArrayList<>();
    static ArrayList<Anwesenheit> anwesenheit = new ArrayList<>();

    public Anwesenheit(String mitglied, int startzeit, int endzeit) {
        this.mitglied = mitglied;
        this.startzeit = startzeit;
        this.endzeit = endzeit;
    }
    public Anwesenheit(int dauer) {
        this.dauer = dauer;
    }
    public int getDauer() {
        return dauer;
    }
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }
    // Methode Anwesenheit hinzuzufügen
    public void anwesenheitHinzufuegen(String mitglied, int startzeit, int endzeit) {
        Anwesenheit eintrag = new Anwesenheit(mitglied, startzeit, endzeit);
        anwesenheit.add(eintrag);
    }

    // Methode Anwesenheit zu verändern
    public void anwesenheitAendern(String mitglied, int index, int neueStartzeit, int neueEndzeit) {
        for (Anwesenheit eintrag : anwesenheit) {
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

    // Methode Anwesenheit zu löschen
    public void anwesenheitLoeschen(String mitglied, int index) {
        for (Anwesenheit eintrag : anwesenheit) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                if (index >= 0 && index < zeiteintraege.size()) {
                    zeiteintraege.remove(index);
                }
            }
        }
    }

    // Methode Anwesenheit für Mitglied anzuzeigen
    public void anzeigenAnwesenheitMitglied(String mitglied) {
        for (Anwesenheit eintrag : anwesenheit) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                System.out.println("Anwesenheitszeiten für Mitglied " + mitglied + ":");
                for (Zeiteintrag zeiteintra : zeiteintraege) {
                }
            }
        }
    }

    // Methode Gesamtanwesenheit zu Mitglied anzuzeigen
    public void anzeigenGesamteAnwesenheit(String mitglied) {
        for (Anwesenheit eintrag : anwesenheit) {
            if (eintrag.mitglied.equals(mitglied)) {
                ArrayList<Zeiteintrag> zeiteintraege = eintrag.zeiteintraege;

                int gesamteAnwesenheitszeit = 0;
                for (Zeiteintrag zeiteintrag : zeiteintraege) {
                    gesamteAnwesenheitszeit += zeiteintrag.endzeit - zeiteintrag.startzeit;
                }
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
