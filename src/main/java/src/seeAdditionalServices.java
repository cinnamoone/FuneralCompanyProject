package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class seeAdditionalServices extends JFrame{
    private JPanel PanelS;
    private JTextArea AreaS;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");


    public seeAdditionalServices() {
        this.setTitle("Lista dodatkowych usług");
        this.setContentPane(PanelS);
        this.pack();
        this.setLocationRelativeTo(null);
        seeServices();
    }

    public void seeServices(){

        List<Document> services = database.getCollection("additionalServices").find().into(new ArrayList<>());
        List<String> newServices = new ArrayList<>();
        for(int service= 0; service < services.size(); service++) {
            String id_s = services.get(service).getString("_id");
            String price = services.get(service).getString("price");
            String name = services.get(service).getString("serviceName");

//            Document deceasedInfo = services.get(service).get("deceasedInfo", Document.class);
//            String nameAndSurname = deceasedInfo.getString("nameAndSurname");
//            String deathDate = deceasedInfo.getString("deathDate");
//
//            List<Object> employees = new ArrayList<>();
//
//            if(comboBox1.getSelectedItem() != "-"){
//                employees.add(comboBox1.getSelectedItem());
//            }


            newServices.add("\n" + (service + 1) +
                    "\nID usługi: " + id_s +
                    "\nCena usługi: " + price +
                    "\nNazwa usługi: " + name +
                    "\n");

            AreaS.append(newServices.get(service));

        }
    }
}
