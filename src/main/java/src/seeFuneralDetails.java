package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class seeFuneralDetails extends JFrame{
    private JPanel panel;
    private JTextArea AreaD;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");


    public seeFuneralDetails() {
        this.setTitle("Szczegóły pogrzebów");
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        seeFuneral();
    }

    public void seeFuneral() {
        List<Document> details = database.getCollection("funeralDetails").find().into(new ArrayList<>());

        List<String> newDetails = new ArrayList<>();

        for (int detail = 0; detail < details.size(); detail++) {
            String id = details.get(detail).getString("_id");
            String fdate = details.get(detail).getString("funeralDate");
            String transport = details.get(detail).getString("transportID");

            Document dece = details.get(detail).get("deceasedInfo", Document.class);
            String deceID = dece.getString("deceasedID");
            String imieinazwisko = dece.getString("nameAndSurname");
            String pesel = dece.getString("pesel");

            Document placeOfBurial = details.get(detail).get("placeOfBurial", Document.class);
            String graveyardName = placeOfBurial.getString("graveyardName");
            String town = placeOfBurial.getString("town");
            String alley = placeOfBurial.getString("alley");
            String sector = placeOfBurial.getString("sector");
            String nr = placeOfBurial.getString("nr");
            String communal = placeOfBurial.getString("communal");

            Document price = details.get(detail).get("price", Document.class);
            String startPrice = price.getString("startPrice");
            String aservPricec = price.getString("aservPricec");
            String summPrice = price.getString("summPrice");



            newDetails.add("\n" + (detail + 1) +
                    "\nID pogrzebu: " + id +
                    "\nData pogrzebu: " + fdate +
                    "\nID zmarłego: " + deceID +
                    "\nImię i nazwisko zmarłego: " + imieinazwisko +
                    "\nPesel zmarłego: " + pesel +
                    "\nNazwa cmentarza: " + graveyardName +
                    "\nMiasto: " + town +
                    "\nAlejka: " + alley +
                    "\nSektor: "+ sector +
                    "\nNumer: "+ nr +
                    "\nKomunalny: " + communal +
                    "\nID transportu " + transport +
                    "\nCena startowa:" + startPrice +
                    "\nCena za usługi: " + aservPricec+
                    "\nSuma: " + summPrice +"\n");

            AreaD.append(newDetails.get(detail));

        }


    }

}
