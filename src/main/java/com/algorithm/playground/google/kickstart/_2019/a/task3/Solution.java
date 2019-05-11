package com.algorithm.playground.google.kickstart._2019.a.task3;

import java.util.*;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/0000000000069881
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//number of seats
				console.nextInt();
				//number of intervals
				int q = console.nextInt();
				int[][] intervals = new int[q][2];
				int max = readIntervals(console, intervals);
				int ans = solve(intervals, max + 2);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(int[][] intervals, int max) {
		boolean[] present = new boolean[max];
		int[] points = new int[max];
		for (int[] interval : intervals) {
			present[interval[0]] = true;
			present[interval[1]] = true;
			present[interval[1] + 1] = true;

			points[interval[0]]++;
			points[interval[1] + 1]--;
		}

		int[] indexes = new int[max];
		int[] seats = new int[points.length - 1];
		int[] multipliers = new int[points.length - 1];
		int val = 0;
		int idx = 0;

		int index = 0;

		//noinspection StatementWithEmptyBody
		for (; !present[index]; index++) {}

		while (index < max) {
			int prev = index;
			//noinspection StatementWithEmptyBody
			for (index++; index < present.length && !present[index]; index++) { }

			if (index != max) {
				val += points[prev];
				seats[idx] = val;
				multipliers[idx] = index - prev;
				indexes[prev] = idx++;
			}
		}

		@SuppressWarnings("unchecked")
		Set<Interval>[] map = new Set[seats.length];
		Heap heap = new Heap();
		for (int[] row : intervals) {
			int li = indexes[row[0]];
			int ri = indexes[row[1]];
			Interval interval = new Interval(li, ri);
			for (int i = li; i <= ri; i++) {
				if (seats[i] == 1) {
					interval.score += multipliers[i];
				}
				if (map[i] == null) {
					map[i] = new HashSet<>();
				}
				map[i].add(interval);
			}
			heap.put(interval);
		}

		int min = Integer.MAX_VALUE;
		while (heap.isNotEmpty()) {
			Interval curr = heap.pollMax();
			min = Math.min(min, curr.score);
			if (min == 0) {
				break;
			}
			for (int i = curr.from; i <= curr.to; i++) {
				seats[i]--;
				map[i].remove(curr);
				if (seats[i] == 1) {
					Interval toUpdate = map[i].iterator().next();
					toUpdate.score += multipliers[i];
					heap.put(toUpdate);
				}
			}
		}
		return min;
	}

	private static int readIntervals(Scanner console, int[][] rows) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rows.length; i++) {
			rows[i][0] = console.nextInt();
			rows[i][1] = console.nextInt();
			max = Math.max(max, rows[i][1]);
		}
		return max;
	}

	private static class Interval {

		private final int from, to;
		private int score = 0;

		private Interval(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Interval{" +
					"from=" + from +
					", to=" + to +
					", score=" + score +
					'}';
		}

	}

	private static class Heap {

		/** Heap */
		private List<Interval> values;
		private Map<Interval, Integer> indexes;

		private Heap() {
			values = new ArrayList<>();
			indexes = new HashMap<>();
		}

		private Interval pollMax() {
			if (isNotEmpty()) {
				Interval value = values.get(0);
				swap(0, values.size() - 1);

				values.remove(values.size() - 1);
				indexes.remove(value);

				if (isNotEmpty()) {
					shiftDown(0);
				}

				return value;
			}
			throw new NoSuchElementException();
		}

		private boolean isNotEmpty() {
			return !indexes.isEmpty();
		}

		/**
		 * Puts a key and associated value to the heap
		 * If there is already a value associated with this key the old value will be overwritten
		 * The position of the key in the heap will be recalculated with respect of new value
		 */
		private void put(Interval interval) {
			int idx = indexes.getOrDefault(interval, values.size());
			indexes.put(interval, idx);
			if (idx == values.size()) {
				values.add(interval);
			} else {
				values.set(idx, interval);
			}

			shiftUp(idx);
			shiftDown(idx);
		}

		private void shiftUp(int idx) {
			if (idx != 0) {
				int parentIdx = parent(idx);
				if (values.get(parentIdx).score < values.get(idx).score) {
					swap(idx, parentIdx);
					shiftUp(parentIdx);
				}
			}
		}

		private void shiftDown(int idx) {
			int max = idx;
			int weight = values.get(idx).score;
			for (int child : children(idx)) {
				if (child < values.size()) {
					int curr = values.get(child).score;
					if (curr > weight) {
						max = child;
						weight = curr;
					}
				}
			}
			if (max != idx) {
				swap(idx, max);
				shiftDown(max);
			}
		}

		private void swap(int idx1, int idx2) {
			Interval value1 = values.get(idx1);
			Interval value2 = values.get(idx2);

			values.set(idx1, value2);
			values.set(idx2, value1);

			indexes.put(value1, idx2);
			indexes.put(value2, idx1);
		}

		private int[] children(int idx) {
			int right = (idx + 1) * 2;
			int left = right - 1;
			return new int[]{left, right};
		}

		private int parent(int idx) {
			return (idx - 1) / 2;
		}

	}

}
