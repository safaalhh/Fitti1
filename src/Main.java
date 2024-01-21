import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel FitFirst;
    private JPanel gymName;
    private JButton mitgliederButton;
    private JButton kurseButton;
    private JFrame mainFrame;


    public Main() {
        mainFrame = new JFrame("Hauptoberfläche");
        mitgliederButton = new JButton("Mitglieder");

        mitgliederButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMitgliederWindow();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.add(mitgliederButton);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(300, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void openMitgliederWindow() {
        JFrame mitgliederFrame = new JFrame("Mitgliederfenster");
        JButton closeButton = new JButton("Mitglieder anzeigen");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mitgliederFrame.dispose();
            }
        });

        JPanel mitgliederPanel = new JPanel();
        mitgliederPanel.add(closeButton);

        mitgliederFrame.getContentPane().add(mitgliederPanel);
        mitgliederFrame.setSize(300, 200);
        mitgliederFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mitgliederFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}