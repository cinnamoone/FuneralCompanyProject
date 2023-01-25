package src;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class additionalServices extends JFrame {
    private JPanel panelA;
    private JTextField addPrice;
    private JTextField addServiceName;
    private JTextField addserviceID;
    private JLabel aServiceID;
    private JLabel serviceName;
    private JLabel servicePrice;
    private JButton addServiceButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JTextField textField1;


    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
    MongoCollection additional = database.getCollection("additionalServices");



    public additionalServices() throws HeadlessException {
        this.setContentPane(panelA);
        this.pack();
        this.setLocationRelativeTo(null);

        addServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Document d =new Document("_id",addserviceID.getText());
                d.append("price",addPrice.getText());
                d.append("serviceName", textField1.getText());

                List<Object> employees = new ArrayList<>();

                if(comboBox1.getSelectedItem() != "-"){
                    employees.add(comboBox1.getSelectedItem());
                }
                if(comboBox2.getSelectedItem() != "-"){
                    employees.add(comboBox2.getSelectedItem());
                }
                if(comboBox3.getSelectedItem() != "-"){
                    employees.add(comboBox2.getSelectedItem());
                }

                if(comboBox4.getSelectedItem() != "-"){
                    employees.add(comboBox2.getSelectedItem());
                }

                if(comboBox5.getSelectedItem() != "-"){
                    employees.add(comboBox2.getSelectedItem());
                }

                if(comboBox6.getSelectedItem() != "-"){
                    employees.add(comboBox2.getSelectedItem());
                }
                d.append("employees", employees);

                additional.insertOne(d);
            }
        });

    }


}
