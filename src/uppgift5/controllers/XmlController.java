package uppgift5.controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import uppgift5.models.AuthenticationModel;
import uppgift5.models.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
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

    public Element setUser(int id, String firstName, String lastName, String userID, String password, String balance, Document xmlDoc) {

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

    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception {
        boolean matches = false;

        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();

        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            if (nodes != null && nodes.getLength() > 0) {
                matches = true;
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }

    public Boolean searchUser(AuthenticationModel authenticationModel) throws Exception {
        //Build DOM
        boolean validate = false;
        String matchedUser = null;
        String matchPassword = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFilePath);
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        //Create XPath


        if (checkIfNodeExists(doc, "//user[userID=contains(.,'" + authenticationModel.getUserID() + "')]/userID/text()")) {
            XPathExpression exprUserID = xpath.compile("//user[userID=contains(.,'" + authenticationModel.getUserID() + "')]/userID/text()");

            Object resultUserID = exprUserID.evaluate(doc, XPathConstants.NODESET);


            NodeList nodesUserID = (NodeList) resultUserID;
            for (int i = 0; i < nodesUserID.getLength(); i++) {
                System.out.println(nodesUserID.item(i).getNodeValue());
                matchedUser = nodesUserID.item(i).getNodeValue();
            }
        } else
            return validate = false;

        if (checkIfNodeExists(doc, "//user[password=contains(.,'" + authenticationModel.getPassword() + "')]/password/text()")) {
            XPathExpression exprPassword = xpath.compile("//user[password=contains(.,'" + authenticationModel.getPassword() + "')]/password/text()");
            Object resultPassword = exprPassword.evaluate(doc, XPathConstants.NODESET);

            NodeList nodesPassword = (NodeList) resultPassword;
            for (int i = 0; i < nodesPassword.getLength(); i++) {
                System.out.println(nodesPassword.item(i).getNodeValue());
                matchPassword = nodesPassword.item(i).getNodeValue();

            }
        } else
            return validate = false;


        if (matchedUser.equals(authenticationModel.getUserID()) && matchPassword.equals(authenticationModel.getPassword())) {

            validate = true;
        }


        return validate;

    }
}



