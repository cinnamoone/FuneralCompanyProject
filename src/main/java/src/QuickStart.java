package src;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;

public class QuickStart {
    public static void main(String[] args) {

//
//
//      Zobacz listę pogrzebów:
//        SwingUtilities.invokeLater(
//                () -> new seeFuneralList().setVisible(true)
//        );


//      Dodaj pogrzeb:
//        SwingUtilities.invokeLater(
//                () -> new funeralList().setVisible(true)
//        );

//      Dodaj zmarłego:
//        SwingUtilities.invokeLater(
//                () -> new addDeceased().setVisible(true)
//        );

//        Dodatkowe usługi
//        SwingUtilities.invokeLater(
//                () -> new additionalServices().setVisible(true)
//        );

       //Lista samochodów:
        SwingUtilities.invokeLater(
                () -> new carList().setVisible(true)
        );






    }


}
