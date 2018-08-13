import java.io.*;
import java.util.*;

class StringTokenizerTest {
	public static void main(String args[]) throws Exception {
		FileReader filereader = new FileReader("book1.csv");
		BufferedReader bufferedreader = new BufferedReader(filereader);

		String line;
		int i = 1;
		int j = 0;
		while ((line = bufferedreader.readLine()) != null) {
			System.out.println("Start line at " + i);
			StringTokenizer stringTokenizerTest = new StringTokenizer(line, ",");
			while (stringTokenizerTest.hasMoreTokens()) {
				System.out.println(stringTokenizerTest.nextToken().toString()
						+ " at " + j + " of " + i);
				j++;
			}
			i++;
		}

		filereader.close();
	}
}