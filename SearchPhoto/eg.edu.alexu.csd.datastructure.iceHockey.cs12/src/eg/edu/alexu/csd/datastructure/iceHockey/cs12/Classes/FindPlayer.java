package eg.edu.alexu.csd.datastructure.iceHockey.cs12;
 
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class FindPlayer implements IPlayersFinder {
	int[][] Chains;
 
	ArrayList<Point> Points=new ArrayList<Point>();
	Point[] Answer;
 
 
	int xmin;
	int xmax;
	int ymin;
	int ymax;
 
 
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) throws NullPointerException {
		if(photo==null)
		{
			throw new NullPointerException();
		}
		
	
        char[][] arr=new char[photo.length][photo[0].toCharArray().length];
        int [][] Taken=new int[photo.length][photo[0].toCharArray().length];
 
 
		char Team=(char)(team+'0');
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=photo[i].toCharArray();
		}
		int i=1;
		for(int y=0;y<arr.length-1;y++)
		{for(int x=0;x<arr[y].length;x++)
		{  
 
			if(findChain(arr,Taken,y,x,i,Team)) {
				//System.out.println(i);
 
				i++;
 
		}}
		}
 
		//System.out.println(i);
 
 
		for(int k=1;k<i;k++)
		{ int count=0;
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
 
 
			for(int j=0;j<Chains.length;j++)
			{  
				for(int m=0;m<Chains[j].length;m++)
				{
					if(k==Chains[j][m])
					{ 
					x.add(m);
					y.add(j);
						count++;
						}
					}
 
		} //System.out.println(count);
			xmax=Collections.max(x);
			xmin=Collections.min(x);
			ymax=Collections.max(y);
			ymin=Collections.min(y);
		
		int z=count*4;
		
			if(z>=threshold) {
 
			  
			  int xcenter= (2*xmax+2*xmin)/2+1;
			  int ycenter=(2*ymax+2*ymin)/2+1;
			  Point CurrentPoint= new Point();
			  CurrentPoint.x=xcenter;
			  CurrentPoint.y=ycenter;
			  Points.add(CurrentPoint);
 
 
			}
			  }
 
		
 
			Answer=new Point[Points.size()];
			for(int k=0;k<Points.size();k++)
			{
				Answer[k]=Points.get(k);
			}
			Answer= SortX();
			Answer=SortY();
 
 
 
 
		// TODO Auto-generated method stub
		return Answer;
 
 
	}
 
	public Point[] SortX ()
	{  Point temp=new Point();
		
		  for(int i=0; i < Answer.length; i++){  
              for(int j=1; j < (Answer.length-i); j++){  
                       if(Answer[j-1].x > Answer[j].x){  
                                
                              temp = Answer[j-1];  
                              Answer[j-1] = Answer[j];  
                              Answer[j] = temp;  
                       }
              }
		  }
 
		return Answer;
 
	}
	public Point[] SortY()
	{  Point temp=new Point();
		
		  for(int i=0; i < Answer.length; i++){  
              for(int j=1; j < (Answer.length-i); j++){  
                       if(Answer[j-1].x == Answer[j].x && Answer[j-1].y> Answer[j].y){  
                              
                              temp = Answer[j-1];  
                              Answer[j-1] = Answer[j];  
                              Answer[j] = temp;  
                       }
              }
		  }
 
		return Answer;
 
	}
 
	public Boolean findChain( char[][] temp ,int [][] Taken,int y,int x,int i,char team) {
		if(temp[y][x]==team)
		{   
 
			if(Taken[y][x]==0) {
				Taken[y][x]=i;
 
				
 
				if(y+1<temp.length) {
 
 
					findChain(temp,Taken,y+1,x,i,team);
					
				}
				if(y-1>-1)
				{   
					findChain(temp,Taken,y-1,x,i,team);
					
				}
				if(x+1<temp[y].length)
				{   
					findChain(temp,Taken,y,x+1,i,team);
					
				}
				if(x-1>-1)
				{   
					findChain(temp,Taken,y,x-1,i,team);
					
				}
 
				return true;
 
			}
			Chains=Taken;
 
		}
		return false;
	}
 
 
}
		
		
		
		
		
		
		
	
	
	


