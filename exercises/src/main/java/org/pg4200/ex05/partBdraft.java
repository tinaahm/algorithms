/*package org.pg4200.ex05;

public class partBdraft {
	/*private TernaryTreeMap.TreeNode put(K key, V value,
										 TernaryTreeMap.TreeNode subtree) {

		// No root present. Add node
		if (subtree == null) {
			TernaryTreeMap.TreeNode node = new TernaryTreeMap.TreeNode();
			node.firstKey = key;
			node.firstValue = value;
			size++;
			return node;
		}

		int cmpFirst = key.compareTo(subtree.firstKey);

		// K & K1 are equal
		if (cmpFirst == 0) {
			subtree.firstValue = value;
			return subtree;
		}

		// If second element is empty
		if (subtree.secondKey == null) {

			// K is smaller than K1, but K2 is empty so switch & insert.
			if (cmpFirst < 0) {
				subtree.secondKey = subtree.firstKey;
				subtree.secondValue = subtree.firstValue;

				subtree.firstKey = key;
				subtree.firstValue = value;

				size++;
				return subtree;
			}

			// K is bigger than K1, K2 is empty so insert
			if (cmpFirst > 0) {
				subtree.secondKey = key;
				subtree.secondValue = value;
				size++;
				return subtree;
			}
		}

		int cmpSecond = key.compareTo(subtree.secondKey);

		// K & K2 are equal
		if (cmpSecond == 0) {
			subtree.secondValue = value;
			return subtree;
		}

		// Both K1 & K2 are unavailable. If children are null = find
		// median and make the others children.

		TernaryTreeMap.TreeNode tmp = new TernaryTreeMap.TreeNode();

		// K is smaller than K1
		if (cmpFirst < 0) {
			subtree.left = put(key, value, subtree.left);
			subtree.right = put(subtree.secondKey, subtree.secondValue, subtree.right);
			subtree.secondKey = null;
			subtree.secondValue = null;

			size++;
			return subtree;
		}

		// K is smaller than K2 & bigger than K1
		if (cmpSecond < 0) {
			subtree.left = put(subtree.firstKey, subtree.firstValue,
					subtree.left);
			subtree.right = put(subtree.secondKey, subtree.secondValue, subtree.right);
			subtree.secondKey = null;
			subtree.secondValue = null;
			subtree.firstKey = key;
			subtree.firstValue = value;

			size++;
			return subtree;
		}

		if (cmpSecond > 0) {
			subtree.left = put(subtree.firstKey, subtree.firstValue,
					subtree.left);
			subtree.right = put(key, value, subtree.right);
			subtree.firstKey = subtree.secondKey;
			subtree.firstValue = subtree.secondValue;
			subtree.secondKey = null;
			subtree.secondValue = null;

			size++;
			return subtree;
		}

		// if statement unnecessary?
		/*
		if (subtree.left == null && subtree.middle == null && subtree.right == null) {

			TreeNode tmp = new TreeNode();

			// K is smaller than K1
			if (cmpFirst < 0) {
				subtree.left = put(key, value, subtree.left);
				subtree.right = put(subtree.secondKey, subtree.secondValue, subtree.right);
				subtree.secondKey = null;
				subtree.secondValue = null;

				size++;
				return subtree;
			}

			// K is smaller than K2 & bigger than K1
			if (cmpSecond < 0) {
				subtree.left = put(subtree.firstKey, subtree.firstValue,
						subtree.left);
				subtree.right = put(subtree.secondKey, subtree.secondValue, subtree.right);
				subtree.secondKey = null;
				subtree.secondValue = null;
				subtree.firstKey = key;
				subtree.firstValue = value;

				size++;
				return subtree;
			}

			if (cmpSecond > 0) {
				subtree.left = put(subtree.firstKey, subtree.firstValue,
						subtree.left);
				subtree.right = put(key, value, subtree.right);
				subtree.firstKey = subtree.secondKey;
				subtree.firstValue = subtree.secondValue;
				subtree.secondKey = null;
				subtree.secondValue = null;

				size++;
				return subtree;
			}

		}*/

		/*
		if (cmpFirst < 0) {
			subtree.left = put(key, value, subtree.left);
			return subtree;
		} else if (cmpFirst == 0) {
			subtree.firstValue = value;
		} else { // Key is bigger than first key.

			if (subtree.secondKey == null) {
				subtree.secondKey = key;
				subtree.secondValue = value;
				size++;
			} else {

				int cmpSecond = key.compareTo(subtree.secondKey);

				if (cmpSecond < 0) {
					subtree.middle = put(key, value, subtree.middle);
				} else if (cmpSecond > 0) {
					subtree.right = put(key, value, subtree.right);
				} else {
					subtree.secondValue = value;
				}
			}
		}*/

		//return subtree;
		/*if (subtree.left == null && subtree.right == null) {
			if (subtree.secondKey == null) {
				int cmp = key.compareTo(subtree.firstKey);

				if (cmp > 0) {
					subtree.secondKey = key;
					subtree.secondValue = value;
					size++;
					return subtree;
				}

				if (cmp < 0 ) {
					TreeNode tmp = subtree;
					subtree.firstKey = key;
					subtree.firstValue = value;
					subtree.secondKey = tmp.firstKey;
					subtree.secondValue = tmp.secondValue;
					size++;
					return subtree;
				}

			}
		}

		int cmpFirst = key.compareTo(subtree.firstKey);
		int cmpSecond = key.compareTo(subtree.secondKey);

		if (cmpFirst < 0) {
			subtree.left = put(key, value, subtree.left);
			return subtree;
		}

		if (cmpSecond > 0) {
			subtree.right = put(key, value, subtree.right);
			return subtree;
		}

		// At this point the key would be bigger than the first key, but
		// smaller than the second.

		TreeNode tmp = subtree;
		subtree.firstKey = key;
		subtree.firstValue = value;
		subtree.secondKey = null;
		subtree.secondValue = null;
		subtree.left = tmp.firstKey;*/
	//}

/*private TreeNode delete(K key, TreeNode subtreeRoot) {
		if (subtreeRoot == null) return null;

		int cmpFirst = key.compareTo(subtreeRoot.firstKey);

		if (cmpFirst < 0) {
		subtreeRoot.left = delete(key, subtreeRoot.left);
		return subtreeRoot;
		}

		if (cmpFirst == 0) {
		size--;

		}

		int cmpSecond = key.compareTo(subtreeRoot.secondKey);

		if (cmpSecond < 0) {
		subtreeRoot.middle = delete(key, subtreeRoot.middle);
		return subtreeRoot;
		}

		if (cmpSecond > 0) {
		subtreeRoot.right = delete(key, subtreeRoot.right);
		return subtreeRoot;
		}

		// cmpSecond == 0


		/*if (cmpFirst > 0 && subtreeRoot.secondKey != null) {
			int cmpSecond = key.compareTo(subtreeRoot.secondKey);

			if (cmpSecond < 0) {
				subtreeRoot.middle = delete(key, subtreeRoot.middle);
				return subtreeRoot;
			}
			if (cmpSecond > 0) {
				subtreeRoot.right = delete(key, subtreeRoot.right);
				return subtreeRoot;
			}
			// cmpSecond == 0

			size --;

			if (subtreeRoot.left == null) return subtreeRoot.right;
			if (subtreeRoot.right == null) return subtreeRoot.left;
			if (subtreeRoot.middle == null) return subtreeRoot.middle;

		}

		if (cmpFirst > 0 && subtreeRoot.secondKey == null) {
			subtreeRoot.right = delete(key, subtreeRoot.right);
			return subtreeRoot;
		}*/

		//}