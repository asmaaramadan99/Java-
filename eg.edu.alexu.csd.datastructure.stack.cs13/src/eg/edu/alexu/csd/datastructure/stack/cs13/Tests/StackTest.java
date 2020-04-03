package eg.edu.alexu.csd.datastructure.stack.cs13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	
	Stack s=new Stack();
	StackTest()
	{
		s.push(10);
		s.push(20);
		s.push(19);
		s.push(5);
		s.push(12);
		s.push(3); 
	} 
	

	@Test
	void testPop() {
		
		assertEquals(3,s.pop());
		assertEquals(12,s.pop());
		assertEquals(5,s.pop());
		assertEquals(19,s.pop());
		assertEquals(20,s.pop());
		assertEquals(10,s.pop());
		assertThrows(RuntimeException.class,()->{s.pop();});
		
	}

	@Test
	void testPeek() {
	assertEquals(3,s.peek());
		s.pop();
		s.pop();
		assertEquals(5,s.peek());
		s.push(80);
		assertEquals(80,s.peek());
	}
	

	@Test
	void testPush() {
		s.push(15);
		assertEquals(15,s.peek());
		s.push(33);
		assertEquals(33,s.peek());
		s.push(120);
		assertEquals(120,s.peek());
	}

	@Test
	void testIsEmpty() {
		assertFalse(s.isEmpty());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		assertTrue(s.isEmpty());
	
	}

	@Test
	void testSize() {
		assertEquals(6,s.size());
		s.pop();
		s.pop();
		assertEquals(4,s.size());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		assertEquals(0,s.size());
		assertThrows(RuntimeException.class,()->{s.pop();});
	}

}
