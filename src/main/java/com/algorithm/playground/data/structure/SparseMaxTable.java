package com.algorithm.playground.data.structure;

import java.util.Arrays;

import static java.lang.Integer.numberOfLeadingZeros;

public class SparseMaxTable {

	private int[] values;
	private int[][] table;

	public SparseMaxTable(int[] values) {
		int log = log2(values.length);
		this.values = values;
		this.table = new int[values.length - 1][log];
		buildTable(log);
	}

	public int getMaxVal(int lo, int hi) {
		return values[getMaxIdx(lo, hi)];
	}

	/**
	 * @param lo
	 * @param hi
	 *
	 * @return an index of max element in range between lo (inclusive) and hi (inclusive)
	 */
	public int getMaxIdx(int lo, int hi) {
		int size = hi - lo + 1;
		if (size == 1) {
			return lo;
		}
		int log = log2(size);
		int k = lo + size - (1 << log);
		int i = table[lo][log - 1];
		int j = table[k][log - 1];
		return getMax(i, j);
	}

	private int log2(int i) {
		return 31 - numberOfLeadingZeros(i);
	}

	/**
	 * @param idx1
	 * @param idx2
	 *
	 * @return an index of max element with respect to it's value
	 */
	private int getMax(int idx1, int idx2) {
		return values[idx2] > values[idx1] ? idx2 : idx1;
	}

	private void buildTable(int log) {
		for (int i = 0; i < table.length; i++) {
			table[i][0] = getMax(i, i + 1);
		}
		for (int i = 1; i < log; i++) {
			int size = 1 << (i + 1);
			for (int j = 0; j + size - 1 < values.length; j++) {
				int idx1 = table[j][i - 1];
				int idx2 = table[j + (1 << i)][i - 1];
				table[j][i] = getMax(idx1, idx2);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int[] r : table) {
			if (builder.length() != 0) {
				builder.append("        ");
			}
			builder.append(Arrays.toString(r)).append('\n');
		}
		return "SparseMaxTable{\n" +
				"values = " + Arrays.toString(values) + "\n" +
				"table = " + builder.toString() + '}';
	}
}
