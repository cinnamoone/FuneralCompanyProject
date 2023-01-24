package src;

import javax.swing.*;
import java.awt.*;

public class funeralList extends JFrame {
    private JPanel panel1;
    private JTextField funeralID;
    private JTextField funeralDate2;
    private JTextField AddnameAndSurname;
    private JTextField AdddeathDate;
    private JTextField addDeceasedID;
    private JTextField isCommunal;
    private JTextField addTown;
    private JTextField addGraveyardName;
    private JButton addFuneralList;
    private JLabel nameSurnameD;
    private JLabel deathDateD;
    private JLabel deceasedID;
    private JLabel graveyard;
    private JLabel communal;
    private JLabel town;
    private JLabel graveyardName;

    public funeralList() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
