package com.algorithm.playground.barclays.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.numberOfLeadingZeros;
import static java.util.Collections.emptyList;

public class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		process(n);
		scanner.close();
	}

	private static void process(int n) {
		IntList data = new IntList(10);
		data.add(0);
		SegmentSumSparseTree tree = new SegmentSumSparseTree(1_000_000_001);

		for (int i = 0; i < n; i++) {
			Command c = new Command(
					scanner.next().charAt(0),
					scanner.nextInt(),
					scanner.nextInt()
			);

			if (c.c == 'I') {
				data.add(c.i2);
				tree.increment(c.i2, 1);
			} else if (c.c == 'U') {
				int old = data.get(c.i1);
				tree.increment(old, -1);
				data.set(c.i1, c.i2);
				tree.increment(c.i2, 1);
			} else if (c.c == 'S') {
				if (c.i2 < c.i1) {
					System.out.println(0);
					continue;
				}
				long sum = tree.sum(c.i1, c.i2);
				System.out.println(sum);
			} else if (c.c == 'C') {
				if (c.i2 < c.i1) {
					System.out.println(0);
					continue;
				}
				int count = tree.count(c.i1, c.i2);
				System.out.println(count);
			}
		}
	}

	private static class IntList {

		private int[] data;
		private int size;

		private IntList(int capacity) {
			this.data = new int[capacity];
		}

		private void add(int val) {
			ensureCapacity();
			data[size++] = val;
		}

		private void set(int idx, int val) {
			data[idx] = val;
		}

		private int get(int idx) {
			return data[idx];
		}

		private void ensureCapacity() {
			if (size == data.length) {
				int newSize = Math.min(size << 1, 1_000_000_001);
				int[] newData = new int[newSize];
				System.arraycopy(data, 0, newData, 0, data.length);
				this.data = newData;
			}
		}

	}

	private static class Command {

		private char c;
		private int i1, i2;

		private Command(char c, int i1, int i2) {
			this.c = c;
			this.i1 = i1;
			this.i2 = i2;
		}

		@Override
		public String toString() {
			return "Command{" +
					"c=" + c +
					", i1=" + i1 +
					", i2=" + i2 +
					'}';
		}
	}

	public static class SegmentSumSparseTree {

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

					node.sum = Node.getSum(left) + Node.getSum(right);
					return node;
				}
			}
		}

		public int count(int lo, int hi) {
			return Node.count(root, lo, hi);
		}

		public long sum(int lo, int hi) {
			return Node.sum(root, lo, hi);
		}

		private void increment(int idx, int val) {
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
			private long sum;
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

			private static long getSum(Node node) {
				return node == null ? 0 : node.sum;
			}

			private static int count(Node node, int from, int to) {
				if (node == null || node.lo > to || node.hi < from) {
					return 0;
				} else if (node.lo >= from && node.hi <= to) {
					return node.value;
				} else {
					int left = count(node.left, from, to);
					int right = count(node.right, from, to);
					return merge(left, right);
				}
			}

			private static long sum(Node node, int from, int to) {
				if (node == null || node.lo > to || node.hi < from) {
					return 0;
				} else if (node.lo >= from && node.hi <= to) {
					return node.sum;
				} else {
					long left = sum(node.left, from, to);
					long right = sum(node.right, from, to);
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
					node.value = value + node.value;
					node.sum = (long) lo * (long) node.value;
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

				node.sum = getSum(node.left) + getSum(node.right);
				return node;
			}

			private static int merge(int left, int right) {
				return left + right;
			}

			private static long merge(long left, long right) {
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

}
