package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funeralList extends JFrame {
    private JPanel panel1;
    private JTextField funeralID;
    private JTextField funeralDate;
    private JTextField AddnameAndSurname;
    private JTextField AdddeathDate;
    private JTextField addDeceasedID;
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
    private JComboBox comm;


        String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
        MongoCollection funeralList = database.getCollection("funeralList");



    public funeralList() throws HeadlessException {
        this.setContentPane(panel1);
        this.pack();
        this.setLocationRelativeTo(null);

        addFuneralList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Document d =new Document("funeralID",funeralID.getText());
                d.append("funeralDate",funeralDate.getText());
                Document deceasedInfo = new Document();
                deceasedInfo.append("nameAndSurname", AddnameAndSurname.getText());
                deceasedInfo.append("deathDate", AdddeathDate.getText());
                deceasedInfo.append("deceasedID", addDeceasedID.getText());
                d.append("deceasedInfo", deceasedInfo);
                Document gravyard = new Document();
                gravyard.append("communal", comm.getSelectedItem());
                gravyard.append("town", addTown.getText());
                gravyard.append("graveyardName", addGraveyardName.getText());
                d.append("graveyard", gravyard);
                funeralList.insertOne(d);
            }
        });
    }


}
