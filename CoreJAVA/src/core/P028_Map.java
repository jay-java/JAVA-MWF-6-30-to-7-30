package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P028_Map {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "java");//entry
		map.put(34.3, "python");
		map.put(false, true);
		map.put(122, 'g');
		map.put(null, null);
		System.out.println(map);
		
		Set set = map.entrySet();
		Iterator itr= set.iterator();
		while(itr.hasNext()) {
			Map.Entry entry = (Entry) itr.next();
			System.out.println("key : "+entry.getKey()+" value : "+entry.getValue());
			
		}
		
	}
}