
	import java.util.*;

	public class linkedhash1 {
	   public static void main(String[] args) {
	      Map map = new HashMap();

	      map.put("nihonsyu", "value1");
	      map.put("jin", "value2");
	      map.put("vabon", "value3");
	      map.put("skoch", "value4");

	      Set keys = map.keySet();
	      for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
	         String key = (String)iterator.next();
	         System.out.println(key + " は" + map.get(key));
	      }
	   }
	}