package com.algorithm.playground.leetcode.problems.lc900.lc952;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
public class LargestComponentSizeByCommonFactor {

	class Solution {
		public int largestComponentSize(int[] A) {
			DSU dsu = new DSU(A.length);
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int i = 0; i < A.length; i++) {
				factorization(i, A[i], graph, dsu);
			}
			Map<Integer, Integer> counts = new HashMap<>();
			int max = 0;
			for (int i = 0; i < A.length; i++) {
				int curr = counts.merge(dsu.find(i), 1, Integer::sum);
				max = Math.max(max, curr);
			}
			return max;
		}

		private void factorization(int key, int val, Map<Integer, List<Integer>> graph, DSU dsu) {
			for (int i = 2; i <= val; i++) {
				if (val % i == 0) {
					while (val % i == 0) {
						val /= i;
					}
					List<Integer> list = graph.get(i);
					if (list == null) {
						list = new ArrayList<>();
					} else {
						for (Integer n : list) {
							dsu.union(n, key);
						}
					}
					list.add(key);
					graph.put(i, list);
				}
			}
		}

		private class DSU {

			private int[] sets;

			private DSU(int size) {
				this.sets = new int[size];
				for (int i = 0; i < sets.length; i++) {
					sets[i] = i;
				}
			}

			private int find(int key) {
				if (sets[key] == key) {
					return key;
				}
				return sets[key] = find(sets[key]);
			}

			private void union(int key1, int key2) {
				sets[find(key1)] = find(key2);
			}

		}
	}

}
