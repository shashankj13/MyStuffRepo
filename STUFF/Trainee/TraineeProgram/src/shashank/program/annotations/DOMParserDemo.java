package shashank.program.annotations;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.Scanner;

public class DOMParserDemo {

  private static Scanner k;

public static void main(String argv[]) {

    try {

	File fXmlFile = new File("NewFile.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("mobile");
			
	System.out.println("----------------------------");
	System.out.println("Enter Brand to Search");
	
	k = new Scanner(System.in);
	String k1 = k.next();
	int count = 1;
	for (int temp = 0; temp < nList.getLength(); temp++) {

		
		Node nNode = nList.item(temp);
		Element eElement = (Element) nNode;
				
		
			 if(k1.equals(eElement.getElementsByTagName("brand").item(0).getTextContent())){
				 System.out.println("\nCurrent Element :" + nNode.getNodeName());
				 System.out.println("Id : " + eElement.getAttribute("id"));
					System.out.println("Color : " + eElement.getElementsByTagName("color").item(0).getTextContent());
					System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
					System.out.println("Brand : " + eElement.getElementsByTagName("brand").item(0).getTextContent());
					count=0;
			 }
			 
		
	}
	if(count==1){
		System.out.println("NOT FOUND");
	}
	
	
	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}
