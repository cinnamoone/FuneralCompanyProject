package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDeceased extends JFrame {
    private JTextField nameDeceased;
    private JTextField surnameDeceased;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton addDeceased;
    private JLabel birthDate;
    private JLabel deathDate;
    private JLabel peselDeceased;
    private JLabel deceasedID;
    private JLabel deceasedInfo;
    private JPanel panelG;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
    MongoCollection deceased = database.getCollection("deceasedInfo");



    public addDeceased() throws HeadlessException {
        this.setContentPane(panelG);
        this.pack();
        this.setLocationRelativeTo(null);

        addDeceased.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Document d =new Document("_id",textField6.getText());
                d.append("name",nameDeceased.getText());
                d.append("surname", surnameDeceased.getText());
                d.append("deathDate", textField4.getText());
                d.append("birthDate", textField3.getText());
                d.append("pesel", textField5.getText());
                deceased.insertOne(d);
                JOptionPane.showMessageDialog(null, "Dodano zmarłego.");

            }
        });

    }

}
