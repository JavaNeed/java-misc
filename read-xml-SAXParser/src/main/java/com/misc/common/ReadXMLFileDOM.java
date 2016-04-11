package com.misc.common;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFileDOM {

	private static NodeList getNodeList(){
		NodeList listOfPersons = null;

		try {
			File file = new File(ReadXMLFileDOM.class.getClassLoader().getResource("book.xml").getFile());

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			doc.getDocumentElement().normalize();
			listOfPersons = doc.getElementsByTagName("person");
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}

		return listOfPersons;
	}

	public static void main (String argv []){
		NodeList listOfPersons = getNodeList();
		int totalPersons = listOfPersons.getLength();
		System.out.println("Total no of people : [" + totalPersons+"]");

		for(int s = 0; s < listOfPersons.getLength(); s++){

			Node firstPersonNode = listOfPersons.item(s);
			if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){

				Element firstPersonElement = (Element)firstPersonNode;

				System.out.println("------------------------------------------------");
				// First Name
				NodeList firstNameList = firstPersonElement.getElementsByTagName("first");
				Element firstNameElement = (Element)firstNameList.item(0);

				NodeList textFNList = firstNameElement.getChildNodes();
				System.out.println("First Name : " + ((Node)textFNList.item(0)).getNodeValue().trim());

				// Last Name
				NodeList lastNameList = firstPersonElement.getElementsByTagName("last");
				Element lastNameElement = (Element)lastNameList.item(0);
				
				NodeList textLNList = lastNameElement.getChildNodes();
				System.out.println("Last Name : " + ((Node)textLNList.item(0)).getNodeValue().trim());

				// Age
				NodeList ageList = firstPersonElement.getElementsByTagName("age");
				Element ageElement = (Element)ageList.item(0);

				NodeList textAgeList = ageElement.getChildNodes();
				System.out.println("Age : " + ((Node)textAgeList.item(0)).getNodeValue().trim());
			}
		}
	}
}
