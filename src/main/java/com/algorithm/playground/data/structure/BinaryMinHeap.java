package com.algorithm.playground.data.structure;

import java.util.*;

/**
 * An implementation for MapHeap data structure based on idea from this video:
 * https://www.youtube.com/watch?v=lAXZGERcDf4&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j
 *
 * @param <K> type of key
 * @param <V> type of weight
 */
public class BinaryMinHeap<K, V extends Comparable<V>> {

	/** Heap */
	private List<Tuple2<K, V>> values;
	/** Map key to index in the heap */
	private Map<K, Integer> indexes;

	public BinaryMinHeap() {
		values = new ArrayList<>();
		indexes = new HashMap<>();
	}

	/**
	 * doesn't remove the minimum value from the heap
	 *
	 * @return a tuple of minimum key and it's weight
	 */
	public Tuple2<K, V> peekMin() {
		if (!isEmpty()) {
			return values.get(0);
		}
		throw new NoSuchElementException();
	}

	/**
	 * Removes the minimum value and returns it
	 *
	 * @return a tuple of minimum key and it's weight
	 */
	public Tuple2<K, V> pollMin() {
		if (!isEmpty()) {
			Tuple2<K, V> value = values.get(0);
			swap(0, values.size() - 1);

			values.remove(values.size() - 1);
			indexes.remove(value._1);

			return value;
		}
		throw new NoSuchElementException();
	}

	/**
	 * @return true if the heap is empty
	 */
	public boolean isEmpty() {
		return indexes.isEmpty();
	}

	/**
	 * @param key a key to search
	 *
	 * @return true if the heap contains the key
	 */
	public boolean contains(K key) {
		return indexes.containsKey(key);
	}

	/**
	 * Removes all values from the heap
	 */
	public void clear() {
		values.clear();
		indexes.clear();
	}

	/**
	 * @return the heap size
	 */
	public int size() {
		return indexes.size();
	}

	/**
	 * Puts a key and associated value to the heap
	 * If there is already a value associated with this key the old value will be overwritten
	 * The position of the key in the heap will be recalculated with respect of new value
	 *
	 * @param key   a key to insert
	 * @param value a weight associated with the key
	 */
	public void put(K key, V value) {
		int idx = indexes.getOrDefault(key, values.size());
		indexes.put(key, idx);
		if (idx == values.size()) {
			values.add(new Tuple2<>(key, value));
		} else {
			values.set(idx, new Tuple2<>(key, value));
		}

		if (!validateParent(idx)) {
			validateChildren(idx);
		}
	}

	/**
	 * @param key
	 *
	 * @return a weight associated with the key
	 */
	public V get(K key) {
		Integer idx = indexes.get(key);
		if (idx == null) {
			throw new NoSuchElementException();
		}
		return values.get(idx)._2;
	}

	/**
	 * Validates that the value is greater than it's parent
	 * If not the value will be swapped with it's parent
	 * In case if the values were swapped performs recursively for it's new position
	 * until a parent is less then the value or the top of the heap is reached
	 *
	 * @param idx an index in the heap
	 *
	 * @return true if values were swapped at least once
	 */
	private boolean validateParent(int idx) {
		if (idx == 0) {
			return false;
		}
		int parentIdx = parent(idx);
		if (values.get(parentIdx)._2.compareTo(values.get(idx)._2) < 0) {
			return false;
		} else {
			swap(idx, parentIdx);
			validateParent(parentIdx);
			return true;
		}
	}

	/**
	 * Validates that the value is less than both it's children
	 * If not the value will be swapped with it's the smallest child
	 * In case if the values were swapped performs recursively for it's new position
	 * until the value is less then it's children or it becomes a leaf
	 *
	 * @param idx an index in the heap
	 */
	private void validateChildren(int idx) {
		int min = idx;
		V weight = values.get(idx)._2;
		for (int child : children(idx)) {
			if (child < values.size()) {
				V curr = values.get(child)._2;
				if (curr.compareTo(weight) < 0) {
					min = child;
					weight = curr;
				}
			}
		}
		if (min != idx) {
			swap(idx, min);
			validateChildren(min);
		}
	}

	/**
	 * Swaps two values in the heap
	 * Updates their indexes in the index map
	 *
	 * @param idx1
	 * @param idx2
	 */
	private void swap(int idx1, int idx2) {
		Tuple2<K, V> value1 = values.get(idx1);
		Tuple2<K, V> value2 = values.get(idx2);

		values.set(idx1, value2);
		values.set(idx2, value1);

		indexes.put(value1._1, idx2);
		indexes.put(value2._1, idx1);
	}

	/**
	 * @param idx
	 *
	 * @return indexes of the children for passed index
	 */
	private int[] children(int idx) {
		int right = (idx + 1) * 2;
		int left = right - 1;
		return new int[]{left, right};
	}

	/**
	 * @param idx
	 *
	 * @return the index of node's parent
	 */
	private int parent(int idx) {
		return (idx - 1) / 2;
	}

}
