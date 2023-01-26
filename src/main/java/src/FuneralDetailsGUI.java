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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

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
    private JLabel transportID;
    private JLabel deceasedInfo;
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
    private JComboBox pracownicy5;
    private JComboBox pracownicy6;
    private JComboBox organista;

    String uri = "mongodb+srv://LessName:Kingusia319@cluster.epf7xb0.mongodb.net/?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase("FuneralCompany");
    MongoCollection funeralDetails = database.getCollection("funeralDetails");
    MongoCollection<Document> additional = database.getCollection("additionalServices");
            public FuneralDetailsGUI()  throws HeadlessException {
                this.setContentPane(panel1);
                this.pack();
                this.setLocationRelativeTo(null);
                zapiszDoListy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                            List<Document> addi = additional.find().into(new ArrayList<>());

                            Document fd =new Document("_id",pogrzebID.getText());
                            fd.append("funeralDate", pogrzebData.getText());
                            Document deceasedInfo = new Document();
                            deceasedInfo.append("deceasedID", dodajIDzmarlego.getText());
                            deceasedInfo.append("nameAndSurname", dodajImieNazwisko.getText());
                            deceasedInfo.append("pesel", dodajPesel.getText());
                            fd.append("deceasedInfo", deceasedInfo);

                            Document aservices1 = new Document();

                            List<Object> aservices2 = new ArrayList<>();
                            Document pallbearers = new Document();

                            Document object1 = new Document();
                            Document object2 = new Document();
                            Document object3 = new Document();
                            Document object4 = new Document();
                            Document object5 = new Document();
                            Document object6 = new Document();
                            Document object7 = new Document();

                            if(service1.getSelectedItem() != "-" &&
                                    service1.getSelectedItem() != "pallbearers1" &&
                                    service1.getSelectedItem() != "pallbearers2" &&
                                    service1.getSelectedItem() != "pallbearers3" &&
                                    service1.getSelectedItem() != "pallbearers4" &&
                                    service1.getSelectedItem() != "pallbearers5" &&
                                    service1.getSelectedItem() != "pallbearers6"){
                                object1.append("_id", service1.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service1.getSelectedItem())){
                                        object1.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object1.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object1);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service2.getSelectedItem() != "-" &&
                                    service2.getSelectedItem() != "pallbearers1" &&
                                    service2.getSelectedItem() != "pallbearers2" &&
                                    service2.getSelectedItem() != "pallbearers3" &&
                                    service2.getSelectedItem() != "pallbearers4" &&
                                    service2.getSelectedItem() != "pallbearers5" &&
                                    service2.getSelectedItem() != "pallbearers6"){
                                object2.append("_id", service2.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service2.getSelectedItem())){
                                        object2.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object2.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object2);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service3.getSelectedItem() != "-" &&
                                    service3.getSelectedItem() != "pallbearers1" &&
                                    service3.getSelectedItem() != "pallbearers2" &&
                                    service3.getSelectedItem() != "pallbearers3" &&
                                    service3.getSelectedItem() != "pallbearers4" &&
                                    service3.getSelectedItem() != "pallbearers5" &&
                                    service3.getSelectedItem() != "pallbearers6"){
                                object3.append("_id", service3.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service3.getSelectedItem())){
                                        object3.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object3.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object3);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service4.getSelectedItem() != "-" &&
                                    service4.getSelectedItem() != "pallbearers1" &&
                                    service4.getSelectedItem() != "pallbearers2" &&
                                    service4.getSelectedItem() != "pallbearers3" &&
                                    service4.getSelectedItem() != "pallbearers4" &&
                                    service4.getSelectedItem() != "pallbearers5" &&
                                    service4.getSelectedItem() != "pallbearers6"){
                                object4.append("_id", service4.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service4.getSelectedItem())){
                                        object4.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object4.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object4);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service5.getSelectedItem() != "-" &&
                                    service5.getSelectedItem() != "pallbearers1" &&
                                    service5.getSelectedItem() != "pallbearers2" &&
                                    service5.getSelectedItem() != "pallbearers3" &&
                                    service5.getSelectedItem() != "pallbearers4" &&
                                    service5.getSelectedItem() != "pallbearers5" &&
                                    service5.getSelectedItem() != "pallbearers6"){
                                object5.append("_id", service5.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service5.getSelectedItem())){
                                        object5.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object5.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object5);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service6.getSelectedItem() != "-" &&
                                    service6.getSelectedItem() != "pallbearers1" &&
                                    service6.getSelectedItem() != "pallbearers2" &&
                                    service6.getSelectedItem() != "pallbearers3" &&
                                    service6.getSelectedItem() != "pallbearers4" &&
                                    service6.getSelectedItem() != "pallbearers5" &&
                                    service6.getSelectedItem() != "pallbearers6"){
                                object6.append("_id", service6.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service6.getSelectedItem())){
                                        object6.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object6.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object6);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service7.getSelectedItem() != "-" &&
                                    service7.getSelectedItem() != "pallbearers1" &&
                                    service7.getSelectedItem() != "pallbearers2" &&
                                    service7.getSelectedItem() != "pallbearers3" &&
                                    service7.getSelectedItem() != "pallbearers4" &&
                                    service7.getSelectedItem() != "pallbearers5" &&
                                    service7.getSelectedItem() != "pallbearers6"){
                                object7.append("_id", service7.getSelectedItem());

                                for(int empl = 0; empl< addi.size(); empl++){
                                    if(addi.get(empl).getString("_id").equals(service7.getSelectedItem())){
                                        object7.append("serviceName", addi.get(empl).getString("serviceName"));
                                        object7.append("price", addi.get(empl).getString("price"));

                                    }
                                }

                                aservices2.add(object7);
                                aservices1.append("aservices", aservices2);
                                fd.append("aservices", aservices1);

                            }

                            if(service1.getSelectedItem().equals("pallbearers1") ||
                                    service2.getSelectedItem().equals("pallbearers1") ||
                                    service3.getSelectedItem().equals("pallbearers1") ||
                                    service4.getSelectedItem().equals("pallbearers1") ||
                                    service5.getSelectedItem().equals("pallbearers1") ||
                                    service6.getSelectedItem().equals("pallbearers1") ||
                                    service7.getSelectedItem().equals("pallbearers1")){

                                pallbearers.append("_id", "pallbearers1");
                                pallbearers.append("serviceName", "trunnonosze");
                                pallbearers.append("price", "100");
                                List<Object> employ = new ArrayList<>();
                                employ.add(pracownicy1.getSelectedItem());
                                pallbearers.append("employees", employ);
                                aservices1.append("pallbearers", pallbearers);
                                fd.append("aservices", aservices1);
                            }
                            if(service1.getSelectedItem().equals("pallbearers2") ||
                                    service2.getSelectedItem().equals("pallbearers2") ||
                                    service3.getSelectedItem().equals("pallbearers2") ||
                                    service4.getSelectedItem().equals("pallbearers2") ||
                                    service5.getSelectedItem().equals("pallbearers2") ||
                                    service6.getSelectedItem().equals("pallbearers2") ||
                                    service7.getSelectedItem().equals("pallbearers2")){

                                pallbearers.append("_id", "pallbearers2");
                                pallbearers.append("serviceName", "trunnonosze");
                                pallbearers.append("price", "200");
                                List<Object> employ = new ArrayList<>();
                                employ.add(pracownicy1.getSelectedItem());
                                employ.add(pracownicy2.getSelectedItem());
                                pallbearers.append("employees", employ);
                                aservices1.append("pallbearers", pallbearers);
                                fd.append("aservices", aservices1);
                            }
                            if(service1.getSelectedItem().equals("pallbearers3") ||
                                    service2.getSelectedItem().equals("pallbearers3") ||
                                    service3.getSelectedItem().equals("pallbearers3") ||
                                    service4.getSelectedItem().equals("pallbearers3") ||
                                    service5.getSelectedItem().equals("pallbearers3") ||
                                    service6.getSelectedItem().equals("pallbearers3") ||
                                    service7.getSelectedItem().equals("pallbearers3")){

                                pallbearers.append("_id", "pallbearers3");
                                pallbearers.append("serviceName", "trunnonosze");
                                pallbearers.append("price", "300");
                                List<Object> employ = new ArrayList<>();
                                employ.add(pracownicy1.getSelectedItem());
                                employ.add(pracownicy2.getSelectedItem());
                                employ.add(pracownicy3.getSelectedItem());
                                pallbearers.append("employees", employ);
                                aservices1.append("pallbearers", pallbearers);
                                fd.append("aservices", aservices1);
                            }

                            if(service1.getSelectedItem().equals("pallbearers4") ||
                                    service2.getSelectedItem().equals("pallbearers4") ||
                                    service3.getSelectedItem().equals("pallbearers4") ||
                                    service4.getSelectedItem().equals("pallbearers4") ||
                                    service5.getSelectedItem().equals("pallbearers4") ||
                                    service6.getSelectedItem().equals("pallbearers4") ||
                                    service7.getSelectedItem().equals("pallbearers4")){

                                pallbearers.append("_id", "pallbearers4");
                                pallbearers.append("serviceName", "trunnonosze");
                                pallbearers.append("price", "400");
                                List<Object> employ = new ArrayList<>();
                                employ.add(pracownicy1.getSelectedItem());
                                employ.add(pracownicy2.getSelectedItem());
                                employ.add(pracownicy3.getSelectedItem());
                                employ.add(pracownicy4.getSelectedItem());
                                pallbearers.append("employees", employ);
                                aservices1.append("pallbearers", pallbearers);
                                fd.append("aservices", aservices1);
                            }

                            if(service1.getSelectedItem().equals("pallbearers5") ||
                                    service2.getSelectedItem().equals("pallbearers5") ||
                                    service3.getSelectedItem().equals("pallbearers5") ||
                                    service4.getSelectedItem().equals("pallbearers5") ||
                                    service5.getSelectedItem().equals("pallbearers5") ||
                                    service6.getSelectedItem().equals("pallbearers5") ||
                                    service7.getSelectedItem().equals("pallbearers5")){

                                pallbearers.append("_id", "pallbearers5");
                                pallbearers.append("serviceName", "trunnonosze");
                                pallbearers.append("price", "500");
                                List<Object> employ = new ArrayList<>();
                                employ.add(pracownicy1.getSelectedItem());
                                employ.add(pracownicy2.getSelectedItem());
                                employ.add(pracownicy3.getSelectedItem());
                                employ.add(pracownicy4.getSelectedItem());
                                employ.add(pracownicy5.getSelectedItem());
                                pallbearers.append("employees", employ);
                                aservices1.append("pallbearers", pallbearers);
                                fd.append("aservices", aservices1);
                            }

                            if(service1.getSelectedItem().equals("pallbearers6") ||
                                    service2.getSelectedItem().equals("pallbearers6") ||
                                    service3.getSelectedItem().equals("pallbearers6") ||
                                    service4.getSelectedItem().equals("pallbearers6") ||
                                    service5.getSelectedItem().equals("pallbearers6") ||
                                    service6.getSelectedItem().equals("pallbearers6") ||
                                    service7.getSelectedItem().equals("pallbearers6")){

                                pallbearers.append("_id", "pallbearers6");
                                pallbearers.append("serviceName", "trunnonosze");
                                pallbearers.append("price", "600");
                                List<Object> employ = new ArrayList<>();
                                employ.add(pracownicy1.getSelectedItem());
                                employ.add(pracownicy2.getSelectedItem());
                                employ.add(pracownicy3.getSelectedItem());
                                employ.add(pracownicy4.getSelectedItem());
                                employ.add(pracownicy5.getSelectedItem());
                                employ.add(pracownicy6.getSelectedItem());
                                pallbearers.append("employees", employ);
                                aservices1.append("pallbearers", pallbearers);
                                fd.append("aservices", aservices1);
                            }


                            fd.append("transportID", IDtransportu.getText());
                            fd.append("aservices", aservices1);
                            Document PlaceOfBurial = new Document();
                            PlaceOfBurial.append("graveyardName", dodajNazweCmentarza.getText());
                            PlaceOfBurial.append("town",dodajNazweMiasta.getText());
                            PlaceOfBurial.append("alley", dodajAlejke.getText());
                            PlaceOfBurial.append("sector", dodajSektor.getText());
                            PlaceOfBurial.append("nr", dodajNumerMiejsca.getText());
                            PlaceOfBurial.append("communal", czyKomunalny.getSelectedItem());
                            fd.append("placeOfBurial", PlaceOfBurial);

                            Document price = new Document();
                            price.append("startPrice", "2000");
                            price.append("aservPrice", dodatkowaCena.getText());
                            price.append("summPrice",cenaKoncowa.getText());
                            fd.append("price", price);

                            funeralDetails.insertOne(fd);
                            JOptionPane.showMessageDialog(null, "Dodano szczegóły pogrzebu do listy.");
                        }
            });
        }
}

