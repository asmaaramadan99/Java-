package eg.edu.alexu.csd.datastructure.stack.cs13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {
     
	ExpressionEvaluator obj=new ExpressionEvaluator();
	@Test
	void testIsValidOperand() {
		assertTrue(obj.isValidOperand('5'));
		assertTrue(obj.isValidOperand('4'));
		assertFalse(obj.isValidOperand('+'));
		assertFalse(obj.isValidOperand('*'));
		assertFalse(obj.isValidOperand('@'));
		assertFalse(obj.isValidOperand('#'));
		
				
	}

	@Test
	void testIsValidOperator() {
		assertTrue(obj.isValidOperator('-'));
		assertTrue(obj.isValidOperator('+'));
		assertTrue(obj.isValidOperator('/'));
		assertTrue(obj.isValidOperator('*'));
		assertFalse(obj.isValidOperator('9'));
		assertFalse(obj.isValidOperator('<'));
		assertFalse(obj.isValidOperator('e'));
		assertFalse(obj.isValidOperator(')'));

    
	}
   
	@Test
	void testInputType() {
		//returns 1 in case of '('
		assertEquals(1,obj.inputType('('));
		//returns 2 in case of an operator
		assertEquals(2,obj.inputType('+'));
		assertEquals(2,obj.inputType('*'));
		assertEquals(2,obj.inputType('/'));
		//returns 3 in case of a digit
		assertEquals(3,obj.inputType('6'));
		//returns 4 in case of a letter
		assertEquals(4,obj.inputType('a'));
		//returns 5 in case of ')'
		assertEquals(5,obj.inputType(')'));
		
	}

	@Test
	void testHasHigherPrec() {
		assertTrue(obj.hasHigherPrec('*', '+'));
		assertTrue(obj.hasHigherPrec('/', '-'));
		assertFalse(obj.hasHigherPrec('*', '/'));
		assertFalse(obj.hasHigherPrec('+', '/'));
		assertFalse(obj.hasHigherPrec('9', '&'));
		
		
	}
    
	@Test
	void testCheckParentheses() {
		String s="(a+b(3*1/2)";
		assertFalse(obj.checkParentheses(s));
		s="((a+b)-(3+5))";
		assertTrue(obj.checkParentheses(s));
		s="(80-123-(345+(4*3))/(12*3))";
		assertTrue(obj.checkParentheses(s));
		
	}

	
    //returns null if the input is invalid
	@Test
	void testCheckValidExpression() {
		String s1="asbd?83u**/23++";
		assertEquals(null,obj.checkValidExpression(s1));
		 s1="(a++b)-(3+4)/5";
		assertEquals(null,obj.checkValidExpression(s1));
		 s1="(12/30)(87+9)";
		assertEquals(null,obj.checkValidExpression(s1));
		 s1="-8*(1+8-3";
		 assertEquals(null,obj.checkValidExpression(s1));
		 s1="&23-8*/(-3+5)";
		 assertEquals(null,obj.checkValidExpression(s1));
		 s1="33/(4+5-56)(";
		 assertEquals(null,obj.checkValidExpression(s1));
		 s1="4-23+12*(23/2)()";
		 assertEquals(null,obj.checkValidExpression(s1));
		 s1="";
		 assertEquals(null,obj.checkValidExpression(s1));
		 s1="(3+8)-(2+3)/5";
		 assertEquals(s1,obj.checkValidExpression(s1));	 
		
	}

    //dummy zero
	@Test
	void testHandleNegativeString() {
		String input="-(3+8)-(2+3)/5";
		String expected="(0-(3+8))-(2+3)/5";
		assertEquals(expected,obj.handleNegative(input));
		input="(a+-b)/-(33-c)*-(3/-8)-(-12--18)";
		expected="(a-b)/(0-(33-c))*(0-(3/(0-8)))-((0-12)+18)";
		assertEquals(expected,obj.handleNegative(input));
		input="-(12+4+-(3*4)-(-8+5)-b)";
		expected="(0-(12+4-(3*4)-((0-8)+5)-b))";
		assertEquals(expected,obj.handleNegative(input));
			
	}

	@Test
	void testInfixToPostfix() {
      assertThrows(RuntimeException.class, () -> {obj.infixToPostfix("23**(3+9)");});
      assertThrows(RuntimeException.class, () -> {obj.infixToPostfix("-8*(1+8-3");});
      assertThrows(RuntimeException.class, () ->{obj.infixToPostfix("4-23+12*(23/2)()");});
      assertThrows(RuntimeException.class, () ->{obj.infixToPostfix(" ");});
      assertThrows(RuntimeException.class, () ->{obj.infixToPostfix("");});
      assertThrows(RuntimeException.class, () ->{obj.infixToPostfix("-*<76+9=76");});
      assertThrows(RuntimeException.class, () ->{obj.infixToPostfix("(87+1)*3/4(");});
      assertThrows(RuntimeException.class, () ->{obj.infixToPostfix("34/7+(12-3)///3");});
      assertEquals("2 3 4 * + ",obj.infixToPostfix("2 + 3 * 4"));
      assertEquals("a b c - d + / e a - * c * ",obj.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
      assertEquals("a b / c - d e * + a c * - ",obj.infixToPostfix("a / b - c + d * e - a * c"));
      assertEquals("0 12 4 + 3 4 * - 0 8 - 5 + - b - - ",obj.infixToPostfix("-(12+4+-(3*4)-(-8+5)-b)"));
      assertEquals("0 3 8 + - 0 2 3 + - * 5 / ",obj.infixToPostfix("-(3+8)*-(2+3)/5"));   
       
	}



	@Test
	void testEvaluate() {
		assertEquals(11,obj.evaluate("-(3+8)*-(2+3)/5"));
		assertEquals(-49,obj.evaluate("(-(33-114/32)+5*-(8/2))"));
		assertEquals(0,obj.evaluate("12/8+-5*-((2/4+3)/2/-9)"));
		assertEquals(-4,obj.evaluate("(130-(35/-2))/-(32+2)"));
		assertThrows(RuntimeException.class, () ->{obj.evaluate("(87+1)*3/4(");});
		assertThrows(RuntimeException.class, () ->{obj.evaluate(" ");});
	    assertThrows(RuntimeException.class, () ->{obj.evaluate("");});
	    assertThrows(RuntimeException.class, () ->{obj.evaluate("4-23+12*(23/0)");});
	    assertThrows(RuntimeException.class, () ->{obj.evaluate("(a-b)/(0-(33-c))*(0-(3/(0-8)))-((0-12)+18)");});
	    	
	}

}
