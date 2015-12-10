
import java.util.*;

public class HashMapDemo{
	public static void main(String[] args){
		Map<String, String> map = new HashMap<String, String>();	

		String key1 = "Robin Li";
		String key2 = "Yanlin Chen";

		map.put(key1, "BaiDu CEO");
		map.put(key2, "Elex CEO");

		System.out.println(map.get(key1));
		System.out.println(map.get(key2));
	}	
}
