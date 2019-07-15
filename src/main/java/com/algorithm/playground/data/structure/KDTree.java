package com.algorithm.playground.data.structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KDTree {

	private KDNode root;
	private int dimensions;

	public KDTree(int dimensions) {
		this.dimensions = dimensions;
	}

	private static void buildCatalogPrefix(StringBuilder builder, int level, Set<Integer> last) {
		if (level == 1) {
			builder.append(" ");
		} else {
			int l = level + 3 * level;
			for (int i = 0; i < l; i++) {
				int charLevel = i == 1 ? 1 : i / 4;
				if (!last.contains(charLevel) && (i == 1 || (i > 6 && i % 4 == 0 && l - i > 3))) {
					builder.append("|");
				} else {
					builder.append(" ");
				}
			}
		}
		String tmp = builder.toString();
		builder.append("|\n").append(tmp).append("|---> ");
	}

	public boolean contains(int[] value) {
		validate(value);
		return contains(root, value, 0);
	}

	public void insert(int[] value) {
		validate(value);
		root = insert(root, value, 0);
	}

	private void validate(int[] value) {
		if (value.length != dimensions) {
			throw new IllegalArgumentException("Length of the array [" + value.length + "] doesn't much dimension count of the tree [" + dimensions + ']');
		}
	}

	private int toIdx(int depth) {
		return depth % dimensions;
	}

	private boolean contains(KDNode node, int[] value, int depth) {
		if (node == null) {
			return false;
		} else {
			int idx = toIdx(depth);
			if (node.value[idx] == value[idx] && Arrays.equals(node.value, value)) {
				return true;
			} else if (node.value[idx] >= value[idx]) {
				return contains(node.left, value, depth + 1);
			} else {
				return contains(node.right, value, depth + 1);
			}
		}
	}

	private KDNode insert(KDNode node, int[] value, int depth) {
		if (node == null) {
			return new KDNode(value);
		} else {
			int idx = toIdx(depth);
			if (node.value[idx] == value[idx] && Arrays.equals(node.value, value)) {
				node.value = value;
			} else if (node.value[idx] >= value[idx]) {
				node.left = insert(node.left, value, depth + 1);
			} else {
				node.right = insert(node.right, value, depth + 1);
			}
			return node;
		}
	}

	@Override
	public String toString() {
		String rootStr;
		if (root == null) {
			rootStr = "\t<empty>\n";
		} else {
			rootStr = "\tNode{key=0, values=" + Arrays.toString(root.value) + "}\n";
			Set<Integer> last = new HashSet<>();
			if (root.right == null) {
				last.add(1);
			}
			rootStr += toString(root.left, 1, last);
			last.add(1);
			rootStr += toString(root.right, 1, last);
		}
		return "KDTree{\n" + rootStr + "}";
	}

	private String toString(KDNode node, int level, Set<Integer> last) {
		if (node == null) {
			return "";
		}
		StringBuilder curr = new StringBuilder("\t");
		buildCatalogPrefix(curr, level, last);

		curr.append("Node{key=")
				.append(toIdx(level))
				.append(", value=")
				.append(Arrays.toString(node.value))
				.append("}\n");

		if (node.right == null) {
			last.add(level + 1);
		}
		curr.append(toString(node.left, level + 1, last));
		last.add(level + 1);
		curr.append(toString(node.right, level + 1, last));
		last.remove(level + 1);
		return curr.toString();
	}

	private class KDNode {

		private KDNode left, right;
		private int[] value;

		private KDNode(int[] value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "KDNode{value=" + Arrays.toString(value) + '}';
		}
	}

}
