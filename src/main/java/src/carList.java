package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class carList extends JFrame{
    private JTextArea AreaCar;
    private JScrollPane ScrollCar;
    private JPanel PanelCar;

    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");

    public carList () {
        this.setTitle("Lista samochodów");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelCar);
        this.pack();
        this.setLocationRelativeTo(null);
        seeCars();
    }

    public void seeCars() {

        List<Document> cars = database.getCollection("cars").find().into(new ArrayList<>());
        List<String> newCars = new ArrayList<>();
        for (int car = 0; car < cars.size(); car++) {
            String carID = cars.get(car).getString("_id");
            String Mark = cars.get(car).getString("mark");
            String Model = cars.get(car).getString("model");
            String Kolor = cars.get(car).getString("color");
            String Rejestracja = cars.get(car).getString("registration");


            newCars.add("\n" + (car + 1) +
                    "\nID samochodu: " + carID +
                    "\nMarka: " + Mark +
                    "\nModel: " + Model +
                    "\nKolor: " + Kolor +
                    "\nRejestracja: " + Rejestracja + "\n");

            AreaCar.append(newCars.get(car));

        }
    }
}
