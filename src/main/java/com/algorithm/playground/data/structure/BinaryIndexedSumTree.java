package com.algorithm.playground.data.structure;

/**
 * An implementation of Binary Indexed sum tree based on idea from this video:
 * https://www.youtube.com/watch?v=CWDQJGaN1gY&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=24
 */
public class BinaryIndexedSumTree {

	/** The tree */
	private int[] tree;
	/** The original array. Is needed for performing updates */
	private int[] values;

	public BinaryIndexedSumTree(int[] values) {
		this.tree = new int[values.length];
		this.values = values;
		for (int i = 0; i < values.length; i++) {
			update(i, values[i] * 2);
		}
	}

	/**
	 * Updates a value in the tree with recalculating all necessary sums
	 * The old value will be replaced by new value
	 *
	 * @param idx   an index in the original array
	 * @param value a new value
	 */
	public void update(int idx, int value) {
		value = value - values[idx];
		for (idx++; idx < tree.length; idx = next(idx)) {
			tree[idx] += value;
		}
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
		return sum(to) - (from == 0 ? 0 : sum(from - 1));
	}

	/**
	 * Calculates the sum of integers between 0 and passed right bound (inclusive)
	 *
	 * @param right
	 *
	 * @return
	 */
	private int sum(int right) {
		int sum = 0;
		for (right++; right > 0; right = parent(right)) {
			sum += tree[right];
		}
		return sum;
	}

	/**
	 * @param idx the index of current node
	 *
	 * @return the parent of current node
	 */
	private int parent(int idx) {
		return idx - (idx & -idx);
	}

	/**
	 * @param idx the current node
	 *
	 * @return the next node for performing an update for current node
	 */
	private int next(int idx) {
		return idx + (idx & -idx);
	}

}
