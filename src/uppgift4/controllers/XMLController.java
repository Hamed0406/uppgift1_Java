package uppgift4.controllers;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/7/2020
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import uppgift4.models.Person;

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

public class XMLController {

    public static final String xmlFilePath = "src\\uppgift4\\XMLDataBase.xml";

    public void writePersonToXMl(List<Person> list) throws ParserConfigurationException, TransformerException {



        // creat DocumentBuilder
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = documentBuilder.newDocument();
        //Build XML Element and text nodes
        Element rootElement = xmlDoc.createElement("persons");
        Element mainElement = xmlDoc.createElement("person");
        for (int i = 0; i < list.size(); i++) {
            rootElement.appendChild(setPerson(i, list.get(i).getFirstName(), list.get(i).getLastName(), list.get(i).getAge(), xmlDoc));//Append new person
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

    private Element setPerson(int id,String firstName, String lastName, String age, Document xmlDoc) {

        Element newPerson = xmlDoc.createElement("person");
        newPerson.setAttribute("ID",String.valueOf(id));

        Text firstNameText = xmlDoc.createTextNode(firstName);
        Element firstNameElement = xmlDoc.createElement("firstName");
        firstNameElement.appendChild(firstNameText);
        Text lastNameText = xmlDoc.createTextNode(lastName);
        Element lastNameElement = xmlDoc.createElement("lastName");
        lastNameElement.appendChild(lastNameText);
        Text ageText = xmlDoc.createTextNode(age);
        Element ageElement = xmlDoc.createElement("age");
        ageElement.appendChild(ageText);
        newPerson.appendChild(firstNameElement);
        newPerson.appendChild(lastNameElement);
        newPerson.appendChild(ageElement);
        return newPerson;
    }
}
