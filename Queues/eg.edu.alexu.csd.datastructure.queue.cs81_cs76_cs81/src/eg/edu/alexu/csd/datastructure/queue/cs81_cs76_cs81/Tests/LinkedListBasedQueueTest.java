package eg.edu.alexu.csd.datastructure.queue.cs81_cs76_cs81;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListBasedQueueTest {
	LinkedListBasedQueue Queue=new LinkedListBasedQueue();

	@Test
	void testEnqueue() {
		Queue.enqueue(5);
		Queue.enqueue(67);
		Queue.enqueue("hello");
		Queue.enqueue("*");
		Queue.enqueue("<>");
		Queue.enqueue('s');
		assertEquals(6,Queue.size());
	}

	@Test
	void testDequeue() {
	     assertThrows(RuntimeException.class,()->{Queue.dequeue();});
	     Queue.enqueue(19);
	     Queue.enqueue(87);
	     assertEquals(19,Queue.dequeue());
	     assertEquals(87,Queue.dequeue());
	     assertThrows(RuntimeException.class,()->{Queue.dequeue();});
	}

	@Test
	void testIsEmpty() {
		Queue.enqueue(78);
		Queue.enqueue(866);
		Queue.enqueue(88);
		assertFalse(Queue.isEmpty());
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		assertTrue(Queue.isEmpty());
	
	}

	@Test
	void testSize() {
		Queue.enqueue(5);
		Queue.enqueue(67);
		Queue.enqueue(3);
		Queue.enqueue(6);
		Queue.enqueue(12);
		Queue.enqueue(45);
		Queue.enqueue(12);
		Queue.enqueue(32);
		assertEquals(8,Queue.size());
		Queue.dequeue();
		assertEquals(7,Queue.size());
		Queue.enqueue("*");
		Queue.enqueue("/");
		Queue.enqueue("()");
		assertEquals(10,Queue.size());
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		Queue.dequeue();
		assertTrue(Queue.isEmpty());
		assertThrows(RuntimeException.class,()->{Queue.dequeue();});
	}

}
