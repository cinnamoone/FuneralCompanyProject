package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class employeeList extends JFrame{
    private JTextArea AreaEmployee;
    private JPanel PanelE;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");

    public employeeList() {
        this.setTitle("Lista pracowników");
        this.setContentPane(PanelE);
        this.pack();
        this.setLocationRelativeTo(null);
        seeEmployee();
    }

    public void seeEmployee() {

        List<Document> employees = database.getCollection("employeeInfo").find().into(new ArrayList<>());
        List<String> newDeceased = new ArrayList<>();
        for (int employee = 0; employee < employees.size(); employee++) {
            String id = employees.get(employee).getString("_id");
            String imie = employees.get(employee).getString("name");
            String nazwisko = employees.get(employee).getString("surname");
            String pesel = employees.get(employee).getString("pesel");
            String function = employees.get(employee).getString("function");



            newDeceased.add("\n" + (employee + 1) +
                    "\nID pracownika: " + id +
                    "\nImię: " + imie +
                    "\nNazwisko: " + nazwisko +
                    "\nPesel: " + pesel +
                    "\nFunkcja: " + function + "\n");

            AreaEmployee.append(newDeceased.get(employee));

        }
    }
}
