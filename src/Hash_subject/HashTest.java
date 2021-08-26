package Hash_subject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTest {
	 public static void main(String[] args){
		  File file = new File("C:\\Users\\jmini\\Desktop\\CARRIERS.txt");
		 
			String[] splitedStr = null;
			int lineCnt = 0;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					lineCnt++;}

				reader.close();

				
			} catch (FileNotFoundException fnf) {

				fnf.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}
			Carriers[] hits = new Carriers[lineCnt];
try {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));

	String line = null;

	splitedStr = null;
int j=0;


	while ((line = reader.readLine()) != null) {


		splitedStr = null;

		splitedStr = line.split("\t");
		lineCnt++;


		for (int i = 0; i < splitedStr.length; i++) {

			splitedStr[i] = splitedStr[i].trim();
			

		}
	
		hits[j] = new Carriers(splitedStr[0],Integer.valueOf(splitedStr[1]));
		j++;
	}

	reader.close();

} catch (FileNotFoundException fnf) {

	fnf.printStackTrace();

} catch (IOException e) {

	e.printStackTrace();

}
}
}
