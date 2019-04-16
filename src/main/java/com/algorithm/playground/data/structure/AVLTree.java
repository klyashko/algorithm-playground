package com.algorithm.playground.data.structure;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {

	private Node root;

	public boolean insert(int val) {
		if (contains(val)) {
			return false;
		}
		root = insert(root, val);
		return true;
	}

	public List<Integer> inOrder() {
		return inOrder(root, new ArrayList<>());
	}

	public boolean contains(int val) {
		return contains(root, val);
	}

	private boolean contains(Node node, int val) {
		if (node == null) {
			return false;
		} else if (node.value > val) {
			return contains(node.left, val);
		} else if (node.value < val) {
			return contains(node.right, val);
		}
		return true;
	}

	private Node insert(Node node, int val) {
		if (node == null) {
			return new Node(val);
		} else if (node.value > val) {
			node.left = insert(node.left, val);
		} else if (node.value < val) {
			node.right = insert(node.right, val);
		}

		node.height = calcHeight(node);
		int balance = getBalance(node);

		if (balance > 1) {
			if (val < node.left.value) {
				/**left left case */
				return rightRotate(node);
			} else {
				/** left right case */
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		} else if (balance < -1) {
			if (val > node.right.value) {
				/** right right case */
				return leftRotate(node);
			} else {
				/** right left case */
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}

		return node;
	}

	private Node leftRotate(Node node) {
		Node right = node.right;
		Node left = right.left;

		right.left = node;
		node.right = left;

		node.height = calcHeight(node);
		right.height = calcHeight(right);

		return right;
	}

	private Node rightRotate(Node node) {
		Node left = node.left;
		Node right = left.right;

		left.right = node;
		node.left = right;

		node.height = calcHeight(node);
		left.height = calcHeight(left);

		return left;
	}

	private int calcHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
	}

	private int getHeight(Node node) {
		return node == null ? 0 : node.height;
	}

	private int getBalance(Node node) {
		return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
	}

	private List<Integer> inOrder(Node node, List<Integer> values) {
		if (node != null) {
			inOrder(node.left, values);
			values.add(node.value);
			inOrder(node.right, values);
		}
		return values;
	}

	@Override
	public String toString() {
		return "AVL tree: " + inOrder(root, new ArrayList<>());
	}

	private class Node {

		private int value, height;
		private Node left, right;

		private Node(int value) {
			this.value = value;
			this.height = 1;
		}

		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					", height=" + height +
					'}';
		}
	}

}
