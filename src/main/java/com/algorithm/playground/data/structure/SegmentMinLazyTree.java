package com.algorithm.playground.data.structure;

import java.util.Arrays;

import static java.lang.Integer.numberOfLeadingZeros;
import static java.lang.System.arraycopy;

public class SegmentMinLazyTree {

	private int[][] tree;
	private int[][] lazy;

	public SegmentMinLazyTree(int[] values) {
		int size = 32 - numberOfLeadingZeros(values.length);
		this.tree = new int[size + 1][];
		this.lazy = new int[size + 1][];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new int[1 << i];
			lazy[i] = new int[1 << i];
		}
		arraycopy(values, 0, tree[tree.length - 1], 0, values.length);
		buildTree(values.length);
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
			tree[level][idx] = Math.min(tree[level + 1][left], tree[level + 1][right]);
		}
	}

	public void increment(int lo, int hi, int val) {
		increment(lo, hi, 0, 0, val);
	}

	private int increment(int lo, int hi, int level, int idx, int val) {
		if (level == tree.length) {
			return Integer.MIN_VALUE;
		}
		int rest = tree.length - level - 1;
		int l = idx << rest;
		int r = l + (1 << rest) - 1;

		int left = idx << 1;
		int right = left + 1;

		lazyUpdateCheck(level, idx);

		if (l >= lo && r <= hi) {
			this.tree[level][idx] += val;
			if (rest != 0) {
				lazy[level + 1][left] += val;
				lazy[level + 1][right] += val;
			}
		} else if (intersect(l, r, lo, hi)) {
			tree[level][idx] = Math.min(
					increment(lo, hi, level + 1, left, val),
					increment(lo, hi, level + 1, right, val)
			);
		}
		return tree[level][idx];
	}

	private void lazyUpdateCheck(int level, int idx) {
		if (lazy[level][idx] != 0) {
			tree[level][idx] += lazy[level][idx];
			int childLevel = level + 1;
			if (childLevel != lazy.length) {
				int left = idx << 1;
				int right = left + 1;

				lazy[level + 1][left] += lazy[level][idx];
				lazy[level + 1][right] += lazy[level][idx];
			}
			lazy[level][idx] = 0;
		}
	}

	private boolean intersect(int l1, int r1, int l2, int r2) {
		return (l1 <= r2 && l1 >= l2) || (r1 >= l2 && r1 <= r2) || (l1 <= l2 && r1 >= r2) || (l1 >= l2 && r1 <= r2);
	}

	private int query(int lo, int hi, int level, int idx) {
		if (level == tree.length) {
			return Integer.MAX_VALUE;
		}
		int rest = tree.length - level - 1;
		int l = idx << rest;
		int r = l + (1 << rest) - 1;

		lazyUpdateCheck(level, idx);

		if (l > hi || r < lo) {
			return Integer.MAX_VALUE;
		} else if (l >= lo && r <= hi) {
			return tree[level][idx];
		} else {
			int left = idx << 1;
			int right = left + 1;

			return Math.min(
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
				tree[r][c] = Math.min(tree[r + 1][left], tree[r + 1][right]);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int[] level : tree) {
			builder.append(Arrays.toString(level)).append('\n');
		}
		builder.append("-------------------------------------------------------").append('\n');
		for (int[] level : lazy) {
			builder.append(Arrays.toString(level)).append('\n');
		}
		return "SegmentMinLazyTree{\n" + builder + '}';
	}
}
