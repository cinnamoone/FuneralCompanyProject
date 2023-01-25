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

public class transportDetails extends JFrame{
    private JPanel panelT;
    private JButton addTransport;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField5;
    private JPanel transportDetail;
    private JLabel trransportID;
    private JTextField addTransportID;
    private JLabel pickUpLocation;
    private JLabel townT;
    private JLabel street;
    private JLabel streetNumber;
    private JLabel postalCode;
    private JLabel carDetails;
    private JLabel carID;
    private JLabel driver;
    private JLabel employeeID;
    private JPanel driverInfo;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTextField textField4;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
    MongoCollection transport = database.getCollection("transportDetails");



    public transportDetails() throws HeadlessException {
        this.setContentPane(panelT);
        this.pack();
        this.setLocationRelativeTo(null);

        addTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Document d =new Document("_id",addTransportID.getText());
                Document pickUpLocation = new Document();
                pickUpLocation.append("town",textField1.getText());
                pickUpLocation.append("funeralDate",textField1.getText());
                pickUpLocation.append("streetName",textField2.getText());
                pickUpLocation.append("houseNr", textField3.getText());
                pickUpLocation.append("postalCode",textField5.getText());
                d.append("pickUpLocation", pickUpLocation);

                d.append("car", comboBox5.getSelectedItem());
                d.append("driver", comboBox3.getSelectedItem());


                transport.insertOne(d);
            }
        });
    }
}
