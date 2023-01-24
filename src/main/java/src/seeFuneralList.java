package src;

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


    public seeFuneralList(MongoDatabase database) {
        this.setTitle("Lista pogrzebów");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        seeFuneral(database);
    }

    public void seeFuneral(MongoDatabase database){

        List<Document> funerals = database.getCollection("funeralList").find().into(new ArrayList<>());
        List<String> newFunerals = new ArrayList<>();
        for(int funeral = 0; funeral < funerals.size(); funeral++) {
            String funeralID = funerals.get(funeral).getString("funeralID");
            Date funeralDate = funerals.get(funeral).getDate("funeralDate");
            Document deceasedInfo = funerals.get(funeral).get("deceasedInfo", Document.class);
            String nameAndSurname = deceasedInfo.getString("nameAndSurname");
            Date deathDate = deceasedInfo.getDate("deathDate");
            Document graveyard = funerals.get(funeral).get("graveyard", Document.class);
            Boolean communal = graveyard.getBoolean("communal");
            String town = graveyard.getString("town");
            String graveyardName = graveyard.getString("graveyardName");
            String odp;
            if(communal==true){
                odp = "TAK";
            }else{
                odp = "NIE";
            }

            newFunerals.add("\n" + (funeral + 1) +
                    "\nID pogrzebu: " + funeralID +
                    "\nOsoba zmarła: " + nameAndSurname +
                    "\nData pogrzebu: " + funeralDate +
                    "\nData śmierci: " + deathDate +
                    "\nMiejsce pogrzebu: " + town +
                    "\nNazwa cmentarza: " + graveyardName +
                    "\nCzy komunalny: " + odp + "\n");

            Area.append(newFunerals.get(funeral));

        }
    }
}
