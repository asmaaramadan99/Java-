package eg.edu.alexu.csd.datastructure.stack.cs13;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluator implements IExpressionEvaluator
{   
	/* @param char c
	 * @return true if c is a letter or a digit and zero otherwise
	 */
    public boolean isValidOperand(char c)
    {
        return Character.isLetterOrDigit(c)?true:false;
    }
    
    /* @param char c
     * @return true if c is a valid operator
     * 
     */
    public boolean isValidOperator(char c)
    {
        return(c=='+'|| c=='-'||c=='/'||c=='*')?true:false;
    }
    /*inputType
     * @param character of the infix expression
     * maps the input type to a specific integer
     * 1-> (
     * 2-> any valid operator(+,/,*,-)
     * 3-> for any digit
     * 4-> for any letter
     * 5-> )
     * @return an integer depending on the type of data
     * and zero otherwise indicating invalid input
     */
    public int inputType(char c)
    {
        if(c=='(')
            return 1;
        if(isValidOperator(c))
            return 2;
        if(Character.isDigit(c))
            return 3;
        if(Character.isLetter(c))
            return 4;
        if(c==')')
            return 5;
        else
            return 0;
    }
    /*@param 2 chars (2 operators) 
     * @return true when operator a has higher precedence than b
     * false otherwise
     */
    public boolean hasHigherPrec(char a,char b)
    {
        if((a=='*' || a=='/') && (b=='+' || b=='-'))
            return true;
        return false;
    }

    /*@param String infix expression
     * isValidFirst checks whether the first character of the input is a digit or a character or a bracket
     * these are the only 3 valid cases at the beginning after handling the negative signs separately.
     * @return true if the first character is valid
     * false otherwise
     */
    public boolean isValidFirst(String s)
    {
        char c=s.charAt(0);
        return (c=='(' || Character.isLetterOrDigit(c))?true:false;
    }
    /*@param 2 consecutive characters of the infix expression
    * checks whether 2 consecutive characters are valid in infix notation.
    * valid cases:
    * (digit or (letter or ((
    * operator letter or operator digit or operator (
    * digit digit or digit operator or digit )
    * letter operator or letter )
    * ) operator or ))
    *
    *  @return true if the combination is valid
    *  false otherwise
    */
    public boolean isValidPair(int a,int b)
    {
        if(a==1 && (b==3|| b==4 ||b==1))
            return true;
        if(a==2 &&(b==1||b==3||b==4))
            return true;
        if((a==3||a==4)&&(b==2||b==5))
            return true;
        if(a==4 &&(b==2|| b==5))
            return true;
        if(a==5 && (b==2||b==5))
            return true;
        if(a==3 && b==3)
            return true;
        return false;
    }
    
    /* @param String infix expression
     * checks whether the parentheses are balanced 
     * @return true if balanced
     * false otherwise
     */
    public boolean checkParentheses(String s)
    {
        int countParentheses=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(')
                countParentheses++;

            else if(s.charAt(i)==')')
                countParentheses--;
        }
        return countParentheses==0?true:false;
    }
    /* @param string infix expression 
     * @param index of an opening bracket 
     * @return index of its closing bracket
     * 
     */
    public int findclosingBracket(String s,int start)
    {
        int i=start;
        int count=0;
        for( ; i<s.length(); i++)
        {
            if(s.charAt(i)=='(') 
            	count++;
            else if(s.charAt(i)==')')
                count--;
            if(count==0)
                break;
        }
        return i;
    }
    /* @param string infix expression
     * checks the validity of the input 
     * @return the expression of valid 
     * null otherwise 
     * 
     */

    public String checkValidExpression(String s)

    {   if(s.isEmpty()) {return null;}
        s=s.replaceAll("\\s","");
        s=handleNegative(s);
        String str=s;
        int size=str.length(),i=1;
        boolean valid=true;
        boolean validParentheses=checkParentheses(str);
        if(!validParentheses ||!isValidFirst(str) || !(isValidOperand(str.charAt(size-1))||(str.charAt(size-1)==')'))) {
        	return null;}
        char prev=str.charAt(0);
        while(i<size-1 &&valid &&validParentheses)
        {
            char current=str.charAt(i);
            if(!(isValidPair(inputType(prev),inputType(current))))
            {
                return null;
            }
            prev=current;
            i++;
        }
        return str ;
    }

   /*
    * @param String infix expression 
    * @param index of first digit in a number
    * @return the index of last digit
    * 
    */
    public int count(String s, int index)
    {
        int i=index;
            while(index<s.length())
            {
                if(!(Character.isDigit(s.charAt(index))))
                    break;
                else
                {
                    i++;
                }
                index++;
            }
            return i;
    }
    /* @param infix expression
     * @param index of first digit
     * @return the whole number as a string 
     * 
     */

    public String getNumber(String s,int index)
    {
        String str="";
        int i=count(s,index);
        str=s.substring(index,i);
        return str;
    }

    /*helping function
     * @param infix expression 
     * @index of occurrence of target string -> { -( , *-( , /-( , +-( , (-( }
     * @return a string with all negative brackets converted using dummy zero -> -(3+5) -> (0-(3+5))
     * 
     */
    public String handleNegativeBrackets(String s,int index1)
    {
        try
        {
            if(s.indexOf("-(",index1)==-1 )
                return s;

           
                index1=s.indexOf("-(",index1);
            if(index1==0)
            {
                int end0=findclosingBracket(s,index1+1);
                s=s.replace("-("+s.substring(index1+2,end0),"(0-"+s.substring(index1+1,end0)+")");
            }
            else if(s.charAt(index1-1)=='+'||s.charAt(index1-1)=='*'||s.charAt(index1-1)=='/'||s.charAt(index1-1)=='(')
            {

                int end1=findclosingBracket(s,index1+1);
                s=s.replace("-("+s.substring(index1+2,end1),"(0-"+s.substring(index1+1,end1)+")");
            }

        }

        catch(IndexOutOfBoundsException e){};
        return handleNegativeBrackets(s,index1+1);
    }
    /*helping function 
     * @param infix expression
     * @param @index of occurrence of target string { (- number , (- symbol }
     * @return target strings replaced by dummy zeros
     * 
     */

    public String handleNegative(String s,int index1)
    {
        try
        
        { 
        	if((s.indexOf("(-",index1)==-1 ))
                return s;
        	if(s.charAt(0)=='-')
        {
        	if(inputType(s.charAt(1))==4)
        		s=s.replace("-"+s.charAt(1), "(0-"+s.charAt(1)+")");
        	else 
        	{
        		int end=count(s,1);
        		 s=s.replace("-"+s.substring(1,end),"(0-"+s.substring(1,end)+")");
            }
        	}
            index1=s.indexOf("(-",index1);
            if(inputType(s.charAt(index1+2))==4)
                s=s.replace("(-"+s.charAt(index1+2),"((0-"+s.charAt(index1+2)+")");
            else
            {   
                int end=count(s,index1+2);
                s=s.replace("(-"+s.substring(index1+2,end),"((0-"+s.substring(index1+2,end)+")");
            }    
        }
        catch(IndexOutOfBoundsException e) {};
        return handleNegative(s,index1+1);

    }
    
    /*helping function 
     * replaces patterns { *- , /- } by dummy zeros 
     * @param infix expression
     * @param index to start searching for patterns from
     * @return infix expression with those patterns replaced
     * 
     */
    public String handleNegative(String s,String pattern,int index)
    { try {
    	if(s.indexOf(pattern,index)==-1)
    		return s;
    	index=s.indexOf(pattern,index);
    	int end=count(s,index+2);
    	if(pattern.equals("*-"))
    	s=s.replace(pattern+s.substring(index+2,end),"*(0-"+s.substring(index+2,end)+")");
    	if(pattern.equals("/-"))
    	s=s.replace(pattern+s.substring(index+2,end),"/(0-"+s.substring(index+2,end)+")");	
    	
    }
    catch(IndexOutOfBoundsException e) {};
    return handleNegative( s,pattern,index+1);
    }
    /* @param String infix expression
     * handles all negative numbers using dummy zero 
     * @returns string after modification 
     */
    public String handleNegative(String s)
    {      s=s.replaceAll("\\-\\-","\\+");
           s=s.replaceAll("\\+\\-","\\-");
    	   s=handleNegativeBrackets(s,0);
 	       s=handleNegative(s,0);
 	       s=handleNegative(s, "*-",0);
 	       s=handleNegative(s,"/-",0);
 	       return s;
    }
    /* @param String infix expression
     * @returns String postfix expression , throws runtime exception if the expression is not valid
     */
    @Override
    public String infixToPostfix(String expression)
    {
        String infix="";
        int i=0;
        int type=0;
        char current;
        StringBuilder postfix=new StringBuilder();
        Stack stack=new Stack();
        infix=checkValidExpression(expression);
        if(infix==null)
            throw new RuntimeException("Invalid infix expression");

        while(i<infix.length())
        {
            current=infix.charAt(i);
            type=inputType(current);
            switch(type)
            {
            case 1:
                stack.push(current);
                i++;
                break;
            case 2:
                if(stack.isEmpty())
                {
                    stack.push(current);
                    i++;
                }
                else if(inputType((char)stack.peek())!=2)
                {
                    stack.push(current);
                    i++;
                }
                else
                {
                    if(hasHigherPrec(current,(char)stack.peek()))
                    {
                        stack.push(current);
                        i++;
                    }

                    else
                    {
                        while(!stack.isEmpty())
                        {
                            if(inputType((char)stack.peek())==2)
                            {
                                if(hasHigherPrec(current,(char)stack.peek()))
                                    break;
                                postfix.append(stack.pop()+" ");
                            }
                            else
                                break;
                        }
                        stack.push(current);
                        i++;
                    }
                }
                break;
            case 3:
                String number=getNumber(infix,i);
                postfix.append(number+" ");
                i=i+number.length();
                break;
            case 4:
                postfix.append(current+" ");
                i++;
                break;
            case 5:

                while(!stack.isEmpty())
                {
                    if((char)stack.peek()=='(')
                        break;
                    postfix.append(stack.pop()+" ");
                }
                stack.pop();
                i++;
                break;
            }
        }
        while(!stack.isEmpty())
        {
            postfix.append(stack.pop()+" ");
        }
        return postfix.toString();
    }
    
    public float compute(String x,String y,char op) {
    	float a=Float.parseFloat(x);
    	float b=Float.parseFloat(y);
    	if(b==0 && op=='/') throw new RuntimeException("can't divide by zero");
    	
    	switch (op)
    	{
    	case '+': return a+b;
    	case '-': return a-b;
    	case '/': return (float)a/b;
    	case '*': return a*b;
    	}
		return 0;
    	
    }
    /*
     * @param String infix expression
     * @returns the value of the expression, throws runtime exception if the expression contains symbols
     */
    @Override
    public int evaluate(String expression)
    {   String current="";
	    Stack stack=new Stack();
	    int inputType=0;
    	String postfix=infixToPostfix(expression).trim();
    	Pattern p = Pattern.compile("[^\\d+ + \\-  / * ( )]");
		Matcher m = p.matcher(postfix);
		boolean notValid = m.find();
		if(notValid) throw new RuntimeException("Invalid Expression");
		
		StringTokenizer tokenizer=new StringTokenizer(postfix);
		while(tokenizer.hasMoreTokens())
		{
			current=tokenizer.nextToken();
			inputType=inputType(current.charAt(0));
			
			switch(inputType) {
			case 3:
				stack.push(current);
				break;
			case 2:	
				String a=(String) stack.pop();
				String b=(String) stack.pop();
				stack.push(Float.toString(compute(b,a,current.charAt(0))));		
				break;		
			}
		}
		return (int) Float.parseFloat((String) stack.pop());      
    }

}
