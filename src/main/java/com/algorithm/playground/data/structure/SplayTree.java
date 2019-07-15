package com.algorithm.playground.data.structure;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class SplayTree {

	private SplayNode root;

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

	public void insert(int key) {
		if (root == null) {
			root = new SplayNode(key);
		} else {
			splay(key);
			if (root.key != key) {
				SplayNode node = new SplayNode(key);
				if (key < root.key) {
					node.left = root.left;
					node.right = root;
					root.left = null;
				} else {
					node.right = root.right;
					node.left = root;
					root.right = null;
				}
				root = node;
			}
		}
	}

	public void remove(int key) {
		if (root != null) {
			splay(key);
			if (key == root.key) {
				if (root.left == null) {
					root = root.right;
				} else {
					SplayNode node = root.right;
					root = root.left;
					splay(key);
					root.right = node;
				}
			}
		}
	}

	public boolean contains(int key) {
		if (root == null) {
			return false;
		}
		splay(key);
		return root.key == key;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int min() {
		SplayNode node = root;
		while (node.left != null) {
			node = node.left;
		}
		return node.key;
	}

	public int max() {
		SplayNode node = root;
		while (node.right != null) {
			node = node.right;
		}
		return node.key;
	}

	@Override
	public String toString() {
		String rootStr;
		if (root == null) {
			rootStr = "\t<empty>\n";
		} else {
			rootStr = "\tNode{key=" + root.key + "}\n";
			Set<Integer> last = new HashSet<>();
			if (root.right == null) {
				last.add(1);
			}
			rootStr += toString(root.left, 1, last, true);
			last.add(1);
			rootStr += toString(root.right, 1, last, false);
		}
		return "SplayTree{\n" + rootStr + "}";
	}

	private String toString(SplayNode node, int level, Set<Integer> last, boolean isLeft) {
		if (node == null) {
			return "";
		}
		StringBuilder curr = new StringBuilder("\t");
		buildCatalogPrefix(curr, level, last);

		curr.append(isLeft ? "{left}" : "{right}")
				.append(" Node{key=")
				.append(node.key)
				.append("}\n");

		if (node.right == null) {
			last.add(level + 1);
		}
		curr.append(toString(node.left, level + 1, last, true));
		last.add(level + 1);
		curr.append(toString(node.right, level + 1, last, false));
		last.remove(level + 1);
		return curr.toString();
	}

	private void splay(int key) {
		SplayNode left, right, target, y, holder;
		left = right = holder = new SplayNode(0);
		target = root;
		while (target.key != key) {
			if (key < target.key) {
				if (target.left == null) {
					break;
				} else if (key < target.left.key) {
					//noinspection SuspiciousNameCombination
					y = target.left;
					target.left = y.right;
					y.right = target;
					target = y;
					if (target.left == null) {
						break;
					}
				}
				right.left = target;
				right = target;
				target = target.left;
			} else {
				if (target.right == null) {
					break;
				} else if (key > target.right.key) {
					//noinspection SuspiciousNameCombination
					y = target.right;
					target.right = y.left;
					y.left = target;
					target = y;
					if (target.right == null) {
						break;
					}
				}
				left.right = target;
				left = target;
				target = target.right;
			}
		}
		left.right = target.left;
		right.left = target.right;
		target.left = holder.right;
		target.right = holder.left;
		root = target;
	}

	private class SplayNode {

		private int key;
		private SplayNode left, right;

		private SplayNode(int key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "SplayNode{" +
					"key=" + key +
					'}';
		}
	}

}
