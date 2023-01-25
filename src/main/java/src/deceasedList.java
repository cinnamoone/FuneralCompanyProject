package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class deceasedList extends JFrame{
    private JPanel PanelDeceased;
    private JTextArea AreaDeceased;

    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");

    public deceasedList() {
        this.setTitle("Lista zmarłych");
        this.setContentPane(PanelDeceased);
        this.pack();
        this.setLocationRelativeTo(null);
        seeDeceased();
    }

    public void seeDeceased() {

        List<Document> deceaseds = database.getCollection("deceasedInfo").find().into(new ArrayList<>());
        List<String> newDeceased = new ArrayList<>();
        for (int deceased = 0; deceased < deceaseds.size(); deceased++) {
            String id_zm = deceaseds.get(deceased).getString("_id");
            String imie = deceaseds.get(deceased).getString("name");
            String nazwisko = deceaseds.get(deceased).getString("surname");
            String data_ur = deceaseds.get(deceased).getString("birthDate");
            String data_sm = deceaseds.get(deceased).getString("deathDate");
            String pesel = deceaseds.get(deceased).getString("pesel");



            newDeceased.add("\n" + (deceased + 1) +
                    "\nID zmarłego: " + id_zm +
                    "\nImię: " + imie +
                    "\nNazwisko: " + nazwisko +
                    "\nData urodzenia: " + data_ur +
                    "\nData śmierci: " + data_sm +
                    "\nPesel: " + pesel +"\n");

            AreaDeceased.append(newDeceased.get(deceased));

        }
    }
}
