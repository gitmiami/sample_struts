package sec2;

import java.util.*;

public class linkedHashMap2 {

	public static void main(String[] args) {

		Map map = new HashMap();

		map.put("日本酒", "久保田");
		map.put("ジン", "ケンジントン");
		map.put("バーボン", "ブッカーズ");
		map.put("スコッチ", "フェイマスグラウス");

		Set entries = map.entrySet();
		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println(entry.getKey() + " は" + entry.getValue());
		}

	}
}
