package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import classes.HashTableDictionary;

class HashTableDictionaryTest {

	HashTableDictionary<Integer, String> t = new HashTableDictionary<Integer, String>(1000);

	@Test
	void testSet() {
		assertNull(t.set(112, "asmaa"));
		assertNull(t.set(1885, "hi"));
		assertNull(t.set(1513, "bye"));
		assertNull(t.set(513, "cat"));
		assertNull(t.set(141, "meow"));
		assertNull(t.set(88, "hello"));
		assertNull(t.set(300, "test"));
		assertNull(t.set(1234, "goodbye"));
		assertNull(t.set(1200, "s"));
		assertNull(t.set(200, "xy"));
		assertEquals("asmaa", t.set(112, "hi"));
		assertEquals("bye", t.set(1513, "asmaa"));
		assertEquals("xy", t.set(200, "no"));
		assertEquals("cat", t.set(513, "yes"));
		assertThrows(Exception.class, () -> {
			t.set(null, "123");
		});
		assertThrows(Exception.class, () -> {
			t.set(null, null);
		});
		assertThrows(Exception.class, () -> {
			t.set(123, null);
		});
	}

	@Test
	void testGet() {
		assertNull(t.set(112, "asmaa"));
		assertNull(t.set(1885, "hi"));
		assertNull(t.set(1513, "bye"));
		assertNull(t.set(513, "cat"));
		assertNull(t.set(141, "meow"));
		assertNull(t.set(88, "hello"));
		assertNull(t.set(300, "test"));
		assertNull(t.set(1234, "goodbye"));
		assertNull(t.set(1200, "s"));
		assertNull(t.set(200, "xy"));
		assertEquals("asmaa", t.get(112));
		assertEquals("hi", t.get(1885));
		assertEquals("bye", t.get(1513));
		assertEquals("cat", t.get(513));
		assertEquals("meow", t.get(141));
		assertEquals("hello", t.get(88));
		assertEquals("test", t.get(300));
		assertEquals("goodbye", t.get(1234));
		assertEquals("s", t.get(1200));
		assertEquals("xy", t.get(200));
		t.set(1234, "abc");
		assertEquals("abc", t.get(1234));
		t.set(513, "123");
		assertEquals("123", t.get(513));
		assertNull(t.get(0));
		assertNull(t.get(99999));
		assertThrows(Exception.class, () -> {
			t.get(null);
		});

	}

	@Test
	void testIsEmpty() {
		t.set(112, "asmaa");
		t.set(1885, "hi");
		t.set(1513, "bye");
		t.set(513, "cat");
		t.set(141, "meow");
		t.set(88, "hello");
		t.set(300, "test");
		t.set(1234, "goodbye");
		t.set(1200, "s");
		t.set(200, "xy");
		assertFalse(t.isEmpty());
		t.remove(112);
		t.remove(1885);
		t.remove(1513);
		t.remove(513);
		t.remove(141);
		t.remove(88);
		t.remove(300);
		assertThrows(Exception.class, () -> {
			t.remove(8977);
		});

		t.remove(1234);
		t.remove(1200);
		t.remove(200);
		assertTrue(t.isEmpty());
		assertThrows(Exception.class, () -> {
			t.remove(1);
		});
		assertThrows(Exception.class, () -> {
			t.remove(null);
		});

	}

	@Test
	void testRemove() {
		t.set(112, "asmaa");
		t.set(1885, "hi");
		t.set(1513, "bye");
		t.set(513, "cat");
		t.set(141, "meow");
		t.set(88, "hello");
		t.set(300, "test");
		t.set(1234, "goodbye");
		t.set(1200, "s");
		t.set(200, "xy");
		assertFalse(t.isEmpty());
		assertEquals("asmaa", t.remove(112));
		assertEquals("hi", t.remove(1885));
		assertEquals("bye", t.remove(1513));
		assertEquals("cat", t.remove(513));
		assertEquals("meow", t.remove(141));
		assertEquals("hello", t.remove(88));
		assertEquals("test", t.remove(300));
		assertThrows(Exception.class, () -> {
			t.remove(8977);
		});

		assertEquals("goodbye", t.remove(1234));
		assertEquals("s", t.remove(1200));
		assertEquals("xy", t.remove(200));
		assertTrue(t.isEmpty());
		assertThrows(Exception.class, () -> {
			t.remove(1);
		});
		assertThrows(Exception.class, () -> {
			t.remove(null);
		});
		assertTrue(t.isEmpty());

	}

}
