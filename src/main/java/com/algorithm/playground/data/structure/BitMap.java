package com.algorithm.playground.data.structure;

import java.util.function.LongBinaryOperator;

import static java.lang.Long.toBinaryString;

public class BitMap {

	private static final int SIZE = Long.SIZE;

	private long[] buckets;

	public BitMap() {
		buckets = new long[0];
	}

	public BitMap(int capacity) {
		this();
		extend(capacity);
	}

	private BitMap(long[] values) {
		buckets = values;
	}

	public boolean set(int idx, boolean val) {
		if (size() <= idx) {
			extend(idx);
		}
		boolean toReturn = get(idx);
		if (val) {
			buckets[getBucket(idx)] |= getCurrent(idx);
		} else if (toReturn) {
			buckets[getBucket(idx)] ^= getCurrent(idx);
		}
		return toReturn;
	}

	public boolean get(int idx) {
		if (size() <= idx) {
			return false;
		}
		long bucket = buckets[getBucket(idx)];
		long curr = getCurrent(idx);
		return (bucket & curr) == curr;
	}

	public BitMap intersection(BitMap other) {
		int size = Math.min(buckets.length, other.buckets.length);
		long[] values = new long[size];
		for (int i = 0; i < values.length; i++) {
			values[i] = buckets[i] & other.buckets[i];
		}
		return new BitMap(values);
	}

	public BitMap union(BitMap other) {
		return transform(other, (l1, l2) -> l1 | l2);
	}

	public BitMap difference(BitMap other) {
		return transform(other, (l1, l2) -> l1 ^ l2);
	}

	private BitMap transform(BitMap other, LongBinaryOperator op) {
		long[] values;
		if (other.buckets.length > buckets.length) {
			values = copyOf(other.buckets);
		} else {
			values = copyOf(buckets);
		}
		int minSize = Math.min(buckets.length, other.buckets.length);
		for (int i = 0; i < minSize; i++) {
			values[i] = op.applyAsLong(buckets[i], other.buckets[i]);
		}
		return new BitMap(values);
	}

	private long[] copyOf(long[] values) {
		long[] newArr = new long[values.length];
		System.arraycopy(values, 0, newArr, 0, values.length);
		return newArr;
	}

	private void extend(int idx) {
		long[] newBuckets = new long[getBucket(idx) + 1];
		System.arraycopy(buckets, 0, newBuckets, 0, buckets.length);
		buckets = newBuckets;
	}

	private int getBucket(int idx) {
		return idx / SIZE;
	}

	private long getCurrent(int idx) {
		return 1L << idx % SIZE;
	}

	private long size() {
		return (long) buckets.length * SIZE;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (long bucket : buckets) {
			StringBuilder curr = new StringBuilder(toBinaryString(bucket)).reverse();
			for (int j = curr.length(); j < SIZE; j++) {
				curr.append('0');
			}
			builder.append(curr);
		}
		return builder.toString();
	}
}
