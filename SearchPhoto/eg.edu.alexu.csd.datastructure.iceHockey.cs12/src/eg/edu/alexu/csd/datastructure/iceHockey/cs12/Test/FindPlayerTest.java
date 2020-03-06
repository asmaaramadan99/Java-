package eg.edu.alexu.csd.datastructure.iceHockey.cs12;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;



class FindPlayerTest {
	ArrayList<Point> input=new ArrayList<Point>();
	
	
	FindPlayer Game=new FindPlayer();
	@Test
	void testFindPlayers() {
		ArrayList<Point> input=new ArrayList<Point>();
		String[] Photo= {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3","VNDSD333", "OINFD33X"};
		
		Point a =new Point(4,5);
		Point b= new Point(13,9);
		Point c= new Point(14,2);
		input.add(a);
		input.add(b);
		input.add(c);
		Point [] expected=new Point[input.size()];
		for(int k=0;k<input.size();k++)
		{
			expected[k]=input.get(k);
		}

        Point [] output=Game.findPlayers(Photo,3, 16);
        
        for(int i=0;i<output.length;i++)
        {
        	assertEquals(expected[i].x,output[i].x);
        	assertEquals(expected[i].y,output[i].y);
   	
        }
	}
	@Test
	void testFindPlayers2() {
		
		String[] Photo=null;
		FindPlayer Game=new FindPlayer();
		 assertThrows(NullPointerException.class, ()->{Game.findPlayers(Photo,3,16);});
		
	}
	@Test
	void testFindPlayers3()
	{
		String[] Photo= {"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"};
		Point a =new Point(3,8);
		Point b= new Point(4,16);
		Point c= new Point(5,4);
		Point d=new Point(16,3);
		Point e=new Point(16,17);
		Point f=new Point(17,9);
		input.add(a);
		input.add(b);
		input.add(c);
		input.add(d);
		input.add(e);
		input.add(f);
		Point [] expected=new Point[input.size()];
		for(int k=0;k<input.size();k++)
		{
			expected[k]=input.get(k);
		}
		 Point[] output=Game.findPlayers(Photo, 4, 16);
		
		 for(int i=0;i<output.length;i++)
	        {
	        	assertEquals(expected[i].x,output[i].x);
	        	assertEquals(expected[i].y,output[i].y);
	   	
	        }

		
	}
	
        
        
        
        	 
        
        	   
        	
        		
        
		
		
		
		
	

}

