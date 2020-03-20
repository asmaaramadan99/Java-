package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs32;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {
	
	SinglyLinkedList list1=new SinglyLinkedList();
	SinglyLinkedList list2=new SinglyLinkedList();
	
	SinglyLinkedListTest(){
	list1.add(0,1);
	list1.add(1,2);
	list1.add(2,3);
	list1.add(3,4);
	list1.add(4,5);
	}
	@Test
	void testGet() {
		assertEquals(1,list1.get(0));
		assertEquals(2,list1.get(1));
		assertEquals(3,list1.get(2));
		assertEquals(4,list1.get(3));
		assertEquals(5,list1.get(4));
		assertThrows(RuntimeException.class,()->{list1.get(-1);});
		assertThrows(RuntimeException.class,()->{list1.get(8);});
		list1.add(3,9);
		assertEquals(9,list1.get(3));
		list1.set(2,10);
		assertEquals(10,list1.get(2));	
		
	}
	@Test
	void testClear() {
		list1.clear();
		assertTrue(list1.isEmpty());
	}
	@Test
	void testRemove() {
		list1.remove(3);
		assertEquals(4,list1.size);
		assertEquals(5,list1.get(3));
	}


	@Test
	void testSublist() {
		list2=(SinglyLinkedList) list1.sublist(1,3);
		assertEquals(3,list2.size());
		assertEquals(list1.get(1),list2.get(0));
		assertEquals(list1.get(2),list2.get(1));
		assertEquals(list1.get(3),list2.get(2));
		
		
	}

	@Test
	void testContains() {
		assertTrue(list1.contains(4));
		assertFalse(list1.contains(7));
	}
	
}

