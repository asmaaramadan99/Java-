package eg.edu.alexu.csd.datastructure.hangman.cs_29;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
		 public String[] ReadWords() {
	
	    
		  String[] words=new String[10];
		 
		
		try {
			 int count=0;
			
			BufferedReader scan=new BufferedReader(new FileReader("MyWords.TXT"));
			String data;
			
				while((data=scan.readLine() )!= null && count<words.length) {
					words[count]=data;
					count++;}	
				
		}
		
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return words;
		
		 }
		
		
	}



	

		


