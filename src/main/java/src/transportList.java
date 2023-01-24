package src;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class transportList extends JFrame {
    private JPanel PanelTL;
    private JTextArea AreaTransport;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
    MongoCollection<Document> transport = database.getCollection("transportDetails");
    MongoCollection<Document> employee = database.getCollection("employeeInfo");
    MongoCollection<Document> car = database.getCollection("cars");


    public transportList() {
        this.setTitle("Lista transportów");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelTL);
        this.pack();
        this.setLocationRelativeTo(null);
        seeTransport();
    }

    public void seeTransport(){

        List<Document> transports = transport.find().into(new ArrayList<>());
        List<Document> employees = employee.find().into(new ArrayList<>());
        List<Document> cars = car.find().into(new ArrayList<>());

        List<String> newTransport = new ArrayList<>();
        String imie = null;
        String nazwisko = null;
        String marka = null;
        String model = null;
        String kolor = null;
        String rejestracja = null;


        for (int transport = 0; transport < transports.size(); transport++) {
            String id = transports.get(transport).getString("_id");
            Document pickUpLocation = transports.get(transport).get("pickUpLocation", Document.class);
            String town = pickUpLocation.getString("town");
            String streetName = pickUpLocation.getString("streetName");
            String streetNr = pickUpLocation.getString("streetNr");
            String houseNr = pickUpLocation.getString("houseNr");
            String postalCode = pickUpLocation.getString("postalCode");
            String car = transports.get(transport).getString("car");
            String driver = transports.get(transport).getString("driver");

            for(int empl = 0; empl< employees.size(); empl++){
                if(employees.get(empl).getString("_id").equals(driver)){
                    imie = employees.get(empl).getString("name");
                    nazwisko = employees.get(empl).getString("surname");
                }
            }

            for(int ca = 0; ca< cars.size(); ca++){
                if(cars.get(ca).getString("_id").equals(car)){
                    marka = cars.get(ca).getString("mark");
                    model = cars.get(ca).getString("model");
                    kolor = cars.get(ca).getString("color");
                    rejestracja = cars.get(ca).getString("registration");
                }
            }

            newTransport.add("\n" + (transport + 1) +
                    "\nID transportu: " + id +
                    "\nMiejscowość: " + town +
                    "\nUlica: " + streetName +
                    "\nNumer ulicy: " + streetNr +
                    "\nNumer domu: " + houseNr +
                    "\nKod pocztowy: " + postalCode +
                    "\nImię kierowcy: " + imie +
                    "\nNazwisko kierowcy: " + nazwisko +
                    "\nMarka karawanu: " + marka +
                    "\nModel karawanu: "+ model +
                    "\nKolor karawanu: "+ kolor +
                    "\nRejestracja karawanu: " + rejestracja + "\n");

            AreaTransport.append(newTransport.get(transport));

        }

    }
}
