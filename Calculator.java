 
 class Calculator implements Calculate{
	

	public int add( int x, int y) {
		
		return x+y;
	}

	
	public float divide(int x, int y) {
		if(y==0)
			throw new ArithmeticException("dividing a number by 0 is not allowed");
		
		return (float) x/y;
		
		}
	}

	 
 
