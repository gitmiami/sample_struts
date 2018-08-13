package sec2;

import java.util.*;

public class linkedHashMap1 {

	public static void main(String[] args) {

		Map map = new LinkedHashMap();

		map.put(null, new Integer(0));
		map.put("one", new Integer(1));
		map.put("two", new Integer(2));
		map.put("three", new Integer(3));
		map.put("winner", null);

		// 再登録
		map.put("three", new Integer(30));
		map.put("two", new Integer(20));
		map.put("one", new Integer(10));

		Set entries = map.entrySet();
		
		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println(entry.getKey() + " は" + entry.getValue());
		}

	}
}
