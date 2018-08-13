import java.util.*;

public class MapExample {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("first name", "‘¾˜Y");
		map.put("last name", "R“c");
		map.put("address", "ˆïéŒ§‚Â‚­‚Îs 999-99-99");
		map.put("tel", "029-000-0000");

		System.out.println(map.entrySet());

		System.out.println(map.values());

		System.out.println(map.keySet());

		System.out.println(map.get("first name"));
		System.out.println(map.get("last name"));
		System.out.println(map.get("address"));
		System.out.println(map.get("tel"));
		System.out.println(map.get("e-mail"));
	}
}
