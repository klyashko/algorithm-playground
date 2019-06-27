package com.algorithm.playground.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CoordinateCompressionBuilder {

	private TreeSet<Integer> coordinates = new TreeSet<>();

	public void addAll(Iterable<Integer> arr) {
		for (Integer i : arr) {
			add(i);
		}
	}

	public void addAll(Integer... arr) {
		for (int i : arr) {
			add(i);
		}
	}

	public void addAll(int[] arr) {
		for (int i : arr) {
			add(i);
		}
	}

	public void add(int coordinate) {
		coordinates.add(coordinate);
	}

	public Map<Integer, Integer> build() {
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (Integer c : coordinates) {
			map.put(c, idx++);
		}
		return map;
	}

	@Override
	public String toString() {
		return "CoordinateCompressionBuilder{" +
				"coordinates=" + coordinates +
				'}';
	}
}
