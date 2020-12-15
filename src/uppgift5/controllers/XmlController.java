package uppgift5.controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import uppgift5.models.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/14/2020
 */
public class XmlController {

    public static final String xmlFilePath = "src\\uppgift5\\XMLUserDataBase.xml";

    public void writeUserToXMl(List<User> list) throws ParserConfigurationException, TransformerException {


        // creat DocumentBuilder
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = documentBuilder.newDocument();
        //Build XML Element and text nodes
        Element rootElement = xmlDoc.createElement("users");
        Element mainElement = xmlDoc.createElement("user");
        for (int i = 0; i < list.size(); i++) {
            rootElement.appendChild(setUser(i, list.get(i).getFirstName(), list.get(i).getLastName(), list.get(i).getUserID(), list.get(i).getPassword(), list.get(i).getBalance(), xmlDoc));//Append new person
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
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
        transformer.transform(domSource, streamResult);

        // System.out.println("Done creating XML File");


    }

    private Element setUser(int id, String firstName, String lastName, String userID, String password, String balance, Document xmlDoc) {

        Element newUser = xmlDoc.createElement("user");
        newUser.setAttribute("ID", String.valueOf(id));

        Text firstNameText = xmlDoc.createTextNode(firstName);
        Element firstNameElement = xmlDoc.createElement("firstName");
        firstNameElement.appendChild(firstNameText);

        Text lastNameText = xmlDoc.createTextNode(lastName);
        Element lastNameElement = xmlDoc.createElement("lastName");
        lastNameElement.appendChild(lastNameText);


        Text userIDText = xmlDoc.createTextNode(userID);
        Element userIDElement = xmlDoc.createElement("userID");
        userIDElement.appendChild(userIDText);


        Text passwordText = xmlDoc.createTextNode(password);
        Element passwordElement = xmlDoc.createElement("password");
        passwordElement.appendChild(passwordText);


        Text balanceText = xmlDoc.createTextNode(balance);
        Element balanceElement = xmlDoc.createElement("balance");
        balanceElement.appendChild(balanceText);


        newUser.appendChild(firstNameElement);
        newUser.appendChild(lastNameElement);
        newUser.appendChild(userIDElement);
        newUser.appendChild(passwordElement);
        newUser.appendChild(balanceElement);
        return newUser;
    }
}



