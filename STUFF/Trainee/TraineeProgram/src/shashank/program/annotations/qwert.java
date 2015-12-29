

k = new Scanner(System.in);
	String k1 = k.next();

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			if(k1.equals(eElement.getElementsByTagName("brand")) )
			{

			if(eElement.getElementsByTagName("brand").item(0).getTextContent()==k1)
			System.out.println("Id : " + eElement.getAttribute("id"));
			System.out.println("Color : " + eElement.getElementsByTagName("color").item(0).getTextContent());
			System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
			System.out.println("Brand : " + eElement.getElementsByTagName("brand").item(0).getTextContent());
			//}

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}
