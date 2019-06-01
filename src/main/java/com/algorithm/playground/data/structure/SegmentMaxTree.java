package com.algorithm.playground.data.structure;

import java.util.Arrays;

import static java.lang.Integer.numberOfLeadingZeros;
import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOfRange;

public class SegmentMaxTree {

	private int[][] tree;
	private int size;

	public SegmentMaxTree(int[] values) {
		int size = 32 - numberOfLeadingZeros(values.length);
		this.size = values.length;
		this.tree = new int[size + 1][];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new int[1 << i];
		}
		arraycopy(values, 0, tree[tree.length - 1], 0, values.length);
		buildTree(values.length);
	}

	public void add(int val) {
		if (tree[tree.length - 1].length == size) {
			extend();
		}
		update(size++, val);
	}

	public void remove(int idx) {
		int[] values = tree[tree.length - 1];
		arraycopy(values, idx + 1, values, idx, values.length - idx - 1);
		int l = idx, r = size;
		for (int level = tree.length - 2; level >= 0; level--) {
			l >>= 1;
			r = (r >> 1) + (r & 1);
			for (int c = l; c < r; c++) {
				int left = c << 1;
				int right = left + 1;
				tree[level][c] = merge(tree[level + 1][left], tree[level + 1][right]);
			}
		}
		if (--size <= values.length >> 2) {
			shrink();
		}
	}

	public int query(int lo, int hi) {
		return query(lo, hi, 0, 0);
	}

	public void update(int idx, int value) {
		int level = tree.length - 1;
		tree[level--][idx] = value;
		for (idx >>= 1; level >= 0; idx >>= 1, level--) {
			int left = idx << 1;
			int right = left + 1;
			tree[level][idx] = merge(tree[level + 1][left], tree[level + 1][right]);
		}
	}

	private void shrink() {
		int len = tree.length - 1;
		int[][] newTree = new int[len][];
		for (int i = 0; i < len; i++) {
			newTree[i] = copyOfRange(tree[i + 1], 0, 1 << i);
		}
		this.tree = newTree;
	}

	private void extend() {
		int len = tree.length + 1;
		int[][] newTree = new int[len][];
		for (int i = 0; i < len; i++) {
			newTree[i] = new int[1 << i];
			int idx = Math.max(0, i - 1);
			arraycopy(tree[idx], 0, newTree[i], 0, tree[idx].length);
		}
		this.tree = newTree;
	}

	private int query(int lo, int hi, int level, int idx) {
		if (level == tree.length) {
			return Integer.MIN_VALUE;
		}
		int rest = tree.length - level - 1;
		int l = idx << rest;
		int r = l + (1 << rest) - 1;
		if (l > hi || r < lo) {
			return Integer.MIN_VALUE;
		} else if (l >= lo && r <= hi) {
			return tree[level][idx];
		} else {
			int left = idx << 1;
			int right = left + 1;
			return merge(
					query(lo, hi, level + 1, left),
					query(lo, hi, level + 1, right)
			);
		}
	}

	private void buildTree(int rightBound) {
		for (int r = tree.length - 2; r >= 0; r--) {
			rightBound = (rightBound >> 1) + (rightBound & 1);
			for (int c = 0; c < rightBound; c++) {
				int left = c << 1;
				int right = left + 1;
				tree[r][c] = merge(tree[r + 1][left], tree[r + 1][right]);
			}
		}
	}

	private int merge(int left, int right) {
		return Math.max(left, right);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int[] level : tree) {
			builder.append(Arrays.toString(level)).append('\n');
		}
		return "SegmentMaxTree{\n" + builder + '}';
	}
}
