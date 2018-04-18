package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Converter {
	
	private static MyFileReader fileReader;
	
	public static void main(String[] args) throws IOException{
		try{
			PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
			fileReader = new MyFileReader(args[0]);
			List<String> lines = fileReader.getLines();
			for(String line : lines) {
				String eng = Extractor.getEnglishSentence(line);
				String deu = Extractor.getGermanSentence(line);
				String finalString = eng + '\t' + deu;
				writer.println(finalString);
			}
			writer.close();
			System.out.println("u done");
		}
		catch(ArrayIndexOutOfBoundsException noArgsException){
			System.out.println("Provide path of file as argument!");
		}
	}
}