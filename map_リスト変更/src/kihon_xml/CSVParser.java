package kihon_xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CSVParser {

	private FileReader reader;

	public CSVParser(String fileName) throws FileNotFoundException
	{
		reader = new FileReader(fileName);
	}

	public void startDocument(){};
	public void startRecord(int n){};
	public void value(String chars, int n){};
	public void endRecord(int n){};
	public void endDocument(){};


	public void parse() throws IOException{

		int c;

		StringBuffer buf = new StringBuffer();

		boolean endOfRecordFLG = true;

		int fiieldNumber = 0;    // クリアされる
		int recordNumber = 0;    //クリアされない　加算される

		//#######################
		startDocument();

		while((c  = reader.read()) != -1){

			char ch  = (char)c;
			switch(ch){

			case ',':

				//#######################
				value(buf.toString(),++fiieldNumber);

				buf.delete(0,buf.length());
				break;

			case'\n':
				if(!endOfRecordFLG){

					//tureにする
					endOfRecordFLG=true;

					//#######################
					value(buf.toString(),++fiieldNumber);

					buf.delete(0,buf.length());

					fiieldNumber = 0;

					//#######################
					endRecord(recordNumber);

				}

				break;

			default:
				if(endOfRecordFLG){
					//#######################
					startRecord(++recordNumber);
				}
				//falseにする
				endOfRecordFLG=false;

				buf.append(ch);

			}


		}

	}



}




