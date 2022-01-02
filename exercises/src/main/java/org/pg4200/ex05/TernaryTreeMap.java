package org.pg4200.ex05;

import com.sun.source.tree.Tree;
import org.pg4200.les05.MyMapBinarySearchTree;
import org.pg4200.les05.MyMapTreeBased;

import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K, V> {

	protected class TreeNode {

		// Each node can contain two elements, instead just of one.
		public K firstKey;
		public V firstValue;

		public K secondKey;
		public V secondValue;

		// Each node can have three children
		public TreeNode left;
		public TreeNode middle;
		public TreeNode right;
	}

	protected TreeNode root;
	protected int size;

	@Override
	public void put(K key, V value) {
		Objects.requireNonNull(key);
		root = put(key, value, root);
	}

	private TreeNode put(K key, V value, TreeNode subtree) {

		// No root present. Add node
		if (subtree == null) {
			TreeNode node = new TreeNode();
			node.firstKey = key;
			node.firstValue = value;
			size++;
			return node;
		}

		int cmpFirst = key.compareTo(subtree.firstKey);

		if (cmpFirst < 0) {
			subtree.left = put(key, value, subtree.left);
			return subtree;
		}

		if (cmpFirst == 0) {
			subtree.firstValue = value;
			return subtree;
		}

		// K is bigger than K1
		if (subtree.secondKey == null) {
			subtree.secondKey = key;
			subtree.secondValue = value;
			size++;
			return subtree;
		}

		int cmpSecond = key.compareTo(subtree.secondKey);

		// K bigger than K1 & smaller than K2
		if (cmpSecond < 0) {
			subtree.middle = put(key, value, subtree.middle);
			return subtree;
		}

		// K bigger than K2
		if (cmpSecond > 0) {
			subtree.right = put(key, value, subtree.right);
			return subtree;
		}

		//if (cmpSecond == 0)
		subtree.secondValue = value;

		return subtree;
	}

	@Override
	public void delete(K key) {
		Objects.requireNonNull(key);
		root = delete(key, root);
	}

	private TreeNode delete(K key, TreeNode subtreeRoot) {

		if (subtreeRoot == null) return null;

		int cmpFirst = key.compareTo(subtreeRoot.firstKey);

		if (cmpFirst < 0) {
			subtreeRoot.left = delete(key, subtreeRoot.left);
			return subtreeRoot;
		}

		if (cmpFirst == 0) {
			size--;

			if (subtreeRoot.secondKey == null) {
				// subtreeRoot.right is null
				if (subtreeRoot.left == null && subtreeRoot.middle == null) {
					return null;
				}
				if (subtreeRoot.left == null) return subtreeRoot.middle;
				if (subtreeRoot.middle == null) return subtreeRoot.left;
				// K has two children
				TreeNode minNode = min(subtreeRoot.middle);
				subtreeRoot.firstKey = minNode.firstKey;
				subtreeRoot.firstValue = minNode.firstValue;
				subtreeRoot.middle = deleteMin(subtreeRoot.middle);

				return subtreeRoot;
			} else {
				// K is 3 node without middle
				if (subtreeRoot.middle == null) {
					subtreeRoot.firstKey = subtreeRoot.secondKey;
					subtreeRoot.firstValue = subtreeRoot.secondValue;
					subtreeRoot.secondKey = null;
					subtreeRoot.secondValue = null;

					subtreeRoot.middle = subtreeRoot.right;
					subtreeRoot.right = null;

					return subtreeRoot;
				} else if (subtreeRoot.left == null) {
					// K is 3 node without left
					subtreeRoot.firstKey = subtreeRoot.secondKey;
					subtreeRoot.firstValue = subtreeRoot.secondValue;
					subtreeRoot.secondKey = null;
					subtreeRoot.secondValue = null;

					subtreeRoot.left = subtreeRoot.middle;
					subtreeRoot.middle = subtreeRoot.right;
					subtreeRoot.right = null;

					return subtreeRoot;
				} else {
					// K is 3 node without right
					TreeNode minNode = min(subtreeRoot.middle);
					subtreeRoot.firstKey = minNode.firstKey;
					subtreeRoot.firstValue = minNode.firstValue;
					subtreeRoot.middle = deleteMin(subtreeRoot.middle);

					return subtreeRoot;
				}
			}
		}

		// K is bigger than K1, check if K2 exists first

		if (subtreeRoot.secondKey == null) {
			subtreeRoot.middle = delete(key, subtreeRoot.middle);
			return subtreeRoot;
		}

		// K2 != null

		int cmpSecond = key.compareTo(subtreeRoot.secondKey);

		if (cmpSecond > 0) {
			subtreeRoot.right = delete(key, subtreeRoot.right);
			return subtreeRoot;
		}

		if (cmpSecond < 0) {
			subtreeRoot.middle = delete(key, subtreeRoot.middle);
			return subtreeRoot;
		}

		// Delete K2
		if (cmpSecond == 0) {
			size--;
		}

		if (subtreeRoot.right == null) {
			subtreeRoot.secondKey = null;
			subtreeRoot.secondValue = null;
			return subtreeRoot;
		}

		TreeNode minNode = min(subtreeRoot.right);
		subtreeRoot.secondKey = minNode.firstKey;
		subtreeRoot.secondValue = minNode.firstValue;
		subtreeRoot.right = deleteMin(subtreeRoot.right);

		return subtreeRoot;
	}

	private TreeNode min(TreeNode subtree) {
		if (subtree.left == null) return subtree;

		return min(subtree.left);
	}

	private TreeNode deleteMin(TreeNode subtree) {

		if (subtree.left == null) {
			if (subtree.secondKey == null) {
				return subtree.middle;
			} else {
				subtree.firstKey = subtree.secondKey;
				subtree.firstValue = subtree.secondValue;
				subtree.secondKey = null;
				subtree.secondValue = null;

				subtree.left = subtree.middle;
				subtree.middle = subtree.right;
				subtree.right = null;

				return subtree;
			}
		}

		subtree.left = deleteMin(subtree.left);

		return subtree;
	}

	@Override
	public V get(K key) {
		Objects.requireNonNull(key);
		return get(key, root);
	}

	private V get(K key, TreeNode subtree) {

		if (subtree == null) return null;

		int cmpFirst = key.compareTo(subtree.firstKey);

		if (cmpFirst < 0) return get(key, subtree.left);

		if (cmpFirst == 0) return subtree.firstValue;

		if (subtree.secondValue != null) {
			int cmpSecond = key.compareTo(subtree.secondKey);

			if (cmpSecond == 0) return subtree.secondValue;

			if (cmpSecond > 0) return get(key, subtree.right);
		}

		// K > K1 & smaller than K2 or K2 is null
		return get(key, subtree.middle);

		/*if (cmpFirst == 0) {
			return subtree.firstValue;
		} else if (cmpFirst < 0) {
			return get(key, subtree.left);
		} else if (subtree.secondKey != null) {
			// Key is bigger than firstKey
				int cmpSecond = key.compareTo(subtree.secondKey);
				if (cmpSecond == 0)
					return subtree.secondValue;
				if (cmpSecond < 0 && subtree.middle != null)
					return get(key, subtree.middle);
				if (cmpSecond > 0)
					return get(key, subtree.right);
		} else {
			return get(key, subtree.right);
		}*/
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return MyMapTreeBased.super.isEmpty();
	}

	@Override
	public int getMaxTreeDepth() {
		if (root == null) return 0;
		return depth(root);
	}

	private int depth(TreeNode subtree) { // private or protected??
		int leftDepth = 0;
		int middleDepth = 0;
		int rightDepth = 0;

		if (subtree.left != null) {
			leftDepth = depth(subtree.left);
		}

		if (subtree.middle != null) {
			middleDepth = depth(subtree.middle);
		}

		if (subtree.right != null) {
			rightDepth = depth(subtree.right);
		}

		return 1 + Math.max(leftDepth, Math.max(middleDepth, rightDepth));
	}
}