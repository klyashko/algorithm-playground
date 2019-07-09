package com.algorithm.playground.leetcode.problems.lc900.lc952;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
public class LargestComponentSizeByCommonFactor {

	class Solution {
		public int largestComponentSize(int[] A) {
			DSU dsu = new DSU(A.length);
			Map<Integer, Integer> graph = new HashMap<>();
			for (int i = 0; i < A.length; i++) {
				factorization(i, A[i], graph, dsu);
			}
			return dsu.max;
		}

		private void factorization(int key, int val, Map<Integer, Integer> graph, DSU dsu) {
			int until = (int) (Math.sqrt(val) + 1);
			for (int i = 2; val != 1 && i <= until; i++) {
				if (val % i == 0) {
					while (val % i == 0) {
						val /= i;
					}
					union(key, i, graph, dsu);
				}
			}
			if (val > 1) {
				union(key, val, graph, dsu);
			}
		}

		private void union(int key, int factor, Map<Integer, Integer> graph, DSU dsu) {
			if (graph.containsKey(factor)) {
				dsu.union(graph.get(factor), key);
			} else {
				graph.put(factor, key);
			}
		}

		private class DSU {

			private int[] sets;
			int max = 1;
			private int[] sizes;

			private DSU(int size) {
				this.sets = new int[size];
				this.sizes = new int[size];
				for (int i = 0; i < sets.length; i++) {
					sets[i] = i;
					sizes[i] = 1;
				}
			}

			private int find(int key) {
				if (sets[key] == key) {
					return key;
				}
				return sets[key] = find(sets[key]);
			}

			private void union(int key1, int key2) {
				int p1 = find(key1);
				int p2 = find(key2);
				if (p1 != p2) {
					sets[p1] = p2;
					sizes[p2] += sizes[p1];
					max = Math.max(max, sizes[p2]);
				}
			}

		}
	}

}
