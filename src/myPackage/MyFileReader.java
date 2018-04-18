package myPackage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
	
	private String pathOfFile;
	private List<String> listOfString = new ArrayList<String>();
	
	public MyFileReader(String pathOfFile){
		this.pathOfFile = pathOfFile;
	}
	
	public List<String> getLines() throws IOException {
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(this.pathOfFile), "UTF-8"));
			String str;
			while((str = in.readLine()) != null){
			    listOfString.add(str);
			}
	        in.close();
		} catch (FileNotFoundException e) {
			System.out.println("You got a bad file mate");
			e.printStackTrace();
		}
		return listOfString;
	}
}