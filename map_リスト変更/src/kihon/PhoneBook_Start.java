package kihon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook_Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PhoneBook pb = new PhoneBook();
		pb.add("scott","01-1111-4444");
		pb.add("bill","02-1111-4444");
		pb.add("james","03-1111-4444");

		for(String num : pb.get("scott")){
			System.out.println("    " + num);
		}

	}


}
