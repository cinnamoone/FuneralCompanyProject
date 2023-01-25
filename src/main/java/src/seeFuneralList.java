package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class seeFuneralList extends JFrame{

    private JPanel MainPanel;
    private JTextArea Area;
    private JScrollPane ScrollPane;

    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");


    public seeFuneralList() {
        this.setTitle("Lista pogrzebów");
        this.setContentPane(MainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        seeFuneral(database);
    }

    public void seeFuneral(MongoDatabase database){

        List<Document> funerals = database.getCollection("funeralList").find().into(new ArrayList<>());
        List<String> newFunerals = new ArrayList<>();
        for(int funeral = 0; funeral < funerals.size(); funeral++) {
            String funeralID = funerals.get(funeral).getString("_id");
            String funeralDate = funerals.get(funeral).getString("funeralDate");
            Document deceasedInfo = funerals.get(funeral).get("deceasedInfo", Document.class);
            String nameAndSurname = deceasedInfo.getString("nameAndSurname");
            String deathDate = deceasedInfo.getString("deathDate");
            Document graveyard = funerals.get(funeral).get("graveyard", Document.class);
            String communal = graveyard.getString("communal");
            String town = graveyard.getString("town");
            String graveyardName = graveyard.getString("graveyardName");

            newFunerals.add("\n" + (funeral + 1) +
                    "\nID pogrzebu: " + funeralID +
                    "\nOsoba zmarła: " + nameAndSurname +
                    "\nData pogrzebu: " + funeralDate +
                    "\nData śmierci: " + deathDate +
                    "\nMiejsce pogrzebu: " + town +
                    "\nNazwa cmentarza: " + graveyardName +
                    "\nCzy komunalny: " + communal + "\n");

            Area.append(newFunerals.get(funeral));

        }
    }
}
