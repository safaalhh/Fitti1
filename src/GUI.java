import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class GUI {
    private ArrayList<Kurs> selectedKurse = new ArrayList<>();
    private JList<String> mitgliederListe;
    private DefaultListModel<String> mitgliederListModel;
    private MitgliedManager mitgliederManager;

    private JButton mitgliederButton;
    private JButton kurseButton;
    private JFrame mainFrame;

    private String[] geschlechtOptions = {"m", "w"};

    public GUI() {
        mitgliederManager = new MitgliedManager();

        mainFrame = new JFrame("FitFirst");
        mitgliederButton = new JButton("Mitglieder");
        kurseButton = new JButton("Kurse");

        mitgliederButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMitgliederWindow();
            }
        });

        kurseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openKurseWindow();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.add(mitgliederButton);
        mainPanel.add(kurseButton);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void openMitgliederWindow() {
        JFrame mitgliederFrame = new JFrame("Mitglieder");
        JButton closeButton = new JButton("Zurück");
        JButton mitgliederAnzeigenButton = new JButton("Mitglieder anzeigen");
        JButton mitgliederHinzufuegenButton = new JButton("Mitglieder hinzufügen");

        mitgliederAnzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openmitgliederAnzeigenWindow();
            }
        });

        mitgliederHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openmitgliederHinzufuegenWindow();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mitgliederFrame.dispose();
            }
        });

        JPanel mitgliederPanel = new JPanel();
        mitgliederPanel.add(mitgliederAnzeigenButton);
        mitgliederPanel.add(mitgliederHinzufuegenButton);
        mitgliederPanel.add(closeButton);

        mitgliederFrame.getContentPane().add(mitgliederPanel);
        mitgliederFrame.setSize(500, 500);
        mitgliederFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mitgliederFrame.setVisible(true);
    }

    private void openmitgliederAnzeigenWindow() {
        JFrame mitgliederAnzeigenFrame = new JFrame("Mitglieder - Mitglieder anzeigen");
        JButton bearbeitenButton = new JButton("Mitglied bearbeiten");
        JButton loeschenButton = new JButton("Mitglied löschen");
        JButton closeButton = new JButton("Zurück");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mitgliederAnzeigenFrame.dispose();
            }
        });

        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bearbeiteMitglied();
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loescheMitglied();
            }
        });

        mitgliederListModel = new DefaultListModel<>();
        mitgliederListe = new JList<>(mitgliederListModel);
        mitgliederListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel mitgliederPanel = new JPanel(new BorderLayout());
        mitgliederPanel.add(new JScrollPane(mitgliederListe), BorderLayout.CENTER);
        mitgliederPanel.add(bearbeitenButton, BorderLayout.WEST);
        mitgliederPanel.add(loeschenButton, BorderLayout.EAST);
        mitgliederPanel.add(closeButton, BorderLayout.SOUTH);

        updateMitgliederListe();

        mitgliederAnzeigenFrame.getContentPane().add(mitgliederPanel);
        mitgliederAnzeigenFrame.setSize(700, 500);
        mitgliederAnzeigenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mitgliederAnzeigenFrame.setVisible(true);
    }

    private void bearbeiteMitglied() {

        int selectedIndex = mitgliederListe.getSelectedIndex();

        if (selectedIndex != -1) {
            Mitglied selectedMitglied = mitgliederManager.getMitgliedListe().get(selectedIndex);

            JFrame bearbeitenFrame = new JFrame("Mitglieder bearbeiten");
            JButton speicherButton = new JButton("Speichern");
            JButton closeButton = new JButton("Abbrechen");

            JTextField mitgliedNummerField = new JTextField(selectedMitglied.getMitgliedNummer());
            JTextField nameField = new JTextField(selectedMitglied.getName());
            JTextField geburtsdatumField = new JTextField(selectedMitglied.getGeburtsdatum());
            JComboBox<String> geschlechtComboBox = new JComboBox<>(geschlechtOptions);
            geschlechtComboBox.setSelectedItem(String.valueOf(selectedMitglied.getGeschlecht()));
            JTextField kurseField = new JTextField();

            for (Kurs kurs : selectedMitglied.getKurse()) {
                kurseField.setText(kurseField.getText() + kurs.getName() + ", ");

            }
            speicherButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedMitglied.setMitgliedNummer(Integer.parseInt(mitgliedNummerField.getText()));
                    selectedMitglied.setName(nameField.getText());
                    selectedMitglied.setGeburtsdatum(geburtsdatumField.getText());
                    selectedMitglied.setGeschlecht((String) geschlechtComboBox.getSelectedItem());

                    bearbeitenFrame.dispose();

                    updateMitgliederListe();
                }
            });

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bearbeitenFrame.dispose();
                }
            });

            JPanel bearbeitenPanel = new JPanel(new GridLayout(7, 2));
            bearbeitenPanel.add(new JLabel("Mitgliedsnummer:"));
            bearbeitenPanel.add(mitgliedNummerField);
            bearbeitenPanel.add(new JLabel("Name:"));
            bearbeitenPanel.add(nameField);
            bearbeitenPanel.add(new JLabel("Geburtsdatum:"));
            bearbeitenPanel.add(geburtsdatumField);
            bearbeitenPanel.add(new JLabel("Geschlecht:"));
            bearbeitenPanel.add(geschlechtComboBox);
            bearbeitenPanel.add(new JLabel("Fitnesskurse:"));
            bearbeitenPanel.add(kurseField);
            bearbeitenPanel.add(speicherButton);
            bearbeitenPanel.add(closeButton);

            bearbeitenFrame.getContentPane().add(bearbeitenPanel);
            bearbeitenFrame.setSize(500, 500);
            bearbeitenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            bearbeitenFrame.setVisible(true);
        }
    }

    private void loescheMitglied() {

        int selectedIndex = mitgliederListe.getSelectedIndex();

        Mitglied deletedMitglied = mitgliederManager.getMitgliedListe().get(selectedIndex);
        mitgliederManager.mitgliedLoeschen(deletedMitglied);
        updateMitgliederListe();
    }

    private void updateMitgliederListe() {
        mitgliederListModel.clear();
        for (Mitglied mitglied : mitgliederManager.getMitgliedListe()) {
            mitgliederListModel.addElement(mitglied.toString());
        }
    }

    private void openmitgliederHinzufuegenWindow() {

        JFrame mitgliederHinzufuegenFrame = new JFrame("Mitglieder - Mitglieder hinzufügen");
        JButton hinzufuegenButton = new JButton("Hinzufügen");
        JButton closeButton = new JButton("Zurück");

        JTextField mitgliedNummerField = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField geburtsdatumField = new JTextField(20);
        JComboBox<String> geschlechtComboBox = new JComboBox<>(geschlechtOptions);
        JTextField kurseField = new JTextField(20);

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Mitglied newMitglied = mitgliederManager.neuesMitgliedHinzufuegen(
                        Integer.parseInt(mitgliedNummerField.getText()),
                        nameField.getText(),
                        geburtsdatumField.getText(),
                        (String) geschlechtComboBox.getSelectedItem()
                );
                for (Kurs kurs : selectedKurse) {
                    mitgliederManager.mitgliedZuKursHinzufuegen(newMitglied,kurs);
                }

                mitgliederHinzufuegenFrame.dispose();

                updateMitgliederListe();
            }
        });

        JComboBox<String> kurseComboBox = new JComboBox<>();
        for (Kurs kurs : mitgliederManager.getKursListe()) {
            kurseComboBox.addItem(kurs.getName());
        }

        kurseComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKursName = (String) kurseComboBox.getSelectedItem();
                selectedKurse.add(mitgliederManager.getKursByName(selectedKursName));
            }
        });




        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mitgliederHinzufuegenFrame.dispose();
            }
        });

        JPanel mitgliederHinzufuegenPanel = new JPanel(new GridLayout(6, 2));
        mitgliederHinzufuegenPanel.add(new JLabel("Mitgliedsnummer:"));
        mitgliederHinzufuegenPanel.add(mitgliedNummerField);
        mitgliederHinzufuegenPanel.add(new JLabel("Name:"));
        mitgliederHinzufuegenPanel.add(nameField);
        mitgliederHinzufuegenPanel.add(new JLabel("Geburtsdatum:"));
        mitgliederHinzufuegenPanel.add(geburtsdatumField);
        mitgliederHinzufuegenPanel.add(new JLabel("Geschlecht:"));
        mitgliederHinzufuegenPanel.add(geschlechtComboBox);
        mitgliederHinzufuegenPanel.add(new JLabel("Fitnesskurse:"));
        mitgliederHinzufuegenPanel.add(kurseComboBox);
        mitgliederHinzufuegenPanel.add(hinzufuegenButton);
        mitgliederHinzufuegenPanel.add(closeButton);

        mitgliederHinzufuegenFrame.getContentPane().add(mitgliederHinzufuegenPanel);
        mitgliederHinzufuegenFrame.setSize(500, 500);
        mitgliederHinzufuegenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mitgliederHinzufuegenFrame.setVisible(true);
    }


    private void openKurseWindow() {
        JFrame kurseFrame = new JFrame("Kurse");
        JButton kurseAnzeigenButton = new JButton("Kurse anzeigen");
        JButton kurseHinzufuegenButton = new JButton("Kurse hinzufügen");
        JButton kurseBearbeitenButton = new JButton("Kurse bearbeiten");
        JButton kurseLoeschenButton = new JButton("Kurse löschen");
        JButton closeButton = new JButton("Zurück");

        kurseAnzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openkurseAnzeigenWindow();
            }
        });

        kurseHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openkurseHinzufuegenWindow();
            }
        });

        kurseBearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bearbeiteKurs();
            }
        });

        kurseLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loescheKurs();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kurseFrame.dispose();
            }
        });

        JPanel kursePanel = new JPanel();
        kursePanel.add(kurseAnzeigenButton);
        kursePanel.add(kurseHinzufuegenButton);
        kursePanel.add(closeButton);

        kurseFrame.getContentPane().add(kursePanel);
        kurseFrame.setSize(500, 500);
        kurseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kurseFrame.setVisible(true);
    }

    private void openkurseAnzeigenWindow() {
        JFrame kurseAnzeigenFrame = new JFrame("Kurse - Kurse anzeigen");
        JButton bearbeitenButton = new JButton("Kurs bearbeiten");
        JButton loeschenButton = new JButton("Kurs löschen");
        JButton closeButton = new JButton("Zurück");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kurseAnzeigenFrame.dispose();
            }
        });

        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bearbeiteKurs();
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loescheKurs();
            }
        });

        mitgliederListModel = new DefaultListModel<>();
        mitgliederListe = new JList<>(mitgliederListModel);
        mitgliederListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel kursePanel = new JPanel(new BorderLayout());
        kursePanel.add(new JScrollPane(mitgliederListe), BorderLayout.CENTER);
        kursePanel.add(bearbeitenButton, BorderLayout.WEST);
        kursePanel.add(loeschenButton, BorderLayout.EAST);
        kursePanel.add(closeButton, BorderLayout.SOUTH);

        updateKurseListe();

        kurseAnzeigenFrame.getContentPane().add(kursePanel);
        kurseAnzeigenFrame.setSize(700, 500);
        kurseAnzeigenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kurseAnzeigenFrame.setVisible(true);
    }

    private void openkurseHinzufuegenWindow() {
        JFrame kurseHinzufuegenFrame = new JFrame("Kurse - Kurse hinzufügen");
        JButton hinzufuegenButton = new JButton("Hinzufügen");
        JButton closeButton = new JButton("Zurück");

        JTextField nameField = new JTextField(20);
        JTextField beschreibungField = new JTextField(20);

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mitgliederManager.neuenKursAnlegen(nameField.getText(), beschreibungField.getText());
                kurseHinzufuegenFrame.dispose();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kurseHinzufuegenFrame.dispose();
            }
        });

        JPanel kursePanel = new JPanel();
        kursePanel.add(closeButton);

        JPanel kurseHinzufuegenPanel = new JPanel(new GridLayout(6, 2));
        kurseHinzufuegenPanel.add(new JLabel("Name:"));
        kurseHinzufuegenPanel.add(nameField);
        kurseHinzufuegenPanel.add(new JLabel("Beschreibung:"));
        kurseHinzufuegenPanel.add(beschreibungField);
        kurseHinzufuegenPanel.add(hinzufuegenButton);
        kurseHinzufuegenPanel.add(closeButton);

        kurseHinzufuegenFrame.getContentPane().add(kurseHinzufuegenPanel);
        kurseHinzufuegenFrame.setSize(500, 500);
        kurseHinzufuegenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kurseHinzufuegenFrame.setVisible(true);
    }

    private void bearbeiteKurs() {
        int selectedIndex = mitgliederListe.getSelectedIndex();

        if (selectedIndex != -1) {
            Kurs selectedKurs = mitgliederManager.getKursListe().get(selectedIndex);

            JFrame bearbeitenFrame = new JFrame("Kurs bearbeiten");
            JButton speicherButton = new JButton("Speichern");
            JButton closeButton = new JButton("Abbrechen");

            JTextField nameField = new JTextField(selectedKurs.getName());
            JTextField beschreibungField = new JTextField(selectedKurs.getBeschreibung());

            speicherButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedKurs.setKursname(nameField.getText());
                    selectedKurs.setBeschreibung(beschreibungField.getText());

                    bearbeitenFrame.dispose();
                    updateKurseListe();
                }
            });

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bearbeitenFrame.dispose();
                }
            });

            JPanel bearbeitenPanel = new JPanel(new GridLayout(4, 2));
            bearbeitenPanel.add(new JLabel("Name:"));
            bearbeitenPanel.add(nameField);
            bearbeitenPanel.add(new JLabel("Beschreibung:"));
            bearbeitenPanel.add(beschreibungField);
            bearbeitenPanel.add(speicherButton);
            bearbeitenPanel.add(closeButton);

            bearbeitenFrame.getContentPane().add(bearbeitenPanel);
            bearbeitenFrame.setSize(500, 500);
            bearbeitenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            bearbeitenFrame.setVisible(true);
        }
    }

    private void loescheKurs() {
        int selectedIndex = mitgliederListe.getSelectedIndex();

        if (selectedIndex != -1) {
            Kurs selectedKurs=mitgliederManager.getKursListe().get(selectedIndex);
            mitgliederManager.kursloeschen(selectedKurs);
            updateKurseListe();
        }
    }

    private void updateKurseListe() {
        mitgliederListModel.clear();
        for (Kurs kurs : mitgliederManager.getKursListe()) {
            mitgliederListModel.addElement(kurs.toString());
        }
    }

    private void mitgliedZuKursHinzufuegen() {
        int selectedIndex = mitgliederListe.getSelectedIndex();

        if (selectedIndex != -1) {
            Mitglied selectedMitglied = mitgliederManager.getMitgliedListe().get(selectedIndex);

            JFrame zuKursHinzufuegenFrame = new JFrame("Mitglied zu Kurs hinzufügen");
            JButton hinzufuegenButton = new JButton("Hinzufügen");
            JButton closeButton = new JButton("Abbrechen");

            JComboBox<String> kurseComboBox = new JComboBox<>();
            for (Kurs kurs : mitgliederManager.getKursListe()) {
                kurseComboBox.addItem(kurs.getName());
            }

            hinzufuegenButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedKursIndex = kurseComboBox.getSelectedIndex();
                    if (selectedKursIndex != -1) {
                        Kurs selectedKurs = mitgliederManager.getKursListe().get(selectedKursIndex);
                        mitgliederManager.mitgliedZuKursHinzufuegen(selectedMitglied,selectedKurs);
                        selectedMitglied.kursBeitreten(selectedKurs);
                        zuKursHinzufuegenFrame.dispose();

                        updateMitgliederListe(); // Mitglieder Liste aktualisieren
                    }
                }
            });

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openmitgliederHinzufuegenWindow();
                    mitgliedZuKursHinzufuegen();
                }
            });

            JPanel zuKursHinzufuegenPanel = new JPanel(new GridLayout(3, 2));
            zuKursHinzufuegenPanel.add(new JLabel("Mitglied auswählen:"));
            zuKursHinzufuegenPanel.add(new JLabel(selectedMitglied.getName()));
            zuKursHinzufuegenPanel.add(new JLabel("Kurs auswählen:"));
            zuKursHinzufuegenPanel.add(kurseComboBox);
            zuKursHinzufuegenPanel.add(hinzufuegenButton);
            zuKursHinzufuegenPanel.add(closeButton);

            zuKursHinzufuegenFrame.getContentPane().add(zuKursHinzufuegenPanel);
            zuKursHinzufuegenFrame.setSize(500, 200);
            zuKursHinzufuegenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            zuKursHinzufuegenFrame.setVisible(true);
        }
    }


}
