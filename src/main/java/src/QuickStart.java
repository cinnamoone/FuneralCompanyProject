package src;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;

public class QuickStart {
    public static void main(String[] args) {

            String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("FuneralCompany");



        SwingUtilities.invokeLater(
                () -> new seeFuneralList(database).setVisible(true)
        );

//        SwingUtilities.invokeLater(
//                () -> new funeralList().setVisible(true)
//        );


    }


}
