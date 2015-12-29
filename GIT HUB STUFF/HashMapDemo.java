import java.util.*;

class HashMapDemo{
	
	public static void main(String arg[]){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Shashank");
		map.put("2", "Ram");
		map.put("3", "Prakhar");
	
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}
}

   
   



