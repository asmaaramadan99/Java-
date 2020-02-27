package eg.edu.alexu.csd.datastructure.hangman.cs_29;

import java.util.Scanner;

public class test {
	public static void main(String[] args) throws Exception
	{
		ReadFile obj=new ReadFile();
		String[] a=obj.ReadWords();
		
		Game obj1=new Game();
		obj1.setDictionary(a);
		String s=obj1.selectRandomSecretWord();
		System.out.println(s);
		obj1.setMaxWrongGuesses(5);
		int max=obj1.WrongGuess;
		
		while(max>0)
		{
		
			Scanner scan=new Scanner(System.in);
			String x=scan.nextLine();
			char c=x.charAt(0);
			String Str=obj1.guess(c);
			System.out.print(Str);
			
		
		
	}
	}

}
