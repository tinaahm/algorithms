package org.pg4200.ex05;

import com.sun.source.tree.Tree;
import org.pg4200.les05.MyMapBinarySearchTree;

import javax.swing.tree.TreeNode;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K,V> {

	@Override
	protected TreeNode delete(K key, TreeNode subtreeRoot) {
		if (subtreeRoot == null) return null;

		int cmp = key.compareTo(subtreeRoot.key);

		// If given k is smaller go to left node
		if (cmp < 0) {
			subtreeRoot.left = delete(key, subtreeRoot.left);
			return subtreeRoot;
		}

		// If given k is bigger go to right node
		if (cmp > 0) {
			subtreeRoot.right = delete(key, subtreeRoot.right);
			return subtreeRoot;
		}

		assert cmp == 0;

		size--;

		if (subtreeRoot.left == null) return subtreeRoot.right;
		if (subtreeRoot.right == null) return subtreeRoot.left;

		assert subtreeRoot.left != null && subtreeRoot.right != null;

		//If node to be deleted has two children
		TreeNode tmp = subtreeRoot;
		subtreeRoot = max(tmp.left);
		subtreeRoot.left = deleteMax(tmp.left);
		subtreeRoot.right = tmp.right;

		return subtreeRoot;
	}

	// Max value from left subtree.
	private TreeNode max(TreeNode subtreeRoot) {
		if (subtreeRoot.right == null) return subtreeRoot;
		return max(subtreeRoot.right);
	}

	private TreeNode deleteMax(TreeNode subtreeRoot) {
		if (subtreeRoot.right == null) return subtreeRoot.left;

		subtreeRoot.right = deleteMax(subtreeRoot.right);
		return subtreeRoot;
	}
}