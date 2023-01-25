package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel MainPanel;
    private JButton zobaczListęPogrzebówButton;
    private JButton dodajZmarłegoButton;
    private JButton zobaczListęZmarłychButton;
    private JButton zobaczListęPracownikówButton;
    private JButton dodajPogrzebButton;
    private JButton zobaczListęKarawanówButton;
    private JButton zobaczListęTransportówButton;

    public Menu() {

        this.setTitle("Menu Główne");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        zobaczListęPogrzebówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(
                                    () -> new seeFuneralList().setVisible(true)
                        );

            }
        });
        zobaczListęKarawanówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(
                        () -> new carList().setVisible(true)
                );
            }
        });
        dodajZmarłegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(
                        () -> new addDeceased().setVisible(true)
                );
            }
        });
        zobaczListęZmarłychButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(
                        () -> new deceasedList().setVisible(true)
                );
            }
        });
        zobaczListęTransportówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(
                        () -> new transportList().setVisible(true)
                );
            }
        });
        zobaczListęPracownikówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(
                        () -> new employeeList().setVisible(true)
                );
            }
        });
        dodajPogrzebButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(
                        () -> new funeralList().setVisible(true)
                );
            }
        });
    }
}
