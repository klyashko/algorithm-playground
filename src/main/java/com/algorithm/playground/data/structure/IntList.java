package com.algorithm.playground.data.structure;

import java.util.Arrays;

public class IntList {

	private int[] values;
	private int size;

	public IntList() {
		this.values = new int[10];
	}

	public IntList(int[] values) {
		this.values = Arrays.copyOf(values, values.length);
		this.size = values.length;
	}

	private static IntList[] arrayOf(int rows) {
		IntList[] list = new IntList[rows];
		for (int i = 0; i < rows; i++) {
			list[i] = new IntList();
		}
		return list;
	}

	public void add(int val) {
		ensureCapacity(size);
		values[size++] = val;
	}

	public int set(int idx, int val) {
		ensureRange(idx);
		int tmp = values[idx];
		values[idx] = val;
		return tmp;
	}

	public int get(int idx) {
		ensureRange(idx);
		return values[idx];
	}

	public void remove(int idx) {
		ensureRange(idx);
		System.arraycopy(values, idx + 1, values, idx, size - idx - 1);
		size--;
	}

	public int size() {
		return size;
	}

	private void ensureRange(int idx) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException(idx + " list size is [" + size + "]");
		}
	}

	private void ensureCapacity(int idx) {
		if (values.length <= idx) {
			int[] newValues = new int[values.length << 1];
			System.arraycopy(values, 0, newValues, 0, values.length);
			values = newValues;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		IntList intList = (IntList) o;
		if (size != intList.size) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (values[i] != intList.values[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		for (int i = 0; i < size; i++) {
			result = 31 * result + values[i];
		}
		return result;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(values, 0, size));
	}

}
