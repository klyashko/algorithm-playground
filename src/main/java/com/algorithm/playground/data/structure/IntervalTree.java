package com.algorithm.playground.data.structure;

import java.util.*;

import static com.algorithm.playground.utils.CollectionUtils.list;
import static com.algorithm.playground.utils.CollectionUtils.sort;
import static java.util.Collections.max;
import static java.util.Comparator.comparingInt;

public class IntervalTree {

	private Node root;

	public IntervalTree() { }

	public IntervalTree(Collection<Interval> intervals) {
		if (!intervals.isEmpty()) {
			List<Interval> leftSorted = sort(intervals, comparingInt(Interval::getLeft));
			int min = leftSorted.get(0).left;
			int max = max(intervals, comparingInt(Interval::getRight)).right;
			root = buildNode(min, max, leftSorted);
		}
	}

	public List<Interval> query(int left, int right) {
		return query(left, right, root, new ArrayList<>());
	}

	public void insert(Interval interval) {
		root = insert(root, interval);
	}

	public Node insert(Node node, Interval interval) {
		if (node == null) {
			int val = (interval.right - interval.left) / 2 + interval.left;
			return new Node(val, list(interval));
		} else {
			if (interval.left <= node.value && interval.right >= node.value) {
				node.insert(interval);
			} else if (node.value > interval.right) {
				node.left = insert(node.left, interval);
			} else {
				node.right = insert(node.right, interval);
			}
		}
		return node;
	}

	private List<Interval> query(int left, int right, Node node, List<Interval> values) {
		if (node != null) {
			node.getIntervals(left, right, values);
			int mid = node.value;
			if (mid >= left && mid <= right) {
				query(left, mid - 1, node.left, values);
				query(mid + 1, right, node.right, values);
			} else if (right < mid) {
				query(left, mid - 1, node.left, values);
			} else {
				query(mid + 1, right, node.right, values);
			}
		}
		return values;
	}

	private Node buildNode(int left, int right, List<Interval> leftSorted) {
		if (leftSorted.isEmpty() || left > right) {
			return null;
		}
		int mid = (right - left) / 2 + left;
		List<Interval> intervals = new ArrayList<>();
		List<Interval> leftValues = new ArrayList<>();
		Iterator<Interval> iterator = leftSorted.iterator();
		while (iterator.hasNext()) {
			Interval curr = iterator.next();
			if (curr.left > mid) {
				break;
			} else if (curr.right >= mid) {
				intervals.add(curr);
				iterator.remove();
			} else {
				leftValues.add(curr);
				iterator.remove();
			}
		}
		Node node = new Node(mid, intervals);
		node.left = buildNode(left, mid - 1, leftValues);
		node.right = buildNode(mid + 1, right, leftSorted);
		return node;
	}

	@Override
	public String toString() {
		return "IntervalTree{" +
				"root=" + root +
				'}';
	}

	private static class Node {

		private final int value;
		private final List<Interval> leftSorted;
		private Node left, right;

		private Node(int value, List<Interval> leftSorted) {
			this.value = value;
			this.leftSorted = leftSorted;
		}

		private void getIntervals(int left, int right, List<Interval> intervals) {
			for (Interval interval : leftSorted) {
				if (interval.left > right) {
					break;
				} else if (interval.intersect(left, right)) {
					intervals.add(interval);
				}
			}
		}

		public void insert(Interval interval) {
			int idx = 0;
			for (; idx < leftSorted.size(); idx++) {
				if (leftSorted.get(idx).left > interval.left) {
					break;
				}
			}
			leftSorted.add(idx, interval);
		}

		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					", leftSorted=" + leftSorted +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}

	public static class Interval {

		private final int left, right;

		public Interval(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

		private boolean intersect(int li, int ri) {
			return (left <= li && right >= li) || (ri >= left && right >= ri) || (li < left && ri > right);
		}

		@Override
		public String toString() {
			return "Interval{" +
					"left=" + left +
					", right=" + right +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Interval interval = (Interval) o;
			return left == interval.left && right == interval.right;
		}

		@Override
		public int hashCode() {
			return Objects.hash(left, right);
		}
	}

}
