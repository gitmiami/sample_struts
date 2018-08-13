package kihon_xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TaggedDataGenerator extends CSVParser{

	public TaggedDataGenerator(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}


	public void startDocument(){
		System.out.println("<addressbook>");
	}
	public void endDocument(){
		System.out.println("</addressbook>");
	}

	public void startRecord(int n){
		System.out.println("\t<person id=\""+n+"\" >");
	}

//	public void value(String chars, int n){
//		String tag = (n == 1) ? "name" : (n==2) ? "email" : "phone";
//		System.out.println("\t\t<" +tag+ ">" + chars + "</" + tag + ">");
//	}

	public void value(String chars, int n){
		String tag;

		if(n == 1){
			tag = "name" ;
		}else if(n==2){
			tag = "email" ;
		}else{
			tag = "phone" ;
		}
		System.out.println("\t\t<" +tag+ ">" + chars + "</" + tag + ">");

	}


	public void endRecord(int ‚Ž){
		System.out.println("\t</person>");
	}

	public static void main(String[] args) {

		TaggedDataGenerator parser = null;

		try{
			parser = new TaggedDataGenerator("test2.csv");
			parser.parse();

		}catch (Exception e){
			e.printStackTrace();

		}
	}

}
