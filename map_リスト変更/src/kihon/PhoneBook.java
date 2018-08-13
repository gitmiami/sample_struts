package kihon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

	Map<String, Set<String>> book = new HashMap<String, Set<String>>();

	public void add(String name, String phoneNumber)
	{

		if( name == null || phoneNumber == null){
			throw new NullPointerException();
		}

		if( phoneNumber.matches("^[0-9#]+$")){
			throw new IllegalArgumentException();
		}

		Set<String> numbers = book.get(name);

		if(numbers == null){
			numbers = new HashSet<String>();
		}

		numbers.add(phoneNumber);
		book.put(name,  numbers);


	}

	public Set<String> get(String name)
	{
		Set<String> numbers = book.get(name);
		Set<String> set = new HashSet<String>();

		if(numbers !=null){
			set.addAll(numbers);
		}

		return set;

	}

}
