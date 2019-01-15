package com.leetcode.problems.tree;

import java.util.*;

@SuppressWarnings("Duplicates")
public class TreeNode {

	private static final String NULL = "null";
	private static final String DELIMITER = ",";

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {

	}

	public TreeNode(int x) { val = x; }

	public void setVal(int val) {
		this.val = val;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public static TreeNode valueOf(List<Integer> values) {
		return valueOf(values.toArray(new Integer[0]));
	}

	public static TreeNode node(List<Integer> values) {
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> nodeQueue = new LinkedList<>();

		for (Integer i : values) {
			queue.offer(i != null ? new TreeNode(i) : null);
		}

		TreeNode root = queue.poll();
		nodeQueue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = nodeQueue.poll();
			if (curr == null) {
				continue;
			}
			curr.left = queue.poll();
			curr.right = queue.poll();

			nodeQueue.offer(curr.left);
			nodeQueue.offer(curr.right);
		}

		return root;
	}

	public static TreeNode valueOf(Integer[] values) {
		if (values.length == 0) {
			return null;
		}
		return valueOf(values, 1);
	}

	public static TreeNode valueOf(String data) {
		if (data.isEmpty()) {
			return null;
		}
		Iterator<String> iterator = Arrays.asList(data.split(DELIMITER)).iterator();
		return valueOf(iterator);
	}

	public static Integer[] toArray(TreeNode node) {
		Integer[] array = new Integer[size(node)];
		packNode(node, 1, array);
		return array;
	}

	public static String toString(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		toStringBuilder(root, builder);
		return builder.toString();
	}

	private static void packNode(TreeNode n, int idx, Integer[] array) {
		if (n == null) {
			return;
		}
		array[idx - 1] = n.val;
		packNode(n.left, idx * 2, array);
		packNode(n.right, idx * 2 + 1, array);
	}

	private static int size(TreeNode n) {
		if (n == null) {
			return 0;
		}
		int size = Math.max(size(n.left), size(n.right));
		return 1 + size * 2;
	}

	private static TreeNode valueOf(Integer[] values, int idx) {
		if (idx > values.length || values[idx - 1] == null) {
			return null;
		}
		TreeNode node = new TreeNode(values[idx - 1]);
		node.left = valueOf(values, idx * 2);
		node.right = valueOf(values, idx * 2 + 1);
		return node;
	}

	private static TreeNode valueOf(Iterator<String> values) {
		if (!values.hasNext()) {
			return null;
		}
		String value = values.next();
		if (NULL.equals(value)) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(value));
		node.left = valueOf(values);
		node.right = valueOf(values);
		return node;
	}

	private static void toStringBuilder(TreeNode node, StringBuilder builder) {
		if (node == null) {
			builder.append(NULL).append(DELIMITER);
			return;
		}
		builder.append(String.valueOf(node.val)).append(DELIMITER);
		toStringBuilder(node.left, builder);
		toStringBuilder(node.right, builder);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeNode treeNode = (TreeNode) o;
		return val == treeNode.val &&
				Objects.equals(left, treeNode.left) &&
				Objects.equals(right, treeNode.right);
	}

	@Override
	public int hashCode() {

		return Objects.hash(val, left, right);
	}

	@Override
	public String toString() {
		return "TreeNode{" + toString(this) + "}";
	}
}
