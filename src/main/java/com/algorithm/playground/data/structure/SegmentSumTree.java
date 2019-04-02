package com.algorithm.playground.data.structure;

/**
 * An implementation of Segment sum tree based on idea from this video:
 * https://www.youtube.com/watch?v=ZBHKZF5w4YU&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=22
 */
@SuppressWarnings("Duplicates")
public class SegmentSumTree {

	/** the tree */
	private final int[] tree;
	/** the size of original array. Potentially can be calculated by tree.length / 2 */
	private final int size;

	public SegmentSumTree(int[] values) {
		int size = 1;
		while (size < values.length) {
			size = size << 1;
		}
		this.size = values.length;
		tree = new int[size << 1];
		buildTree(values, 1, 0, this.size - 1);
	}

	/**
	 * Updates a value in the tree with recalculating all necessary sums
	 * The old value will be replaced by new value
	 *
	 * @param idx   an index in the original array
	 * @param value a new value
	 */
	public void update(int idx, int value) {
		if (idx >= size) {
			throw new ArrayIndexOutOfBoundsException(idx + " index is not in array of size " + size);
		}
		update(0, size - 1, idx, value, 1);
	}

	/**
	 * Calculates the sum of integers between passed indexes (inclusive)
	 *
	 * @param from a start index from the original array
	 * @param to   a stop index from the original array
	 *
	 * @return
	 */
	public int sum(int from, int to) {
		return query(0, size - 1, from, to, 1);
	}

	/**
	 * Calculates the sum of integers between passed indexes (inclusive)
	 *
	 * @param li   the left bound of the current node range
	 * @param ri   the right bound of the current node range
	 * @param from a start index from the original array
	 * @param to   a stop index from the original array
	 * @param idx  the index of a node in the tree
	 *
	 * @return
	 */
	private int query(int li, int ri, int from, int to, int idx) {
		if (li > to || ri < from) {
			return 0;
		} else if (li >= from && ri <= to) {
			return tree[idx - 1];
		} else {
			int mid = (ri - li) / 2 + li;
			int left = query(li, mid, from, to, idx * 2);
			int right = query(mid + 1, ri, from, to, idx * 2 + 1);
			return left + right;
		}
	}

	/**
	 * Updates a value in the tree
	 *
	 * @param li  the left bound of the current node range
	 * @param ri  the right bound of the current node range
	 * @param i   an index in the original array
	 * @param val new value
	 * @param idx the index of a node in the tree
	 *
	 * @return
	 */
	private int update(int li, int ri, int i, int val, int idx) {
		if (i < li || i > ri) {
			return tree[idx - 1];
		} else if (li == i && ri == i) {
			tree[idx - 1] = val;
			return val;
		}
		int mid = (ri - li) / 2 + li;
		int left = update(li, mid, i, val, idx * 2);
		int right = update(mid + 1, ri, i, val, idx * 2 + 1);
		tree[idx - 1] = left + right;
		return tree[idx - 1];
	}

	/**
	 * Builds the tree
	 *
	 * @param values values of the tree
	 * @param idx    the index of a node in the tree
	 * @param from   a start index from the original array
	 * @param to     a stop index from the original array
	 *
	 * @return
	 */
	private int buildTree(int[] values, int idx, int from, int to) {
		if (from == to) {
			tree[idx - 1] = values[from];
			return values[from];
		}
		int mid = (to - from) / 2 + from;
		int left = buildTree(values, idx * 2, from, mid);
		int right = buildTree(values, idx * 2 + 1, mid + 1, to);
		tree[idx - 1] = left + right;
		return tree[idx - 1];
	}

}
