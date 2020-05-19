package unitTests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import classes.BinaryTreeNode;
import classes.MiscUtils;

class MiscUtilsTest {
	MiscUtils obj = new MiscUtils();

	@Test
	void main() {
	}

	@Test
	void insert() {
		BinaryTreeNode root = null;
		root = obj.insert(root, 9);
		root = obj.insert(root, 12);
		root = obj.insert(root, 4);
		root = obj.insert(root, 33);
		root = obj.insert(root, 2);
		root = obj.insert(root, 1);
		root = obj.insert(root, 8);
		root = obj.insert(root, 34);

		obj.traverse(root);
		System.out.println();
		System.out.println();
		System.out.println();
		root = null;

		root = obj.insert(root, 9);
		root = obj.insert(root, 12);
		root = obj.insert(root, 4);
		root = obj.insert(root, 33);
		root = obj.insert(root, 2);
		root = obj.insert(root, 2);
		root = obj.insert(root, 8);
		root = obj.insert(root, 8);

		obj.traverse(root);

	}

	@Test
	void sumRange() {
		BinaryTreeNode root = null;
		root = obj.insert(root, 9);
		root = obj.insert(root, 12);
		root = obj.insert(root, 4);
		root = obj.insert(root, 33);
		root = obj.insert(root, 2);
		root = obj.insert(root, 1);
		root = obj.insert(root, 8);
		root = obj.insert(root, 34);
		assertEquals(35, obj.sumRange(root, 2, 12));
		assertEquals(79, obj.sumRange(root, 12, 36));
		assertEquals(0, obj.sumRange(root, 0, 0));
		assertEquals(36, obj.sumRange(root, -5, 12));
		root = null;
		root = obj.insert(root, 9);
		root = obj.insert(root, 12);
		root = obj.insert(root, 4);
		root = obj.insert(root, -6);
		root = obj.insert(root, 3);
		root = obj.insert(root, -2);
		root = obj.insert(root, 5);
		root = obj.insert(root, 8);
		assertEquals(18, obj.sumRange(root, -2, 8));
		assertEquals(0, obj.sumRange(root, 14, 5));
		assertEquals(-8, obj.sumRange(root, -6, 0));

	}

	@Test
	void isValidBST() {

		BinaryTreeNode a = new BinaryTreeNode(7);
		BinaryTreeNode b = new BinaryTreeNode(12);
		BinaryTreeNode c = new BinaryTreeNode(2);
		BinaryTreeNode d = new BinaryTreeNode(4);
		BinaryTreeNode e = new BinaryTreeNode(6);
		BinaryTreeNode f = new BinaryTreeNode(20);
		BinaryTreeNode k = new BinaryTreeNode(4);

		a.left = b;
		a.right = c;
		assertFalse(obj.isValidBST(a));
		a.right = b;
		a.left = d;
		d.left = b;
		d.right = c;
		b.left = e;
		assertFalse(obj.isValidBST(a));
		a.left = e;
		a.right = b;
		e.right = f;
		e.left = d;
		assertFalse(obj.isValidBST(a));

		a.left = e;
		a.right = b;
		e.left = d;
		d.left = k;
		assertFalse(obj.isValidBST(a));
		BinaryTreeNode root = null;
		root = obj.insert(root, 9);
		root = obj.insert(root, 12);
		root = obj.insert(root, 4);
		root = obj.insert(root, -6);
		root = obj.insert(root, 3);
		root = obj.insert(root, -2);
		root = obj.insert(root, 5);
		root = obj.insert(root, 8);
		assertTrue(obj.isValidBST(root));

	}

	@Test
	void nextSmallerNumber() {
		int[] arr = new int[] { 10, 9, 2, 7, 6, 1, 2 };

		int[] ans = new int[] { 1, 2, 5, 4, 5, -1, -1 };
		assertArrayEquals(ans, obj.nextSmallerNumber(arr));

		arr = new int[] { 1, 2, 3 };
		ans = new int[] { -1, -1, -1 };
		assertArrayEquals(ans, obj.nextSmallerNumber(arr));

		arr = new int[] { 1, 2, 3, 1 };
		ans = new int[] { -1, 3, 3, -1 };
		assertArrayEquals(ans, obj.nextSmallerNumber(arr));
		arr = new int[] { 10, 11, 12, 13, 14, 15, 3 };
		ans = new int[] { 6, 6, 6, 6, 6, 6, -1 };
		assertArrayEquals(ans, obj.nextSmallerNumber(arr));
		assertThrows(Exception.class, () -> {
			obj.nextSmallerNumber(null);
		});
	}
}
