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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.*;

public class FuneralDetailsGUI extends JFrame {
    private JPanel panel1;
    private JTextField pogrzebID;
    private JTextField pogrzebData;
    private JTextField dodajIDzmarlego;
    private JTextField dodajImieNazwisko;
    private JTextField dodajPesel;
    private JTextField IDtransportu;
    private JComboBox service1;
    private JComboBox service2;
    private JComboBox service3;
    private JComboBox service4;
    private JComboBox service5;
    private JComboBox service6;
    private JComboBox service7;
    private JLabel serviceList;
    private JTextField funeralID;
    private JTextField funeralDate;
    private JLabel transportID;
    private JTextField deceasedID;
    private JLabel deceasedInfo;
    private JTextField nameAndSurname;
    private JTextField pesel;
    private JTextField dodajNazweCmentarza;
    private JTextField dodajNazweMiasta;
    private JTextField dodajAlejke;
    private JTextField dodajSektor;
    private JTextField dodajNumerMiejsca;
    private JComboBox czyKomunalny;
    private JButton zapiszDoListy;
    private JTextField dodatkowaCena;
    private JTextField cenaKoncowa;
    private JLabel plecaOfBurial;
    private JLabel graveyardName;
    private JLabel town;
    private JLabel alley;
    private JLabel sector;
    private JLabel number;
    private JLabel communal;
    private JLabel summaryPrice;
    private JLabel startPrice;
    private JLabel startPrice1;
    private JComboBox pracownicy1;
    private JComboBox pracownicy2;
    private JComboBox pracownicy3;
    private JComboBox pracownicy4;
    private JComboBox pracownic5;
    private JComboBox pracownicy6;
    private JComboBox organista;

    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
    MongoCollection funeralDetails = database.getCollection("funeralDetails");
            public FuneralDetailsGUI()  throws HeadlessException {
                this.setContentPane(panel1);
                this.pack();
                this.setLocationRelativeTo(null);
                zapiszDoListy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                Document fd =new Document("_id",pogrzebID.getText());
                fd.append("funeralDate", pogrzebData.getText());
                fd.append("deceasedID", dodajIDzmarlego.getText());
                fd.append("nameAndSurname", dodajImieNazwisko.getText());
                fd.append("pesel", dodajPesel.getText());
                List<List> aservices = new ArrayList<>();
                List<Object> services = new ArrayList<>();
                if(service1.getSelectedItem() != "-"){
                    services.add(service1.getSelectedItem());
                }
                if(service2.getSelectedItem() != "-"){
                    services.add(service2.getSelectedItem());
                }
                if(service3.getSelectedItem() != "-"){
                    services.add(service3.getSelectedItem());
                }
                if(service4.getSelectedItem() != "-"){
                    services.add(service4.getSelectedItem());
                }
                if(service5.getSelectedItem() != "-"){
                    services.add(service5.getSelectedItem());
                }
                if(service6.getSelectedItem() != "-"){
                    services.add(service6.getSelectedItem());
                }
                        List<Object> pallbearers = new ArrayList<>();
                        if(pracownicy1.getSelectedItem() != "-"){
                            pallbearers.add(service1.getSelectedItem());
                        }
                        if(pracownicy2.getSelectedItem() != "-"){
                            pallbearers.add(service2.getSelectedItem());
                        }
                        if(pracownicy3.getSelectedItem() != "-"){
                            pallbearers.add(service3.getSelectedItem());
                        }
                        if(pracownicy4.getSelectedItem() != "-"){
                            pallbearers.add(service4.getSelectedItem());
                        }
                        if(pracownic5.getSelectedItem() != "-"){
                            pallbearers.add(service5.getSelectedItem());
                        }
                        if(pracownicy6.getSelectedItem() != "-"){
                            pallbearers.add(service6.getSelectedItem());
                        }
                fd.append("aservices", aservices);


                fd.append("transportID", IDtransportu.getText());
                fd.append("graveyardName", dodajNazweCmentarza.getText());
                fd.append("town",dodajNazweMiasta.getText());
                fd.append("alley", dodajAlejke.getText());
                fd.append("sector", dodajSektor.getText());
                fd.append("nr", dodajNumerMiejsca.getText());
                fd.append("communal", czyKomunalny.getSelectedItem());
                fd.append("aservPrice", dodatkowaCena.getText());
                fd.append("summPrice",cenaKoncowa.getText());
                funeralDetails.insertOne(fd);
                JOptionPane.showMessageDialog(null, "Dodano zmarłego.");
            }
            });
        }
}

