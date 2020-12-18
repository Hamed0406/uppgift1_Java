package uppgift5.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import uppgift5.models.TransactionModel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/16/2020
 */
public class AccountViewController implements Initializable {
    public Path path = Path.of("src/uppgift5/Resources/TempUser.txt");
    public     String xmlFilePath =("src\\uppgift5\\Resources\\");//To load from
    public String logonUser;
    public ObservableList<TransactionModel> list = FXCollections.observableArrayList();
    String balance="0";
    @FXML
    private Label lbLogonUser;
    @FXML
    private Button btnExt;
    @FXML
    private Button btnLodUs;
    @FXML
    private TableView<TransactionModel> tableView;
    @FXML
    private TableColumn<TransactionModel, String> transactionColumn;
    @FXML
    private TableColumn<TransactionModel, String> dateColumn;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLoadUser;
    @FXML
    private Button btnLoadTransaction;
    @FXML
    private Button btnDeposit;
    @FXML
    private Button btnWithrow;
    @FXML
    private TextField txDeposit;
    @FXML
    private TextField txWithrow;
    @FXML
            private Label lbBalance;

BankAccountController bankAccountController=new BankAccountController();
    public void loadUser() throws IOException, SAXException, ParserConfigurationException {
        File file = new File(String.valueOf(path));
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            logonUser = data;
            //TODO load userdata from XML and add to table.
loaderXML(logonUser);
balanceCalculator();
         //   System.out.println(data);


        }

        reader.close();

        //   System.out.println(logonUser);

        lbLogonUser.setText(logonUser);

    }

    private void loaderXML(String logonUserXML) throws ParserConfigurationException, IOException, SAXException {

        list.clear();
        String transactionT = null;
        String dateT = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document xmlDOc = documentBuilder.parse(xmlFilePath+logonUserXML+".xml");
        NodeList transactionList = xmlDOc.getElementsByTagName("transaction");


        for (int i = 0; i < transactionList.getLength(); i++) {
            Node p = transactionList.item(i);
            if (p.getNodeType() == Node.ELEMENT_NODE) {
                Element transaction = (Element) p;
                String ID = transaction.getAttribute("ID");
                NodeList typeList = transaction.getChildNodes();
                transactionT = transaction.getElementsByTagName("transactionType").item(0).getTextContent();
                dateT = transaction.getElementsByTagName("date").item(0).getTextContent();
                TransactionModel tempP = new TransactionModel(transactionT, dateT);
                list.add(tempP);

            }


        }





    }


    public void deposit(ActionEvent event) throws TransformerException, ParserConfigurationException {
        String tempDeposit=txDeposit.getText();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStamp = now.format(formatter);
        list.add(new TransactionModel(tempDeposit,timeStamp));
        //TODO update balance
        txDeposit.clear();
        bankAccountController.registerTransaction(list,logonUser);
        balanceCalculator();


    }


    public void withrow(ActionEvent event) throws TransformerException, ParserConfigurationException {
        String tempWithrow=("-"+txWithrow.getText());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStamp = now.format(formatter);
        int tempBalance=Integer.parseInt(balance);
        //if(!(tempBalance<=0)) {   //check balance
            list.add(new TransactionModel(tempWithrow, timeStamp));
            //TODO update balance
     //   }
        txDeposit.clear();
        bankAccountController.registerTransaction(list,logonUser);
        balanceCalculator();


    }


    public void balanceCalculator()
    {
        //TODO balance calculator
      int size=  list.size();
      int amount=Integer.parseInt(balance);
      amount=0;
      for(int i=0;i<size;i++)
      {
          amount=amount+Integer.parseInt(list.get(i).getTransaction()) ;
      }
      balance= String.valueOf(amount);
      lbBalance.setText(balance);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionColumn.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableView.setItems(list);
        try {
            loadUser();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


    }
}
