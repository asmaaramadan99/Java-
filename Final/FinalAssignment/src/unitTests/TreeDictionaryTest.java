package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.TreeDictionary;
 
class TreeDictionaryTest {
	
    TreeDictionary<String,Integer>t=new TreeDictionary<String,Integer>();
    
  
	@Test
	void testSet() {
		assertNull(t.set("asmaa",1234));
		assertNull(t.set("hi",122));
		assertNull(t.set("bye",56));
		assertNull(t.set("ok",4));
		assertNull(t.set("meow",12));
		assertNull(t.set("tree",598));
		assertEquals(1234,t.set("asmaa",666));
		assertEquals(598,t.set("tree",36));
		assertEquals(56,t.set("bye",6));
		assertEquals(4,t.set("ok",621));
		assertEquals(122,t.set("hi",23));
		assertThrows(Exception.class, () -> {
		    t.set(null,89);
		  });
		assertThrows(Exception.class, () -> {
		    t.set(null,null);
		  });
		assertThrows(Exception.class, () -> {
		    t.set("test",null);
		  });
		
		
		
	}
	
	@Test
	void testGet() {
		t.set("asmaa",1234);
		t.set("hi",122);
		t.set("bye",56);
		t.set("ok",4);
		t.set("meow",12);
		t.set("tree",598);
		t.set("sun",144);
		t.set("ds",1244);
		t.set("meowww",88);
		assertEquals(1234,t.get("asmaa"));
		assertEquals(598,t.get("tree"));
		assertEquals(56,t.get("bye"));
		assertEquals(4,t.get("ok"));
		assertEquals(122,t.get("hi"));
		assertEquals(12,t.get("meow"));
		assertEquals(144,t.get("sun"));
		assertEquals(1244,t.get("ds"));
		assertEquals(88,t.get("meowww"));
		t.set("ds", 22);
		assertEquals(22,t.get("ds"));
		assertThrows(Exception.class, () -> {
		    t.get(null);
		  });
		assertNull(t.get("abc"));
		assertNull(t.get("xyz"));
		assertNull(t.get("9888"));

		
		
	}


	@Test
	void testRemove() {
		t.set("asmaa",1234);
		t.set("hi",122);
		t.set("bye",56);
		t.set("ok",4);
		t.set("meow",12);
		t.set("tree",598);
		t.set("sun",144);
		t.set("ds",1244);
		t.set("meowww",88);
		assertEquals(1234,t.remove("asmaa"));
		assertEquals(598,t.remove("tree"));
		assertEquals(56,t.remove("bye"));
		assertEquals(4,t.remove("ok"));
		assertEquals(122,t.remove("hi"));
		assertEquals(12,t.remove("meow"));
		assertEquals(144,t.remove("sun"));
		assertEquals(1244,t.remove("ds"));
		assertEquals(88,t.remove("meowww"));
		assertTrue(t.isEmpty());
		assertThrows(Exception.class, () -> {
		    t.remove(null);
		  });
		assertNull(t.remove("abc"));
		assertNull(t.remove("xyz"));
		assertNull(t.remove("9888"));
     
	}

	@Test
	void testIsEmpty() {
		
		t.set("asmaa",1234);
		t.set("hi",122);
		t.set("bye",56);
		t.set("ok",4);
		t.set("meow",12);
		t.set("tree",598);
		t.set("sun",144);
		t.set("ds",1244);
		t.set("meowww",88);
		assertFalse(t.isEmpty());
		assertEquals(1234,t.remove("asmaa"));
		assertEquals(598,t.remove("tree"));
		assertEquals(56,t.remove("bye"));
		assertEquals(4,t.remove("ok"));
		assertEquals(122,t.remove("hi"));
		assertEquals(12,t.remove("meow"));
		assertEquals(144,t.remove("sun"));
		assertEquals(1244,t.remove("ds"));
		assertEquals(88,t.remove("meowww"));
		assertTrue(t.isEmpty());
		
	}
	

}
