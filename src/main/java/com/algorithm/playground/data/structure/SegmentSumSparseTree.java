package com.algorithm.playground.data.structure;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.numberOfLeadingZeros;
import static java.util.Collections.emptyList;

public class SegmentSumSparseTree {

	private Node root;
	private int size;

	public SegmentSumSparseTree(int size) {
		this.size = 1;
		while (this.size < size) {
			this.size <<= 1;
		}
	}

	public SegmentSumSparseTree(int[] values) {
		this(values.length);
		root = buildTree(values, 0, size - 1);
	}

	private static Node buildTree(int[] values, int lo, int hi) {
		if (lo >= values.length) {
			return null;
		} else if (lo == hi) {
			return values[lo] == 0 ? null : new Node(lo, hi, values[lo]);
		} else {
			int mid = (hi - lo >> 1) + lo;
			Node left = buildTree(values, lo, mid);
			Node right = buildTree(values, mid + 1, hi);
			if (left == null && right == null) {
				return null;
			} else {
				Node node = new Node(lo, hi);
				node.value = Node.getValue(left) + Node.getValue(right);
				node.left = left;
				node.right = right;
				return node;
			}
		}
	}

	public int query(int lo, int hi) {
		return Node.query(root, lo, hi);
	}

	public void update(int idx, int val) {
		root = Node.update(root, 0, size - 1, idx, val);
	}

	private List<List<Node>> collectNodes(Node node, List<List<Node>> nodes, int level) {
		if (node != null) {
			if (level == nodes.size()) {
				nodes.add(new ArrayList<>());
			}
			nodes.get(level).add(node);
			collectNodes(node.left, nodes, level + 1);
			collectNodes(node.right, nodes, level + 1);
		}
		return nodes;
	}

	@Override
	public String toString() {
		int log = 32 - numberOfLeadingZeros(size);
		List<List<Node>> nodes = collectNodes(root, new ArrayList<>(), 0);

		for (int i = nodes.size(); i < log; i++) {
			nodes.add(emptyList());
		}

		StringBuilder builder = new StringBuilder();
		int window = 1 << nodes.size() - 1;
		for (int r = 0; r < nodes.size(); r++, window >>= 1) {
			int size = 1 << r;
			List<Node> level = nodes.get(r);
			builder.append('[');
			for (int c = 0, idx = 0, start = 0; c < size; c++, start += window) {
				if (idx < level.size() && level.get(idx).lo == start) {
					builder.append(level.get(idx++).value);
				} else {
					builder.append('0');
				}
				if (c + 1 != size) {
					builder.append(',');
				}
			}
			builder.append(']').append('\n');
		}
		return builder.toString();
	}

	private static class Node {

		private final int lo, hi;
		private int value;
		private Node left, right;

		private Node(int lo, int hi) {
			this.lo = lo;
			this.hi = hi;
		}

		public Node(int lo, int hi, int value) {
			this(lo, hi);
			this.value = value;
		}

		private static int getValue(Node node) {
			return node == null ? 0 : node.value;
		}

		private static int query(Node node, int from, int to) {
			if (node == null || node.lo > to || node.hi < from) {
				return 0;
			} else if (node.lo >= from && node.hi <= to) {
				return node.value;
			} else {
				int left = query(node.left, from, to);
				int right = query(node.right, from, to);
				return merge(left, right);
			}
		}

		private static Node update(Node node, int lo, int hi, int idx, int value) {
			if ((node == null || (lo == hi && lo == idx)) && value == 0) {
				return null;
			} else if (lo > idx || hi < idx) {
				return node;
			}
			node = node == null ? new Node(lo, hi) : node;
			if (lo == hi) {
				node.value = value;
				return node;
			}
			int mid = (hi - lo >> 1) + lo;
			node.left = update(node.left, lo, mid, idx, value);
			node.right = update(node.right, mid + 1, hi, idx, value);
			if (node.left == null && node.right == null) {
				return null;
			}
			int left = getValue(node.left);
			int right = getValue(node.right);
			node.value = merge(left, right);
			return node;
		}

		private static int merge(int left, int right) {
			return left + right;
		}

		@Override
		public String toString() {
			String left = this.left == null ? "null" : "Node[" + this.left.value + "]";
			String right = this.right == null ? "null" : "Node[" + this.right.value + "]";
			return "Node{" +
					"lo=" + lo +
					", hi=" + hi +
					", value=" + value +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}

}
