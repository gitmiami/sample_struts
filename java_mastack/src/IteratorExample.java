import java.util.*;

public class IteratorExample {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");

		Iterator<String> it = set.iterator();

		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}

	}
}
