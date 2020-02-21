import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import java.lang.RuntimeException;

class CalculatorTest {
	 
    Calculator object=new Calculator();

	@Test
	void testAdd() {
		int sum=object.add(3, 4);
		assertEquals(7,sum);
	}

	@Test
	void testDivide() {
		
	
		
		
	
		assertEquals(4.5,object.divide(9,2));
		assertEquals(-3,object.divide(-6,2));
		assertEquals(0.4,round(object.divide(2, 5)*10)/10.0);
		assertThrows(RuntimeException.class,()->{ object.divide(8,0);});
	


}
	
}
