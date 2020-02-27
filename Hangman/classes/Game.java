package eg.edu.alexu.csd.datastructure.hangman.cs_29;

import java.util.Arrays;
import java.util.Random;

class Game implements IHangman {
	String[] MyDictionary =new String[10];
	String SecretWord;
	int WrongGuess;
	int trials=0;
	String Word;
	
    @Override
	public void setDictionary(String[]words) {
		// TODO Auto-generated method stub
    	
		MyDictionary=words;
		
	}

	@Override
	public String selectRandomSecretWord() {
		Random number=new Random();
		int num=number.nextInt(9);
		SecretWord=MyDictionary[num];
		Word=SecretWord.replaceAll(".","-");
		
		return SecretWord;
	}

	@Override
	public String guess(Character c) throws Exception {
		
		char[]array=Word.toCharArray();
		int flag=0;
		
	
		for(int i=0;i<SecretWord.length();i++)
		{
			if(SecretWord.charAt(i)==c)
			{
				array[i]=c;
				Word=String.copyValueOf(array);
				flag=1;
			}
		}
		
		if(flag==0 & c!=null)
		{   trials++;
			
		}
		if(WrongGuess==trials)
		{ 
			System.out.println("you lost");
			throw new IllegalArgumentException();
			
		}
	
		
		
		
		return Word;
	}

	@Override
	public void setMaxWrongGuesses(Integer Max) {
		if(Max==null)
		{
			WrongGuess=1;
		}
		else
			WrongGuess=Max;
			
		
		
		
		
	}

}
