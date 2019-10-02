package com.algorithm.playground.google.kickstart._2019.f.task2;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edc/00000000001864bc
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				console.nextInt();
				Map<Key, Long> counts = new HashMap<>();
				for (int i = 0; i < n; i++) {
					int size = console.nextInt();
					int[] skills = new int[size];
					for (int j = 0; j < size; j++) {
						skills[j] = console.nextInt();
					}
					counts.merge(new Key(skills), 1L, Long::sum);
				}
				long ans = solve(counts, n);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static long solve(Map<Key, Long> counts, long n) {
		long count = n * n;
		for (Entry<Key, Long> e : counts.entrySet()) {
			long val = e.getValue();
			List<Key> subsets = allSubsets(e.getKey().skills, 0, new ArrayList<>(), new ArrayList<>());
			for (Key k : subsets) {
				count -= counts.getOrDefault(k, 0L) * val;
			}
		}
		return count;
	}

	private static List<Key> allSubsets(int[] skills, int idx, List<Integer> curr, List<Key> result) {
		if (idx == skills.length) {
			int[] arr = new int[curr.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = curr.get(i);
			}
			result.add(new Key(arr));
		} else {
			allSubsets(skills, idx + 1, curr, result);
			curr.add(skills[idx]);
			allSubsets(skills, idx + 1, curr, result);
			curr.remove(curr.size() - 1);
		}
		return result;
	}

	private static class Key {

		private final int[] skills;

		private Key(int[] skills) {
			this.skills = skills;
			Arrays.sort(this.skills);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			} else if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Key key = (Key) o;
			return Arrays.equals(skills, key.skills);
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(skills);
		}

		@Override
		public String toString() {
			return "Key{" +
					"skills=" + Arrays.toString(skills) +
					'}';
		}
	}

}
