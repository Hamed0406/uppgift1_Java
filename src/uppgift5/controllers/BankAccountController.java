package uppgift5.controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import uppgift5.models.TransactionModel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/17/2020
 */
public class BankAccountController {
    public     String xmlFilePath =("src\\uppgift5\\Resources\\");//To load from

    public void registerTransaction(List<TransactionModel> list,String bankAccount) throws ParserConfigurationException, TransformerException {


        // creat DocumentBuilder
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = documentBuilder.newDocument();
        //Build XML Element and text nodes
        Element rootElement = xmlDoc.createElement("transactions");
        Element mainElement = xmlDoc.createElement("transaction");
        for (int i = 0; i < list.size(); i++) {
            rootElement.appendChild(setTransaction(i, list.get(i).getTransaction(), list.get(i).getDate(), xmlDoc));//Append new transaction
        }
        xmlDoc.appendChild(rootElement);

        //Set output format
        //Declare the  file
        //Declare the fileOutPutStream
        //Creat XMLSerializer the XMl data with
        //The specified output format
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlDoc);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath+bankAccount+".xml"));
        transformer.transform(domSource, streamResult);

        // System.out.println("Done creating XML File");


    }

    private Element setTransaction(int id, String transaction, String date,  Document xmlDoc) {

        Element newTransaction = xmlDoc.createElement("transaction");
        newTransaction.setAttribute("ID", String.valueOf(id));

        Text transactionNameText = xmlDoc.createTextNode(transaction);
        Element transactionNameElement = xmlDoc.createElement("transactionType");
        transactionNameElement.appendChild(transactionNameText);

        Text dateText = xmlDoc.createTextNode(date);
        Element dateElement = xmlDoc.createElement("date");
        dateElement.appendChild(dateText);

        newTransaction.appendChild(transactionNameElement);
        newTransaction.appendChild(dateElement);

        return newTransaction;
    }

    public void openAccount(String userNameID) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = documentBuilder.newDocument();
        //Build XML Element and text nodes
        Element rootElement = xmlDoc.createElement("transactions");
        Element mainElement = xmlDoc.createElement("transaction");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStamp = now.format(formatter);
        rootElement.appendChild(setTransaction(0, "0", timeStamp, xmlDoc));
        xmlDoc.appendChild(rootElement);

        //Set output format
        //Declare the  file
        //Declare the fileOutPutStream
        //Creat XMLSerializer the XMl data with
        //The specified output format
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlDoc);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath+userNameID+".xml"));
        transformer.transform(domSource, streamResult);

    }
}


